package com.androidlab.app1.module

import com.androidlab.app1.mapper.impl.BreweryMapperImpl
import dagger.Module
import dagger.Provides
import org.junit.Test

import org.junit.Assert.*

@Module
class BreweryModuleTest {
    @Provides
    fun provideBreweryMapper(): BreweryMapperImpl {
        return BreweryMapperImpl()
    }
}