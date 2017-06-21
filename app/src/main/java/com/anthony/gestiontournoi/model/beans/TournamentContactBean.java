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
        nameInDb = "TOURNAMENT_CONTACT"
)
public class TournamentContactBean {

    @ToOne(joinProperty = "contactId")
    private ContactBean contact;
    @NotNull
    private long contactId;

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

    @Generated(hash = 321829790)
    private transient Long contact__resolvedKey;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1854786509)
    private transient TournamentContactBeanDao myDao;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getTournamentId() {
        return this.tournamentId;
    }

    public long getContactId() {
        return this.contactId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1580685488)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTournamentContactBeanDao() : null;
    }

    @Generated(hash = 1761803057)
    public TournamentContactBean(long contactId, long tournamentId) {
        this.contactId = contactId;
        this.tournamentId = tournamentId;
    }

    @Generated(hash = 58801671)
    public TournamentContactBean() {
    }
}
