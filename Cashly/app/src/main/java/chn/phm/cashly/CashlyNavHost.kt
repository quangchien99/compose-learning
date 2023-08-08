package chn.phm.cashly

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import chn.phm.cashly.ui.screens.AccountsScreen
import chn.phm.cashly.ui.screens.BillsScreen
import chn.phm.cashly.ui.screens.OverviewScreen
import chn.phm.cashly.ui.screens.SingleAccountScreen
import chn.phm.cashly.ui.screens.SingleBillScreen

@Composable
fun CashlyNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Overview.route,
        modifier = modifier
    ) {
        composable(route = Overview.route) {
            OverviewScreen(
                onClickSeeAllAccounts = { navHostController.navigateSingleTopTo(Accounts.route) },
                onAccountClick = { accountType ->
                    navHostController.navigateToSingleAccount(accountType)
                },
                onClickSeeAllBills = {
                    navHostController.navigateSingleTopTo(Bills.route)
                },
                onBillClick = { billName ->
                    navHostController.navigateToSingleBill(billName)
                }
            )
        }

        composable(route = Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navHostController.navigateToSingleAccount(accountType)
                }
            )
        }

        composable(route = Bills.route) {
            BillsScreen(
                onBillClick = { billName ->
                    navHostController.navigateToSingleBill(billName)
                }
            )
        }

        composable(
            route = SingleBill.routeWithArgs,
            arguments = SingleBill.arguments,
            deepLinks = SingleBill.deepLinks
        ) { navBackStackEntry ->
            val billName =
                navBackStackEntry.arguments?.getString(SingleBill.billNameArg)
            SingleBillScreen(billName)
        }

        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks
        ) { navBackStackEntry ->
            val accountType =
                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
            SingleAccountScreen(accountType)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // re-selecting the same item
        launchSingleTop = true
        // Restore state when re-selecting a previously selected item
        restoreState = true
    }

private fun NavHostController.navigateToSingleAccount(accountType: String) {
    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
}

private fun NavHostController.navigateToSingleBill(billName: String) {
    this.navigateSingleTopTo("${SingleBill.route}/$billName")
}