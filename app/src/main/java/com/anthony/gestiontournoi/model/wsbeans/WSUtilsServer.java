package com.anthony.gestiontournoi.model.wsbeans;

import android.util.Log;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.control.activities.MainActivity;
import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.ContactBean;
import com.anthony.gestiontournoi.model.beans.FieldBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TimestampBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.beans.TournamentContactBean;
import com.anthony.gestiontournoi.model.beans.TournamentPlaceBean;
import com.anthony.gestiontournoi.model.beans.TournamentTeamBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class WSUtilsServer {
    private static final Gson GSON = new Gson();

    //    private static final String URL = "http://192.168.1.14:8000/"; // NICO MAISON
//   private static final String URL = "http://192.168.42.31:8000/"; // NICO
    private static final String URL = "http://192.168.60.137:8000/"; // MALO

    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";
    private static final String URL_UPDATE_BEAN_MATCHS = URL + "updateBeanMatch/";
    private static final String URL_UPDATE_BEAN_TEAM = URL + "updateBeanTeam/";
    private static final String URL_UPDATE_BEAN_CLUB = URL + "updateBeanClub/";
    private static final String URL_UPDATE_BEAN_PLACE = URL + "updateBeanPlace/";
    private static final String URL_UPDATE_BEAN_CONTACT = URL + "updateBeanContact/";
    private static final String URL_UPDATE_BEAN_FIELD = URL + "updateBeanField/";


    public static void updateBeanTournament(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TOURNAMENT + timestamp);
        Log.w("tag", "Json tournament : " + json);

        ArrayList<TournamentBean> listTournaments = GSON.fromJson(json, new TypeToken<ArrayList<TournamentBean>>() {
        }.getType());
        Log.w("tag", "" + listTournaments.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listTournaments.size(); i++) {
            TournamentBean tournamentBean = listTournaments.get(i);
            Log.w("tag", "ID : " + tournamentBean.getId() + " delete : " + tournamentBean.isDelete());

            // CHECK SI TOURNAMENT_PLACE NE CONTIENT PAS DEJA LE tOURNAMENTpLACEbEAN
            List<Long> placesId = tournamentBean.getPlaceId();
            List<TournamentPlaceBean> tournamentPlaceBeanList = WSUtilsMobile.getPlaceByTournament(tournamentBean.getId());
            for (int j = 0; j < placesId.size(); j++) {
                Log.w("tag", "TournamentPlaceBean : " + j + "PlaceId : " + placesId.get(j));
                TournamentPlaceBean tournamentPlaceBean = new TournamentPlaceBean();
                tournamentPlaceBean.setTournamentId(tournamentBean.getId());
                tournamentPlaceBean.setPlaceId(placesId.get(j));
                MyApplication.getDaoSession().getTournamentPlaceBeanDao().insert(tournamentPlaceBean);

            }

            List<Long> teamId = tournamentBean.getTeamId();
            List<TournamentTeamBean> tournamentTeamBeanList = WSUtilsMobile.getTeamByTournament(tournamentBean.getId());
            for (int k = 0; k < teamId.size(); k++) {
                Log.w("tag", "TournamentTeamBean : " + k + "TeamId : " + teamId.get(k));
                TournamentTeamBean tournamentTeamBean = new TournamentTeamBean();
                tournamentTeamBean.setTournamentId(tournamentBean.getId());
                tournamentTeamBean.setTeamId(teamId.get(k));
                MyApplication.getDaoSession().getTournamentTeamBeanDao().insert(tournamentTeamBean);


            }

            List<Long> contactId = tournamentBean.getContactId();
            List<TournamentContactBean> tournamentContactBeanArrayList = WSUtilsMobile.getContactByTournament(tournamentBean.getId());
            for (int k = 0; k < contactId.size(); k++) {
                Log.w("tag", "TournamentContactBean : " + k + "contactId : " + contactId.get(k));
                TournamentContactBean tournamentContactBean = new TournamentContactBean();
                tournamentContactBean.setTournamentId(tournamentBean.getId());
                tournamentContactBean.setContactId(contactId.get(k));
                MyApplication.getDaoSession().getTournamentContactBeanDao().insert(tournamentContactBean);

            }

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean tournament " + tournamentBean.getId() + " : " + tournamentBean.getTimeStamp());
            if (maxTimestamp < tournamentBean.getTimeStamp()) {
                maxTimestamp = tournamentBean.getTimeStamp();
            }

            if (tournamentBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getTournamentBeanDao().delete(tournamentBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getTournamentBeanDao().load(tournamentBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getTournamentBeanDao().insert(tournamentBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getTournamentBeanDao().update(tournamentBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listTournaments.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setTournamentTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
        }
    }

    public static void updateBeanMatchs(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_MATCHS + timestamp);
        Log.w("tag", "Json matchs : " + json);


        ArrayList<MatchBean> listMatchs = GSON.fromJson(json, new TypeToken<ArrayList<MatchBean>>() {
        }.getType());
        Log.w("tag", "Matchs " + listMatchs.size());


        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;


        for (int i = 0; i < listMatchs.size(); i++) {
            MatchBean matchBean = listMatchs.get(i);
            Log.w("tag", "ID MATCH: " + matchBean.getId() + " delete : " + matchBean.isDelete());

            if (matchBean.getTeamsId().isEmpty()) {
                Log.w("TAGGETTEAM", "team id : null");
            } else {
                Log.w("TAGGETTEAM", matchBean.getTeamsId().size() + "");
                TeamBean team1 = WSUtilsMobile.getTeam(matchBean.getTeamsId().get(0));
                TeamBean team2 = WSUtilsMobile.getTeam(matchBean.getTeamsId().get(1));
                Log.w("TAGTEAMS", team1.getName() + " t2" + team2.getName());
                matchBean.setTeam1(team1);
                matchBean.setTeam2(team2);
            }


            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean match " + matchBean.getId() + " : " + matchBean.getTimeStamp());
            if (maxTimestamp < matchBean.getTimeStamp()) {
                maxTimestamp = matchBean.getTimeStamp();
            }

            if (matchBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getMatchBeanDao().delete(matchBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getMatchBeanDao().load(matchBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getMatchBeanDao().insert(matchBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getMatchBeanDao().update(matchBean);

                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE

        if (!listMatchs.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setMatchTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);

        }
    }

    public static void updateBeanTeam(long timestamp) throws Exception {
        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_TEAM + timestamp);
        Log.w("tag", "Json team : " + json);

        ArrayList<TeamBean> listTeams = GSON.fromJson(json, new TypeToken<ArrayList<TeamBean>>() {
        }.getType());
        Log.w("tag", "listTeams size : " + listTeams.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listTeams.size(); i++) {
            TeamBean teamBean = listTeams.get(i);
            Log.w("tag", "ID team : " + teamBean.getId() + " delete : " + teamBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            if (maxTimestamp < teamBean.getTimeStamp()) {
                maxTimestamp = teamBean.getTimeStamp();
            }

            if (teamBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getTeamBeanDao().delete(teamBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getTeamBeanDao().load(teamBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getTeamBeanDao().insert(teamBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getTeamBeanDao().update(teamBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listTeams.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setTeamTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
        }
    }

    public static void updateBeanClub(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_CLUB + timestamp);
        Log.w("tag", "Json clubs : " + json);

        ArrayList<ClubBean> listClubs = GSON.fromJson(json, new TypeToken<ArrayList<ClubBean>>() {
        }.getType());
        Log.w("tag", "Clubs " + listClubs.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listClubs.size(); i++) {
            ClubBean clubBean = listClubs.get(i);
            Log.w("tag", "ID : " + clubBean.getId() + " delete : " + clubBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean club " + clubBean.getId() + " : " + clubBean.getTimeStamp());
            if (maxTimestamp < clubBean.getTimeStamp()) {
                maxTimestamp = clubBean.getTimeStamp();
            }

            if (clubBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getClubBeanDao().delete(clubBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getClubBeanDao().load(clubBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getClubBeanDao().insert(clubBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getClubBeanDao().update(clubBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listClubs.isEmpty()) {
            TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
            timestampBean.setClubTimestamp(maxTimestamp);
            MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
        }
    }


    public static void updateBeanPlace(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_PLACE + timestamp);
        Log.w("tag", "Json place : " + json);

        ArrayList<PlaceBean> listPlaces = GSON.fromJson(json, new TypeToken<ArrayList<PlaceBean>>() {
        }.getType());
        Log.w("tag", "Places : " + listPlaces.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listPlaces.size(); i++) {
            PlaceBean placeBean = listPlaces.get(i);
            Log.w("tag", "ID : " + placeBean.getId() + " delete : " + placeBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean place " + placeBean.getId() + " : " + placeBean.getTimeStamp());
            if (maxTimestamp < placeBean.getTimeStamp()) {
                maxTimestamp = placeBean.getTimeStamp();
            }

            if (placeBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getPlaceBeanDao().delete(placeBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getPlaceBeanDao().load(placeBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getPlaceBeanDao().insert(placeBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getPlaceBeanDao().update(placeBean);
                }
            }
        }
    }

    // ON UPDATE LES CONTACTS D'UN TOURNOI
    public static void updateBeanContact(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_CONTACT + timestamp);
        Log.w("tag", "Json place : " + json);

        ArrayList<ContactBean> listContacts = GSON.fromJson(json, new TypeToken<ArrayList<ContactBean>>() {
        }.getType());
        Log.w("tag", "Contacts : " + listContacts.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listContacts.size(); i++) {
            ContactBean contactBean = listContacts.get(i);
            Log.w("tag", "ID : " + contactBean.getId() + " delete : " + contactBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean contact " + contactBean.getId() + " : " + contactBean.getTimeStamp());
            if (maxTimestamp < contactBean.getTimeStamp()) {
                maxTimestamp = contactBean.getTimeStamp();
            }

            if (contactBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getContactBeanDao().delete(contactBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getContactBeanDao().load(contactBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getContactBeanDao().insert(contactBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getContactBeanDao().update(contactBean);
                }

            }

        }
        //       updateTournamentContact();

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listContacts.isEmpty()) {
            updateMobileTimeStamp(maxTimestamp);
        }
    }

//    // ON UPDATE LES TOURNAMENT_CONTACTS
//    public static void updateTournamentContact() {
//        Log.w("tag_tournament_contact", "tag_tournament_contact");
//        List<TournamentBean> tournamentBeanList = WSUtilsMobile.getAllTournament();
//        for (int j = 0; j < tournamentBeanList.size(); j++) {
//            List<ContactBean> contactBeanList = tournamentBeanList.get(j).getContactList();
//            for (int i = 0; i < contactBeanList.size(); i++) {
//                TournamentContactBean tournamentContactBean = new TournamentContactBean();
//                tournamentContactBean.setContact(contactBeanList.get(i));
//                tournamentContactBean.setTournament(tournamentBeanList.get(j));
//                MyApplication.getDaoSession().getTournamentContactBeanDao().insert(tournamentContactBean);
//            }
//        }
//
//    }

    // ON UPDATE LES FIELDS D'UN TOURNOI
    public static void updateBeanField(long timestamp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(URL_UPDATE_BEAN_FIELD + timestamp);
        Log.w("tag", "Json field : " + json);

        ArrayList<FieldBean> listFields = GSON.fromJson(json, new TypeToken<ArrayList<FieldBean>>() {
        }.getType());
        Log.w("tag", "Contacts : " + listFields.size());

        // ON DECLARE LA VARIABLE QUI STOCK LE PLUS GRAND TIMESTAMP
        long maxTimestamp = 0;

        for (int i = 0; i < listFields.size(); i++) {
            FieldBean fieldBean = listFields.get(i);
            Log.w("tag", "ID : " + fieldBean.getId() + " delete : " + fieldBean.isDelete());

            // ON RECUPERE LE PLUS GRAND TIMESTAMP
            Log.w("tag", "timestamp bean field " + fieldBean.getId() + " : " + fieldBean.getTimeStamp());
            if (maxTimestamp < fieldBean.getTimeStamp()) {
                maxTimestamp = fieldBean.getTimeStamp();
            }

            if (fieldBean.isDelete()) {
                // SI DELETE A TRUE ALORS ON DELETE DE LA BDD MOBILE
                MyApplication.getDaoSession().getFieldBeanDao().delete(fieldBean);
            } else {
                // ON CHECK SI IL EXISTE EN BDD MOBILE
                if (MyApplication.getDaoSession().getFieldBeanDao().load(fieldBean.getId()) == null) {
                    // ON AJOUT SI EXISTE PAS
                    MyApplication.getDaoSession().getFieldBeanDao().insert(fieldBean);
                } else {
                    // ON MET A JOUR
                    MyApplication.getDaoSession().getFieldBeanDao().update(fieldBean);
                }
            }
        }

        // ON MET A JOUR LE TIMESTAMP DU MOBILE
        if (!listFields.isEmpty()) {
            updateMobileTimeStamp(maxTimestamp);
        }


    }

    public static void updateMobileTimeStamp(long maxTimestamp) {
        TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
        timestampBean.setTournamentTimestamp(maxTimestamp);
        MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
    }


}
