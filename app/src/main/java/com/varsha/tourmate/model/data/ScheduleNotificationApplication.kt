package com.varsha.tourmate.model.data

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.varsha.tourmate.viewmodel.NotificationKey.RMNDR_NOTI_CHNNL_ID
import com.varsha.tourmate.viewmodel.NotificationKey.RMNDR_NOTI_CHNNL_NAME

class ScheduleNotificationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val notificationChannel = NotificationChannel(
            RMNDR_NOTI_CHNNL_ID,
            RMNDR_NOTI_CHNNL_NAME,
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Channel for reminder notifications"
        }

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}
