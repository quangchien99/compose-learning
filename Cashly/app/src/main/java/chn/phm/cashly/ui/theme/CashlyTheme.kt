package chn.phm.cashly.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Green500,
    surface = DarkBlue900,
    onSurface = Color.White,
    background = DarkBlue900,
    onBackground = Color.White
)

private val DarkDialogColorScheme = darkColorScheme(
    primary = Color.White,
    surface = Color.White.copy(alpha = 0.12f).compositeOver(Color.Black),
    onSurface = Color.White
)

/**
 * A [MaterialTheme] for Cashly.
 */
@Composable
fun CashlyTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = DarkColorScheme, typography = Typography, content = content)
}

/**
 * A theme overlay used for dialogs.
 */
@Composable
fun CashlyDialogThemeOverlay(content: @Composable () -> Unit) {
    val currentTypography = MaterialTheme.typography
    val dialogTypography = currentTypography.copy(
        bodyLarge = currentTypography.bodyLarge.copy(
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            letterSpacing = 1.sp
        ),
        labelMedium = currentTypography.labelMedium.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.2.em
        )
    )
    MaterialTheme(
        colorScheme = DarkDialogColorScheme,
        typography = dialogTypography,
        content = content
    )
}