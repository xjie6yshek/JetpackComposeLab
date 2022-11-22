package com.example.login.form.db.converter

import androidx.room.TypeConverter
import com.example.login.form.data.Images

import com.google.gson.Gson

class ImagesConverter {
    @TypeConverter
    fun fromImage(images: Images?): String {
        return Gson().toJson(images);
    }
    @TypeConverter
    fun toImage(data: String): Images? {
        return Gson().fromJson(data,Images::class.java)
    }
}
