package me.argraur.donate.layouts

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import me.argraur.donate.ui.DonateTheme

@Composable
fun DonationsLayout(activity: AppCompatActivity) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (donationsText, noGatherings, button, divider) = createRefs()
        Text(
                text = "Пожертвования",
                textAlign = TextAlign.Center,
                fontSize = TextUnit.Sp(24),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                        .constrainAs(donationsText) {
                            top.linkTo(parent.top, margin = 28.dp)
                            centerHorizontallyTo(parent)
                        }
                        .selectable(selected = false, enabled = false, onClick = {})
        )
        Divider(
                color = if (isSystemInDarkTheme()) Color.Gray else Color.LightGray,
                startIndent = 20.dp,
                thickness = 2.dp,
                modifier = Modifier
                        .constrainAs(divider) {
                            top.linkTo(donationsText.bottom, margin = 28.dp)
                            absoluteRight.linkTo(parent.absoluteRight, margin = 10.dp)
                        }
        )
        Text(
                text = "У вас пока нет сборов.\nНачните доброе дело.",
                textAlign = TextAlign.Center,
                fontSize = TextUnit.Sp(17),
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                modifier = Modifier
                        .constrainAs(noGatherings) {
                            centerHorizontallyTo(parent)
                            centerVerticallyTo(parent)
                        }
                        .selectable(selected = false, enabled = false, onClick = {})
        )
        Button(
                onClick = {
                    activity.setContent {
                        DonateTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(color = MaterialTheme.colors.background) {
                                ChooseTypeLayout(activity)
                            }
                        }
                    }
                },
                modifier = Modifier
                        .constrainAs(button) {
                            centerHorizontallyTo(parent)
                            top.linkTo(noGatherings.bottom, 18.dp)
                        },
                shape = RoundedCornerShape(30)
        ) {
            Text(
                    text = "Создать сбор",
                    letterSpacing = TextUnit.Sp(0)
            )
        }
    }
}