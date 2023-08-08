package chn.phm.cashly

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

/**
 * Contract for information needed on every Rally navigation destination
 */

interface CashlyDestination {
    val icon: ImageVector
    val route: String
}

/**
 * Cashly app navigation destinations
 */
object Overview : CashlyDestination {
    override val icon = Icons.Filled.PieChart
    override val route = "overview"
}

object Accounts : CashlyDestination {
    override val icon = Icons.Filled.AttachMoney
    override val route = "accounts"
}

object SingleAccount : CashlyDestination {
    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
    // part of the CashlyTabRow selection
    override val icon = Icons.Filled.Money
    override val route = "single_account"
    const val accountTypeArg = "account_type"
    val routeWithArgs = "$route/{$accountTypeArg}"
    val arguments = listOf(
        navArgument(accountTypeArg) { type = NavType.StringType }
    )
    val deepLinks = listOf(
        navDeepLink { uriPattern = "cashly://$route/{$accountTypeArg}" }
    )
}

// Screens to be displayed in the top CashlyTabRow
val cashlyTabRowScreens = listOf(Overview, Accounts)