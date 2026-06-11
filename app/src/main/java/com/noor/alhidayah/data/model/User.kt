package com.noor.alhidayah.data.model
data class User(
    val id: String = "",
    val displayName: String = "",
    val email: String = "",
    val totalTasbihCount: Long = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val lastActive: Long = System.currentTimeMillis(),
    val profileImageUrl: String? = null
) { fun toFirestoreMap() = mapOf("displayName" to displayName,"email" to email,"totalTasbihCount" to totalTasbihCount,"createdAt" to createdAt,"lastActive" to lastActive,"profileImageUrl" to profileImageUrl)
    companion object { fun fromFirestore(id: String, data: Map<String, Any?>) = User(id=id,displayName=data["displayName"] as? String?:"",email=data["email"] as? String?:"",totalTasbihCount=(data["totalTasbihCount"] as? Long)?:0L,createdAt=(data["createdAt"] as? Long)?:0L,lastActive=(data["lastActive"] as? Long)?:0L,profileImageUrl=data["profileImageUrl"] as? String) }
}