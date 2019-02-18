package com.example.sutharnil.task1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    String text;
    EditText sharetext;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool1);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomview);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu1:
                        Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        return true;

                }
                return true;
            }
        });
// nav bar

        dl=(DrawerLayout)findViewById(R.id.activity_main);
        t=new ActionBarDrawerToggle(MainActivity.this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayShowHomeEnabled(true);


//
        Button btn = (Button) findViewById(R.id.btn);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.button);
        Button btn3 = (Button) findViewById(R.id.button2);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button3);
        Button btn6= (Button) findViewById(R.id.button6);
        Button btn7= (Button) findViewById(R.id.button5);
        Button btn8= (Button) findViewById(R.id.button7);
        Button send = (Button) findViewById(R.id.send);
        sharetext = (EditText) findViewById(R.id.sharetext);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra("sleep", 10);
                startService(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,collaps_toolbar.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Recyclerview.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Recyclerview2.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Collaps.class);
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Recyclerwithdatabase.class);
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Database.class);
                startActivity(intent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingintent =  new Intent(Intent.ACTION_SEND);
                sharingintent.setType("text/plain");
                String  text = sharetext.getText().toString();
                sharingintent.putExtra(Intent.EXTRA_SUBJECT,"subject here");
                sharingintent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(sharingintent,"Share Option"));
            }
        });
//share button



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        inflater.inflate(R.menu.menu1, menu);

        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView)menu.findItem(R.id.menu6).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search");
        searchView.setIconifiedByDefault(false);
        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)){
            return true;
        }

        switch (item.getItemId()) {

            case R.id.menu1:
                Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu3:
                Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu4:
                Toast.makeText(MainActivity.this, "log out", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu5:
                Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();

                Intent sharingintent =  new Intent(Intent.ACTION_SEND);
                sharingintent.setType("text/plain");
                String  text = sharetext.getText().toString();
                sharingintent.putExtra(Intent.EXTRA_SUBJECT,"subject here");
                sharingintent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(sharingintent,"Share Option"));
                return true;

            case R.id.menu6:
                Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
                return true;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu11) {                Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();

            // Handle the camera action
        } else if (id == R.id.menu12) {
            Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.menu14) {
            Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.menu13) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
