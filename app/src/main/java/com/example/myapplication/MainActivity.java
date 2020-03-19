package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity
        implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new MainFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof MainFragment) {
            MainFragment mainFragment = (MainFragment) fragment;
            mainFragment.setOnItemSelectedListener(this);
        }
    }

    public void onItemSelected(ListViewNumber numberItem) {
        ExtraFragment newFragment = new ExtraFragment();
        Bundle args = new Bundle();
        args.putInt(CommonConstants.EXTRA_NUMBER, numberItem.getmNumber());
        int color = numberItem.isDva() ? Color.RED : Color.BLUE;
        args.putInt(CommonConstants.EXTRA_NUMBER_COLOR, color);
        newFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!isChangingConfigurations()) {
            int size = ListViewSingleton.getInstance().getData().size();
            outState.putInt(CommonConstants.LIST_SIZE, size);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (!isChangingConfigurations()) {
            int size = savedInstanceState.getInt(CommonConstants.LIST_SIZE);
            ListViewSingleton.getInstance().restoreState(size);
        }
    }
}