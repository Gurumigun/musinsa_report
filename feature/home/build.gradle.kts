import com.kiy.report.core.buildlogic.setNamespace

plugins {
    id("musinsa.android.feature")
    id("kotlinx-serialization")
}

android {
    setNamespace("feature.main")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.kotlinx.immutable)
    androidTestImplementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.serialization.json)
}
