package com.example.admin.mapkt.presentatioin.splash

import android.content.Context
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.admin.mapkt.R
import com.example.admin.mapkt.di.ComponentManager
import com.example.admin.mapkt.presentatioin.core.BaseFragment

class SplashFragment : BaseFragment(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter() = ComponentManager.plusSplashComponent().splashPresenter()

    override val layoutIdRes: Int
        get() = R.layout.fragment_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SplashFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
