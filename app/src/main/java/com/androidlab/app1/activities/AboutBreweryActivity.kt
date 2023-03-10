package com.androidlab.app1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidlab.app1.Constants.Constants.Companion.NO_WEBSITE
import com.androidlab.app1.R
import com.androidlab.app1.models.Brewery
import com.androidlab.app1.services.BreweryService
import com.androidlab.app1.services.RetrofitClientInstance.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutBreweryActivity : AppCompatActivity() {

    private var brewName: TextView? = null
    private var brewStreet: TextView? = null
    private var brewType: TextView? = null
    private var brewWebSite: TextView? = null
    private var brewMobile: TextView? = null
    private var brewCity: TextView? = null
    private var brewState: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_data)
        getBreweryById(intent.extras!!.getString(BREW_ID)!!)
    }

    private fun getBreweryById(name: String) {

        brewName = findViewById(R.id.name)
        brewStreet = findViewById(R.id.street)
        brewType = findViewById(R.id.type)
        brewWebSite = findViewById(R.id.website)
        brewMobile = findViewById(R.id.phone)
        brewCity = findViewById(R.id.city)
        brewState = findViewById(R.id.state)

        val service = retrofitInstance!!.create(
            BreweryService::class.java
        )
        val secondCall: Call<Brewery?>? = service.getBreweryById(name)
        secondCall?.enqueue(object : Callback<Brewery?> {
            override fun onResponse(call: Call<Brewery?>, response: Response<Brewery?> ) {
                val brewery = response.body()

                brewName!!.text = brewery!!.name
                brewStreet!!.text = brewery!!.street
                brewType!!.text = brewery!!.breweryType
                if (brewery!!.websiteUrl == null) {
                    brewWebSite!!.text = NO_WEBSITE
                } else {
                    brewWebSite!!.text = brewery.websiteUrl
                }
                brewMobile!!.text = brewery!!.phone
                brewCity!!.text   = brewery!!.city
                brewState!!.text  = brewery!!.state
            }

            override fun onFailure(call: Call<Brewery?>, t: Throwable) {
                Toast.makeText(
                    this@AboutBreweryActivity,
                    "Something went wrong... Please try later!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    companion object {
        const val BREW_ID = "name"

        fun newIntent(context: Context, brewName: String?): Intent {
            val detailIntent = Intent(context, AboutBreweryActivity::class.java)
            detailIntent.putExtra(BREW_ID, brewName)
            return detailIntent
        }
    }
}