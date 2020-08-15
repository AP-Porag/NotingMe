package com.example.notingme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.notingme.model.Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Toolbar toolbar;

    //Variable declare for content
    RecyclerView noteList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarXML);
        setSupportActionBar(toolbar);

        noteList = findViewById(R.id.noteListXML);

        drawerLayout = findViewById(R.id.navigationDrawer);
        navigationView = findViewById(R.id.navViewXML);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        List<String>title = new ArrayList<>();
        List<String>content = new ArrayList<>();

        //dummy data start
        title.add("First note titel.");
        content.add("First note content");

        title.add("Second note titel.");
        content.add("Second note content");

        title.add("Third note titel.");
        content.add("Third note content");

        title.add("Fourth note titel.");
        content.add("Fourth note content");

        title.add("Fifth note titel.");
        content.add("Fifth note content");

        title.add("Sixth note titel.");
        content.add("Sixth note content");

        //dummy data end

        noteList.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //noteList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(title,content);
        noteList.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.addNotefab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddNote.class));
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addNotesXML:
                startActivity(new Intent(getApplicationContext(),AddNote.class));
                break;
            default:
                Toast.makeText(this, item +" Featured Added Soon", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            default:
                Toast.makeText(this, item +" Featured Added Soon", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}