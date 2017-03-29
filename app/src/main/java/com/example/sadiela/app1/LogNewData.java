package com.example.sadiela.app1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class LogNewData extends AppCompatActivity implements FragmentCommunicator {

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private Capture c = new Capture();

    public void setCaptureData(Integer cap, String l, String d) {
        c.catchNum = cap;
        c.location = l;
        c.date = d;
    }

    @Override
    public void setCarapaceData(double strCLmin, double strCLnt, double strCW, double curCLmin, double curCLnt, double curCW) {
        c.strCLMin = strCLmin;
        c.strCLnt = strCLnt;
        c.strCW = strCW;
        c.curCLMin = curCLmin;
        c.curCLnt = curCLnt;
        c.curCW = curCW;
    }

    @Override
    public void setOtherData(double headDep, double headWid, double headLen, double bodyDep) {
        c.headD = headDep;
        c.headW = headWid;
        c.headL = headLen;
        c.bodyD = bodyDep;
        startActivity(new Intent(this, MainActivity.class));
    }


    //private Turtle t = new Turtle();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_data);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.log_data_menu, menu);
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

    //@Override
    //public void onFragmentInteraction(Uri uri) {
    //}


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch(position) {
                case 0:
                    return CaptureData.newInstance(c.catchNum, c.location, c.date);
                case 1:
                    return CarapaceData.newInstance(c.strCLMin, c.strCLnt, c.strCW, c.curCLMin, c.curCLnt, c.curCW);
                case 2:
                    return OtherData.newInstance(c.headD, c.headW, c.headL, c.bodyD);
            }
            throw new IndexOutOfBoundsException("case number");
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Capture Data";
                    // date, catchnum, location (captureID)
                case 1:
                    return "Carapace Data";
                    // strCLmin, strCLnt, strCW, curCLmin, curCLnt, curCW
                case 2:
                    return "Other Data";
                    // headW, headL, headD, weight, bodyD
            }
            return null;
        }


        /*public void enterData(View v) {

            // get EditText by id
            (EditText) inputTxt = (EditText) findViewById(R.id.input);

            // Store EditText in Variable
            String str = inputTxt.getText().toString();
            // Gets the data repository in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
        }*/
    }
}