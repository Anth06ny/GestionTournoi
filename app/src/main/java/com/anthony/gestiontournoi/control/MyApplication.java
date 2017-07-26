package com.anthony.gestiontournoi.control;

import android.app.Application;
import android.content.Intent;

import com.anthony.gestiontournoi.model.ServiceTournament;
import com.anthony.gestiontournoi.model.beans.DaoMaster;
import com.anthony.gestiontournoi.model.beans.DaoSession;
import com.facebook.stetho.Stetho;
import com.squareup.otto.Bus;

import org.greenrobot.greendao.database.Database;


public class MyApplication extends Application {

    private static DaoSession daoSession;

    private static MyApplication instance;

    private static Bus bus;

    public static MyApplication getInstance() {
        return instance;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }




    @Override
    public void onCreate() {
        super.onCreate();
        bus = new Bus();
        instance = this;
        Stetho.initializeWithDefaults(this);
        setupDatabase();

        // START SERVICE UPDATE_TOURNAMENT
        Intent intentTournament = new Intent(this, ServiceTournament.class);
        intentTournament.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_TOURNAMENT);
        startService(intentTournament);

        // START SERVICE UPDATE_TEAM
        Intent intentTeam = new Intent(this, ServiceTournament.class);
        intentTeam.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_TEAM);
        startService(intentTeam);

        // START SERVICE UPDATE_CLUB
        Intent intentClub = new Intent(this, ServiceTournament.class);
        intentClub.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_CLUB);
        startService(intentClub);

        // START SERVICE UPDATE_PLACE
        Intent intenPlace = new Intent(this, ServiceTournament.class);
        intenPlace.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_PLACE);
        startService(intenPlace);
//
//        // START SERVICE UPDATE_MATCH
//        Intent intentMatch = new Intent(this, ServiceTournament.class);
//        intentMatch.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_MATCH);
//        startService(intentMatch);
    }


    private void setupDatabase() {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    //---------------------------
    //      GETTER / SETTER
    //---------------------------
    public static Bus getBus() {
        return bus;
    }
}
