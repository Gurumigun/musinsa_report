import java.util.Properties

plugins {
    id("musinsa.android.application")
    id("musinsa.android.hilt")
}

android {
    namespace = "com.kiy.report"

    defaultConfig {
        applicationId = "com.kiy.report"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        buildConfig = true
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
}

dependencies {
    implementation(projects.feature.home)
}
