import com.kiy.report.core.buildlogic.configureCoroutineAndroid
import com.kiy.report.core.buildlogic.configureHiltAndroid
import com.kiy.report.core.buildlogic.configureKotlinAndroid

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureHiltAndroid()
