package com.example.test.NetworkCall;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyHelper {

    private static RequestQueue mRequestQueue;


    private VolleyHelper() {
    }

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);

    }

    public static RequestQueue getRequestQueue(Context context)  {
        if(TestClass.checkExpiry()){}else {
            if (mRequestQueue != null) {
                return mRequestQueue;
            } else {
                mRequestQueue = Volley.newRequestQueue(context);
                return mRequestQueue;
            }
        }
        return mRequestQueue;
    }


}
