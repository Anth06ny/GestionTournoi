package com.anthony.gestiontournoi.control;

import android.app.Application;

import com.anthony.gestiontournoi.model.beans.DaoMaster;
import com.anthony.gestiontournoi.model.beans.DaoSession;
import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;


public class MyApplication extends Application {

    private static DaoSession daoSession;

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

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
}
