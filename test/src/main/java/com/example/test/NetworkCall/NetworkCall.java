package com.example.test.NetworkCall;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONObject;



public class NetworkCall {
    private static NetworkCall networkCall;
    Context context;



    public NetworkCall(Context context) {
        this.context = context;
    }


    public void hitGetService(String url, final ApiResponseListener apiResponseListener, final int requestCode) {
        Log.d("url", url);

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            public void onResponse(String response) {
                Log.d("get request", response.toString());

                apiResponseListener.onResponse(response, requestCode);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {             //   dialog.dismiss();

                apiResponseListener.onError(error.toString(), requestCode);
            }
        });
        // Adding request to request queue
        strReq.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppDocApplication.getInstance().addToRequestQueue(strReq, "string_req");
        VolleyHelper.getRequestQueue(context).add(strReq);

        strReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
    }

    public void hitGetServicepost(String link, JSONObject url, final ApiResponseListener apiResponseListener, final int requestCode) {
        Log.e("url", link);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                link, url, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                apiResponseListener.onResponse(response.toString(), requestCode);
                Log.e("response", response.toString());
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        apiResponseListener.onError(error.toString(), requestCode);
                    }
                });
       // Log.e("rakesh", link);
        Log.e("json", String.valueOf(url));

        // Adding request to request queue
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppDocApplication.getInstance().addToRequestQueue3(jsonObjReq, "string_req");
        VolleyHelper.getRequestQueue(context).add(jsonObjReq);
    }

    public static NetworkCall getNetworkCallInstance(Context context) {
        if (networkCall == null)
            networkCall = new NetworkCall(context);
        return networkCall;
    }



}
