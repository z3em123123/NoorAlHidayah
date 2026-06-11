package com.noor.alhidayah.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.noor.alhidayah.data.model.TasbihSession
@Database(entities=[TasbihSession::class],version=1,exportSchema=true)
abstract class NoorDatabase:RoomDatabase(){abstract fun tasbihDao():TasbihDao;companion object{const val DATABASE_NAME="noor_alhidayah_db"}}