package com.anthony.gestiontournoi.model.wsbeans;

import android.util.Log;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.control.activities.MainActivity;
import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.ClubContactBean;
import com.anthony.gestiontournoi.model.beans.ContactBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TeamContactBean;
import com.anthony.gestiontournoi.model.beans.TimestampBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.beans.TournamentContactBean;
import com.anthony.gestiontournoi.model.beans.TournamentContactBeanDao;
import com.anthony.gestiontournoi.model.beans.TournamentPlaceBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;


public class WSUtilsServer {
    private static final Gson GSON = new Gson();
    
    private static final String URL = "http://192.168.1.27:8000/"; // MALO MAISON

    private static final String URL_UPDATE_BEAN_TOURNAMENT = URL + "updateBeanTournament/";
    private static final String URL_UPDATE_BEAN_MATCHS = URL + "updateBeanMatch/";
    private static final String URL_UPDATE_BEAN_TEAM = URL + "updateBeanTeam/";
    private static final String URL_UPDATE_BEAN_CLUB = URL + "updateBeanClub/";
    private static final String URL_UPDATE_BEAN_PLACE = URL + "updateBeanPlace/";
    private static final String URL_UPDATE_BEAN_CONTACT = URL + "updateBeanContact/";
    private static final String URL_EDIT_BEAN_TOURNAMENT = URL + "editTournament/";
    private static final String URL_ADD_BEAN_TOURNAMENT = URL + "addTournament";


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
            for (int j = 0; j < placesId.size(); j++) {
                Log.w("tag", "TournamentPlaceBean : " + j + "PlaceId : " + placesId.get(j));
                TournamentPlaceBean tournamentPlaceBean = new TournamentPlaceBean();
                tournamentPlaceBean.setTournamentId(tournamentBean.getId());
                tournamentPlaceBean.setPlaceId(placesId.get(j));
                // récup all tournamentplacebean
                List<TournamentPlaceBean> allTournamentPlaceBean = MyApplication.getDaoSession().getTournamentPlaceBeanDao().loadAll();
                // comparer si il existe pas deja
                if (!allTournamentPlaceBean.contains(tournamentPlaceBean)) {
                    // si il existe pas on le persiste
                    MyApplication.getDaoSession().getTournamentPlaceBeanDao().insert(tournamentPlaceBean);
                }
            }
            TournamentContactBean tournamentContactBean = new TournamentContactBean();
            // on récupère les id des contacts
            List<Long> contactId = tournamentBean.getContactId();
            for (int k = 0; k < contactId.size(); k++) {
                Log.w("tag", "TournamentContactBean : " + k + "contactId : " + contactId.get(k));
                // on récupère tous les tournamentContactBean
                List<TournamentContactBean> allTournamentContactBean = MyApplication.getDaoSession().getTournamentContactBeanDao().loadAll();
                // on rempli un tournamentcontactbean
                tournamentContactBean.setTournamentId(tournamentBean.getId());
                tournamentContactBean.setContactId(contactId.get(k));
                // récup all TournamentContactBean


                // comparaison si existe
                if (!allTournamentContactBean.contains(tournamentContactBean)) {
                    MyApplication.getDaoSession().getTournamentContactBeanDao().insert(tournamentContactBean);
                }
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

            // on récup l'id du tournoi
            long tournamentId = matchBean.getTournamentId();
            Log.w("TestTournamentId", " tournamentId" + tournamentId);
            TournamentBean tournamentBean = WSUtilsMobile.getTournament(tournamentId);
            matchBean.setTournament(tournamentBean);

            long team1Id = matchBean.getTeam1Id();
            Log.w("TestTeam1Id", "team1Id" + team1Id);
            TeamBean team1 = WSUtilsMobile.getTeam(team1Id);
            matchBean.setTeam1(team1);

            long team2Id = matchBean.getTeam2Id();
            Log.w("TestTeam2Id", "team2Id" + team2Id);
            TeamBean team2 = WSUtilsMobile.getTeam(team2Id);
            matchBean.setTeam2(team2);

            long teamTableId = matchBean.getTeamTableId();
            Log.w("TestTeamTableId", "teamTableId" + teamTableId);
            TeamBean teamTable = WSUtilsMobile.getTeam(teamTableId);
            matchBean.setTeamTable(teamTable);


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

        // on récup la liste des teams
        for (int i = 0; i < listTeams.size(); i++) {

            // on crée l'objet team
            TeamBean teamBean = listTeams.get(i);
            Log.w("tag", "ID team : " + teamBean.getId() + " delete : " + teamBean.isDelete());

            // on stocke dans TeamContactBean
            List<Long> contactId = teamBean.getContactId();
            for (int k = 0; k < contactId.size(); k++) {
                Log.w("tag", "TeamContactBean : " + k + "contactId : " + contactId.get(k));
                TeamContactBean teamContactBean = new TeamContactBean();
                teamContactBean.setTeamId(teamBean.getId());
                teamContactBean.setContactId(contactId.get(k));
                // on récup tous les teamContactBean
                List<TeamContactBean> allTeamContactBean = MyApplication.getDaoSession().getTeamContactBeanDao().loadAll();
                // on compare si ça existe deja
                if (!allTeamContactBean.contains(teamContactBean)) {
                    MyApplication.getDaoSession().getTeamContactBeanDao().insert(teamContactBean);
                }
            }


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

            // on stocke dans ClubContactBean
            List<Long> contactId = clubBean.getContactId();
            for (int k = 0; k < contactId.size(); k++) {
                Log.w("tag", "ClubContactBean : " + k + "contactId : " + contactId.get(k));
                ClubContactBean clubContactBean = new ClubContactBean();
                clubContactBean.setClubId(clubBean.getId());
                clubContactBean.setContactId(contactId.get(k));
                //on récup tous les ClubContactBean
                List<ClubContactBean> allClubContactBean = MyApplication.getDaoSession().getClubContactBeanDao().loadAll();
                // on compare si ça existe deja
                if (!allClubContactBean.contains(clubContactBean)) {
                    MyApplication.getDaoSession().getClubContactBeanDao().insert(clubContactBean);
                }
            }

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


    public static void updateMobileTimeStamp(long maxTimestamp) {
        TimestampBean timestampBean = MyApplication.getDaoSession().getTimestampBeanDao().load(MainActivity.ID_TIMESTAMP);
        timestampBean.setTournamentTimestamp(maxTimestamp);
        MyApplication.getDaoSession().getTimestampBeanDao().update(timestampBean);
    }

    public static void editTournament(String json, long tournament_id) {

        try {
            Log.w("TAG_JSON", json);
            // DECODER LE JSON DANS L'EDIT TOURNAMENT DU PHP
            OkHttpUtils.sendPostOkHttpRequest(URL_EDIT_BEAN_TOURNAMENT + tournament_id, json);

            // JSON A RETRAVAILLER
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void addTournament(String json) {

        try {
            Log.w("TAG_JSON", json);
            // ENVOI DU JSON AU SERVEUR
            OkHttpUtils.sendPostOkHttpRequest(URL_ADD_BEAN_TOURNAMENT, json);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
