package com.androidlab.app1.models

import com.google.gson.annotations.SerializedName

class Brewery {

    @SerializedName("id")
    val id: String? = null
    @SerializedName("name")
    val name: String? = null
    @SerializedName("brewery_type")
    val breweryType: String? = null
    @SerializedName("street")
    val street: String? = null
    @SerializedName("address_2")
    val secondAddress: String? = null
    @SerializedName("address_3")
    val thirdAddress: String? = null
    @SerializedName("city")
    val city: String? = null
    @SerializedName("state")
    val state: String? = null
    @SerializedName("county_province")
    val countyProvince: String? = null
    @SerializedName("postal_code")
    val postalCode: String? = null
    @SerializedName("country")
    val country: String? = null
    @SerializedName("longitude")
    val longitude: String? = null
    @SerializedName("latitude")
    val latitude: String? = null
    @SerializedName("phone")
    val phone: String? = null
    @SerializedName("website_url")
    val websiteUrl: String? = null
    @SerializedName("updated_at")
    val updatedAt: String? = null
    @SerializedName("created_at")
    val createdAt: String? = null

    override fun toString(): String {
        return "Brewery(id=$id," +
                " name=$name," +
                " breweryType=$breweryType," +
                " street=$street," +
                " secondAddress=$secondAddress," +
                " thirdAddress=$thirdAddress," +
                " city=$city," +
                " state=$state," +
                " countyProvince=$countyProvince," +
                " postalCode=$postalCode," +
                " country=$country," +
                " longitude=$longitude," +
                " latitude=$latitude," +
                " phone=$phone," +
                " websiteUrl=$websiteUrl," +
                " updatedAt=$updatedAt," +
                " createdAt=$createdAt)"
    }

}