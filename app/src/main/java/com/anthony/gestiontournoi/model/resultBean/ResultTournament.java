package com.anthony.gestiontournoi.model.resultBean;

import com.anthony.gestiontournoi.model.beans.TournamentBean;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 12/07/2017.
 */

public class ResultTournament {
    private ArrayList<TournamentBean> tournaments;
    private ArrayList<Long> id;

    public ResultTournament(ArrayList<TournamentBean> tournaments, ArrayList<Long> id) {
        this.tournaments = tournaments;
        this.id = id;
    }

    public ArrayList<TournamentBean> getTournaments() {
        return tournaments;
    }

    public ArrayList<Long> getId() {
        return id;
    }
}
