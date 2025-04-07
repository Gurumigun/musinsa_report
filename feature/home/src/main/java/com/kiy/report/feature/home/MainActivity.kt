package com.knowmerce.report.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.knowmerce.report.feature.search.screen.SearchScreen
import com.knowmerce.report.designsystem.theme.knowmerceReportTheme
import com.knowmerce.report.feature.home.navigation.MediaNavigation
import com.knowmerce.report.feature.home.screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            knowmerceReportTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = MediaNavigation.Main
                    ) {

                        composable<MediaNavigation.Main> {
                            HomeScreen(innerPadding = innerPadding, navController)
                        }

                        composable<MediaNavigation.SearchPage> {
                            SearchScreen(
                                innerPadding,
                                navController
                            )
                        }
                    }
                }
            }
        }
    }
}
