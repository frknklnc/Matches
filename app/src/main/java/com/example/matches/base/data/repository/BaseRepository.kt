package com.example.matches.base.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


open class BaseRepository {

    protected fun <T> fetch(apiCall: suspend () -> T): Flow<T> {
        return flow<T> {
            emit(apiCall())
        }
    }
}