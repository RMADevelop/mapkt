package com.example.admin.mapkt.presentatioin.main

import com.arellomobile.mvp.InjectViewState
import com.example.admin.mapkt.presentatioin.Screens
import com.example.admin.mapkt.presentatioin.core.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        var router: Router
) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(Screens.WEATHER_INFO_SCREEN_KEY)
    }
}