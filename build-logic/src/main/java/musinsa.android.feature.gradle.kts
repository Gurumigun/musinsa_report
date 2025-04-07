import com.kiy.report.core.buildlogic.configureHiltAndroid

plugins {
    id("musinsa.android.library")
    id("musinsa.android.compose")
}

//android {
//    packaging {
//        resources {
//            excludes.add("META-INF/**")
//        }
//    }
//    defaultConfig {
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//}

configureHiltAndroid()

dependencies {
//    implementation(project(":core:model"))
//    implementation(project(":core:designsystem"))
//    implementation(project(":core:domain"))
//
//    val libs = project.extensions.libs
//    implementation(libs.findLibrary("hilt.navigation.compose").get())
//    implementation(libs.findLibrary("androidx.compose.navigation").get())
//    androidTestImplementation(libs.findLibrary("androidx.compose.navigation.test").get())
//
//    implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
//    implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
//    implementation(libs.findBundle("coil").get())
}
