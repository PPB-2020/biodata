package com.ditya.biodata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {
    Button button_call, button_email, button_loc;
    ImageView button_loc_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://demo-web.my.id");

        button_call = findViewById(R.id.telfon);
        button_email = findViewById(R.id.email);
        button_loc_img = findViewById(R.id.imageView2);
        button_loc = findViewById(R.id.maps);
        String email = "111202113265@mhs.dinus.ac.id";

        button_loc_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMap = new Intent(Intent.ACTION_VIEW
                        , Uri.parse("https://goo.gl/maps/ztVr4wNsTKUNA1hN7"));
                startActivity(openMap);
            }
        });

        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomor = "085727401089";
                Intent menelepon = new Intent(Intent.ACTION_DIAL);
                menelepon.setData(Uri.fromParts("tel", nomor, null));
                startActivity(menelepon);
            }
        });
        button_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mengemail = new Intent(Intent.ACTION_VIEW
                        , Uri.parse("mailto:"+ email));
                startActivity(mengemail);
            }
        });
        button_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMap = new Intent(Intent.ACTION_VIEW
                        , Uri.parse("https://goo.gl/maps/ztVr4wNsTKUNA1hN7"));
                startActivity(openMap);
            }
        });
    }
}