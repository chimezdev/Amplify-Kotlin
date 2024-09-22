plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    alias(libs.plugins.hiltAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.shirtersdroid"
    compileSdk = 34
    android.buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "com.example.shirtersdroid"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.debug.example.com\"")
            buildConfigField("Boolean", "IS_LOGGING_ENABLED", "true")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.debug.example.com\"")
            buildConfigField("Boolean", "IS_LOGGING_ENABLED", "false")
        }
    }
    compileOptions {
        // Support for Java 8 features
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
//    implementation(libs.javapoet)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.timber)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.coresplashscreen)
    implementation(libs.androidx.constraintlayout)
//    implementation(libs.hilt.android)
    implementation(libs.lifecycleviewmodelktx)
    implementation(libs.compose.ui)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material)
    implementation(libs.lifecycle.viewmodel.compose)
//    kapt(libs.hilt.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Amplify core dependency
    implementation(libs.amplifyframework.core)
    implementation(libs.amplifyframework.aws.auth.cognito)
    implementation(libs.aws.auth.cognito.v1420)
    implementation(libs.authenticator)
    implementation("com.amplifyframework:core:1.35.4")
    implementation("com.amplifyframework:aws-auth-cognito:1.35.4")
//  Support for Java 8 features
    coreLibraryDesugaring(libs.desugar.jdk.libs)
}
//kapt {
//    correctErrorTypes = true // Fix for kapt-specific errors
////    useBuildCache = true // Enable caching for faster builds
//}