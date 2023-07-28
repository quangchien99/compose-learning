package om.platform.marsphotosapplication

import android.app.Application
import om.platform.marsphotosapplication.data.AppContainer
import om.platform.marsphotosapplication.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}