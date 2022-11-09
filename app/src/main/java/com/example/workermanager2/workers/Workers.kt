package com.example.workermanager2.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Worker1(
    context: Context, params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            val input = inputData.keyValueMap
            val seconds = input["seconds"] as Int
            repeat(seconds) {
                delay(1000)
                Log.d("worker111", "Worker1->$it")
            }
            val output = Data.Builder().putString("worker1", "worker1: $seconds").build()
            Log.d("worker111", "Worker1->return")
            return@withContext Result.success(output)
        }
    }
}

class Worker2(
    context: Context, params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            val input = inputData.keyValueMap
            val seconds = input["seconds"] as Int
            repeat(seconds) {
                delay(1000)
                Log.d("worker111", "Worker2->$it")
            }
            val output = Data.Builder().putString("worker2", "worker2: $seconds").build()
            Log.d("worker111", "Worker2->return")
            return@withContext Result.success(output)
        }
    }
}

class Worker3(
    context: Context, params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            val input = inputData.keyValueMap
            val seconds = input["seconds"] as Int
            repeat(seconds) {
                delay(1000)
                Log.d("worker111", "Worker3->$it")
            }
            val output = Data.Builder().putString("worker3", "worker3: $seconds").build()
            Log.d("worker111", "Worker3->return")
            return@withContext Result.success(output)
        }
    }
}

