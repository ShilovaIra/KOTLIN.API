package com.androidlab.app1.service.impl

import com.androidlab.app1.service.BreweryService
import com.androidlab.app1.mapper.impl.BreweryMapperImpl
import javax.inject.Inject


class BreweryServiceImpl @Inject constructor(private val breweryMapperImpl: BreweryMapperImpl): BreweryService {

    override fun updateList(breweriesList: Array<String?>): Array<String?> {
        return breweryMapperImpl.brewToBrewMapper(breweriesList)
    }

}