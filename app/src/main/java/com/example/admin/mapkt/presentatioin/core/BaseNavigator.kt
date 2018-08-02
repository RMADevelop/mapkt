package com.example.admin.mapkt.presentatioin.core

import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import ru.terrakok.cicerone.android.SupportAppNavigator

abstract class BaseNavigator(
        activity: FragmentActivity,
        fragmentManager: FragmentManager,
        @IdRes containerId: Int
) : SupportAppNavigator(activity, fragmentManager, containerId) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }
}