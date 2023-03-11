package com.androidlab.app1.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidlab.app1.Constants.Constants
import com.androidlab.app1.R
import com.androidlab.app1.models.Brewery
import com.androidlab.app1.controllers.BreweryController
import com.androidlab.app1.controllers.RetrofitClientInstance.retrofitInstance
import com.androidlab.app1.mapper.impl.BreweryMapperImpl
import com.androidlab.app1.processor.BrewsProcessor
import com.androidlab.app1.processor.DaggerBrewsProcessor
import com.androidlab.app1.service.BreweryService
import com.androidlab.app1.service.impl.BreweryServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrewListActivity : AppCompatActivity() {

    private var listView: ListView? = null

    val brewsProcessor: BreweryServiceImpl = DaggerBrewsProcessor.create().service()
    val brewMapper: BreweryMapperImpl = DaggerBrewsProcessor.create().getMapper()

    private val controller: BreweryController = retrofitInstance!!.create(
        BreweryController::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        listView = findViewById(R.id.breweriesListView)
        getBreweries()
    }

    private fun getBreweries() {

        val call: Call<List<Brewery?>?>? = controller.getBreweries()
        call?.enqueue(object : Callback<List<Brewery?>?> {
            override fun onResponse(call: Call<List<Brewery?>?>,
                                    response: Response<List<Brewery?>?>,
            ) {
                val res = response.body()
                var breweriesList = arrayOfNulls<String>(res!!.size)
                for (i in res.indices) {
                    val brew = res[i]
                    breweriesList[i] = brew!!.id
                }

                breweriesList = brewsProcessor.updateList(breweriesList)

                listView!!.adapter = ArrayAdapter(
                    this@BrewListActivity,
                    android.R.layout.simple_list_item_1,
                    breweriesList
                )

                listView!!.setOnItemClickListener { _, _, position, _ ->
                    val selectedBrew = breweriesList[position]
                    val detailIntent = AboutBreweryActivity.newIntent(
                        this@BrewListActivity,
                        selectedBrew
                    )
                    startActivity(detailIntent)
                }
            }

            override fun onFailure(call: Call<List<Brewery?>?>, t: Throwable) {
                Toast.makeText(
                    this@BrewListActivity,
                    Constants.UNABLE_TO_FIND_BREWS,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }


}