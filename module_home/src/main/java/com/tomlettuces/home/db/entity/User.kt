package com.tomlettuces.home.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User constructor(
    @PrimaryKey
    @SerializedName("id") var id: Int) {

    constructor() : this(0)

    var name: String = ""

    @ColumnInfo(name = "age")
    var age: Int = 0


}