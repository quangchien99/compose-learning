package chn.phm.cashly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import chn.phm.cashly.ui.common.CashlyTabRow
import chn.phm.cashly.ui.theme.CashlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CashlyApp()
        }
    }
}

@Composable
fun CashlyApp() {
    CashlyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            cashlyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview
        Scaffold(
            topBar = {
                CashlyTabRow(allScreens = cashlyTabRowScreens, onTabSelected = { newScreen ->
                    navController.navigate(newScreen.route)
                }, currentScreen = currentScreen)
            }
        ) { innerPadding ->
            CashlyNavHost(
                navHostController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}