package com.example.listmatkul

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listmatkul.ui.theme.ListmatkulTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val matkularray = resources.getStringArray(R.array.list_matkul)
            val sksarray = resources.getStringArray(R.array.list_sks)

            ListMatkul(matkularray.size,matkularray,sksarray)
        }
    }
}

@Composable
fun ListMatkul(item:Int, matkul:Array<String>,sks:Array<String>){

    Surface(modifier = Modifier) {
        Column {
            judul(text = "Siakad Si Adam")
            LazyColumn(contentPadding = PaddingValues(12.dp)){
                items(matkul.size){
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)) {
                        Row(modifier = Modifier) {
                            Image(painter = painterResource(id = R.drawable.logo_unj),
                                contentDescription =null,
                                modifier = Modifier.padding(horizontal = 20.dp))
                            Column(modifier = Modifier) {
                                Text(text = matkul[it],
                                    fontSize = 20.sp)
                                Text(text = sks[it],
                                    fontSize = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun judul(text:String){
    CenterAlignedTopAppBar(
        title = { Text(text = text, fontSize = 30.sp)},
        modifier = Modifier.fillMaxWidth())
}

