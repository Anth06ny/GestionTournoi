package com.anthony.gestiontournoi.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TournamentBean;

import java.util.ArrayList;

public class RVTournamentAdapter extends RecyclerView.Adapter<RVTournamentAdapter.ViewHolder> {

    private ArrayList<TournamentBean> tournamentBeanArrayList;

    public RVTournamentAdapter(ArrayList<TournamentBean> tournamentBeanArrayList) {
        this.tournamentBeanArrayList = tournamentBeanArrayList;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title_tournament, date_tournament, place_tournament;
        public ImageView logo_tournament;
        public ImageButton follow_tournament;


        public ViewHolder(View itemView) {
            super(itemView);
            title_tournament = (TextView) itemView.findViewById(R.id.TV_title_tournament);
            date_tournament = (TextView) itemView.findViewById(R.id.TV_date_tournament);
            place_tournament = (TextView) itemView.findViewById(R.id.TV_place_tournament);
            logo_tournament = (ImageView) itemView.findViewById(R.id.img_logo_tournament);
            follow_tournament = (ImageButton) itemView.findViewById(R.id.img_follow_tournament);

        }
    }

    @Override
    public RVTournamentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tournament, parent, false);
        return new RVTournamentAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVTournamentAdapter.ViewHolder holder, int position) {
        TournamentBean tournamentBean = tournamentBeanArrayList.get(position);
        holder.title_tournament.setText(tournamentBean.getName());
        holder.date_tournament.setText(tournamentBean.getStartDate() + " " + tournamentBean.getEndDate());
        holder.place_tournament.setText(tournamentBean.getPlaceList() + "");
        // follow ?
        // logo?

    }

    @Override
    public int getItemCount() {
        return tournamentBeanArrayList.size();
    }


}
