package com.example.garden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.garden.weather.WeatherModel;
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





        //set on click listeners for bottom buttons
        b.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigate(item.getItemId());
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
    private void navigate(int menuItemId) {

        if (menuItemId == R.id.garden_icon) {
            navController.navigate(R.id.gardenUI);
        }
        else if (menuItemId == R.id.knowledge_icon) {
            navController.navigate(R.id.knowledgeUI);
        }
        else if (menuItemId == R.id.notifications_icon) {
            navController.navigate(R.id.notificationsUI);
        }
        else if (menuItemId == R.id.weather_icon) {
            navController.navigate(R.id.weatherUI);
        }
        else if (menuItemId == R.id.calendar_icon) {
            navController.navigate(R.id.calendarUI);
        }
    }


}