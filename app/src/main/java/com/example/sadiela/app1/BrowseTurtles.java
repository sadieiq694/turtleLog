package com.example.sadiela.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BrowseTurtles extends AppCompatActivity {

    ArrayList<Turtle> existingTurtles = new ArrayList<Turtle>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_turtles);
        existingTurtles.clear();
        existingTurtles.add(new Turtle("1", "Fred", "C. mydas"));
        existingTurtles.add(new Turtle("2", "Bob", "C. mydas"));
        existingTurtles.add(new Turtle("3", "Joe", "C. mydas"));
        ArrayAdapter<Turtle> adapter = new ArrayAdapter<Turtle>(this, R.layout.simple_list_item_1, existingTurtles);
        ListView listView = (ListView) findViewById(R.id.turtleList);
        listView.setAdapter(adapter);
    }

}
