package com.kiy.report.core.api.impl.di

import com.kiy.report.core.api.impl.MusinsaRepositoryImpl
import com.kiy.report.data.api.MusinsaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 7.
 */

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
     @Binds
     @Singleton
     abstract fun bindsMusinsaRepository(
         repository: MusinsaRepositoryImpl,
     ): MusinsaRepository
}
