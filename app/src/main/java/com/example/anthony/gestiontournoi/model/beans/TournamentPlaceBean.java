package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TOURNAMENT_PLACE"
)
public class TournamentPlaceBean {

    @ToOne(joinProperty = "tournamentId")
    private TournamentBean tournament;
    @NotNull
    private long tournamentId;

    @ToOne(joinProperty = "placeId")
    private PlaceBean place;
    @NotNull
    private long placeId;
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1092268629)
    public void setPlace(@NotNull PlaceBean place) {
        if (place == null) {
            throw new DaoException(
                    "To-one property 'placeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.place = place;
            placeId = place.getId();
            place__resolvedKey = placeId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 137871494)
    public PlaceBean getPlace() {
        long __key = this.placeId;
        if (place__resolvedKey == null || !place__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlaceBeanDao targetDao = daoSession.getPlaceBeanDao();
            PlaceBean placeNew = targetDao.load(__key);
            synchronized (this) {
                place = placeNew;
                place__resolvedKey = __key;
            }
        }
        return place;
    }

    @Generated(hash = 2133679615)
    private transient Long place__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1626021110)
    public void setTournament(@NotNull TournamentBean tournament) {
        if (tournament == null) {
            throw new DaoException(
                    "To-one property 'tournamentId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.tournament = tournament;
            tournamentId = tournament.getId();
            tournament__resolvedKey = tournamentId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1893104069)
    public TournamentBean getTournament() {
        long __key = this.tournamentId;
        if (tournament__resolvedKey == null || !tournament__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TournamentBeanDao targetDao = daoSession.getTournamentBeanDao();
            TournamentBean tournamentNew = targetDao.load(__key);
            synchronized (this) {
                tournament = tournamentNew;
                tournament__resolvedKey = __key;
            }
        }
        return tournament;
    }

    @Generated(hash = 235429544)
    private transient Long tournament__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 536049581)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentPlaceBeanDao()
                : null;
    }

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 361483113)
    private transient TournamentPlaceBeanDao myDao;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public long getPlaceId() {
        return this.placeId;
    }

    public long getTournamentId() {
        return this.tournamentId;
    }

    @Generated(hash = 1030230259)
    public TournamentPlaceBean(long tournamentId, long placeId) {
        this.tournamentId = tournamentId;
        this.placeId = placeId;
    }

    @Generated(hash = 38722981)
    public TournamentPlaceBean() {
    }
}
