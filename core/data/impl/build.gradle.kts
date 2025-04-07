import com.kiy.report.core.buildlogic.setNamespace

plugins {
    id("musinsa.android.library")
    id("musinsa.android.hilt")
    id("kotlinx-serialization")
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data.api)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.retrofit)
}
