package com.example.baseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  private NavController mNavController;
  private NavHostFragment mNavHostFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    
    mNavHostFragment =
      (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
    mNavController = mNavHostFragment.getNavController();
  
    NavigationUI.setupActionBarWithNavController(this, mNavController);
  }
  
  @Override
  public boolean onSupportNavigateUp() {
    return mNavController.navigateUp() || super.onSupportNavigateUp();
  }
}