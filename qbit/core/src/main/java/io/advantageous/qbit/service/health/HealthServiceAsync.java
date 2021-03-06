package io.advantageous.qbit.service.health;


import io.advantageous.qbit.client.ClientProxy;
import io.advantageous.qbit.reactive.Callback;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Async interface to QBit health system.
 */
public interface HealthServiceAsync extends ClientProxy {


    /**
     * Register a service with the health system
     *
     * @param name     name of the service
     * @param ttl      ttl on how long before the service timeout.
     * @param timeUnit time unit for the ttl.
     */
    default void register(String name, long ttl, TimeUnit timeUnit) {
    }


    /**
     * Check in the service so it passes it TTL
     *
     * @param name name of service.
     */
    default void checkInOk(String name) {
    }

    /**
     * Check in with a certain TTL.
     *
     * @param name   name of service (PASS, WARN, FAIL, UNKNOWN)
     * @param status status
     */
    default void checkIn(String name, HealthStatus status) {
    }


    /**
     * Checks to see if all services registered with the health system are ok.
     *
     * @param ok callback
     */
    default void ok(Callback<Boolean> ok) {
    }

    /**
     * Returns list of healthy nodes.
     *
     * @param callback callback
     */
    default void findHealthyNodes(Callback<List<String>> callback) {
    }

    /**
     * Find all nodes
     *
     * @param callback callback
     */
    default void findAllNodes(Callback<List<String>> callback) {
    }

    /**
     * Find all nodes with a certain status.
     *
     * @param callback    callback
     * @param queryStatus status you are looking for.
     */
    default void findAllNodesWithStatus(Callback<List<String>> callback, HealthStatus queryStatus) {
    }

    /**
     * Find all healthy nodes
     *
     * @param callback callback.
     */
    default void findNotHealthyNodes(Callback<List<String>> callback) {
    }


    /**
     * Load all nodes no matter the status.
     *
     * @param callback callback
     */
    default void loadNodes(Callback<List<NodeHealthStat>> callback) {
        callback.accept(Collections.emptyList());
    }

    /**
     * Unregister the service
     *
     * @param serviceName name of service
     */
    default void unregister(String serviceName) {
    }

    /**
     * Fail with a particular reason.
     *
     * @param name   name
     * @param reason reason
     */
    default void failWithReason(final String name, final HealthFailReason reason) {
    }


    /**
     * Fail with error
     *
     * @param name  name
     * @param error error
     */
    default void failWithError(final String name, final Throwable error) {
    }

    /**
     * warn with reason
     *
     * @param name   name
     * @param reason reason
     */
    default void warnWithReason(final String name, final HealthFailReason reason) {
    }


    /**
     * warn with error
     *
     * @param name  name
     * @param error error
     */
    default void warnWithError(final String name, final Throwable error) {
    }


    /**
     * Register a service but don't specify a check in TTL.
     *
     * @param name name
     */
    default void registerNoTtl(String name) {
    }


}
