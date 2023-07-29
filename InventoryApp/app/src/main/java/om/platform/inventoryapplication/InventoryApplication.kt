package om.platform.inventoryapplication

import android.app.Application
import om.platform.inventoryapplication.data.AppContainer
import om.platform.inventoryapplication.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}