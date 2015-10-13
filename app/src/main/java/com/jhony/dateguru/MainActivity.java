package com.jhony.dateguru;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

import models.pickedValue;

public class MainActivity extends Activity {
String returne="empty";
    NumberPicker np;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      np = (NumberPicker) findViewById(R.id.num_Picker);
       btn=(Button) findViewById(R.id.btn_next);

        np.setMinValue(1);
        np.setMaxValue(31);
        np.setWrapSelectorWheel(true);
        setNumberPickerTextColor(np, Color.WHITE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoadActivity.class);
                intent.putExtra("date",np.getValue());
pickedValue.setValue(np.getValue());
                startActivity(intent);
            }
        });
    }

    public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color)
    {
        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            View child = numberPicker.getChildAt(i);
            if(child instanceof EditText){
                try{
                    Field selectorWheelPaintField = numberPicker.getClass()
                            .getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
                    ((EditText)child).setTextColor(color);
                    numberPicker.invalidate();
                    return true;
                }
                catch(NoSuchFieldException e){
                    Log.w("setNumberPickerText", e);
                }
                catch(IllegalAccessException e){
                    Log.w("setNumberPickerText", e);
                }
                catch(IllegalArgumentException e){
                    Log.w("setNumberPickerText", e);
                }
            }
        }
        return false;
    }
   public String GetGuru(int selected){
     //  10th, 19th, 28th of any month U r number 1…
       if (selected==1||selected==10||selected==19||selected==28){


       }
        return returne;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
