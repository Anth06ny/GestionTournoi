package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "USER"
)
public class UserBean {

    @Id
    private Long id;

    private String ultimatePseudo;
    private String firstName;
    private String lastName;
    private String facebookId;
    private String googleId;
    private String registrationId;
    private long timeStamp;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getUltimatePseudo() {
    return this.ultimatePseudo;
}

public void setUltimatePseudo(String ultimatePseudo) {
    this.ultimatePseudo = ultimatePseudo;
}

public String getFirstName() {
    return this.firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return this.lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getFacebookId() {
    return this.facebookId;
}

public void setFacebookId(String facebookId) {
    this.facebookId = facebookId;
}

public String getGoogleId() {
    return this.googleId;
}

public void setGoogleId(String googleId) {
    this.googleId = googleId;
}

public String getRegistrationId() {
    return this.registrationId;
}

public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
}

public long getTimeStamp() {
    return this.timeStamp;
}

public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1758802736)
public List<TeamBean> getTeamList() {
    if (teamList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        TeamBeanDao targetDao = daoSession.getTeamBeanDao();
        List<TeamBean> teamListNew = targetDao._queryUserBean_TeamList(id);
        synchronized (this) {
            if (teamList == null) {
                teamList = teamListNew;
            }
        }
    }
    return teamList;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 924184687)
public synchronized void resetTeamList() {
    teamList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 37726508)
public List<ClubBean> getClubList() {
    if (clubList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        ClubBeanDao targetDao = daoSession.getClubBeanDao();
        List<ClubBean> clubListNew = targetDao._queryUserBean_ClubList(id);
        synchronized (this) {
            if (clubList == null) {
                clubList = clubListNew;
            }
        }
    }
    return clubList;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1363018792)
public synchronized void resetClubList() {
    clubList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 920092832)
public List<TournamentBean> getTournamentMarkList() {
    if (tournamentMarkList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        TournamentBeanDao targetDao = daoSession.getTournamentBeanDao();
        List<TournamentBean> tournamentMarkListNew = targetDao
                ._queryUserBean_TournamentMarkList(id);
        synchronized (this) {
            if (tournamentMarkList == null) {
                tournamentMarkList = tournamentMarkListNew;
            }
        }
    }
    return tournamentMarkList;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 999982765)
public synchronized void resetTournamentMarkList() {
    tournamentMarkList = null;
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1491512534)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getUserBeanDao() : null;
}

    @Transient
    private boolean isDelete;

    //Relationnelle Inverse table intermediaire
    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = UserFollowedTeamBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "userId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "teamId"
    )
    private List<TeamBean> teamList;

    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = UserFollowedClubBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "userId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "clubId"
    )
    private List<ClubBean> clubList;

    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = UserFollowedTournamentBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "userId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "tournamentId"
    )
    private List<TournamentBean> tournamentMarkList;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 83707551)
private transient UserBeanDao myDao;

@Generated(hash = 1767997531)
public UserBean(Long id, String ultimatePseudo, String firstName,
        String lastName, String facebookId, String googleId,
        String registrationId, long timeStamp) {
    this.id = id;
    this.ultimatePseudo = ultimatePseudo;
    this.firstName = firstName;
    this.lastName = lastName;
    this.facebookId = facebookId;
    this.googleId = googleId;
    this.registrationId = registrationId;
    this.timeStamp = timeStamp;
}

@Generated(hash = 1203313951)
public UserBean() {
}


     /* ---------------------------------
    // Generate
    // -------------------------------- */

}
