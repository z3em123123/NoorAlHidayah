package com.noor.alhidayah.data.repository
import com.noor.alhidayah.data.local.TasbihDao;import com.noor.alhidayah.data.model.TasbihSession
import kotlinx.coroutines.flow.Flow;import javax.inject.*
@Singleton class TasbihRepository @Inject constructor(private val tasbihDao:TasbihDao,private val authRepository:AuthRepository){
    suspend fun recordSession(userId:String,count:Int):Result<Unit>=try{val s=TasbihSession(userId=userId,count=count);tasbihDao.insertSession(s);val total=tasbihDao.getTotalCount(userId).toLong();authRepository.updateTasbihCount(userId,total);tasbihDao.markAsSynced(s.id);Result.success(Unit)}catch(e:Exception){Result.success(Unit)}
    fun getSessions(userId:String):Flow<List<TasbihSession>>=tasbihDao.getSessionsByUser(userId)
    suspend fun getTotalCount(userId:String):Int=tasbihDao.getTotalCount(userId)
    suspend fun clearUserData(userId:String){tasbihDao.deleteAllForUser(userId)}
}