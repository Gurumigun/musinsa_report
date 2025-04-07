package com.kiy.report.core.buildlogic

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.kiy.report.$name"
    }
}
