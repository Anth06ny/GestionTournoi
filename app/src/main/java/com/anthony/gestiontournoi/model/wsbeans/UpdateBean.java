package com.anthony.gestiontournoi.model.wsbeans;

import com.anthony.gestiontournoi.model.beans.ClubBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;

import java.util.ArrayList;


public class UpdateBean {

    //Liste des tournois modifiés
    private ArrayList<TournamentBean> updateTournament;

    //Ainsi que ClubContact, Place et les contacts des clubs . Club supprimés
    private ArrayList<ClubBean> updateClub;

    //Ainsi que le contact des équipes   , équipes supprimées
    private ArrayList<TeamBean> updateTeam;

    //Matche des tournois suivis ainsi que les fields
    private ArrayList<MatchBean> updateMatch;

    //Ainsi ses tournois, club et équipe suivis (juste id)
    //private UserBean userBean;
}
