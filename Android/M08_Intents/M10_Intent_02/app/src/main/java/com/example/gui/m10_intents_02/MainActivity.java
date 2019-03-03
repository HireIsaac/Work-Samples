package com.example.gui.m10_intents_02;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    //    private View bouncingBallView = null;
    private View bouncingBallView = null;
    private int PICK_IMAGE_REQUEST = 17;
    FloatingActionButton actionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButton = (FloatingActionButton) findViewById(R.id.actionButton);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap(500, 500, config);
        FrameLayout finalView = new FrameLayout(this);
        LinearLayout linearLayout = new LinearLayout(this);

        bouncingBallView = new BouncingBallView(this, bitmap);
        if(actionButton.getParent() != null) {
            ((ViewGroup)actionButton.getParent()).removeView(actionButton);
        }
        linearLayout.addView(actionButton);
        finalView.addView(bouncingBallView);
        finalView.addView(linearLayout);
        setContentView(finalView);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

                Log.w("MainActivity-INTENT", "M10_Intents_02: onCreate getting photo");
            }
        });
    }




    /**
     * Returns after photo picked from gallery
     * http://codetheory.in/android-pick-select-image-from-gallery-with-intents/
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.w("MainActivity-INTENT", "onActivityResult-1 requestCode:" + requestCode + " resultCode:" + resultCode);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            Bitmap bitmap;
            bitmap = null;

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                ImageView imageView = (ImageView) findViewById(R.id.imageView);
//                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (null != bitmap) {
                bouncingBallView = new BouncingBallView(this, bitmap);
                setContentView(bouncingBallView);
                Log.w("MainActivity-INTENT", "onActivityResult-2: " + String.valueOf(bitmap));
            }
        }
    }



}
