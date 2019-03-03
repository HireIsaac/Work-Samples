package com.example.russ.m04_gui_01;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivityScreenSize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_screen_size);

        String versionNum = Integer.toString(Build.VERSION.SDK_INT);
        Boolean afterKitKat = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT);

        // Put it on the screen
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(" Version Number is " + versionNum);
        t.append("\n afterKitKat = " + afterKitKat.toString());
        t.append("\n Build.VERSION.RELEASE = " + Build.VERSION.RELEASE);
        t.append("\n Build.VERSION.INCREMENTAL = " + Build.VERSION.INCREMENTAL);
        // dump build and display metrics
        t.append("\n\nThis is the screen size of Activity #1" + this.getSizeName(this));
        t.append("\n Build.DISPLAY = " + Build.DISPLAY.toString());
        t.append("\n getDisplayMetrics().densityDpi = " + getResources().getDisplayMetrics().densityDpi);
        t.append("\n getDisplayMetrics().density = " + getResources().getDisplayMetrics().density);
        t.append("\n getDisplayMetrics().xdpi = " + getResources().getDisplayMetrics().xdpi);
        t.append("\n getDisplayMetrics().ydpi = " + getResources().getDisplayMetrics().ydpi);
        t.append("\n getDisplayMetrics().heightPixels = " + getResources().getDisplayMetrics().heightPixels);
        t.append("\n getDisplayMetrics().widthPixels = " + getResources().getDisplayMetrics().widthPixels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_screen_size, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view){
        Log.v("MainActivityScreenSize", "Test");
        Intent intent = new Intent(this, secondActivity.class);
        Log.v("MainActivityScreenSize", "Test");



        startActivity(intent);
    }

    // Use bitmasks to determine screen size
    private static String getSizeName(Context context) {
        int screenLayout = context.getResources().getConfiguration().screenLayout;
        screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenLayout) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "small";
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "normal";
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "large";
            case 4: // Configuration.SCREENLAYOUT_SIZE_XLARGE is API >= 9
                return "xlarge";
            default:
                return "undefined";
        }
    }


}