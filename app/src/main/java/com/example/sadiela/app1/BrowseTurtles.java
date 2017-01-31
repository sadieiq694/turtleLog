package com.example.sadiela.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class BrowseTurtles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_turtles);
        ArrayList<Turtle> existingTurtles = new ArrayList<Turtle>();
    }


}
