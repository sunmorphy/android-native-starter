package com.andikas.nativestarter.core.data

import com.andikas.nativestarter.core.data.source.local.LocalDataSource
import com.andikas.nativestarter.core.data.source.remote.RemoteDataSource
import com.andikas.nativestarter.domain.IDataRepository
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IDataRepository {

}