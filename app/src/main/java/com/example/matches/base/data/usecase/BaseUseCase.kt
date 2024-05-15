package com.example.matches.base.data.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase<in P, R>(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

    protected abstract fun build(params: P): Flow<R>

    fun execute(params: P) = build(params).flowOn(dispatcher)
}