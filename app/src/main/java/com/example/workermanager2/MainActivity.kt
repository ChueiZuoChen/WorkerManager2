package com.example.workermanager2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.workermanager2.ui.theme.WorkerManager2Theme
import com.example.workermanager2.workers.Worker1
import com.example.workermanager2.workers.Worker2
import com.example.workermanager2.workers.Worker3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkerManager2Theme {
                HomeView(modifier = Modifier.fillMaxSize(), applicationContext)
            }
        }
    }
}

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    applicationContext: Context
) {
    Button(onClick = {
        val work1 = OneTimeWorkRequestBuilder<Worker1>().setInputData(workDataOf("seconds" to 5)).build()
        val work2 = OneTimeWorkRequestBuilder<Worker2>().setInputData(workDataOf("seconds" to 10)).build()
        val work3 = OneTimeWorkRequestBuilder<Worker3>().setInputData(workDataOf("seconds" to 15)).build()

        val wm1 = WorkManager.getInstance(applicationContext)
            .beginWith(listOf(work1,work2))
            .then(work3)
            .enqueue()
        Log.d("worker111", "wm1: ${wm1.result}")

    }) {
        Text(text = "Start")
    }
}