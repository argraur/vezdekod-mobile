package me.argraur.donate.elements

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ConstraintLayoutScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import me.argraur.donate.R
import me.argraur.donate.layouts.ChooseTypeLayout
import me.argraur.donate.layouts.DonationsLayout
import me.argraur.donate.ui.DonateTheme

@Composable
fun HeaderText(modifierText: Modifier, modifierDivider: Modifier, modifierFab: Modifier, text: String, activity: AppCompatActivity) {
    FloatingActionButton(
            onClick = {
                activity.setContent {
                    DonateTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(color = MaterialTheme.colors.background) {
                            ChooseTypeLayout(activity = activity)
                        }
                    }
                }
            },
            icon = {
                Image(
                        vectorResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                )
            },
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            modifier = modifierFab
    )
    Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = TextUnit.Sp(24),
            fontWeight = FontWeight.Bold,
            modifier = modifierText
    )
    Divider(
            color = if (isSystemInDarkTheme()) Color.Gray else Color.LightGray,
            startIndent = 20.dp,
            thickness = 2.dp,
            modifier = modifierDivider
    )
}