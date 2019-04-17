package com.example.dryulia.mainscreen;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.event.EventFragment;
import com.example.dryulia.mainscreen.home.HomeFragment;
import com.example.dryulia.mainscreen.message.MessageFragment;
import com.example.dryulia.mainscreen.profile.ProfileFragment;

public class MainScreenActivity extends AppCompatActivity {

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
                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        selectedFragment = home;
                        break;
                    case R.id.menu_account:
                        selectedFragment = profile;
                        break;
                    case R.id.menu_event:
                        selectedFragment = event;
                        break;
                    case R.id.menu_message:
                        selectedFragment = message;
                        break;
                }
                selectedMenuId = menuItem.getItemId();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, selectedFragment);
                fragmentTransaction.commit();
                return true;
            }
        });
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, home);
        fragmentTransaction.commit();
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

    public void setPage(int i) {
        bottomNavigationView.setSelectedItemId(getId(i));
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
