package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity(
        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "timestampbean"
)
public class TimestampBean {

    @Id(autoincrement = true)
    private Long id;

    private long clubTimestamp = 1;
    private long contactTimestamp = 1;
    private long fieldTimestamp = 1;
    private long matchTimestamp = 1;
    private long placeTimestamp = 1;
    private long teamTimestamp = 1;
    private long tournamentTimestamp = 1;
    private long userTimestamp = 1;
    //---------------------------
    // GENERATE
    //---------------------------

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 706834386)
    private transient TimestampBeanDao myDao;

    @Generated(hash = 312428427)
    public TimestampBean(Long id, long clubTimestamp, long contactTimestamp,
                         long fieldTimestamp, long matchTimestamp, long placeTimestamp,
                         long teamTimestamp, long tournamentTimestamp, long userTimestamp) {
        this.id = id;
        this.clubTimestamp = clubTimestamp;
        this.contactTimestamp = contactTimestamp;
        this.fieldTimestamp = fieldTimestamp;
        this.matchTimestamp = matchTimestamp;
        this.placeTimestamp = placeTimestamp;
        this.teamTimestamp = teamTimestamp;
        this.tournamentTimestamp = tournamentTimestamp;
        this.userTimestamp = userTimestamp;
    }

    @Generated(hash = 25085395)
    public TimestampBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getClubTimestamp() {
        return this.clubTimestamp;
    }

    public void setClubTimestamp(long clubTimestamp) {
        this.clubTimestamp = clubTimestamp;
    }

    public long getContactTimestamp() {
        return this.contactTimestamp;
    }

    public void setContactTimestamp(long contactTimestamp) {
        this.contactTimestamp = contactTimestamp;
    }

    public long getFieldTimestamp() {
        return this.fieldTimestamp;
    }

    public void setFieldTimestamp(long fieldTimestamp) {
        this.fieldTimestamp = fieldTimestamp;
    }

    public long getMatchTimestamp() {
        return this.matchTimestamp;
    }

    public void setMatchTimestamp(long matchTimestamp) {
        this.matchTimestamp = matchTimestamp;
    }

    public long getPlaceTimestamp() {
        return this.placeTimestamp;
    }

    public void setPlaceTimestamp(long placeTimestamp) {
        this.placeTimestamp = placeTimestamp;
    }

    public long getTeamTimestamp() {
        return this.teamTimestamp;
    }

    public void setTeamTimestamp(long teamTimestamp) {
        this.teamTimestamp = teamTimestamp;
    }

    public long getTournamentTimestamp() {
        return this.tournamentTimestamp;
    }

    public void setTournamentTimestamp(long tournamentTimestamp) {
        this.tournamentTimestamp = tournamentTimestamp;
    }

    public long getUserTimestamp() {
        return this.userTimestamp;
    }

    public void setUserTimestamp(long userTimestamp) {
        this.userTimestamp = userTimestamp;
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
    @Generated(hash = 1836859749)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTimestampBeanDao() : null;
    }
}
