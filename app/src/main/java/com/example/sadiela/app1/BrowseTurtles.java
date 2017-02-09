package com.example.sadiela.app1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
        existingTurtles.add(new Turtle("4", "Frances", "C. mydas"));
        existingTurtles.add(new Turtle("5", "Felicia", "C. mydas"));

        ArrayAdapter<Turtle> adapter = new ArrayAdapter<Turtle>(this, R.layout.turtle_search, existingTurtles);
        ListView listView = (ListView) findViewById(R.id.turtleList);
        listView.setAdapter(adapter);

        ArrayList<String> turtleStrings = searchStrings(existingTurtles);
        ArrayAdapter<String> searchAdapter = new ArrayAdapter<String>(this, R.layout.turtle_search, turtleStrings);
        AutoCompleteTextView searchView = (AutoCompleteTextView) findViewById(R.id.autocomplete_turtle);
        searchView.setAdapter(searchAdapter);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    public void doMySearch(String q) {

    }

    public ArrayList<String> searchStrings (ArrayList<Turtle> turtles) {
        ArrayList<String> turtleStr= new ArrayList<String>();
        for(Turtle i: turtles) {
            turtleStr.add(i.toString());
        }
        return turtleStr;
    }

}
//FTS table

