package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TOURNAMENT"
)
public class TournamentBean {

    @Id
    private Long id;

    private String name;
    private Long startDate;
    private Long endDate;
    private String halfTime;
    private String format;
    private String picture;
    private Long playerFee;
    private Long teamFee;
    private String urlInfo;
    private long timestamp;

    @Transient
    private boolean delete;

    //Relationelle
    @ToOne(joinProperty = "club")
    private ClubBean clubBean;
    private Long club;

    //Relationelle Inverse
    @ToMany(referencedJoinProperty = "tournamentId")
    @OrderBy("date ASC")
    private List<MatchBean> matchList;

    @Transient
    private List<Long> matchs;

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

    @Transient
    private List<Long> team;

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

    @Transient
    private List<Long> place;

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

    @Transient
    private List<Long> contact;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 741298605)
    private transient TournamentBeanDao myDao;

    @Generated(hash = 1323987349)
    public TournamentBean(Long id, String name, Long startDate, Long endDate,
            String halfTime, String format, String picture, Long playerFee,
            Long teamFee, String urlInfo, long timestamp, Long club) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.halfTime = halfTime;
        this.format = format;
        this.picture = picture;
        this.playerFee = playerFee;
        this.teamFee = teamFee;
        this.urlInfo = urlInfo;
        this.timestamp = timestamp;
        this.club = club;
    }

    @Generated(hash = 882910022)
    public TournamentBean() {
    }

    @Generated(hash = 585466602)
    private transient Long clubBean__resolvedKey;

    public List<Long> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Long> matchs) {
        this.matchs = matchs;
    }

    public List<Long> getTeam() {
        return team;
    }

    public void setTeam(List<Long> team) {
        this.team = team;
    }

    public List<Long> getPlace() {
        return place;
    }

    public void setPlace(List<Long> place) {
        this.place = place;
    }

    public List<Long> getContact() {
        return contact;
    }

    public void setContact(List<Long> contact) {
        this.contact = contact;
    }
     /* ---------------------------------
    // Generate
    // -------------------------------- */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getHalfTime() {
        return this.halfTime;
    }

    public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getPlayerFee() {
        return this.playerFee;
    }

    public void setPlayerFee(Long playerFee) {
        this.playerFee = playerFee;
    }

    public Long getTeamFee() {
        return this.teamFee;
    }

    public void setTeamFee(Long teamFee) {
        this.teamFee = teamFee;
    }

    public String getUrlInfo() {
        return this.urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getClub() {
        return this.club;
    }

    public void setClub(Long club) {
        this.club = club;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1458757382)
    public ClubBean getClubBean() {
        Long __key = this.club;
        if (clubBean__resolvedKey == null || !clubBean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClubBeanDao targetDao = daoSession.getClubBeanDao();
            ClubBean clubBeanNew = targetDao.load(__key);
            synchronized (this) {
                clubBean = clubBeanNew;
                clubBean__resolvedKey = __key;
            }
        }
        return clubBean;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1550101609)
    public void setClubBean(ClubBean clubBean) {
        synchronized (this) {
            this.clubBean = clubBean;
            club = clubBean == null ? null : clubBean.getId();
            clubBean__resolvedKey = club;
        }
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
            List<MatchBean> matchListNew = targetDao
                    ._queryTournamentBean_MatchList(id);
            synchronized (this) {
                if (matchList == null) {
                    matchList = matchListNew;
                }
            }
        }
        return matchList;
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
    @Generated(hash = 1893166736)
    public List<TeamBean> getTeamList() {
        if (teamList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamBeanDao targetDao = daoSession.getTeamBeanDao();
            List<TeamBean> teamListNew = targetDao
                    ._queryTournamentBean_TeamList(id);
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
    @Generated(hash = 98101394)
    public List<PlaceBean> getPlaceList() {
        if (placeList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlaceBeanDao targetDao = daoSession.getPlaceBeanDao();
            List<PlaceBean> placeListNew = targetDao
                    ._queryTournamentBean_PlaceList(id);
            synchronized (this) {
                if (placeList == null) {
                    placeList = placeListNew;
                }
            }
        }
        return placeList;
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
    @Generated(hash = 430937274)
    public List<ContactBean> getContactList() {
        if (contactList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactBeanDao targetDao = daoSession.getContactBeanDao();
            List<ContactBean> contactListNew = targetDao
                    ._queryTournamentBean_ContactList(id);
            synchronized (this) {
                if (contactList == null) {
                    contactList = contactListNew;
                }
            }
        }
        return contactList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1466168391)
    public synchronized void resetContactList() {
        contactList = null;
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

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 644297522)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentBeanDao() : null;
    }
}
