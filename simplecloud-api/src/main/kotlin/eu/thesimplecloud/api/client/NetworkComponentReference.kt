package eu.thesimplecloud.api.client

import eu.thesimplecloud.api.CloudAPI
import eu.thesimplecloud.api.utils.INetworkComponent

data class NetworkComponentReference(val componentType: NetworkComponentType, val name: String) {

    companion object {
        @JvmStatic
        val MANAGER_COMPONENT_REFERENCE = NetworkComponentReference(NetworkComponentType.MANAGER, "Manager")


    }

    fun getNetworkComponent(): INetworkComponent? {
        return when (componentType) {
            NetworkComponentType.WRAPPER -> {
                CloudAPI.instance.getWrapperManager().getWrapperByName(name)
            }
            NetworkComponentType.SERVICE -> {
                CloudAPI.instance.getCloudServiceManager().getCloudServiceByName(name)
            }
            NetworkComponentType.MANAGER -> {
                INetworkComponent.MANAGER_COMPONENT
            }
        }
    }

}