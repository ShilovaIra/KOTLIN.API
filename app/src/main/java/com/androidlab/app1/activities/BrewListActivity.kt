package com.androidlab.app1.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidlab.app1.R
import com.androidlab.app1.models.Brewery
import com.androidlab.app1.services.BreweryService
import com.androidlab.app1.services.RetrofitClientInstance.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrewListActivity : AppCompatActivity() {

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        listView = findViewById(R.id.breweriesListView)
        getBreweries()
    }

    private fun getBreweries() {
        val service = retrofitInstance!!.create(
            BreweryService::class.java
        )

        val call: Call<List<Brewery?>?>? = service.getBreweries()
        call?.enqueue(object : Callback<List<Brewery?>?> {
            override fun onResponse(call: Call<List<Brewery?>?>,
                                    response: Response<List<Brewery?>?>,
            ) {
                val res = response.body()
                val breweriesList = arrayOfNulls<String>(res!!.size)
                for (i in res.indices) {
                    val brew = res[i]
                    breweriesList[i] = brew!!.id
                }

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
                    "Something went wrong...Please try later!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }


}