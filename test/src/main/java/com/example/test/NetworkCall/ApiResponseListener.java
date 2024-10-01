package com.example.test.NetworkCall;

/**
 * Created by rakesh  on 12/08/2019.
 *
 */
public interface ApiResponseListener {
    void onResponse(String response, int requestCode);
    void onError(String error, int requestCode);


}
