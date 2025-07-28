package com.andikas.nativestarter.core.data.source.remote

import com.andikas.nativestarter.core.data.source.remote.network.Network
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val network: Network
) {
    val service = network.api
}