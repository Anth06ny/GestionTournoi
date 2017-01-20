package com.example.anthony.gestiontournoi.control;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Anthony on 19/01/2017.
 */
public class MyApplication extends Application {

    //private static DaoSession daoSession;

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Stetho.initializeWithDefaults(this);
        setupDatabase();
    }

    private void setupDatabase() {
        //        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        //        Database db = helper.getWritableDb();
        //        daoSession = new DaoMaster(db).newSession();
    }
}
