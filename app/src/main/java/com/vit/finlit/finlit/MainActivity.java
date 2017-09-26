package com.vit.finlit.finlit;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConstraintLayout content = (ConstraintLayout)findViewById(R.id.content_frame);
        content.setAlpha(0f);
        content.animate().alpha(1f).setDuration(500);

        ListView myListView = (ListView) findViewById(R.id.listview);
        ArrayList<String> newArr = new ArrayList<String>();
        newArr.add("Hey");
        newArr.add("You");
        newArr.add("Standiing");
        newArr.add("In");
        newArr.add("The");
        newArr.add("Isle");

        ArrayAdapter<String> newArrAd = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, newArr);
        myListView.setAdapter(newArrAd);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Dude wait I'm not programmed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_first_layout) {
            ConstraintLayout content = (ConstraintLayout)findViewById(R.id.content_frame);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FirstFragment()).commit();
            content.setAlpha(0f);
            content.animate().alpha(1f).setDuration(500);


        } else if (id == R.id.nav_second_layout) {
            ConstraintLayout content = (ConstraintLayout)findViewById(R.id.content_frame);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new SecondFragment()).commit();
            content.setAlpha(0f);
            content.animate().alpha(1f).setDuration(500);

        } else if (id == R.id.nav_third_layout) {
            ConstraintLayout content = (ConstraintLayout)findViewById(R.id.content_frame);
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ThirdFragment()).commit();
            content.setAlpha(0f);
            content.animate().alpha(1f).setDuration(500);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
