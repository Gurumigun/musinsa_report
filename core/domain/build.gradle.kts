import com.kiy.report.core.buildlogic.setNamespace

plugins {
    id("musinsa.android.library")
}

android {
    setNamespace("core.domain")
}

dependencies {
    implementation(projects.core.data.api)
    implementation(projects.core.data.impl)

    implementation(projects.core.model)
}
