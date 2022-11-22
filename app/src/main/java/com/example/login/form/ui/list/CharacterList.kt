package com.example.login.form.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.login.form.R
import com.example.login.form.data.Character
import com.example.login.form.ui.NavRoutes
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig

@Composable
fun CharacterList(navController: NavHostController, characters: List<Character>) {
    LazyVerticalGrid (columns = GridCells.Adaptive(160.dp)){
        items(characters.size) { index ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            navController.navigate(NavRoutes.Detail.route + "/" + index)
                        }
                    )
            ) {
                Column{
                    AsyncImage(
                        model = characters[index].images.icon,
                        contentDescription = null
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 5.dp),
                        text = characters[index].name
                    )

                    Row (modifier = Modifier.padding(start = 7.dp, bottom = 10.dp, top = 5.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.attack),
                            contentDescription = null
                        )

                        Text(
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 5.dp),
                            text = characters[index].attack_type
//                            text = characters[index].attack_type,
////                            powerstats.power.toFloat() / 20,
//                            config = RatingBarConfig()
//                                .size(15.dp)
//                                .numStars(5),
//                            onValueChange = {},
//                            onRatingChanged = {}
                        )
                    }
                }

            }
        }
    }
}