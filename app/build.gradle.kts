plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pmdmtarea2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pmdmtarea2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    //1º Habilitar viewBinding y dataBinding
    buildFeatures{
        viewBinding=true
        dataBinding=true
    }
}



dependencies {
    implementation(libs.core.splashscreen)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.androidx.drawerlayout)
    implementation(libs.androidx.preference)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //2º Agregamos las dependencias
   // implementation (libs.recyclerview)
  //  implementation(libs.cardview)


}