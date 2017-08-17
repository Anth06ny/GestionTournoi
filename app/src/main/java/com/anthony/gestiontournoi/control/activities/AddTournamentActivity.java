package com.anthony.gestiontournoi.control.activities;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.google.gson.Gson;

import java.text.ParseException;
import java.util.Date;

public class AddTournamentActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private EditText etTitle;
    private EditText etHalftime;
    private EditText etCap;
    private EditText etGender;
    private EditText etNbPlayer;
    private EditText etPlayerFee;
    private EditText etTeamFee;
    private EditText etPicture;
    private EditText etFieldType;
    private EditText etDuration;
    private EditText etWebsite;
    private EditText etClub;
    private EditText etStartDate;
    private ImageButton ibStartDate;
    private EditText etEndDate;
    private ImageButton ibEndDate;
    private Button btCancel;
    private Button btAdd;
    private Calendar calendar;
    private DatePickerDialog datePickerDialogStart;
    private DatePickerDialog datePickerDialogEnd;

    private void findViews() {
        etTitle = (EditText)findViewById( R.id.et_title );
        etHalftime = (EditText)findViewById( R.id.et_halftime );
        etCap = (EditText)findViewById( R.id.et_cap );
        etGender = (EditText)findViewById( R.id.et_gender );
        etNbPlayer = (EditText)findViewById( R.id.et_nbPlayer );
        etPlayerFee = (EditText)findViewById( R.id.et_playerFee );
        etTeamFee = (EditText)findViewById( R.id.et_teamFee );
        etPicture = (EditText)findViewById( R.id.et_picture );
        etFieldType = (EditText)findViewById( R.id.et_fieldType );
        etDuration = (EditText)findViewById( R.id.et_duration );
        etWebsite = (EditText)findViewById( R.id.et_website );
        etClub = (EditText)findViewById( R.id.et_club );
        etStartDate = (EditText)findViewById( R.id.et_startDate );
        ibStartDate = (ImageButton)findViewById( R.id.ib_startDate );
        etEndDate = (EditText)findViewById( R.id.et_endDate );
        ibEndDate = (ImageButton)findViewById( R.id.ib_endDate );
        btCancel = (Button)findViewById( R.id.bt_cancel );
        btAdd = (Button)findViewById( R.id.bt_add );

        ibStartDate.setOnClickListener( this);
        ibEndDate.setOnClickListener( this );
        btCancel.setOnClickListener( this );
        btAdd.setOnClickListener( this );
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if ( v == ibStartDate ) {
            // Handle clicks for ibStartDate
            datePickerDialogStart = new DatePickerDialog(this, this,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialogStart.show();
        } else if ( v == ibEndDate ) {
            // Handle clicks for ibEndDate
            datePickerDialogEnd = new DatePickerDialog(this, this,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialogEnd.show();
        } else if ( v == btCancel ) {
            // Handle clicks for btCancel
        } else if ( v == btAdd ) {
            // Handle clicks for btAdd
            Long id = null;
            Long playerFee = 0L;
            Long teamFee = 0L;
            Integer nbPlayer =0;

            if (!etClub.getText().toString().isEmpty()){
                id = Long.parseLong(etClub.getText().toString());
            }
            if (!etPlayerFee.getText().toString().isEmpty()){
                playerFee = Long.parseLong(etPlayerFee.getText().toString());
            }
            if (!etTeamFee.getText().toString().isEmpty()){
                teamFee = Long.parseLong(etTeamFee.getText().toString());
            }
            if (!etNbPlayer.getText().toString().isEmpty()){
                nbPlayer = Integer.parseInt(etNbPlayer.getText().toString());
            }

            Calendar calendarTimestamp = Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date start = null;
            Date end = null;
            try {
                start = sdf.parse(etStartDate.getText().toString());
                end = sdf.parse(etEndDate.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }


            TournamentBean tournamentBean = new TournamentBean();

            tournamentBean.setClubId(id);

            tournamentBean.setName(etTitle.getText().toString());

            if (start != null){
                Log.w("tag", "date du start : " + sdf.format(start.getTime()));
                tournamentBean.setStartDate(start.getTime());
            }
            if (end != null){
                Log.w("tag", "date du end : " + sdf.format(end.getTime()));
                tournamentBean.setEndDate(end.getTime());
            }

            tournamentBean.setDuration(etDuration.getText().toString());
            tournamentBean.setHalfTime(etHalftime.getText().toString());
            tournamentBean.setCap(etCap.getText().toString());
            tournamentBean.setPicture(etPicture.getText().toString());
            tournamentBean.setPlayerFee(playerFee);
            tournamentBean.setTeamFee(teamFee);
            tournamentBean.setFieldType(etFieldType.getText().toString());
            //tournamentBean.setNumberOfPlayer(nbPlayer);
            //tournamentBean.setGender(etGender.getText().toString());

            tournamentBean.setSiteWeb(etWebsite.getText().toString());
            tournamentBean.setTimeStamp(calendarTimestamp.getTimeInMillis());

            Log.w("tag", "TimeStamp Millis : " + tournamentBean.getTimeStamp());
            Gson gson = new Gson();
            String reponse = gson.toJson(tournamentBean);
            Log.w("tag", "json : " + reponse);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tournament);
        findViews();
        calendar = Calendar.getInstance();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month++;
        if(view == datePickerDialogStart.getDatePicker()){
            etStartDate.setText(dayOfMonth + "/" + month + "/" + year);
        } else if (view == datePickerDialogEnd.getDatePicker()){
            etEndDate.setText(dayOfMonth + "/" + month + "/" + year);
        }
    }
}
