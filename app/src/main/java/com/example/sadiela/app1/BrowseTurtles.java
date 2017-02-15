package com.example.sadiela.app1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        ArrayAdapter<Turtle> adapter = new ArrayAdapter<Turtle>(this, R.layout.turtle_search2, existingTurtles);
        ListView listView = (ListView) findViewById(R.id.turtleList);
        listView.setAdapter(adapter);

        ArrayList<String> turtleStrings = searchStrings(existingTurtles);
        ArrayAdapter<String> searchAdapter = new ArrayAdapter<String>(this, R.layout.turtle_search2, turtleStrings);
        //AutoCompleteTextView searchView = (AutoCompleteTextView) findViewById(R.id.autocomplete_turtle);
        // searchView.setAdapter(searchAdapter);

        /*Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        //final ArrayAdapter<Turtle> adapter = new ArrayAdapter<Turtle>(this, R.layout.turtle_search2, existingTurtles);
        //ListView listView = (ListView) findViewById(R.id.turtleList);
        //listView.setAdapter(adapter);
        final BrowseTurtles browseActivity = this;

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextChange(String newText) {
                        Log.d("Searching", newText);
                        ArrayAdapter<String> partialList = new ArrayAdapter<String>(browseActivity, R.layout.turtle_search2, partialSearchOptions(newText));
                        ListView listView = (ListView) findViewById(R.id.turtleList);
                        listView.setAdapter(partialList);
                        return false;
                    }
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Log.d("Submit", query);
                        ArrayAdapter<String> finalList = new ArrayAdapter<String>(browseActivity, R.layout.turtle_search2, partialSearchOptions(query));
                        ListView listView = (ListView) findViewById(R.id.turtleList);
                        listView.setAdapter(finalList);
                        return false;
                    }
                //NEW FUNCTION: GIVEN A PARTIAL SEARCH STRING, RETURN OPTIONS

                }
        );
        return true;
    }

    public ArrayList<String> partialSearchOptions(String text) {
        ArrayList<String> matchingTurtles = new ArrayList<String>();
        for(Turtle t : existingTurtles){
            if(t.toString().contains(text)) {
                matchingTurtles.add(t.toString());
            }
        }
        return matchingTurtles;
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

