
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.form.R
import com.example.login.form.ui.NavRoutes
import com.example.login.form.ui.theme.LoginFormTheme
import com.example.utils.Keyboard
import com.example.utils.keyboardAsState

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val isKeyboardOpen by keyboardAsState()

        if (isKeyboardOpen === Keyboard.Closed) {
            Image(
                painter = painterResource(R.drawable.ellipse_1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(180.dp)
                    .height(130.dp)
                    .align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(R.drawable.vector),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 40.dp, top = 15.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.ellipse_2),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(165.dp)
                .height(240.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.study_in),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )


            Spacer(modifier = Modifier.height(95.dp))

            var userName by remember { mutableStateOf("") }
            val onUserNameChange = { text : String ->
                userName = text
            }
            usernameInput("Create Username", userName, onUserNameChange)

            Spacer(modifier = Modifier.height(20.dp))

            var password by remember { mutableStateOf("") }
            val onPasswordChange = { text : String ->
                password = text
            }
            passwordInput("Create Password", password, onPasswordChange)

            Spacer(modifier = Modifier.height(20.dp))

            var emailId by remember { mutableStateOf("") }
            val onEmailIdChange = { text : String ->
                emailId = text
            }
            emailInput("Email ID", emailId, onEmailIdChange)

            Spacer(modifier = Modifier.height(35.dp))

            joinButton(navController, userName, password, emailId)
        }

        if (isKeyboardOpen === Keyboard.Closed) {
            Image(
                painter = painterResource(R.drawable.ellipse_3),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(170.dp)
                    .height(130.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun joinButton(navController: NavHostController, username: String, password: String, email: String) {
    val context = LocalContext.current

    Button(
        contentPadding = PaddingValues(bottom = 3.dp),
        onClick = {
            if (username.trim() != "" && password.trim() != "" && email.trim() != "") {
                Toast.makeText(context, "Completed", Toast.LENGTH_LONG).show()
                navController.navigate(NavRoutes.List.route)
            }
            else {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }
        },
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults
            .buttonColors(backgroundColor = Color.Black, contentColor = Color.White),
        modifier = Modifier
            .width(170.dp)
            .height(45.dp),
    )
    {
        Text("Join Us", fontSize = 25.sp, fontWeight = FontWeight(700))
    }
}

@Composable
fun passwordInput(placeholder: String, text: String, onTextChange: (String) -> Unit) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text,
        onValueChange =  { onTextChange(it) },
        placeholder = { Text(
            text = placeholder,
            fontSize = 20.sp,
        ) },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(287.dp)
            .height(56.dp)
            .background(Color.Transparent)
            .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.moveFocus(FocusDirection.Next)
        }),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun usernameInput(placeholder: String, text: String, onTextChange: (String) -> Unit) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text,
        onValueChange =  { onTextChange(it) },
        placeholder = { Text(
            text = placeholder,
            fontSize = 20.sp,
        ) },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(287.dp)
            .height(56.dp)
            .background(Color.Transparent)
            .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.moveFocus(FocusDirection.Next)
        }),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
    )
}

@Composable
fun emailInput(placeholder: String, text: String, onTextChange: (String) -> Unit) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text,
        onValueChange =  { onTextChange(it) },
        placeholder = { Text(
            text = placeholder,
            fontSize = 20.sp,
        ) },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(287.dp)
            .height(56.dp)
            .background(Color.Transparent)
            .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.moveFocus(FocusDirection.Next)
        }),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
    )
}

private fun checkInput(username: String, password: String, email: String): String {
    if (username.trim() != "" && password.trim() != "" && email.trim() != "") {
        return "Completed"
    }

    return "Error"
}