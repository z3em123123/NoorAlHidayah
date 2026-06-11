package com.noor.alhidayah

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NoorAlHidayahApp : Application() {
    companion object {
        const val ATHAN_CHANNEL_ID = "athan_channel"
        const val PRAYER_REMINDER_CHANNEL_ID = "prayer_reminder_channel"
    }
    override fun onCreate() { super.onCreate(); createNotificationChannels() }
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = getSystemService(NotificationManager::class.java)
            val ac = NotificationChannel(ATHAN_CHANNEL_ID, "الأذان", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "قناة لتشغيل صوت الأذان"
                setSound(null, null); enableVibration(true)
            }
            val rc = NotificationChannel(PRAYER_REMINDER_CHANNEL_ID, "تذكير الصلاة", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "تنبيهات تذكيرية"
            }
            nm.createNotificationChannel(ac); nm.createNotificationChannel(rc)
        }
    }
}
