package com.noor.alhidayah.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName="tasbih_sessions")
data class TasbihSession(@PrimaryKey(autoGenerate=true) val id:Long=0,val userId:String,val count:Int,val timestamp:Long=System.currentTimeMillis(),val synced:Boolean=false)