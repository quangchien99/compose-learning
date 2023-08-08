package chn.phm.cashly.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import chn.phm.cashly.R
import chn.phm.cashly.data.Bill
import chn.phm.cashly.data.UserData
import chn.phm.cashly.ui.common.BillRow
import chn.phm.cashly.ui.common.DetailBody

@Composable
fun BillsScreen(
    onBillClick: (String) -> Unit = {},
    bills: List<Bill> = remember {
        UserData.bills
    }
) {
    DetailBody(
        modifier = Modifier.clearAndSetSemantics { contentDescription = "Bills" },
        items = bills,
        colors = { bill -> bill.color },
        amounts = { bill -> bill.amount },
        totalAmount = bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(id = R.string.due)
    ) { bill ->
        BillRow(
            modifier = Modifier.clickable {
                onBillClick(bill.name)
            },
            name = bill.name,
            due = bill.due,
            amount = bill.amount,
            color = bill.color
        )
    }
}

/**
 * Detail screen for a single bill.
 */
@Composable
fun SingleBillScreen(
    billName: String? = UserData.bills.first().name
) {
    val bill = remember(billName) { UserData.getBill(billName) }
    DetailBody(
        items = listOf(bill),
        colors = { bill.color },
        amounts = { bill.amount },
        totalAmount = bill.amount,
        circleLabel = bill.name,
    ) { row ->
        BillRow(
            name = row.name,
            due = row.due,
            amount = row.amount,
            color = row.color
        )
    }
}