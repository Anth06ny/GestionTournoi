package com.anthony.gestiontournoi.control.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.ContactBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.anthony.gestiontournoi.view.adapter.RVTournamentContactAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetailTournamentActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgLogoOnetournament;
    private TextView tvTitleOnetournament;
    private TextView tvDateOnetournament;
    private LinearLayout linearPlace;
    private TextView tvPlace;
    private LinearLayout linearFormat;
    private TextView tvFormat;
    private LinearLayout linearField;
    private TextView tvField;
    private LinearLayout linearTeamPlayerFee;
    private TextView tvFee;
    private LinearLayout linearWebsite;
    private TextView tvWebsite;
    private LinearLayout linearLength;
    private TextView tvLength;
    private LinearLayout linearCap;
    private TextView tvCap;
    private LinearLayout linearHalftime;
    private TextView tvHalftime;
    private TextView tv_tel_hint;
    private TextView tv_mail_hint;
    private TextView tv_mail;
    private CardView CVTeam;
    private CardView CVMatch;
    private CardView CVPlace;
    private RecyclerView RVContacts;
    private List<ContactBean> contactBeanList;
    private RVTournamentContactAdapter rvTournamentContactAdapter;
    private long tournament_id;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-07-05 14:39:24 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        imgLogoOnetournament = (ImageView) findViewById(R.id.img_logo_onetournament);
        tvTitleOnetournament = (TextView) findViewById(R.id.tv_title_onetournament);
        tvDateOnetournament = (TextView) findViewById(R.id.tv_date_onetournament);
        linearPlace = (LinearLayout) findViewById(R.id.linear_place);
        tvPlace = (TextView) findViewById(R.id.tv_place);
        linearFormat = (LinearLayout) findViewById(R.id.linear_format);
        tvFormat = (TextView) findViewById(R.id.tv_format);
        linearField = (LinearLayout) findViewById(R.id.linear_field);
        tvField = (TextView) findViewById(R.id.tv_field);
        linearTeamPlayerFee = (LinearLayout) findViewById(R.id.linear_team_player_fee);
        tvFee = (TextView) findViewById(R.id.tv_fee);
        linearWebsite = (LinearLayout) findViewById(R.id.linear_website);
        tvWebsite = (TextView) findViewById(R.id.tv_website);
        linearLength = (LinearLayout) findViewById(R.id.linear_length);
        tvLength = (TextView) findViewById(R.id.tv_length);
        linearCap = (LinearLayout) findViewById(R.id.linear_cap);
        tvCap = (TextView) findViewById(R.id.tv_cap);
        linearHalftime = (LinearLayout) findViewById(R.id.linear_halftime);
        tvHalftime = (TextView) findViewById(R.id.tv_halftime);
        tv_tel_hint = (TextView) findViewById(R.id.tv_tel_hint);
        tv_mail_hint = (TextView) findViewById(R.id.tv_mail_hint);
        tv_mail = (TextView) findViewById(R.id.tv_mail);
        CVTeam = (CardView) findViewById(R.id.CVTeam);
        CVMatch = (CardView) findViewById(R.id.CVMatch);
        CVPlace = (CardView) findViewById(R.id.CVPlace);
        RVContacts = (RecyclerView) findViewById(R.id.RVContacts);

        CVTeam.setOnClickListener(this);
        CVMatch.setOnClickListener(this);
        CVPlace.setOnClickListener(this);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailtournament);
        findViews();

        tournament_id = getIntent().getExtras().getLong("id");

        TournamentBean tournamentBean = WSUtilsMobile.getTournament(tournament_id);
        tvTitleOnetournament.setText(tournamentBean.getName());
        tvDateOnetournament.setText("Du " + tournamentBean.getStartDate() + " au " + tournamentBean.getEndDate());

        List<PlaceBean> placeBeanList = tournamentBean.getPlaceList();
        if (!placeBeanList.isEmpty()) {
            tvPlace.setText(placeBeanList.get(0).getName());
        }
        tvFormat.setText(tournamentBean.getGender());

        tvField.setText(tournamentBean.getFieldType());
        tvFee.setText(tournamentBean.getTeamFee() + " / " + tournamentBean.getPlayerFee());
        tvWebsite.setText(tournamentBean.getSiteWeb());
        tvLength.setText(tournamentBean.getDuration());
        tvCap.setText(tournamentBean.getCap());
        tvHalftime.setText(tournamentBean.getHalfTime());


        if (!tournamentBean.getPicture().isEmpty()) {
            Glide.with(this).load(tournamentBean.getPicture()).into(imgLogoOnetournament);
        } else {
            Glide.with(this).load(R.drawable.ic_info_black_48dp).into(imgLogoOnetournament);
        }


// ADAPTER POUR CONTACTS
        contactBeanList = tournamentBean.getContactList();
        rvTournamentContactAdapter = new RVTournamentContactAdapter(contactBeanList);

        RVContacts.setAdapter(rvTournamentContactAdapter);

        RVContacts.setLayoutManager(new LinearLayoutManager(this));
        RVContacts.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    public void onClick(View view) {
        if (view == CVTeam) {
            Intent intent = new Intent(this, RVTournamentTeamActivity.class);
            intent.putExtra("id", tournament_id);
            startActivity(intent);
        } else if (view == CVMatch) {
            Intent intent = new Intent(this, RVTournamentMatchActivity.class);
            intent.putExtra("id", tournament_id);
            startActivity(intent);
        } else if (view == CVPlace) {
            Intent intent = new Intent(this, RVTournamentPlaceActivity.class);
            intent.putExtra("id", tournament_id);
            startActivity(intent);
        }
    }
}
