package com.anthony.gestiontournoi.model.wsbeans;

import com.anthony.gestiontournoi.control.MyApplication;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.beans.TournamentBeanDao;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 05/07/2017.
 */

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

    // RETOURNE TOUS LES TOURNAMENTS DE LA DATABASE MOBILE

    public static ArrayList<TournamentBean> getAllTournament(){
        ArrayList<TournamentBean> tournamentBeanArrayList = (ArrayList<TournamentBean>) MyApplication.getDaoSession().getTournamentBeanDao().loadAll();
        return tournamentBeanArrayList;
    }

    // RETOURNE TOUTES LES TEAMS DE LA DATABASE MOBILE
    public static ArrayList<TeamBean> getAllTeam() {
        return null;
    }


    public static void deleteTournamentById(ArrayList<Long> arrayListId) {

        TournamentBeanDao tournamentBeanDao = MyApplication.getDaoSession().getTournamentBeanDao();

        for (int i = 0; i < arrayListId.size(); i++) {

            tournamentBeanDao.load(arrayListId.get(i)).delete();
        }

    }
}
