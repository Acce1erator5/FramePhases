package uz.ttpu.framephases

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawDemo() {
    var color by remember { mutableStateOf(Color.Red) }
    SideEffect { Log.d("Phases", "DrawDemo: composition") }

    Column {
        Button(onClick = { color = if (color == Color.Red) Color.Green else Color.Red }) {
            Text("Change Color")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(
            modifier = Modifier
                .size(100.dp)
                .logPhases("Draw demo")
                .drawBehind {
                    drawRect(color)
                }
        )
    }
}
