package com.rsschool.android2021;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements BackPressedForFragments, Fragments {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
    }

/*
    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        // TODO: invoke function which apply changes of the transaction
        transaction.commit();
    }


    private void openSecondFragment(int min, int max) {
        // TODO: implement it
        final Fragment secondFragment = SecondFragment.newInstance(min, max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment);
        transaction.commit();
    }
*/

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        BackPressedForFragments backPressedForFragments = null;

       for (Fragment fragment : fm.getFragments()) {
            if (fragment instanceof BackPressedForFragments) {
                backPressedForFragments = (BackPressedForFragments) fragment;
                break;
            }
        }
       if (backPressedForFragments != null) {
            backPressedForFragments.onBackPressed();
        }else {
           super.onBackPressed();
       }
    }


    @Override
    public void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        transaction.commit();
    }

    @Override
    public void openSecondFragment(int min, int max) {
        final Fragment secondFragment = SecondFragment.newInstance(min, max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment);
        transaction.commit();
    }
}