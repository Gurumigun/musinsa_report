package com.kiy.report.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kiy.report.core.designsystem.theme.MusinsaReportTheme
import com.kiy.report.feature.home.screen.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusinsaReportTheme {
                MainScreen()
            }
        }
    }
}
