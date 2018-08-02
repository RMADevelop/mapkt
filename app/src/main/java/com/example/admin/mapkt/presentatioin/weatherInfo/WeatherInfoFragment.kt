package com.example.admin.mapkt.presentatioin.weatherInfo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.admin.mapkt.R
import com.example.admin.mapkt.data.local.entity.Location
import com.example.admin.mapkt.di.ComponentManager
import com.example.admin.mapkt.domain.models.Weather
import com.example.admin.mapkt.presentatioin.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_weather_info.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WeatherInfoFragment : BaseFragment(), WeatherInfoView {
    override fun showLocation(it: Location) {
        temperature.text = ("location  ${it.latitude}   ${it.longitude}")
    }

    override fun showWeather(weather: Weather) {
        temperature.text = weather.factWeatherDto.daytime
    }

    override val layoutIdRes: Int
        get() = R.layout.fragment_weather_info

    @InjectPresenter
    lateinit var weatherInfoPresenter: WeatherInfoPresenter

    @ProvidePresenter
    fun providePresenter() = ComponentManager.plusWeatherInfoComponent().presenter()

    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                WeatherInfoFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onBackPressed() {
        activity?.finish()
//        weatherInfoPresenter.onBackPressed()
    }
}
