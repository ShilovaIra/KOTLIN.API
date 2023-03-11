package com.androidlab.app1.module

import com.androidlab.app1.mapper.impl.BreweryMapperImpl
import dagger.Module
import dagger.Provides

@Module
class BreweryModule {

    @Provides
    fun provideBreweryMapper(): BreweryMapperImpl {
        return BreweryMapperImpl()
    }
}