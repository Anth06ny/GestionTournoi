package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(
        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "MATCH_USE_CONFIRM"
)
public class MatchUserConfirmBean {

    //Relationelle
    @ToOne(joinProperty = "matchId")
    private MatchBean matchBean;
    private Long matchId;

    //Relationelle
    @ToOne(joinProperty = "userId")
    private UserBean userBean;
    private Long userId;
     /* ---------------------------------
    // Generate
    // -------------------------------- */
}
