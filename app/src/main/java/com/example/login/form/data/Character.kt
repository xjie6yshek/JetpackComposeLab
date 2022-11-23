package com.example.login.form.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.utils.Constants.Companion.CHARACTER_TABLE
import com.google.gson.annotations.SerializedName

data class Connections(@SerializedName("groupAffiliation")
                       val groupAffiliation: String = "",
                       @SerializedName("relatives")
                       val relatives: String = "")


@Entity(tableName = CHARACTER_TABLE)
data class Character(@SerializedName("name")
                     val name: String = "",
                     @SerializedName("latin_name")
                     val latin_name: String = "",
                     @SerializedName("animal_type")
                     val animal_type: String = "",
                     @SerializedName("active_time")
                     val active_time: String = "",
                     @SerializedName("length_min")
                     val length_min: Float = 0F,
                     @SerializedName("length_max")
                     val length_max: Float = 0F,
                     @SerializedName("weight_min")
                     val weight_min: Float = 0F,
                     @SerializedName("weight_max")
                     val weight_max: Float = 0F,
                     @SerializedName("lifespan")
                     val lifespan: String = "",
                     @SerializedName("habitat")
                     val habitat: String = "",
                     @SerializedName("diet")
                     val diet: String = "",
                     @SerializedName("geo_range")
                     val geo_range: String = "",
                     @SerializedName("image_link")
                     val image_link: String = "",
                     @PrimaryKey
                     @SerializedName("id")
                     val id: Int = 0,
)



