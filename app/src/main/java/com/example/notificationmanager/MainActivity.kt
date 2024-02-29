package com.example.notificationmanager

import android.app.Notification
import android.app.NotificationManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    //A class that represents how a persistent notification is to be presented to the user using the NotificationManager.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Code To Convert drawable png to bitmap
        var drawable: Drawable? =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher, null)
        var bitmapDrawable = drawable as BitmapDrawable
        var largeIcon: Bitmap = bitmapDrawable.bitmap

        //https://developer.android.com/reference/android/app/Notification     //to know more
        val notificationManager = getSystemService(NOTIFICATION_SERVICE)
        // NotificationManager is a class in the Android SDK that provides functionality to manage notifications shown to the user.
        // It allows you to create, update, and cancel notifications that appear in the notification drawer or as pop-up alerts.

        var notification =
            Notification.Builder(this)  //The Notification.Builder has been added to make it easier to construct Notifications.
                //the NotificationBuilder is a class used to construct and customize notifications that are displayed to users.
                // The NotificationBuilder is typically used in conjunction with the NotificationManager to create and manage notifications within an Android application.
                .setLargeIcon(Bitmap.createBitmap(largeIcon))
                .setSmallIcon(R.drawable.n)
                .setContentText("Hello People")
                .setSubText("message from Valen")
                .setChannelId()
                // A "channel ID" in notifications typically refers to a unique identifier associated with a communication channel or endpoint through which notifications are sent or received.
                //it's important to note that starting from Android 8.0 (API level 26), notification channels were introduced.
                //Notification channels allow developers to categorize notifications and give users more control over which types of notifications they want to receive and how they are presented.
                //When creating notifications using the NotificationBuilder, you need to specify a notification channel for the notification to be associated with.
                // This ensures that the notification is properly categorized and follows the user's notification preferences.
                .build()


        //custom class example
        var v: Valen = Valen()
        val b = v.a
        Toast.makeText(this, "$b", Toast.LENGTH_SHORT).show()

    }

    class Valen() { //Trial custom class
        var a = 10
    }

    //WHAT IS CHANNEL?
//A "channel ID" in notifications typically refers to a unique identifier
// associated with a communication channel or endpoint through which notifications are sent or received.
//
//For instance, in messaging platforms like Slack or Microsoft Teams, each channel within a workspace has its own unique identifier.
// When sending notifications programmatically, developers often need to specify the channel ID to direct the notification to the appropriate destination.
//
//Similarly, in other notification systems, such as email services or push notification services for mobile apps,
// there may be identifiers associated with specific channels or endpoints to ensure that notifications reach the intended recipients.
//
//The channel ID helps identify where the notification should be delivered and is essential for proper routing and delivery of messages within a system.
}