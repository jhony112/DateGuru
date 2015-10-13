package com.jhony.dateguru;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoadActivity extends Activity implements Animation.AnimationListener {
    ImageView imgLogo;
    // Animation
    Animation animRotate;
    TextView status;
    int boys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        imgLogo = (ImageView) findViewById(R.id.rotator);
        status = (TextView) findViewById(R.id.status);
        // load the animation
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);

        // set animation listener
        animRotate.setAnimationListener(this);


        // start the animation
        imgLogo.startAnimation(animRotate);
      boys= getIntent().getIntExtra("date", 0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load, menu);
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

    @Override
protected void onPause(){
    super.onPause();
        finish();
}
    public void onAnimationStart(Animation animation) {

        Thread timer = new Thread(){
            public void run(){
                try{sleep(5000);}
                catch (InterruptedException e){e.printStackTrace();}
                finally {
                    Intent intent=new Intent(LoadActivity.this,TabActivity.class);

                    startActivity(intent);

                }
            }
        };
        timer.start();

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
status.setText(status.getText()+".");
    }
}
