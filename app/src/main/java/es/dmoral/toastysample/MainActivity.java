package es.dmoral.toastysample;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.My_function;
import es.dmoral.toasty.Toasty;

import static android.graphics.Typeface.BOLD_ITALIC;

import com.example.test.My_Function;
import com.example.test.NetworkCall.ApiResponseListener;
import com.example.test.NetworkCall.NetworkCall;
import com.example.test.NetworkCall.TestClass;


/**
 * This file is part of Toasty.
 *
 * Toasty is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Toasty is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Toasty.  If not, see <http://www.gnu.org/licenses/>.
 */

public class MainActivity extends AppCompatActivity implements ApiResponseListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_error_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  try {
                    if(TestClass.checkExpiry()){
                        Toasty.error(MainActivity.this, R.string.error_message, Toasty.LENGTH_SHORT, true).show();

                    }
                    else {}

                } catch (Exception e) {

                   // Toasty.error(MainActivity.this, R.string.error_message, Toasty.LENGTH_SHORT, true).show();

                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                   // throw new RuntimeException(e);
                }*/

                String api="https://apihook.leadoff.in/LMSOneDB/OMSService.svc/NoticeBoard?CompanyMainID=1&LoginID=19&Flag=Fresh&UniqueID=";


                NetworkCall.getNetworkCallInstance(MainActivity.this).hitGetService(api, MainActivity.this
                        , 10);
                /*Toasty.error(MainActivity.this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                 if (My_Function.validateNumber("9000")) {
                    //Toast.makeText(context, "Please enter Mobile no. ", Toast.LENGTH_SHORT).show();
                     Toasty.error(MainActivity.this, "Please enter Mobile no", Toasty.LENGTH_SHORT, true).show();

                 }
                ToastUtil.showToast(getApplicationContext(), "Hello from ToastLibrary!");
              */  //Toasty.error(MainActivity.this, R.string.error_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        //hi test
        findViewById(R.id.button_success_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.success(MainActivity.this, R.string.success_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_info_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(MainActivity.this, R.string.info_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_warning_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.warning(MainActivity.this, R.string.warning_message, Toasty.LENGTH_SHORT, true).show();
            }
        });
        findViewById(R.id.button_normal_toast_wo_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.normal(MainActivity.this, R.string.normal_message_without_icon).show();
            }
        });
        findViewById(R.id.button_normal_toast_w_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable icon = getResources().getDrawable(R.drawable.ic_pets_white_48dp);
                Toasty.normal(MainActivity.this, R.string.normal_message_with_icon, icon).show();
            }
        });
        findViewById(R.id.button_info_toast_with_formatting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(MainActivity.this, getFormattedMessage()).show();
            }
        });
        findViewById(R.id.button_custom_config).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.Config.getInstance()
                        .setToastTypeface(Typeface.createFromAsset(getAssets(), "PCap Terminal.otf"))
                        .allowQueue(false)
                        .apply();
                Toasty.custom(MainActivity.this, R.string.custom_message, getResources().getDrawable(R.drawable.laptop512),
                        android.R.color.black, android.R.color.holo_green_light, Toasty.LENGTH_SHORT, true, true).show();
                Toasty.Config.reset(); // Use this if you want to use the configuration above only once
            }
        });
    }

    private CharSequence getFormattedMessage() {
        final String prefix = "Formatted ";
        final String highlight = "bold italic";
        final String suffix = " text";
        SpannableStringBuilder ssb = new SpannableStringBuilder(prefix).append(highlight).append(suffix);
        int prefixLen = prefix.length();
        ssb.setSpan(new StyleSpan(BOLD_ITALIC),
                prefixLen, prefixLen + highlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    @Override
    public void onResponse(String response, int requestCode) {

    }

    @Override
    public void onError(String error, int requestCode) {

    }
}
