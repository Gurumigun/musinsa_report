plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "musinsa.android.hilt"
            implementationClass = "com.kiy.report.core.buildlogic.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "musinsa.kotlin.hilt"
            implementationClass = "com.kiy.report.core.buildlogic.HiltKotlinPlugin"
        }
    }
}
