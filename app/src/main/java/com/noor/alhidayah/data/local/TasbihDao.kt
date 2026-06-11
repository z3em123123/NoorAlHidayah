package com.noor.alhidayah.data.local
import androidx.room.*
import com.noor.alhidayah.data.model.TasbihSession
import kotlinx.coroutines.flow.Flow
@Dao interface TasbihDao{
    @Insert(onConflict=OnConflictStrategy.REPLACE) suspend fun insertSession(session:TasbihSession):Long
    @Query("SELECT * FROM tasbih_sessions WHERE userId=:userId ORDER BY timestamp DESC") fun getSessionsByUser(userId:String):Flow<List<TasbihSession>>
    @Query("SELECT * FROM tasbih_sessions WHERE userId=:userId AND synced=0") suspend fun getUnsyncedSessions(userId:String):List<TasbihSession>
    @Query("UPDATE tasbih_sessions SET synced=1 WHERE id=:sessionId") suspend fun markAsSynced(sessionId:Long)
    @Query("SELECT COALESCE(SUM(count),0) FROM tasbih_sessions WHERE userId=:userId") suspend fun getTotalCount(userId:String):Int
    @Query("DELETE FROM tasbih_sessions WHERE userId=:userId") suspend fun deleteAllForUser(userId:String)
}