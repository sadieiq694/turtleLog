package com.example.sadiela.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }

    // logging function

    public void switchLogActivity(View v) {
        startActivity(new Intent(this, LogNewData.class));
    }

    public void switchExistingLogActivity(View v) {
        startActivity(new Intent(this, LogExistingData.class));
    }



    public void doAnotherThing(View v) {
        Button b = (Button) v;
        TextView tv = (TextView)findViewById(R.id.statusMessage);
        if (tv.getText().equals("heyyyyy")) {
            tv.setText("hi");
        } else {
            tv.setText("heyyyyy");
        }
    }
}
