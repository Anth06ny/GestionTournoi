package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;


@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TEAM_MATCHS"
)
public class TeamMatchsBean {

    @ToOne(joinProperty = "teamId")
    private TeamBean team;
    @NotNull
    private long teamId;

    @ToOne(joinProperty = "matchsId")
    private MatchBean matchs;
    @NotNull
    private long matchsId;


    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 2070026652)
    private transient TeamMatchsBeanDao myDao;


    /* ---------------------------------
    // Generate
    // -------------------------------- */


    @Generated(hash = 1534133156)
    public TeamMatchsBean(long teamId, long matchsId) {
        this.teamId = teamId;
        this.matchsId = matchsId;
    }

    @Generated(hash = 1494040967)
    public TeamMatchsBean() {
    }

    public long getTeamId() {
        return this.teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public long getMatchsId() {
        return this.matchsId;
    }

    public void setMatchsId(long matchsId) {
        this.matchsId = matchsId;
    }

    @Generated(hash = 1834174654)
    private transient Long team__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 441261818)
    public TeamBean getTeam() {
        long __key = this.teamId;
        if (team__resolvedKey == null || !team__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamBeanDao targetDao = daoSession.getTeamBeanDao();
            TeamBean teamNew = targetDao.load(__key);
            synchronized (this) {
                team = teamNew;
                team__resolvedKey = __key;
            }
        }
        return team;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1015633714)
    public void setTeam(@NotNull TeamBean team) {
        if (team == null) {
            throw new DaoException(
                    "To-one property 'teamId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.team = team;
            teamId = team.getId();
            team__resolvedKey = teamId;
        }
    }

    @Generated(hash = 404032630)
    private transient Long matchs__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 727875427)
    public MatchBean getMatchs() {
        long __key = this.matchsId;
        if (matchs__resolvedKey == null || !matchs__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MatchBeanDao targetDao = daoSession.getMatchBeanDao();
            MatchBean matchsNew = targetDao.load(__key);
            synchronized (this) {
                matchs = matchsNew;
                matchs__resolvedKey = __key;
            }
        }
        return matchs;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1752989582)
    public void setMatchs(@NotNull MatchBean matchs) {
        if (matchs == null) {
            throw new DaoException(
                    "To-one property 'matchsId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.matchs = matchs;
            matchsId = matchs.getId();
            matchs__resolvedKey = matchsId;
        }
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
    @Generated(hash = 838682804)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeamMatchsBeanDao() : null;
    }


}

