package com.anthony.gestiontournoi.view.adapter;


import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.control.activities.DetailTournamentActivity;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.N)
public class RVTournamentAdapter extends RecyclerView.Adapter<RVTournamentAdapter.ViewHolder> {
    private Calendar calendarStart = new GregorianCalendar();
    private Calendar calendarEnd = new GregorianCalendar();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String defautPlace = "Pas de lieu associé";
    private Context context;

    private ArrayList<TournamentBean> tournamentBeanArrayList;

    public RVTournamentAdapter(ArrayList<TournamentBean> tournamentBeanArrayList) {
        this.tournamentBeanArrayList = tournamentBeanArrayList;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title_tournament, date_tournament, place_tournament;
        public ImageView logo_tournament;
        public ImageButton follow_tournament;
        public CardView CVTournament;


        public ViewHolder(View itemView) {
            super(itemView);

            title_tournament = (TextView) itemView.findViewById(R.id.TV_title_tournament);
            date_tournament = (TextView) itemView.findViewById(R.id.TV_date_tournament);
            place_tournament = (TextView) itemView.findViewById(R.id.TV_place_tournament);
            logo_tournament = (ImageView) itemView.findViewById(R.id.img_logo_tournament);
            follow_tournament = (ImageButton) itemView.findViewById(R.id.img_follow_tournament);
            CVTournament = (CardView) itemView.findViewById(R.id.CVTournament);

        }
    }

    @Override
    public RVTournamentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tournament, parent, false);
        return new RVTournamentAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        context = holder.logo_tournament.getContext();

        final TournamentBean tournamentBean = tournamentBeanArrayList.get(position);
        calendarStart.setTimeInMillis(tournamentBean.getStartDate());
        calendarEnd.setTimeInMillis(tournamentBean.getEndDate());
//        Drawable drawable = holder.logo_tournament.getContext().getDrawable(R.drawable.ic_menu_gallery);
        if (!tournamentBean.getPicture().isEmpty()) {
            Log.w("tag", "url img : " + tournamentBean.getPicture());
            Glide.with(context).load(tournamentBean.getPicture()).into(holder.logo_tournament);
        } else {
            holder.logo_tournament.setImageResource(R.drawable.ic_menu_gallery);
        }

        holder.title_tournament.setText(tournamentBean.getName());
        holder.date_tournament.setText(sdf.format(calendarStart) + " au " + sdf.format(calendarEnd));
        if (tournamentBean.getPlaceList().size() != 0) {
            holder.place_tournament.setText(tournamentBean.getPlaceList().get(0).getName());
        } else {
            holder.place_tournament.setText(defautPlace);
        }

        Glide.with(context).load(R.drawable.ic_heart_outline_black_48dp).into(holder.follow_tournament);
//        Glide.with(context).load(tournamentBean.getPicture()).into(holder.follow_tournament);

        holder.CVTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailTournamentActivity.class);
                intent.putExtra("id", tournamentBean.getId());
                context.startActivity(intent);
            }
        });

        // follow ?
        // logo?

    }

    @Override
    public int getItemCount() {
        return tournamentBeanArrayList.size();
    }


}
