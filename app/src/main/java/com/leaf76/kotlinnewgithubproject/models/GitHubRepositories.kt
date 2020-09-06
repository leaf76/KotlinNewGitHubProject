package com.leaf76.kotlinnewgithubproject.models

import android.util.Log
import com.google.gson.Gson
import com.leaf76.kotlinnewgithubproject.api.response.SearchUsersResponse
import com.leaf76.kotlinnewgithubproject.objects.APIResultWrapper
import kotlinx.coroutines.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception

private const val TAG = "GitHubRepositories"

class GitHubRepositories {

    private val client = OkHttpClient()
    private val gson = Gson()

    // Function that makes the network request, blocking the current thread
    suspend fun makeSearchUsersRequest(
        jsonBody: String
    ): APIResultWrapper<SearchUsersResponse> = withContext(Dispatchers.IO) {
        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.github.com")
            .addPathSegments("search/users")
            .addQueryParameter("q", "leaf76")
            .build()

        Log.d(TAG, "makeSearchUsersRequest: show $url")

        val request = Request.Builder()
            .url(url)
            .build()
        return@withContext try {
            val r = client.newCall(request).execute()

            val getCode = r.code
            Log.d(TAG, "makeSearchUsersRequest: show code: $getCode")

            val rBody = r.body?.string()

            Log.d(TAG, "makeSearchUsersRequest: show body: $rBody")
            val response = gson.fromJson(rBody, SearchUsersResponse::class.java)
            APIResultWrapper.Success(response)
        } catch (e: Exception) {
            Log.e(TAG, "makeSearchUsersRequest: show error ${e.message}")
            APIResultWrapper.Error(e)
        }
    }
}