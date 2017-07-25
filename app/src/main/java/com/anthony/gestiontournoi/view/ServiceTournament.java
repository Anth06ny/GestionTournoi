package com.anthony.gestiontournoi.view;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.anthony.gestiontournoi.MainActivity;
import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.BeanType;
import com.anthony.gestiontournoi.model.UpdateBeanAT;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class ServiceTournament extends Service {

    public enum ServiceAction {
        LOAD_DATA
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int actionID = intent.getExtras().getInt("toto", -1);

        Intent intent1 = new Intent(this, ServiceTournament.class);
        intent1.putExtra("toto", ServiceAction.LOAD_DATA);

        if (actionID>= 0 && actionID < ServiceAction.values().length) {
            ServiceAction sa = ServiceAction.values()[actionID];

            switch (sa){
                case LOAD_DATA:
                    break;
            }


            Toast.makeText(this, "Start service : ID " + startId, Toast.LENGTH_SHORT).show();
            long timestamp = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTournamentTimestamp();
            Log.w("tag", "Start service : ID " + startId + "timestamp mobile : " + timestamp);
            UpdateBeanAT updateBeanAT = new UpdateBeanAT(BeanType.TOURNAMENT, timestamp);
            updateBeanAT.execute();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
