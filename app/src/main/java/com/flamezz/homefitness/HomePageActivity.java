package com.flamezz.homefitness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class HomePageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private TrainingPlansFragment trainingPlansFragment;
    private ProfileFragment profileFragment;
    private LanguageFragment languageFragment;
    private LogoutFragment logoutFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        setUpNavigationView();
        InitializeControls();

    }

    private void setUpNavigationView()
    {
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView textViewEmail = header.findViewById(R.id.textViewEmail);
        FirebaseAuth firebaseAuth;
        FirebaseAuth user = firebaseAuth = FirebaseAuth.getInstance();
        if(user!=null)
        {
            textViewEmail.setText(Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail());
        }



    }

    private void InitializeControls()
    {
        trainingPlansFragment = new TrainingPlansFragment();
        logoutFragment = new LogoutFragment();
        profileFragment = new ProfileFragment();
        languageFragment = new LanguageFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

     if(id==R.id.nav_trainingplans)
     {
            setNavigationFragment(trainingPlansFragment);
     }
     else if(id==R.id.nav_language)
     {
         setNavigationFragment(languageFragment);
     }
     else if(id==R.id.nav_profile)
     {
         setNavigationFragment(profileFragment);
     }
     else if(id==R.id.nav_logout) {
         setNavigationFragment(logoutFragment);

     }
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setNavigationFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.myFrameLayout,fragment);
        fragmentTransaction.commit();
    }

}
