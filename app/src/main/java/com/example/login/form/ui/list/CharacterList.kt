package com.example.login.form.ui.list

import android.widget.TextView
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
import okhttp3.internal.concurrent.TaskRunner.Companion.logger

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
                            logger.info(index.toString())

                            navController.navigate(NavRoutes.Detail.route + "/" + characters[index].id)
                        }
                    )
            ) {
                Column{
                    AsyncImage(
                        model = characters[index].image_link,
                        contentDescription = null
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 5.dp),
                        text = characters[index].name
                    )

                }

            }
        }
    }
}