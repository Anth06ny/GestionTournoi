package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "USER_FOLLOWED_TOURNAMENT"
)
public class UserFollowedTournamentBean {

    //Relationelle
    @ToOne(joinProperty = "userId")
    private UserBean user;
    @NotNull
    private long userId;

    @ToOne(joinProperty = "tournamentId")
    private TournamentBean tournament;
    @NotNull
    private long tournamentId;
     /* ---------------------------------
    // Generate
    // -------------------------------- */
}
