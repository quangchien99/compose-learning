package chn.phm.cashly.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Green500,
    surface = DarkBlue900,
    onSurface = Color.White,
    background = DarkBlue900,
    onBackground = Color.White
)

/**
 * A [MaterialTheme] for Rally.
 */
@Composable
fun CashlyTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = DarkColorScheme, typography = Typography, content = content)
}