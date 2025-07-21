// 📁 groq_service.dart
import 'dart:convert';
import 'dart:async';
import 'package:http/http.dart' as http;

class GroqService {
  static const String _apiKey = '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';
  static const String _baseUrl = 'https://api.groq.com/openai/v1/chat/completions';

  static Stream<String> streamMessage(
    List<Map<String, String>> messages, {
    String model = 'llama-3.3-70b-versatile',
  }) async* {
    final request = http.Request('POST', Uri.parse(_baseUrl));
    request.headers.addAll({
      'Authorization': 'Bearer $_apiKey',
      'Content-Type': 'application/json',
    });

    request.body = jsonEncode({
      'model': model,
      'stream': true,
      'messages': messages,
    });

    final response = await request.send();

    if (response.statusCode != 200) {
      final error = await response.stream.bytesToString();
      throw Exception('Groq Streaming Error: ${response.statusCode} - $error');
    }

    final utf8Stream = response.stream.transform(utf8.decoder);

    await for (final chunk in utf8Stream) {
      final lines = chunk.split('\n');
      for (final line in lines) {
        if (line.startsWith('data: ')) {
          final data = line.substring(6).trim();
          if (data == '[DONE]') return;
          try {
            final json = jsonDecode(data);
            final content = json['choices'][0]['delta']['content'];
            if (content != null) yield content.toString();
          } catch (_) {
            // Ignore partial/incomplete chunks
          }
        }
      }
    }
  }
}
