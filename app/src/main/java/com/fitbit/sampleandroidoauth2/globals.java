package com.fitbit.sampleandroidoauth2;


import android.app.Application;

public class globals extends Application {
    private static globals instance;
    private static int fsteps;
    private static int redeemedsteps;
    private static int availablesteps;

    private globals(){}

    public void setSteps( int t){
        globals.fsteps=t;
    }
    public int getSteps(){ return  globals.fsteps; }

    public void setredeemedstepsSteps( int t){
        globals.redeemedsteps=t;
    }
    public int getredeemedstepsSteps(){ return  globals.redeemedsteps; }

    public void setavailablestepsSteps( int t){
        globals.availablesteps=t;
    }
    public int getavailablestepsSteps(){ return  globals.availablesteps; }




    public static synchronized globals getInstance()
    {
        if(instance==null)
        {
            instance=new globals();
        }
        return instance;
    }

}

