package me.argraur.donate.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import me.argraur.donate.R

@Composable
fun TypeCard(modifier: Modifier, text1str: String, text2str: String, vectorAsset: VectorAsset) {
    Card(
            modifier = modifier,
            backgroundColor = if (!isSystemInDarkTheme()) Color(0xFFF5F5F5) else Color.DarkGray,
            elevation = 0.dp,
            shape = RoundedCornerShape(15.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (image, text1, text2, next) = createRefs()
            Image(vectorAsset, modifier = Modifier.constrainAs(image) {
                start.linkTo(parent.start, margin = 10.dp)
                centerVerticallyTo(parent)
            })
            Text(text1str, fontSize = TextUnit.Sp(16), fontWeight = FontWeight.Black, modifier = Modifier.constrainAs(text1) {
                start.linkTo(image.end, margin = 14.dp)
            }.padding(0.dp, 12.dp, 0.dp, 0.dp))
            Text(text2str, fontSize = TextUnit.Sp(13), color = if (!isSystemInDarkTheme()) Color (0xFF6D7885) else Color.LightGray, modifier = Modifier.constrainAs(text2) {
                top.linkTo(text1.bottom, margin = 2.dp)
                start.linkTo(image.end, margin = 14.dp)
            }.padding(0.dp, 0.dp, 0.dp, 12.dp))
            Image(vectorResource(id = R.drawable.ic_next), modifier = Modifier
                    .constrainAs(next) {
                        end.linkTo(parent.end, margin = 18.75.dp)
                        centerVerticallyTo(parent)
                    }
                    .padding(0.dp, 3.dp, 0.dp, 0.dp))
        }
    }
}