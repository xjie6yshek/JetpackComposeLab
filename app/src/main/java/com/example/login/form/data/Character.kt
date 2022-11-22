package com.example.login.form.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.utils.Constants.Companion.CHARACTER_TABLE
import com.google.gson.annotations.SerializedName


@Entity(tableName = CHARACTER_TABLE)
data class Character(@SerializedName("img")
                     val images: Images,
                     @SerializedName("localized_name")
                     val name: String = "",
                     @SerializedName("attack_type")
                     val attack_type: String = "",
                     @SerializedName("primary_attr")
                     val primary_attr: String = "",
                     @SerializedName("base_str")
                     val base_str: Int = 0,
                     @SerializedName("base_agi")
                     val base_agi: Int = 0,
                     @SerializedName("base_int")
                     val base_int: Int = 0,
                     @PrimaryKey
                     @SerializedName("id")
                     val id: Int = 0)


data class Images(@SerializedName("img")
                  val img: String = "",
                  @SerializedName("icon")
                  val icon: String = "")


data class Stats(@SerializedName("base_health")
                      val base_health: Int = 0,
                      @SerializedName("base_health_regen")
                      val base_health_regen: Int = 0,
                      @SerializedName("base_mana")
                      val base_mana: Int = 0,
                      @SerializedName("base_mana_regen")
                      val base_mana_regen: Int = 0,
                      @SerializedName("base_armor")
                      val base_armor: Int = 0,
                      @SerializedName("move_speed")
                      val move_speed: Int = 0,
                      @SerializedName("base_attack_min")
                      val base_attack_min: Int = 0,
                      @SerializedName("base_attack_max")
                      val base_attack_max: Int = 0)



