package com.leaf76.kotlinnewgithubproject.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leaf76.kotlinnewgithubproject.models.GitHubRepositories
import com.leaf76.kotlinnewgithubproject.objects.APIResultWrapper
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {

    private val gitHubRepositories = GitHubRepositories()

    fun getSearchGitHubUsers() = viewModelScope.launch {
        when (val result = gitHubRepositories.makeSearchUsersRequest("123")) {
            is APIResultWrapper.Success -> {
                Log.d(TAG, "getSearchGitHubUsers: show data: ${result.data}")
            }
            is APIResultWrapper.Error -> {
                Log.d(TAG, "getSearchGitHubUsers: show exception: ${result.exception}")
            }
        }
    }
}