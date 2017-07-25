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



public class ServiceTournament extends Service {

    public static final String SERVICE_TYPE = "ServiceType";

    public enum ServiceAction {
        LOAD_DATA
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ServiceAction actionID = (ServiceAction) intent.getExtras().get(SERVICE_TYPE);

//        Intent intent1 = new Intent(this, ServiceTournament.class);
//        intent1.putExtra("toto", ServiceAction.LOAD_DATA);

        if (actionID != null) {


            switch (actionID){
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
