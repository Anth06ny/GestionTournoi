
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
    private String duration;
    private String halfTime;
    private String cap;
    private String picture;
    private Long playerFee;
    private Long teamFee;
    private String fieldType;
    private String genderNumberOfPlayer;
    private String siteWeb;
    private long timeStamp;

    @Transient
    private boolean isDelete;

    //Relationelle
    @ToOne(joinProperty = "clubId")
    private ClubBean clubBean;
    private Long clubId;

    //Relationelle Inverse
    @ToMany(referencedJoinProperty = "tournamentId")
    @OrderBy("date ASC")
    private List<MatchBean> matchList;

    @Transient
    private List<Long> matchsId;



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
    private List<Long> placeId;

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
    private List<Long> contactId;
    //---------------------------
    //  GENERATED
    //---------------------------

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 741298605)
    private transient TournamentBeanDao myDao;

    @Generated(hash = 1056085804)
    public TournamentBean(Long id, String name, Long startDate, Long endDate, String duration,
                          String halfTime, String cap, String picture, Long playerFee, Long teamFee,
                          String fieldType, String genderNumberOfPlayer, String siteWeb, long timeStamp,
                          Long clubId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.halfTime = halfTime;
        this.cap = cap;
        this.picture = picture;
        this.playerFee = playerFee;
        this.teamFee = teamFee;
        this.fieldType = fieldType;
        this.genderNumberOfPlayer = genderNumberOfPlayer;
        this.siteWeb = siteWeb;
        this.timeStamp = timeStamp;
        this.clubId = clubId;
    }

    @Generated(hash = 882910022)
    public TournamentBean() {
    }

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

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHalfTime() {
        return this.halfTime;
    }

    public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
    }

    public String getCap() {
        return this.cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
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

    public String getFieldType() {
        return this.fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

//    public int getNumberOfPlayer() {
//        return this.numberOfPlayer;
//    }
//
//    public void setNumberOfPlayer(int numberOfPlayer) {
//        this.numberOfPlayer = numberOfPlayer;
//    }
//
//    public String getGender() {
//        return this.gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public String getSiteWeb() {
        return this.siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getClubId() {
        return this.clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    @Generated(hash = 585466602)
    private transient Long clubBean__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 2123103705)
    public ClubBean getClubBean() {
        Long __key = this.clubId;
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 994758370)
    public void setClubBean(ClubBean clubBean) {
        synchronized (this) {
            this.clubBean = clubBean;
            clubId = clubBean == null ? null : clubBean.getId();
            clubBean__resolvedKey = clubId;
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

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1442721827)
    public synchronized void resetMatchList() {
        matchList = null;
    }

//    /**
//     * To-many relationship, resolved on first access (and after reset).
//     * Changes to to-many relations are not persisted, make changes to the target entity.
//     */
//    @Generated(hash = 1893166736)
//    public List<TeamBean> getTeamList() {
//        if (teamList == null) {
//            final DaoSession daoSession = this.daoSession;
//            if (daoSession == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            TeamBeanDao targetDao = daoSession.getTeamBeanDao();
//            List<TeamBean> teamListNew = targetDao
//                    ._queryTournamentBean_TeamList(id);
//            synchronized (this) {
//                if (teamList == null) {
//                    teamList = teamListNew;
//                }
//            }
//        }
//        return teamList;
//    }
//
//    /**
//     * Resets a to-many relationship, making the next get call to query for a fresh result.
//     */
//    @Generated(hash = 924184687)
//    public synchronized void resetTeamList() {
//        teamList = null;
//    }

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

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
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

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
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

    public List<Long> getPlaceId() {
        return placeId;
    }

    public void setPlaceId(List<Long> placeId) {
        this.placeId = placeId;
    }

//    public List<Long> getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(List<Long> teamId) {
//        this.teamId = teamId;
//    }

    public List<Long> getMatchsId() {
        return matchsId;
    }

    public void setMatchsId(List<Long> matchsId) {
        this.matchsId = matchsId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public List<Long> getContactId() {
        return contactId;
    }

    public void setContactId(List<Long> contactId) {
        this.contactId = contactId;
    }

    public String getGenderNumberOfPlayer() {
        return this.genderNumberOfPlayer;
    }

    public void setGenderNumberOfPlayer(String genderNumberOfPlayer) {
        this.genderNumberOfPlayer = genderNumberOfPlayer;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 644297522)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentBeanDao() : null;
    }
}
