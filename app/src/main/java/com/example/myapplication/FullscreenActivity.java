package com.example.myapplication;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    private SimpleCounter counter = null;

    private SimpleCounter counter1,counter2,counter3,counter4,counter5,counter6;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (counter == null) {
            counter = new SimpleCounter();
            counter1 = new SimpleCounter();
            counter2 = new SimpleCounter();
            counter3 = new SimpleCounter();
            counter4 = new SimpleCounter();
            counter5 = new SimpleCounter();
            counter6 = new SimpleCounter();
        }

        setContentView(R.layout.activity_fullscreen);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);



        findViewById(R.id.editText1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter1.add();
                ((TextView)view).setText(String.valueOf(counter1.getValue()));
            }
        });
        findViewById(R.id.editText2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter2.add();
                ((TextView)view).setText(String.valueOf(counter2.getValue()));
            }
        });
        findViewById(R.id.editText3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter3.add();
                ((TextView)view).setText(String.valueOf(counter3.getValue()));
            }
        });
        findViewById(R.id.editText4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter4.add();
                ((TextView)view).setText(String.valueOf(counter4.getValue()));
            }
        });
        findViewById(R.id.editText5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter5.add();
                ((TextView)view).setText(String.valueOf(counter5.getValue()));
            }
        });
        findViewById(R.id.editText6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter6.add();
                ((TextView)view).setText(String.valueOf(counter6.getValue()));
            }
        });
    }
}
