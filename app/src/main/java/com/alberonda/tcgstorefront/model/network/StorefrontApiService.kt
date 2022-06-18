package com.alberonda.tcgstorefront.model.network

import com.alberonda.tcgstorefront.model.network.responses.GetGamesResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://api.cardtrader.com"

private const val accessToken =
    "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJjYXJkdHJhZGVyLXByb2R1Y3Rpb24iLCJzdWIiOiJhcHA6MzU4NCIsImF1ZCI6ImFwcDozNTg0IiwiZXhwIjo0ODA4NTQzMzUyLCJqdGkiOiI2MzI5MjBiMi05YjZjLTQ3MTItYTJjYi1lOWU2ZWM3MTBkOTUiLCJpYXQiOjE2NTI4Njk3NTIsIm5hbWUiOiJhbGJlcnRvcmV5ZXNtYXJ0aW4gQXBwIDIwMjExMjIyMTAzODUyIn0.ontZWDVwbH9ttbK8R8yBn5Vj_GosD8bJsHDxt1DWx3LaS7ZMYNPke0_2Hs5p6LMRmmshTLHyXZI-0fBlXHzYY_UWDOMD18qPAtsvjJfigrEjDzShuOkGmTC9_BvFgvGeZpEPUgDwQW1ByRNGGfp3TknX9HzTatpwUMXHPZKgy1Aqn4PWyT9CAo50Zdgjq2foKG33s0YtsoVJawOQM8MDgd7BQN3_9jamRE5Od83yALo3jW9ONDiRKjJ_2Es4Tnuysuske3Zv-cRN06szAlj_6eDumToYerFLmMUfymSlOgPVEjJkOV94opKCsA9tybL1Lu39uuzvy26eM9GZT3vgwQ"

/**
 * Build interceptor to add auth header
 */
var client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest: Request = chain.request().newBuilder()
        .addHeader("Authorization", "Bearer $accessToken")
        .build()
    chain.proceed(newRequest)
}.build()

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StorefrontApiService {
    @GET("api/v2/games")
    suspend fun getGames() : GetGamesResponse
}

object RetrofitService {
    val retrofitService : StorefrontApiService by lazy {
        retrofit.create(StorefrontApiService::class.java)
    }
}