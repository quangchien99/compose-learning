package chn.phm.cashly

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Contract for information needed on every Rally navigation destination
 */

interface CashlyDestination {
    val icon: ImageVector
    val route: String
}

/**
 * Rally app navigation destinations
 */
object Overview : CashlyDestination {
    override val icon = Icons.Filled.PieChart
    override val route = "overview"
}

// Screens to be displayed in the top CashlyTabRow
val cashlyTabRowScreens = listOf(Overview)