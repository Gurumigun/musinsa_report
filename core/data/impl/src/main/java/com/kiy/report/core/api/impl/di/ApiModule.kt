package com.kiy.report.core.api.impl.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kiy.report.core.api.impl.api.MusinsaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {
    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        prettyPrint = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClientCache(
        @ApplicationContext context: Context,
    ): OkHttpClient {
        val cacheTime = 60 * 5
        val cacheSize = (5 * 1024 * 1024).toLong()
        val cache = Cache(File(context.cacheDir, "http_cache"), cacheSize)

        val apiKeyInterceptor = Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    .header("Cache-Control", "public, max-age=$cacheTime")
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        json: Json,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://meta.musinsa.com/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaTypeOrNull()!!))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideKakakoApi(retrofit: Retrofit): MusinsaApi {
        return retrofit.create(MusinsaApi::class.java)
    }
}
