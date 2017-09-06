package com.anthony.gestiontournoi.control.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anthony.gestiontournoi.R;
import com.anthony.gestiontournoi.model.ServiceTournament;
import com.anthony.gestiontournoi.model.beans.ContactBean;
import com.anthony.gestiontournoi.model.beans.MatchBean;
import com.anthony.gestiontournoi.model.beans.PlaceBean;
import com.anthony.gestiontournoi.model.beans.TeamBean;
import com.anthony.gestiontournoi.model.beans.TournamentBean;
import com.anthony.gestiontournoi.model.wsbeans.WSUtilsMobile;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EditTournamentActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView editTvTitleOnetournament;
    private ImageView editImgLogoOneTournament;
    private TextView editTvDateOnetournament;
    private ImageView editTitleEdit;
    private ImageView editDateEdit;
    private LinearLayout editLinearPlace;
    private TextView editTvPlaceHint;
    private TextView editTvPlace;
    private ImageView editImgEditPlace;
    private LinearLayout editLinearFormat;
    private TextView editTvFormatHint;
    private TextView editTvFormat;
    private ImageView editImgEditFormat;
    private LinearLayout editLinearField;
    private TextView editTvFieldHint;
    private TextView editTvField;
    private ImageView editImgEditField;
    private LinearLayout editLinearTeamPlayerFee;
    private TextView editTvFeeHint;
    private TextView editTvFee;
    private ImageView editImgEditFee;
    private LinearLayout editLinearWebsite;
    private TextView editTvWebsiteHint;
    private TextView editTvWebsite;
    private ImageView editImgEditWebsite;
    private TextView editTvMatchesHint;
    private LinearLayout editLinearLength;
    private TextView editTvLengthHint;
    private TextView editTvLength;
    private ImageView editImgEditLength;
    private LinearLayout editLinearCap;
    private TextView editTvCapHint;
    private TextView editTvCap;
    private ImageView editImgEditCap;
    private LinearLayout editLinearHalftime;
    private TextView editTvHalftimeHint;
    private TextView editTvHalftime;
    private ImageView editImgEditHalftime;
    private TextView editTvContactsHint;
    private CardView editCVTeam;
    private TextView editTvTeamsBtn;
    private CardView editCVMatch;
    private TextView editTvMatchesBtn;
    private CardView editCVPlace;
    private TextView editTvPlacesBtn;

    private long tournament_id;

    private FloatingActionButton fab;

    private String m_Place = "";
    private String m_Format = "";
    private String m_Field = "";
    private String m_Fee = "";
    private String m_Website = "";
    private String m_Length = "";
    private String m_Cap = "";
    private String m_Halftime = "";
    private String m_Title = "";
    private String m_Date = "";

    private static final Gson GSON = new Gson();

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-08-16 09:57:20 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        editTvTitleOnetournament = (TextView) findViewById(R.id.edit_tv_title_onetournament);
        editTvDateOnetournament = (TextView) findViewById(R.id.edit_tv_date_onetournament);
        editTitleEdit = (ImageView) findViewById(R.id.edit_title_edit);
        editDateEdit = (ImageView) findViewById(R.id.edit_date_edit);
        editImgLogoOneTournament = (ImageView) findViewById(R.id.edit_img_logo_onetournament);
        editLinearPlace = (LinearLayout) findViewById(R.id.edit_linear_place);
        editTvPlaceHint = (TextView) findViewById(R.id.edit_tv_place_hint);
        editTvPlace = (TextView) findViewById(R.id.edit_tv_place);
        editImgEditPlace = (ImageView) findViewById(R.id.edit_img_edit_place);
        editLinearFormat = (LinearLayout) findViewById(R.id.edit_linear_format);
        editTvFormatHint = (TextView) findViewById(R.id.edit_tv_format_hint);
        editTvFormat = (TextView) findViewById(R.id.edit_tv_format);
        editImgEditFormat = (ImageView) findViewById(R.id.edit_img_edit_format);
        editLinearField = (LinearLayout) findViewById(R.id.edit_linear_field);
        editTvFieldHint = (TextView) findViewById(R.id.edit_tv_field_hint);
        editTvField = (TextView) findViewById(R.id.edit_tv_field);
        editImgEditField = (ImageView) findViewById(R.id.edit_img_edit_field);
        editLinearTeamPlayerFee = (LinearLayout) findViewById(R.id.edit_linear_team_player_fee);
        editTvFeeHint = (TextView) findViewById(R.id.edit_tv_fee_hint);
        editTvFee = (TextView) findViewById(R.id.edit_tv_fee);
        editImgEditFee = (ImageView) findViewById(R.id.edit_img_edit_fee);
        editLinearWebsite = (LinearLayout) findViewById(R.id.edit_linear_website);
        editTvWebsiteHint = (TextView) findViewById(R.id.edit_tv_website_hint);
        editTvWebsite = (TextView) findViewById(R.id.edit_tv_website);
        editImgEditWebsite = (ImageView) findViewById(R.id.edit_img_edit_website);
        editTvMatchesHint = (TextView) findViewById(R.id.edit_tv_matches_hint);
        editLinearLength = (LinearLayout) findViewById(R.id.edit_linear_length);
        editTvLengthHint = (TextView) findViewById(R.id.edit_tv_length_hint);
        editTvLength = (TextView) findViewById(R.id.edit_tv_length);
        editImgEditLength = (ImageView) findViewById(R.id.edit_img_edit_length);
        editLinearCap = (LinearLayout) findViewById(R.id.edit_linear_cap);
        editTvCapHint = (TextView) findViewById(R.id.edit_tv_cap_hint);
        editTvCap = (TextView) findViewById(R.id.edit_tv_cap);
        editImgEditCap = (ImageView) findViewById(R.id.edit_img_edit_cap);
        editLinearHalftime = (LinearLayout) findViewById(R.id.edit_linear_halftime);
        editTvHalftimeHint = (TextView) findViewById(R.id.edit_tv_halftime_hint);
        editTvHalftime = (TextView) findViewById(R.id.edit_tv_halftime);
        editImgEditHalftime = (ImageView) findViewById(R.id.edit_img_edit_halftime);
        editTvContactsHint = (TextView) findViewById(R.id.edit_tv_contacts_hint);

        editCVTeam = (CardView) findViewById(R.id.edit_CVTeam);
        editTvTeamsBtn = (TextView) findViewById(R.id.edit_tv_teams_btn);
        editCVMatch = (CardView) findViewById(R.id.edit_CVMatch);
        editTvMatchesBtn = (TextView) findViewById(R.id.edit_tv_matches_btn);
        editCVPlace = (CardView) findViewById(R.id.edit_CVPlace);
        editTvPlacesBtn = (TextView) findViewById(R.id.edit_tv_places_btn);

        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tournament);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViews();

        tournament_id = getIntent().getExtras().getLong("id");

        TournamentBean tournamentBean = WSUtilsMobile.getTournament(tournament_id);

        editTvTitleOnetournament.setText(tournamentBean.getName());
        editTvDateOnetournament.setText("Du " + tournamentBean.getStartDate() + " au " + tournamentBean.getEndDate());

        List<PlaceBean> placeBeanList = tournamentBean.getPlaceList();
        if (!placeBeanList.isEmpty()) {
            editTvPlace.setText(placeBeanList.get(0).getName());
        }
        //editTvFormat.setText(tournamentBean.getGender());

        editTvField.setText(tournamentBean.getFieldType());
        editTvFee.setText(tournamentBean.getTeamFee() + " / " + tournamentBean.getPlayerFee());
        editTvWebsite.setText(tournamentBean.getSiteWeb());
        editTvLength.setText(tournamentBean.getDuration());
        editTvCap.setText(tournamentBean.getCap());
        editTvHalftime.setText(tournamentBean.getHalfTime());


        if (!tournamentBean.getPicture().isEmpty()) {
            Glide.with(this).load(tournamentBean.getPicture()).into(editImgLogoOneTournament);
        } else {
            Glide.with(this).load(R.drawable.ic_info_black_48dp).into(editImgLogoOneTournament);
        }


        editImgEditPlace.setOnClickListener(this);
        editImgEditFormat.setOnClickListener(this);
        editImgEditField.setOnClickListener(this);
        editImgEditFee.setOnClickListener(this);
        editImgEditWebsite.setOnClickListener(this);
        editImgEditLength.setOnClickListener(this);
        editImgEditCap.setOnClickListener(this);
        editImgEditHalftime.setOnClickListener(this);
        editTitleEdit.setOnClickListener(this);
        editDateEdit.setOnClickListener(this);

        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == editImgEditPlace) {
            //Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvPlace.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier la place");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Place = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Place,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvPlace.setText(m_Place);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();

        } else if (view == editImgEditFormat) {
            //Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvFormat.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le format");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Format = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Format,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvFormat.setText(m_Format);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editImgEditField) {
            //Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvField.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le field");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Field = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Field,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvField.setText(m_Field);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editImgEditFee) {
//Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvFee.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le field");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Fee = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Fee,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvFee.setText(m_Fee);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editImgEditWebsite) {
//Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvWebsite.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le website");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Website = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Website,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvWebsite.setText(m_Website);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editImgEditLength) {
//Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvLength.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le length");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Length = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Length,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvLength.setText(m_Length);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editImgEditCap) {
//Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvCap.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le cap");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Cap = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Cap,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvCap.setText(m_Cap);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editImgEditHalftime) {
//Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvHalftime.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le halftime");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Halftime = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Halftime,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvHalftime.setText(m_Halftime);
                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editTitleEdit) {
//Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText input = new EditText(this);

            // Specify the type of input expected;
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint(editTvTitleOnetournament.getText());
            alertDialogBuilder.setView(input);

            //titre
            alertDialogBuilder.setTitle("Modifier le name");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Title = input.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Title,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvTitleOnetournament.setText(m_Title);

                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == editDateEdit) {
            //Préparation de la fenêtre
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            // Set up the input
            final EditText inputDate = new EditText(this);

            // Specify the type of input expected;
            inputDate.setInputType(InputType.TYPE_CLASS_TEXT);
            inputDate.setHint(editTvDateOnetournament.getText());
            alertDialogBuilder.setView(inputDate);

            //titre
            alertDialogBuilder.setTitle("Modifier la date");

            //bouton ok
            alertDialogBuilder.setPositiveButton("ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Affiche un toast apresle click sur le bouton ok
                            m_Date = inputDate.getText().toString();
                            Toast.makeText(EditTournamentActivity.this, m_Date,
                                    Toast.LENGTH_SHORT).show();
                            //Modifie l'editTvPlace
                            editTvDateOnetournament.setText(m_Date);

                        }
                    });

            //Afficher la fenêtre
            alertDialogBuilder.show();
        } else if (view == fab) {
            // récup id du tournoi
            TournamentBean tournamentBean = WSUtilsMobile.getTournament(tournament_id);
            tournamentBean.setName(editTvTitleOnetournament.getText() + "");
            //PLACE
            //FORMAT
            tournamentBean.setFieldType(editTvField.getText() + "");
            //FEE
            tournamentBean.setSiteWeb(editTvWebsite.getText() + "");
            tournamentBean.setDuration(editTvLength.getText() + "");
            tournamentBean.setCap(editTvCap.getText() + "");
            tournamentBean.setHalfTime(editTvHalftime.getText() + "");

            tournamentBean.setTimeStamp(MainActivity.ID_TIMESTAMP);
            // tout remodifier


            //////////// ON VA CREER ET PARSER LE JSON

            // on stocke dans contactBeanIds la liste des id des contacts
            List<ContactBean> contactBeanList = tournamentBean.getContactList();
            Log.w("TAG_TEST_CONTACTS", contactBeanList.size() + "");
            List<Long> contactBeanIds = new ArrayList<>();
            if (!contactBeanList.isEmpty()) {
                for (int i = 0; i < contactBeanList.size(); i++) {
                    Long contact = contactBeanList.get(i).getId();
                    Log.w("TAG_CONTACT", contact + "");
                    contactBeanIds.add(contact);
                }
                Log.w("TAG_TEST_LIST", contactBeanIds.size() + "");
            }


            // on stocke dans placeBeanIds la liste des id des places
            List<PlaceBean> placeBeanList = tournamentBean.getPlaceList();
            List<Long> placeBeanIds = new ArrayList<>();
            if (!placeBeanList.isEmpty()) {
                for (int i = 0; i < placeBeanList.size(); i++) {
                    Long place = placeBeanList.get(i).getId();
                    placeBeanIds.add(place);
                }
            }

//            // on stocke dans teamBeanIds la liste des id des teams
//            List<TeamBean> teamBeanList = tournamentBean.getTeamList();
//            List<Long> teamBeanIds = new ArrayList<>();
//            if (!teamBeanList.isEmpty()) {
//                for (int i = 0; i < teamBeanList.size(); i++) {
//                    Long team = teamBeanList.get(i).getId();
//                    teamBeanIds.add(team);
//                }
//            }

            // on stocke dans matchsBeanIds la liste des id des matchs
            List<MatchBean> matchsBeanList = tournamentBean.getMatchList();
            List<Long> matchsBeanIds = new ArrayList<>();
            if (!matchsBeanList.isEmpty()) {
                for (int i = 0; i < matchsBeanList.size(); i++) {
                    Long matchs = matchsBeanList.get(i).getId();
                    matchsBeanIds.add(matchs);
                }
            }


            // on passe a null les contactsList, placeList, et teamList

            tournamentBean.resetContactList();
            tournamentBean.resetPlaceList();
//            tournamentBean.resetTeamList();
            tournamentBean.resetMatchList();


            String json = GSON.toJson(tournamentBean);
            Log.w("TAG_JSON_1", json);
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(json);
                jsonObject.put("club", tournamentBean.getClubId());
                jsonObject.put("contact", contactBeanIds);
                jsonObject.put("place", placeBeanIds);
  //              jsonObject.put("team", teamBeanIds);
                jsonObject.put("userUltimate", "[]");
                jsonObject.put("matchs", matchsBeanIds);

                Log.w("TAG_TOURNAMENT_EDIT", jsonObject + "");
                String jsonn = jsonObject.toString();


                Intent intentTournament = new Intent(this, ServiceTournament.class);
                intentTournament.putExtra(ServiceTournament.SERVICE_TYPE, ServiceTournament.ServiceAction.LOAD_TOURNAMENT);
                intentTournament.putExtra("json", jsonn);
                intentTournament.putExtra("tournament_id", tournamentBean.getId());
                startService(intentTournament);

            } catch (JSONException e) {
                e.printStackTrace();
            }


            finish();

        }

    }
}
