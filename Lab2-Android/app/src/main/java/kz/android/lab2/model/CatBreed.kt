package kz.android.lab2.model

import com.google.gson.annotations.SerializedName

data class CatBreed(
    @SerializedName("name") val name: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("intelligence") val intelligence: Int,
    @SerializedName("grooming") val grooming: Int,
    @SerializedName("other_pets_friendly") val energy: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int
)