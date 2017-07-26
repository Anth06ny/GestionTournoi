package com.anthony.gestiontournoi.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TeamBean;

import java.util.ArrayList;

/**
 * Created by Malorie on 04/07/2017.
 */

public class RVTeamAdapter extends RecyclerView.Adapter<RVTeamAdapter.ViewHolder> {

    private ArrayList<TeamBean> teamBeanArrayList;
    private String defautPlace = "Pas de lieu associé";


    public RVTeamAdapter(ArrayList<TeamBean> teamBeanArrayList) {
        this.teamBeanArrayList = teamBeanArrayList;
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_team, place_team, number_team;
        private ImageView logo_team;
        private ImageButton follow_team;

        public ViewHolder(View itemView) {
            super(itemView);
            name_team = (TextView) itemView.findViewById(R.id.TV_name_team);
            place_team = (TextView) itemView.findViewById(R.id.TV_place_team);
            number_team = (TextView) itemView.findViewById(R.id.TV_number_team);
            logo_team = (ImageView) itemView.findViewById(R.id.img_logo_team);
            follow_team = (ImageButton) itemView.findViewById(R.id.img_follow_team);
        }
    }


    @Override
    public RVTeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_team, parent, false);
        return new RVTeamAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVTeamAdapter.ViewHolder holder, int position) {
        TeamBean teamBean = teamBeanArrayList.get(position);
        holder.name_team.setText(teamBean.getName());
        if (teamBean.getClub() != null){
            holder.place_team.setText(teamBean.getClub().getPlace().getName());
        } else {
            holder.place_team.setText(defautPlace);
        }

        // holder.number_team.setText(teamBean.get); ???
        // follow ?
        // logo?

    }

    @Override
    public int getItemCount() {
        return teamBeanArrayList.size();
    }


}
