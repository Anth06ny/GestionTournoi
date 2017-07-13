package com.anthony.gestiontournoi.view;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.anthony.gestiontournoi.model.BeanType;
import com.anthony.gestiontournoi.model.UpdateBeanAT;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class ServiceTournament extends Service {
    private UpdateBeanAT updateBeanAT;
    private long timestamp;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Start service : ID " + startId, Toast.LENGTH_SHORT).show();
        timestamp = 100;
        Log.w("tag", "Start service : ID " + startId);
        updateBeanAT = new UpdateBeanAT(BeanType.TOURNAMENT, timestamp);
        updateBeanAT.execute();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
