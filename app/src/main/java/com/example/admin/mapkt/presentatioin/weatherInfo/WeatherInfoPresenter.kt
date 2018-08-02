package com.example.admin.mapkt.presentatioin.weatherInfo

import com.arellomobile.mvp.InjectViewState
import com.example.admin.mapkt.domain.weatherInfo.WeatherInteractor
import com.example.admin.mapkt.presentatioin.core.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class WeatherInfoPresenter @Inject constructor(
        var router: Router,
        var weatherInteractor: WeatherInteractor
) : BasePresenter<WeatherInfoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        weatherInteractor.getWeatherInfo(55.75396, 37.620393)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(Consumer { viewState.showWeather(it) })
        weatherInteractor.getLocationObserver()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    viewState.showLocation(it)
                }
    }

    override fun onBackPressed() = router.finishChain()
}