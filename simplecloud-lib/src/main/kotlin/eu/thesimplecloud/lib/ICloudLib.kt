package eu.thesimplecloud.lib

import eu.thesimplecloud.clientserverapi.lib.bootstrap.IBootstrap
import eu.thesimplecloud.lib.service.ICloudService
import eu.thesimplecloud.lib.service.ICloudServiceManager
import eu.thesimplecloud.lib.servicegroup.ICloudServiceGroupManager
import eu.thesimplecloud.lib.servicegroup.grouptype.ICloudLobbyGroup
import eu.thesimplecloud.lib.servicegroup.grouptype.ICloudProxyGroup
import eu.thesimplecloud.lib.servicegroup.grouptype.ICloudServerGroup
import eu.thesimplecloud.lib.wrapper.IWrapperManager

/**
 * It represents the main part of a cloud part
 * The Wrapper, Manager and CloudPlugin should implement this interface.
 */
interface ICloudLib {

    /**
     * Returns the [IWrapperManager] to manage wrapper
     */
    fun getWrapperManager(): IWrapperManager

    /**
     * Returns the [ICloudServiceGroupManager] to manage service groups
     */
    fun getCloudServiceGroupManager(): ICloudServiceGroupManager

    /**
     * Returns the [ICloudServiceManager] to manage services
     */
    fun getCloudServiceManger(): ICloudServiceManager

    /**
     * Returns the implementation class of the [ICloudService]
     */
    fun getCloudServiceImplementationClass(): Class<out ICloudService>

    /**
     * Returns the implementation class of the [ICloudLobbyGroup]
     */
    fun getCloudLobbyGroupImplementationClass(): Class<out ICloudLobbyGroup>

    /**
     * Returns the implementation class of the [ICloudServerGroup]
     */
    fun getCloudServerGroupImplementationClass(): Class<out ICloudServerGroup>

    /**
     * Returns the implementation class of the [ICloudProxyGroup]
     */
    fun getCloudProxyGroupImplementationClass(): Class<out ICloudProxyGroup>

    /**
     *
     */
    fun getStartNewServiceFunction(): (ICloudServerGroup) -> Unit
}