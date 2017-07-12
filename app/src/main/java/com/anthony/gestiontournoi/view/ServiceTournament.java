package com.anthony.gestiontournoi.view;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class ServiceTournament extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
