package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TOURNAMENT"
)
public class TournamentBean {

    @Id(autoincrement = true)
    private Long id;

    private String name;
    private Long startDate;
    private Long endDate;
    private String halfTime;
    private String format;
    private String picture;
    private Long playerFee;
    private Long teamFee;

    //Relationelle
    @ToOne(joinProperty = "clubId")
    private ClubBean club;
    private Long clubId;

    //Relationelle Inverse
    @ToMany(referencedJoinProperty = "tournamentId")
    @OrderBy("date ASC")
    private List<MatchBean> matchList;

    //Relationnelle Inverse table intermediaire
    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = TournamentTeamBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "tournamentId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "teamId"
    )
    private List<TeamBean> teamList;

    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = TournamentPlaceBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "tournamentId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "placeId"
    )
    private List<PlaceBean> placeList;

    //Relationnelle Inverse table intermediaire
    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = TournamentContactBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "tournamentId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "contactId"
    )
    private List<ContactBean> contactList;
     /* ---------------------------------
    // Generate
    // -------------------------------- */

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

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1466168391)
public synchronized void resetContactList() {
        contactList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 430937274)
public List<ContactBean> getContactList() {
    if (contactList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        ContactBeanDao targetDao = daoSession.getContactBeanDao();
        List<ContactBean> contactListNew = targetDao._queryTournamentBean_ContactList(id);
        synchronized (this) {
            if(contactList == null) {
                contactList = contactListNew;
            }
        }
    }
    return contactList;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1423199708)
public synchronized void resetPlaceList() {
        placeList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 98101394)
public List<PlaceBean> getPlaceList() {
    if (placeList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        PlaceBeanDao targetDao = daoSession.getPlaceBeanDao();
        List<PlaceBean> placeListNew = targetDao._queryTournamentBean_PlaceList(id);
        synchronized (this) {
            if(placeList == null) {
                placeList = placeListNew;
            }
        }
    }
    return placeList;
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
@Generated(hash = 1893166736)
public List<TeamBean> getTeamList() {
    if (teamList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        TeamBeanDao targetDao = daoSession.getTeamBeanDao();
        List<TeamBean> teamListNew = targetDao._queryTournamentBean_TeamList(id);
        synchronized (this) {
            if(teamList == null) {
                teamList = teamListNew;
            }
        }
    }
    return teamList;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1442721827)
public synchronized void resetMatchList() {
        matchList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1566352568)
public List<MatchBean> getMatchList() {
    if (matchList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        MatchBeanDao targetDao = daoSession.getMatchBeanDao();
        List<MatchBean> matchListNew = targetDao._queryTournamentBean_MatchList(id);
        synchronized (this) {
            if(matchList == null) {
                matchList = matchListNew;
            }
        }
    }
    return matchList;
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1758955476)
public void setClub(ClubBean club) {
        synchronized (this) {
                this.club = club;
                clubId = club == null ? null : club.getId();
                club__resolvedKey = clubId;
        }
}

/** To-one relationship, resolved on first access. */
@Generated(hash = 1356688269)
public ClubBean getClub() {
        Long __key = this.clubId;
        if (club__resolvedKey == null || !club__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
                }
                ClubBeanDao targetDao = daoSession.getClubBeanDao();
                ClubBean clubNew = targetDao.load(__key);
                synchronized (this) {
                        club = clubNew;
                        club__resolvedKey = __key;
                }
        }
        return club;
}

@Generated(hash = 1772927184)
private transient Long club__resolvedKey;

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 644297522)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentBeanDao() : null;
}

/** Used for active entity operations. */
@Generated(hash = 741298605)
private transient TournamentBeanDao myDao;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

public Long getClubId() {
        return this.clubId;
}

public void setClubId(Long clubId) {
        this.clubId = clubId;
}

public Long getTeamFee() {
        return this.teamFee;
}

public void setTeamFee(Long teamFee) {
        this.teamFee = teamFee;
}

public Long getPlayerFee() {
        return this.playerFee;
}

public void setPlayerFee(Long playerFee) {
        this.playerFee = playerFee;
}

public String getPicture() {
        return this.picture;
}

public void setPicture(String picture) {
        this.picture = picture;
}

public String getFormat() {
        return this.format;
}

public void setFormat(String format) {
        this.format = format;
}

public String getHalfTime() {
        return this.halfTime;
}

public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
}

public Long getEndDate() {
        return this.endDate;
}

public void setEndDate(Long endDate) {
        this.endDate = endDate;
}

public Long getStartDate() {
        return this.startDate;
}

public void setStartDate(Long startDate) {
        this.startDate = startDate;
}

public String getName() {
        return this.name;
}

public void setName(String name) {
        this.name = name;
}

public Long getId() {
        return this.id;
}

public void setId(Long id) {
        this.id = id;
}

@Generated(hash = 932421142)
public TournamentBean(Long id, String name, Long startDate, Long endDate,
                String halfTime, String format, String picture, Long playerFee,
                Long teamFee, Long clubId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.halfTime = halfTime;
        this.format = format;
        this.picture = picture;
        this.playerFee = playerFee;
        this.teamFee = teamFee;
        this.clubId = clubId;
}

@Generated(hash = 882910022)
public TournamentBean() {
}
}
