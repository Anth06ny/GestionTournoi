package com.anthony.gestiontournoi.model;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.control.activities.MainActivity;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class ServiceTournament extends Service {

    public static final String SERVICE_TYPE = "ServiceType";

    public enum ServiceAction {
        LOAD_TOURNAMENT,
        LOAD_MATCH,
        LOAD_TEAM,
        LOAD_CLUB,
        LOAD_PLACE,
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ServiceAction action = (ServiceAction) intent.getExtras().get(SERVICE_TYPE);

        if (action != null) {

            switch (action) {
                case LOAD_TOURNAMENT:
                    long timestampTournament = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTournamentTimestamp();
                    UpdateBeanAT updateBeanTournamentAT = new UpdateBeanAT(BeanType.TOURNAMENT, timestampTournament);
                    updateBeanTournamentAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

                    break;

                case LOAD_MATCH:
                    Log.w("tag", "load_match");
                    long timestampMatch = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getMatchTimestamp();
                    UpdateBeanAT updateBeanMatchAT = new UpdateBeanAT(BeanType.MATCHS, timestampMatch);
                    updateBeanMatchAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    break;

                case LOAD_TEAM:
                    long timestampTeam = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTeamTimestamp();
                    UpdateBeanAT updateBeanTeamAT = new UpdateBeanAT(BeanType.TEAM, timestampTeam);
                    updateBeanTeamAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    break;

                case LOAD_CLUB:
                    long timestampClub = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getClubTimestamp();
                    UpdateBeanAT updateBeanClubAT = new UpdateBeanAT(BeanType.CLUB, timestampClub);
                    updateBeanClubAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    break;

                case LOAD_PLACE:
                    long timestampPlace = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getPlaceTimestamp();
                    UpdateBeanAT updateBeanPlaceAT = new UpdateBeanAT(BeanType.PLACE, timestampPlace);
                    updateBeanPlaceAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    break;
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
