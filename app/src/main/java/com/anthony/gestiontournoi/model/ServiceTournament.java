package com.anthony.gestiontournoi.model;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.control.activities.MainActivity;

import static com.anthony.gestiontournoi.model.BeanType.EDIT_TOURNAMENT;
import static com.anthony.gestiontournoi.model.ServiceTournament.ServiceAction.ADD_TOURNAMENT;


public class ServiceTournament extends Service {

    public static final String SERVICE_TYPE = "ServiceType";
    public static String JSON = "json";
    public static String TOURNAMENT_ID = "tournament_id";

    public enum ServiceAction {
        LOAD_TOURNAMENT,
        EDIT_TOURNAMENT,
        LOAD_SEQUENCE,
        ADD_TOURNAMENT,
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ServiceAction action = (ServiceAction) intent.getExtras().get(SERVICE_TYPE);

        if (action != null) {

            switch (action) {
                case LOAD_SEQUENCE:
                    // On récupère les Place
                    long timestampPlaceSQ = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getPlaceTimestamp();
                    UpdateBeanAT updateBeanPlaceATSQ = new UpdateBeanAT(BeanType.PLACE, timestampPlaceSQ);
                    updateBeanPlaceATSQ.execute();

                    // On récupère les Team
                    long timestampTeamSQ = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTeamTimestamp();
                    UpdateBeanAT updateBeanTeamATSQ = new UpdateBeanAT(BeanType.TEAM, timestampTeamSQ);
                    updateBeanTeamATSQ.execute();

                    // On récupère les Contact
                    long timestampContactSQ = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getContactTimestamp();
                    UpdateBeanAT updateBeanContactATSQ = new UpdateBeanAT(BeanType.CONTACT, timestampContactSQ);
                    updateBeanContactATSQ.execute();

                    // On récupère les Club
                    long timestampClubSQ = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getClubTimestamp();
                    UpdateBeanAT updateBeanClubATSQ = new UpdateBeanAT(BeanType.CLUB, timestampClubSQ);
                    updateBeanClubATSQ.execute();

                    // On récupère les Tournament
                    long timestampTournamentSQ = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTournamentTimestamp();
                    UpdateBeanAT updateBeanTournamentATSQ = new UpdateBeanAT(BeanType.TOURNAMENT, timestampTournamentSQ);
                    updateBeanTournamentATSQ.execute();

                    // On récupère les Match
                    long timestampMatchSQ = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getMatchTimestamp();
                    UpdateBeanAT updateBeanMatchATSQ = new UpdateBeanAT(BeanType.MATCHS, timestampMatchSQ);
                    updateBeanMatchATSQ.execute();


                case EDIT_TOURNAMENT:
                    if (intent.getExtras().get(JSON) != null) {
                        String json = (String) intent.getExtras().get(JSON);
                        long tournament_id = (long) intent.getExtras().get(TOURNAMENT_ID);

                        UpdateBeanAT updateBeanEditTournamentAT = new UpdateBeanAT(EDIT_TOURNAMENT, MainActivity.ID_TIMESTAMP, json, tournament_id);
                        updateBeanEditTournamentAT.execute();

                        // Je dois supprimer mes dépendances afin de ne pas les rentrer 2 fois



                        long timestampTournament = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTournamentTimestamp();
                        UpdateBeanAT updateBeanTournamentAT = new UpdateBeanAT(BeanType.TOURNAMENT, timestampTournament);
                        updateBeanTournamentAT.execute(AsyncTask.THREAD_POOL_EXECUTOR);
                    }


                    break;

                case ADD_TOURNAMENT:
                    if (intent.getExtras().get(JSON) != null) {
                        String json = (String) intent.getExtras().get(JSON);

                        UpdateBeanAT updateBeanAddTournamentAT = new UpdateBeanAT(BeanType.ADD_TOURNAMENT, MainActivity.ID_TIMESTAMP, json);
                        updateBeanAddTournamentAT.execute();


                        long timestampTournament = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTournamentTimestamp();
                        UpdateBeanAT updateBeanTournamentAT = new UpdateBeanAT(BeanType.TOURNAMENT, timestampTournament);
                        updateBeanTournamentAT.execute(AsyncTask.THREAD_POOL_EXECUTOR);
                    }


                    break;


//                case LOAD_MATCH:
//                    Log.w("tag", "load_match");
//                    long timestampMatch = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getMatchTimestamp();
//                    UpdateBeanAT updateBeanMatchAT = new UpdateBeanAT(BeanType.MATCHS, timestampMatch);
//                    updateBeanMatchAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                    break;
//
//                case LOAD_TEAM:
//                    long timestampTeam = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getTeamTimestamp();
//                    UpdateBeanAT updateBeanTeamAT = new UpdateBeanAT(BeanType.TEAM, timestampTeam);
//                    updateBeanTeamAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                    break;
//
//                case LOAD_CLUB:
//                    long timestampClub = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getClubTimestamp();
//                    UpdateBeanAT updateBeanClubAT = new UpdateBeanAT(BeanType.CLUB, timestampClub);
//                    updateBeanClubAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                    break;
//
//                case LOAD_PLACE:
//                    long timestampPlace = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP).getPlaceTimestamp();
//                    UpdateBeanAT updateBeanPlaceAT = new UpdateBeanAT(BeanType.PLACE, timestampPlace);
//                    updateBeanPlaceAT.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                    break;
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
