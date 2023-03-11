package com.androidlab.app1.processor

import com.androidlab.app1.mapper.impl.BreweryMapperImpl
import com.androidlab.app1.module.BreweryModule
import com.androidlab.app1.service.impl.BreweryServiceImpl
import dagger.Component

@Component(modules = [BreweryModule::class])
interface TestBrewProcessor: BrewsProcessor {
    override fun service(): BreweryServiceImpl
    override fun getMapper(): BreweryMapperImpl
}