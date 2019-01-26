package com.fitbit.sampleandroidoauth2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RedeemPageActivity extends AppCompatActivity {
    private long v_coffee_activity_steps= 2000;
    private long v_coconut_activity_steps= 3000;
    private long v_smoothie_activity_steps= 4000;
    globals stepGlobalInstance = globals.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_redeem_page);
        //final TextView CoffeeTextView = (TextView) findViewById(R.id.textView_Coffee);
        //final TextView CoconutWaterTextView = (TextView) findViewById(R.id.textView_Coconut_water);
        //final TextView SmoothieTextView = (TextView) findViewById(R.id.textView_Smothie);
        Button CoffeeButton = (Button) findViewById(R.id.button_Coffee);
        Button CoconutWaterButton = (Button) findViewById(R.id.button_Coconut_Water);
        Button SmoothieButton = (Button) findViewById(R.id.button_Smothie);

        Intent intent = getIntent();
        //final long v_activity_steps = intent.getLongExtra("REDEEM STEPS",0);
        final long v_activity_steps = stepGlobalInstance.getSteps();
        //CoffeeTextView.setText("Starbucks Coffee");
        //CoconutWaterTextView.setText("Coconut Water");
        //SmoothieTextView.setText("Smoothie");

        CoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long v_activity_steps_redeemed=0;
               // if(v_activity_steps >= v_coffee_activity_steps){
                if(stepGlobalInstance.getavailablestepsSteps() >= v_coffee_activity_steps){
                    v_activity_steps_redeemed = v_coffee_activity_steps;
                    stepGlobalInstance.setredeemedstepsSteps(stepGlobalInstance.getredeemedstepsSteps() +(int) (v_coffee_activity_steps));
                }
                else{
                    Toast.makeText(RedeemPageActivity.this, v_coffee_activity_steps+" step required to redeem!", Toast.LENGTH_SHORT).show();
                }
                //stepGlobalInstance.setRedeemedSteps(v_activity_steps_redeemed);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("REDEEMED STEPS",v_activity_steps_redeemed);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        CoconutWaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long v_activity_steps_redeemed=0;
                //if(v_activity_steps >= v_coconut_activity_steps){
                if(stepGlobalInstance.getavailablestepsSteps()>=v_coconut_activity_steps){
                    v_activity_steps_redeemed = v_coconut_activity_steps;
                    stepGlobalInstance.setredeemedstepsSteps(stepGlobalInstance.getredeemedstepsSteps() +(int) (v_coconut_activity_steps));
                }
                else{
                    Toast.makeText(RedeemPageActivity.this, v_coconut_activity_steps+" step required to redeem!", Toast.LENGTH_SHORT).show();
                }
                //stepGlobalInstance.setRedeemedSteps(v_activity_steps_redeemed);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("REDEEMED STEPS",v_activity_steps_redeemed);
                setResult(RESULT_OK,resultIntent);
                finish();

            }
        });

        SmoothieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long v_activity_steps_redeemed=0;
                //if(v_activity_steps >= v_smoothie_activity_steps){
                if(stepGlobalInstance.getavailablestepsSteps()>= v_smoothie_activity_steps){
                    v_activity_steps_redeemed = v_smoothie_activity_steps;
                    stepGlobalInstance.setredeemedstepsSteps(stepGlobalInstance.getredeemedstepsSteps() +(int) (v_smoothie_activity_steps));
                }
                else{
                    Toast.makeText(RedeemPageActivity.this, v_smoothie_activity_steps+" step required to redeem!", Toast.LENGTH_SHORT).show();
                }
                //stepGlobalInstance.setRedeemedSteps(v_activity_steps_redeemed);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("REDEEMED STEPS",v_activity_steps_redeemed);
                setResult(RESULT_OK,resultIntent);
                finish();

            }
        });
    }
}
