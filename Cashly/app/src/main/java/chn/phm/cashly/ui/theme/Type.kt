package chn.phm.cashly.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import chn.phm.cashly.R

private val EczarFontFamily = FontFamily(
    Font(R.font.eczar_regular),
    Font(R.font.eczar_semibold, FontWeight.SemiBold)
)
private val RobotoCondensed = FontFamily(
    Font(R.font.robotocondensed_regular),
    Font(R.font.robotocondensed_light, FontWeight.Light),
    Font(R.font.robotocondensed_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = RobotoCondensed,
        fontSize = 96.sp,
        fontWeight = FontWeight.W100
    ),
    displayMedium = TextStyle(
        fontFamily = EczarFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 44.sp,
        letterSpacing = 1.5.sp
    ),
    displaySmall = TextStyle(
        fontFamily = RobotoCondensed,
        fontSize = 14.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.W700,
        fontSize = 34.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = RobotoCondensed,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700
    ),
    headlineSmall = TextStyle(
        fontFamily = EczarFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        fontSize = 18.sp,
        letterSpacing = 3.sp
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 3.sp
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.1.em
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.1.em
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        letterSpacing = 0.1.em
    ),
    labelLarge = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.em
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp
    )
)