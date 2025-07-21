<<<<<<< HEAD
plugins {
    id("com.android.application")
    // START: FlutterFire Configuration
    id("com.google.gms.google-services")
    // END: FlutterFire Configuration
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.my_webapp"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion
=======
android {
    namespace = "com.example.my_webapp"
    compileSdk = 34
    ndkVersion = "27.0.12077973" // ✅ Set correct NDK version
>>>>>>> f2150a390a7dc191f5531d606a5456a06527bbad

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
<<<<<<< HEAD
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.my_webapp"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
=======
        applicationId = "com.example.my_webapp"
        minSdk = 23 // ✅ Firebase Auth requires at least 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
>>>>>>> f2150a390a7dc191f5531d606a5456a06527bbad
    }

    buildTypes {
        release {
<<<<<<< HEAD
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
=======
>>>>>>> f2150a390a7dc191f5531d606a5456a06527bbad
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}
<<<<<<< HEAD

flutter {
    source = "../.."
}
=======
>>>>>>> f2150a390a7dc191f5531d606a5456a06527bbad
