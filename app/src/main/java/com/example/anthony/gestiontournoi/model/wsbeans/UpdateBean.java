package com.example.anthony.gestiontournoi.model.wsbeans;

import com.example.anthony.gestiontournoi.model.beans.ClubBean;
import com.example.anthony.gestiontournoi.model.beans.MatchBean;
import com.example.anthony.gestiontournoi.model.beans.TeamBean;
import com.example.anthony.gestiontournoi.model.beans.TournamentBean;
import com.example.anthony.gestiontournoi.model.beans.UserBean;

import java.util.ArrayList;

/**
 * Created by Anthony on 26/01/2017.
 */
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
    private UserBean userBean;
}
