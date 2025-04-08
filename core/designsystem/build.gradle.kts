import com.kiy.report.core.buildlogic.setNamespace

plugins {
    id("musinsa.android.library")
    id("musinsa.android.compose")
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.coil)
    implementation(projects.core.model)
    implementation(libs.androidx.constraintlayout)
}
