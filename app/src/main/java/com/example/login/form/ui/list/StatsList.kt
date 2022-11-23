import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.form.R
import com.example.viewmodels.MainViewModel

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun PowerStatsList(
    id: Int,
    viewModel: MainViewModel,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val rotateState = animateFloatAsState(
        targetValue = if (expanded) 180F else 0F,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth().padding(0.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .selectable(
                    selected = expanded,
                    onClick = {
                        expanded = !expanded
                        onClick()
                    }
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Statistics",
                fontSize = 20.sp
            )
            Icon(
                Icons.Default.ArrowDropDown, "",
                modifier = Modifier.rotate(rotateState.value),
            )
        }

        AnimatedVisibility(
            visible = expanded,
        ) {
            Column {
                Row {

                    Icon(painter = painterResource(R.drawable.length), "",)
                    Text(text = "Length: ${viewModel.characterList[id].length_min} - ${viewModel.characterList[id].length_max}",
                         fontSize = 40.sp)
                }
                Row {
                    Icon(painter = painterResource(R.drawable.weight), "",)
                    Text(text = "Weight: ${viewModel.characterList[id].weight_min} - ${viewModel.characterList[id].weight_max}",
                         fontSize = 40.sp)
                }
                Row {
                    Icon(painter = painterResource(R.drawable.time), "",)
                    Text(text = "Lifetime: ${viewModel.characterList[id].lifespan} years",
                         fontSize = 40.sp)
                }
            }
        }
    }
}

@Composable
fun IconRow(text: String, iconId: Int) {
    Row(Modifier.padding(10.dp)) {
        Text(
            text = text
        )
        Icon(
            painter = painterResource(iconId),
            contentDescription = null
        )
    }
}