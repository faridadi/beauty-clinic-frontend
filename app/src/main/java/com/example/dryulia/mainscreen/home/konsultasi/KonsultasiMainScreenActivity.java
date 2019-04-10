
package com.example.dryulia.mainscreen.home.konsultasi;

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

public class KonsultasiMainScreenActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment;
    private static KonsultasiMainScreenActivity konsultasiMainScreenActivity;
    public static int selectedMenuId;

    public static KonsultasiMainScreenActivity getInstance() {
        return konsultasiMainScreenActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_main_screen);
        konsultasiMainScreenActivity = this;

        selectedMenuId = R.id.menu_home;

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.menu_account:
                        selectedFragment = new ProfileFragment();
                        break;
                    case R.id.menu_event:
                        selectedFragment = new EventFragment();
                        break;
                    case R.id.menu_message:
                        selectedFragment = new MessageFragment();
                        break;

                }

                selectedMenuId = menuItem.getItemId();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, selectedFragment);
                fragmentTransaction.commit();
                return true;
            }
        });
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
        bottomNavigationView.setSelectedItemId(selectedMenuId);
        super.onStart();
    }
    }

