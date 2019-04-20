package com.example.dryulia.mainscreen;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.event.EventFragment;
import com.example.dryulia.mainscreen.home.HomeFragment;
import com.example.dryulia.mainscreen.message.MessageFragment;
import com.example.dryulia.mainscreen.profile.ProfileFragment;

public class MainScreenActivity extends AppCompatActivity  {

    public BottomNavigationView bottomNavigationView;
    private static Fragment selectedFragment;
    private static MainScreenActivity mainScreenActivity;
    public static int selectedMenuId;

    public static MainScreenActivity getInstance() {
        return mainScreenActivity;
    }
    Fragment home;
    Fragment profile;
    Fragment event;
    Fragment message;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mainScreenActivity = this;
        home  = new HomeFragment();
        profile = new ProfileFragment();
        event = new EventFragment();
        message = new MessageFragment();
        selectedMenuId = R.id.menu_home;
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String TAG = "";
                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        selectedFragment = home;
                        TAG = "home";
                        break;
                    case R.id.menu_account:
                        selectedFragment = profile;
                        TAG = "profile";
                        break;
                    case R.id.menu_event:
                        selectedFragment = event;
                        TAG = "event";
                        break;
                    case R.id.menu_message:
                        selectedFragment = message;
                        TAG = "message";
                        break;
                }
                selectedMenuId = menuItem.getItemId();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, selectedFragment,TAG).commit();
                return true;
            }
        });
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, home,"home").commit();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().findFragmentByTag("home") != null){
            super.onBackPressed();
            //exit daro aplikasi
        }else if((getSupportFragmentManager().findFragmentByTag("profile") != null)||
                (getSupportFragmentManager().findFragmentByTag("event") != null)||
                (getSupportFragmentManager().findFragmentByTag("message") != null)){
            bottomNavigationView.setSelectedItemId(R.id.menu_home);
        }else{
            bottomNavigationView.setSelectedItemId(R.id.menu_home);
        }
    }

    public static int getId(int i) {
        return i == 0
                ? R.id.menu_home
                : i == 1
                ? R.id.menu_account
                : i == 2
                ? R.id.menu_event
                : R.id.menu_account;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
