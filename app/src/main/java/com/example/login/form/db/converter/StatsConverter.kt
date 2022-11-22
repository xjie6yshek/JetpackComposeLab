package com.example.login.form.db.converter

import androidx.room.TypeConverter
import com.example.login.form.data.Stats

import com.google.gson.Gson

class StatsConverter {
    @TypeConverter
    fun fromImage(stats: Stats?): String {
        return Gson().toJson(stats);
    }
    @TypeConverter
    fun toImage(data: String): Stats? {
        return Gson().fromJson(data,Stats::class.java)
    }
}
