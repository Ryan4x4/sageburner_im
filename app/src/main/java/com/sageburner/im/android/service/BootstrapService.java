
package com.sageburner.im.android.service;

import com.sageburner.im.android.core.User;
import com.sageburner.im.android.ibe.IBEParamsWrapper;
import retrofit.RestAdapter;

/**
 * Bootstrap API service
 */
public class BootstrapService {

    private RestAdapter restAdapter;

    /**
     * Create bootstrap service
     * Default CTOR
     */
    public BootstrapService() {
    }

    /**
     * Create bootstrap service
     *
     * @param restAdapter The RestAdapter that allows HTTP Communication.
     */
    public BootstrapService(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    private UserService getUserService() {
        return getRestAdapter().create(UserService.class);
    }

    private IBEParamsService getIBEParamsService() {
        return getRestAdapter().create(IBEParamsService.class);
    }

    private RestAdapter getRestAdapter() {
        return restAdapter;
    }

    public User authenticate(String email, String password) {
        return getUserService().authenticate(email, password);
    }

    public IBEParamsWrapper getIBEParamsWrapper(int key) {
        return getIBEParamsService().getIBEParamsWrapper(key);
    }
}