android {
    namespace = "com.example.my_webapp"
    compileSdk = 34
    ndkVersion = "27.0.12077973" // ✅ Set correct NDK version

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.my_webapp"
        minSdk = 23 // ✅ Firebase Auth requires at least 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}
