package me.argraur.donate.layouts

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ColumnScope.gravity
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import me.argraur.donate.R
import me.argraur.donate.elements.HeaderText

@Composable
fun FormLayout(activity: AppCompatActivity, isTargeted: Boolean) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (formText, divider, fab, card, nameText) = createRefs()
        HeaderText(
                modifierText = Modifier
                        .constrainAs(formText) {
                            top.linkTo(parent.top, margin = 28.dp)
                            centerHorizontallyTo(parent)
                        }
                        .selectable(selected = false, enabled = false, onClick = {}),
                modifierDivider = Modifier
                        .constrainAs(divider) {
                            top.linkTo(formText.bottom, margin = 28.dp)
                            absoluteRight.linkTo(parent.absoluteRight, margin = 10.dp)
                        },
                text = if (!isTargeted) "Регулярный сбор" else "Целевой сбор",
                modifierFab = Modifier
                        .constrainAs(fab) {
                            top.linkTo(formText.top)
                            bottom.linkTo(formText.bottom)
                            start.linkTo(parent.start, margin = 10.dp)
                        },
                activity = activity
        )
        Card(modifier = Modifier.fillMaxWidth().padding(12.dp, 0.dp, 12.dp).constrainAs(card) {
            top.linkTo(formText.bottom, margin = 4.dp)
        }, backgroundColor = Color.Transparent, border = BorderStroke(1.dp, Color(0xFF3F8AE0)), shape = RoundedCornerShape(15.dp), elevation = 0.dp) {
            ConstraintLayout(Modifier.fillMaxWidth()) {
                val (text, image) = createRefs()
                Text("Загрузить обложку", fontWeight = FontWeight.SemiBold,fontSize = TextUnit.Sp(16), modifier = Modifier.padding(0.dp, 60.dp, 0.dp, 60.dp).constrainAs(text) {
                    centerHorizontallyTo(parent)
                }, color = Color(0xFF3F8AE0))
                Image(vectorResource(id = R.drawable.ic_addimage), Modifier.constrainAs(image) {
                    end.linkTo(text.start, margin = 11.dp)
                }.padding(0.dp, 59.dp, 0.dp, 59.dp))
            }
        }
        Text("Название сбора", color = Color(0xFF6D7885), modifier = Modifier.constrainAs(nameText) {
            top.linkTo(card.bottom, margin = 26.dp)
            start.linkTo(parent.start, margin = 12.dp)
        })
    }
}