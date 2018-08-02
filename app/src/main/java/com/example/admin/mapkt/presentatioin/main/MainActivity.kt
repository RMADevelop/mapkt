package com.example.admin.mapkt.presentatioin.main

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.admin.mapkt.R
import com.example.admin.mapkt.di.ComponentManager
import com.example.admin.mapkt.di.components.MainModule
import com.example.admin.mapkt.presentatioin.core.BaseActivity
import com.example.admin.mapkt.presentatioin.core.BaseFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var provider: Provider<MainPresenter>

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = provider.get()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.container) as BaseFragment?

    override fun inject() {
        ComponentManager/*.appComponent*/
                .plusMainComponent(MainModule(this, supportFragmentManager))
                .inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}
