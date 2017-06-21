package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TOURNAMENT_TEAM"
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

    @ToOne(joinProperty = "contactId")
    private ContactBean contact;
    private long contactId;
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
     * Used for active entity operations.
     */
    @Generated(hash = 1082414291)
    private transient TournamentTeamBeanDao myDao;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    @Generated(hash = 321829790)
    private transient Long contact__resolvedKey;

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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1968726297)
    public void setContact(@NotNull ContactBean contact) {
        if (contact == null) {
            throw new DaoException(
                    "To-one property 'contactId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.contact = contact;
            contactId = contact.getId();
            contact__resolvedKey = contactId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 231313235)
    public ContactBean getContact() {
        long __key = this.contactId;
        if (contact__resolvedKey == null || !contact__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactBeanDao targetDao = daoSession.getContactBeanDao();
            ContactBean contactNew = targetDao.load(__key);
            synchronized (this) {
                contact = contactNew;
                contact__resolvedKey = __key;
            }
        }
        return contact;
    }

    public long getContactId() {
        return this.contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 793452769)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentTeamBeanDao() : null;
    }

    @Generated(hash = 1560834132)
    public TournamentTeamBean(long teamId, long tournamentId, long contactId) {
        this.teamId = teamId;
        this.tournamentId = tournamentId;
        this.contactId = contactId;
    }

    @Generated(hash = 883459894)
    public TournamentTeamBean() {
    }
}
