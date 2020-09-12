package me.argraur.donate.layouts

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import me.argraur.donate.elements.TypeCard
import me.argraur.donate.ui.DonateTheme

@Composable
fun ChooseTypeLayout(activity: AppCompatActivity) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (donationsText, fab, divider, card1, card2) = createRefs()
        FloatingActionButton(
                onClick = {
                    activity.setContent {
                        DonateTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(color = MaterialTheme.colors.background) {
                                DonationsLayout(activity)
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
                modifier = Modifier
                        .constrainAs(fab) {
                            top.linkTo(donationsText.top)
                            bottom.linkTo(donationsText.bottom)
                            start.linkTo(parent.start, margin = 10.dp)
                        }
        )
        Text(
                text = "Тип сбора",
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
        TypeCard(
                modifier = Modifier
                        .constrainAs(card1) {
                            centerHorizontallyTo(parent)
                            centerVerticallyTo(parent)
                        }
                        .padding(10.dp, 0.dp, 10.dp, 0.dp)
                        .clickable(onClick = {
                            activity.setContent {
                                DonateTheme {
                                    // A surface container using the 'background' color from the theme
                                    Surface(color = MaterialTheme.colors.background) {
                                        FormLayout(activity = activity, isTargeted = true)
                                    }
                                }
                            }
                        }),
                text1str = "Целевой сбор",
                text2str = "Когда есть определенная цель",
                vectorAsset = vectorResource(id = R.drawable.ic_targeted)
        )
        TypeCard(
                modifier = Modifier
                        .constrainAs(card2) {
                            centerHorizontallyTo(parent)
                            top.linkTo(card1.bottom, margin = 12.dp)
                        }
                        .padding(10.dp, 0.dp, 10.dp, 0.dp)
                        .clickable(onClick = {
                            activity.setContent {
                                DonateTheme {
                                    // A surface container using the 'background' color from the theme
                                    Surface(color = MaterialTheme.colors.background) {
                                        FormLayout(activity = activity, isTargeted = false)
                                    }
                                }
                            }
                        }),
                text1str = "Регулярный сбор",
                text2str = "Если помощь нужна ежемесячно",
                vectorAsset = vectorResource(id = R.drawable.ic_regular)
        )
    }
}