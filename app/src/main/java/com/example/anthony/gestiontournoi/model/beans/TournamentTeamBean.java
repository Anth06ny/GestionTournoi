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
public class TournamentTeamBean {

    @ToOne(joinProperty = "teamId")
    private TeamBean team;
    @NotNull
    private long teamId;

    @ToOne(joinProperty = "tournamentId")
    private TournamentBean tournament;
    @NotNull
    private long tournamentId;
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

    @Generated(hash = 1834174654)
    private transient Long team__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 793452769)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentTeamBeanDao()
                : null;
    }

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1082414291)
    private transient TournamentTeamBeanDao myDao;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public long getTournamentId() {
        return this.tournamentId;
    }

    public long getTeamId() {
        return this.teamId;
    }

    @Generated(hash = 411836118)
    public TournamentTeamBean(long teamId, long tournamentId) {
        this.teamId = teamId;
        this.tournamentId = tournamentId;
    }

    @Generated(hash = 883459894)
    public TournamentTeamBean() {
    }
}
