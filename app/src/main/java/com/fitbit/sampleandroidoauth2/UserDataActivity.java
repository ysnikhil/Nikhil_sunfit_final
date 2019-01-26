package com.fitbit.sampleandroidoauth2;


import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.sampleandroidoauth2.databinding.ActivityUserDataBinding;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class UserDataActivity extends Activity {

    private ActivityUserDataBinding binding;
    private UserDataPagerAdapter userDataPagerAdapter;
    globals stepGlobalInstance = globals.getInstance();





    public static Intent newIntent(Context context) {
        return new Intent(context, UserDataActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_data);
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main_page);
        binding.setLoading(false);

        userDataPagerAdapter = new UserDataPagerAdapter(getFragmentManager());
        binding.viewPager.setAdapter(userDataPagerAdapter);

        binding.viewPager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });



        //addTabs();
        //binding.todayStepCountTextView.setText(String.valueOf(stepGlobalInstance.getSteps()));
        LoadUISteps();


    }



    private void LoadUISteps() {


        stepGlobalInstance.setavailablestepsSteps(stepGlobalInstance.getSteps()-stepGlobalInstance.getredeemedstepsSteps());



        TextView txt1 = findViewById(R.id.today_stepCount_textView);
        txt1.setText(String.valueOf(stepGlobalInstance.getSteps()));

        TextView txt2 = findViewById(R.id.total_redeemed_stepCount_textView);
        txt2.setText(String.valueOf(stepGlobalInstance.getredeemedstepsSteps()));

        TextView txt3 = findViewById(R.id.total_available_stepCount_textView);
        txt3.setText(String.valueOf(stepGlobalInstance.getavailablestepsSteps()));

        //Setup Last refreshed date on Labels
        Date dt = new Date();
        TextView txt1Label = findViewById(R.id.today_steps_last_refreshed);
        txt1Label.setText("Last Refreshed on : "+dt.toString());
        TextView txt2Label = findViewById(R.id.toal_redeemed_steps_last_refreshed);
        txt2Label.setText("Last Refreshed on : "+dt.toString());
        TextView txt3Label = findViewById(R.id.total_stepsAvailable_last_refreshed);
        txt3Label.setText("Last Refreshed on : "+dt.toString());

    }

    private void addTabs() {
        final ActionBar actionBar = getActionBar();
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        int numberOfTabs = userDataPagerAdapter.getCount();
        for (int i = 0; i < numberOfTabs; i++) {
            final int index = i;
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(getString(userDataPagerAdapter.getTitleResourceId(i)))
                            .setTabListener(new ActionBar.TabListener() {
                                @Override
                                public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                                    binding.viewPager.setCurrentItem(index);

                                }

                                @Override
                                public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

                                }

                                @Override
                                public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

                                }
                            }));
        }
    }


    public void onLogoutClick(View view) {
        //binding.setLoading(true);
        //AuthenticationManager.logout(this);
        startActivity(new Intent(UserDataActivity.this,RedeemPageActivity.class));
    }

    public void onSyncClick(View view) {

        finish();
        startActivity(getIntent());
        //LoadUISteps();
    }
    //Added by Ranjan

    @Override
    protected void onResume() {
        super.onResume();
        LoadUISteps();

    }



}