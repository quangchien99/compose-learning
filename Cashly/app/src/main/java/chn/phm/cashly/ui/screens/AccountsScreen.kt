package chn.phm.cashly.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import chn.phm.cashly.R
import chn.phm.cashly.data.UserData
import chn.phm.cashly.ui.common.AccountRow
import chn.phm.cashly.ui.common.DetailBody

/**
 * The Accounts screen.
 */
@Composable
fun AccountsScreen(
    onAccountClick: (String) -> Unit = {}
) {
    val totalAmount = remember {
        UserData.accounts.map { account -> account.balance }.sum()
    }

    DetailBody(
        modifier = Modifier.semantics { contentDescription = "Accounts Screen" },
        items = UserData.accounts,
        colors = { account -> account.color },
        amounts = { account -> account.balance },
        totalAmount = totalAmount,
        circleLabel = stringResource(id = R.string.total)
    ) { account ->
        AccountRow(
            modifier = Modifier.clickable {
                onAccountClick(account.name)
            },
            name = account.name,
            number = account.number,
            amount = account.balance,
            color = account.color
        )
    }
}

/**
 * Detail screen for a single account.
 */
@Composable
fun SingleAccountScreen(
    accountType: String? = UserData.accounts.first().name
) {
    val account = remember(accountType) { UserData.getAccount(accountType) }
    DetailBody(
        items = listOf(account),
        colors = { account.color },
        amounts = { account.balance },
        totalAmount = account.balance,
        circleLabel = account.name,
    ) { row ->
        AccountRow(
            name = row.name,
            number = row.number,
            amount = row.balance,
            color = row.color
        )
    }
}