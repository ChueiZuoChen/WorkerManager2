package com.example.workermanager2.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
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
            var counter = 0
            repeat(seconds) {
                delay(1000)
                Log.d("worker111", "Worker1->$it")
                counter += seconds
            }
            Log.d("worker111", "Worker1->return")
            return@withContext Result.success(workDataOf("result1" to counter))
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
            var counter = 0
            repeat(seconds) {
                delay(1000)
                Log.d("worker111", "Worker2->$it")
                counter += seconds
            }
            Log.d("worker111", "Worker2->return")
            return@withContext Result.success(workDataOf("result2" to counter))
        }
    }
}

class Worker3(
    context: Context, params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            val input = inputData.keyValueMap
            val work1Result = input["result1"] as Int
            val work2Result = input["result2"] as Int
            Log.d("worker111", "work1Result->$work1Result")
            Log.d("worker111", "work2Result->$work2Result")
            Log.d("worker111", "Worker3->return")
            return@withContext Result.success(workDataOf("sum" to work1Result + work2Result))
        }
    }
}

