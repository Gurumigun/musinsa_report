import com.kiy.report.core.buildlogic.configureHiltAndroid
import com.kiy.report.core.buildlogic.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
