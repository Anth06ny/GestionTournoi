package com.anthony.gestiontournoi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailTournamentActivity extends AppCompatActivity {

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
    private CardView CVTeam;
    private CardView CVMatch;
    private CardView CVPlace;

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
        CVTeam = (CardView) findViewById(R.id.CVTeam);
        CVMatch = (CardView) findViewById(R.id.CVMatch);
        CVPlace = (CardView) findViewById(R.id.CVPlace);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailtournament);
        findViews();
    }
}
