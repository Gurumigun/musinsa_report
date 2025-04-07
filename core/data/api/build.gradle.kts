import com.kiy.report.core.buildlogic.setNamespace

plugins {
    id("musinsa.android.library")
    id("kotlinx-serialization")
}

android {
    setNamespace("core.data.api")
}

dependencies {
    implementation(projects.core.model)
}
