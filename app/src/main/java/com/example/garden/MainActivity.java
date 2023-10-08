package com.example.garden;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Initialize and assign variable
    NavigationBarView b;

    NavController navController;

    NavHostFragment navHostFragment;

    int currentFragmentID;
    int homeID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        b = (NavigationBarView) findViewById(R.id.bottom_nav_view);
        //setting the current fragment view to the main UI
        currentFragmentID = R.id.main_UI;





        //set on click listeners for bottom buttons
        b.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Log.d("ui clicks", "home button clicked");
                    navigate("main_ui");
                }
                else if (item.getItemId() == R.id.garden) {
                    Log.d("ui clicks", "garden button clicked");
                    navigate("garden_ui");
                }

                return true;
            }
        });




        //get a reference to the weather view model. It is always the same even if the activity is remade
        WeatherModel model = new ViewModelProvider(this).get(WeatherModel.class);
        Random rand = new Random();






        //register the UI state as an observer of this activity
        //update the UI to whatever the UIstate currently is in the weatherModel
        model.getUiState().observe(this, uiState -> {
            //temp.setText("Temp: " + uiState.getTemp());
            //humidity.setText("Humidity: " + uiState.getHumidity());
        });

    }

    //handle navigation sanitization here
    private void navigate(String menuButtonID) {

        switch(menuButtonID) {
            case "main_ui":
                Log.d("navigation", "navigating to main_ui");
                navController.navigate(R.id.main_UI);
                break;
            case "garden_ui":
                Log.d("navigation", "navigating to garden_ui");
                navController.navigate(R.id.action_main_UI_to_gardenUI);
                break;
            case "weather_ui":
                Log.d("navigation", "navigating to weather_ui");
            default:
                Log.d("navigation", "received unexpected input into navigate function");


        }







    }


}