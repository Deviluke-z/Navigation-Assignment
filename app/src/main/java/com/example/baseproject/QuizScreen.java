package com.example.baseproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizScreen extends Fragment {
  
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";
  
  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;
  
  public QuizScreen() {
    // Required empty public constructor
  }
  
  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment QuizScreen.
   */
  // TODO: Rename and change types and number of parameters
  public static QuizScreen newInstance(String param1, String param2) {
    QuizScreen fragment = new QuizScreen();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_quiz_screen, container, false);
    
    view.findViewById(R.id.btnSubmit).setOnClickListener(v -> {
        if (view.findViewById(R.id.rbAnswer1).createAccessibilityNodeInfo().isChecked() ||
          view.findViewById(R.id.rbAnswer2).createAccessibilityNodeInfo().isChecked() ||
          view.findViewById(R.id.rbAnswer4).createAccessibilityNodeInfo().isChecked()) {
          
          Navigation.findNavController(view).navigate(R.id.action_quizScreen_to_failScreen);
          
        } else if (view.findViewById(R.id.rbAnswer3).createAccessibilityNodeInfo().isChecked()) {
          
          Navigation.findNavController(view)
            .navigate(QuizScreenDirections.actionQuizScreenToCongratScreen("100"));
          
        } else {
          Toast.makeText(getContext(), "Bạn chưa chọn phương án nào", Toast.LENGTH_SHORT).show();
        }
        
    });
    
    setHasOptionsMenu(true);
    return view;
  }
  
  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.quiz_nav_menu, menu);
  }
  
  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    return NavigationUI.onNavDestinationSelected(
      item,
      NavHostFragment.findNavController(this)
    ) || super.onOptionsItemSelected(item);
  }
}