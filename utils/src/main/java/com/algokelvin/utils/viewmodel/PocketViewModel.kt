package com.algokelvin.utils.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.algokelvin.utils.db.database.PocketDB
import com.algokelvin.utils.db.entity.PocketEntity

class PocketViewModel : ViewModel() {
    fun insertNotePocket(context: Context, pocketEntity: PocketEntity) {
        val pocketDatabase = PocketDB.getInstance(context)
        pocketDatabase.pocketDao().insertPocket(pocketEntity)
    }
    fun getNotePocket(context: Context, type: String, date: String): List<PocketEntity> {
        val pocketDatabase = PocketDB.getInstance(context)
        return pocketDatabase.pocketDao().getAllPocket(type, date)
    }
    fun getAmountPocket(context: Context, type: String): Int {
        val pocketDatabase = PocketDB.getInstance(context)
        return pocketDatabase.pocketDao().getBalancePocket(type)
    }
}