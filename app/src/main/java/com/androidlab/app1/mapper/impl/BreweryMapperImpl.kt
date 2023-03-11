package com.androidlab.app1.mapper.impl

import com.androidlab.app1.mapper.BreweryMapper
import javax.inject.Inject

//class BreweryMapperImpl @Inject constructor(): BreweryMapper {
class BreweryMapperImpl: BreweryMapper {

     override fun brewToBrewMapper(breweriesList: Array<String?>): Array<String?> {
        //var brewery: Brewery = Brewery()
        val newBrewsList = arrayOfNulls<String>(breweriesList.size)
        for (i in breweriesList.indices) {
            newBrewsList[i] = "Hello " + breweriesList[i]
        }
        return newBrewsList
    }
}