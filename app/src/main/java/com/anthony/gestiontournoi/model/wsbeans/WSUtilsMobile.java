package com.anthony.gestiontournoi.model.wsbeans;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.ContactBean;
import com.anthony.gestiontournoi.model.beans.FieldBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.beans.TournamentBeanDao;

import java.util.ArrayList;


public class WSUtilsMobile {

    // MET A JOUR LES TABLES DE LA DATABASE MOBILE DEPUIS LE DB DISTANTE
    public static void updateBean() {

    }

    // MET A JOUR LA TABLE TOURNAMENT DE LA DATABASE MOBILE DEPUIS LE DB DISTANTE
    public static void updateTournament() {

    }

    // MET A JOUR LA TABLE TEAM DE LA DATABASE MOBILE DEPUIS LE DB DISTANTE
    public static void updateTeam() {

    }

    /******************** GET ALL ********************/
    // RETOURNE TOUS LES TOURNAMENTS DE LA DATABASE MOBILE
    public static ArrayList<TournamentBean> getAllTournament() {
        ArrayList<TournamentBean> tournamentBeanArrayList = (ArrayList<TournamentBean>) MyApplication.getDaoSession().getTournamentBeanDao().loadAll();
        return tournamentBeanArrayList;
    }

    // RETOURNE TOUTES LES TEAMS DE LA DATABASE MOBILE
    public static ArrayList<TeamBean> getAllTeam() {
        ArrayList<TeamBean> teamBeanArrayList = (ArrayList<TeamBean>) MyApplication.getDaoSession().getTeamBeanDao().loadAll();
        return teamBeanArrayList;
    }

    // RETOURNE TOUTES LES MATCHS DE LA DATABASE MOBILE
    public static ArrayList<MatchBean> getAllMatch() {
        ArrayList<MatchBean> matchBeanArrayList = (ArrayList<MatchBean>) MyApplication.getDaoSession().getMatchBeanDao().loadAll();
        return matchBeanArrayList;
    }

    // RETOURNE TOUTES LES CLUBS DE LA DATABASE MOBILE
    public static ArrayList<ClubBean> getAllClub() {
        ArrayList<ClubBean> clubBeanArrayList = (ArrayList<ClubBean>) MyApplication.getDaoSession().getClubBeanDao().loadAll();
        return clubBeanArrayList;
    }

    // RETOURNE TOUTES LES PLACES DE LA DATABASE MOBILE
    public static ArrayList<PlaceBean> getAllPlace() {
        ArrayList<PlaceBean> placeBeanArrayList = (ArrayList<PlaceBean>) MyApplication.getDaoSession().getPlaceBeanDao().loadAll();
        return placeBeanArrayList;
    }


    /******************** GET ONE ********************/
    public static TournamentBean getTournament(long id) {
        TournamentBean tournamentBean = MyApplication.getDaoSession().getTournamentBeanDao().load(id);
        return tournamentBean;
    }

    public static TeamBean getTeam(long id) {
        TeamBean teamBean = MyApplication.getDaoSession().getTeamBeanDao().load(id);
        return teamBean;
    }


    public static ClubBean getClub(long id) {
        ClubBean clubBean = MyApplication.getDaoSession().getClubBeanDao().load(id);
        return clubBean;
    }

    public static MatchBean getMatch(long id) {
        MatchBean matchBean = MyApplication.getDaoSession().getMatchBeanDao().load(id);
        return matchBean;
    }

    public static FieldBean getField(long id) {
        FieldBean fieldBean = MyApplication.getDaoSession().getFieldBeanDao().load(id);
        return fieldBean;
    }

    public static ContactBean getContact(long id) {
        ContactBean contactBean = MyApplication.getDaoSession().getContactBeanDao().load(id);
        return contactBean;
    }




    public static void deleteTournamentById(ArrayList<Long> arrayListId) {

        TournamentBeanDao tournamentBeanDao = MyApplication.getDaoSession().getTournamentBeanDao();

        for (int i = 0; i < arrayListId.size(); i++) {

            tournamentBeanDao.load(arrayListId.get(i)).delete();
        }

    }
}
