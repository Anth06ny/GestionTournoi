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
        nameInDb = "TEAM_CONTACT"
)
class TeamContactBean {
    @ToOne(joinProperty = "teamId")
    private TeamBean team;
    @NotNull
    private long teamId;

    @ToOne(joinProperty = "contactId")
    private ContactBean contact;
    @NotNull
    private long contactId;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
/** Used for active entity operations. */
@Generated(hash = 2122570750)
private transient TeamContactBeanDao myDao;
@Generated(hash = 695141783)
public TeamContactBean(long teamId, long contactId) {
    this.teamId = teamId;
    this.contactId = contactId;
}
@Generated(hash = 1154058358)
public TeamContactBean() {
}
public long getTeamId() {
    return this.teamId;
}
public void setTeamId(long teamId) {
    this.teamId = teamId;
}
public long getContactId() {
    return this.contactId;
}
public void setContactId(long contactId) {
    this.contactId = contactId;
}
@Generated(hash = 1834174654)
private transient Long team__resolvedKey;
/** To-one relationship, resolved on first access. */
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
/** called by internal mechanisms, do not call yourself. */
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
@Generated(hash = 321829790)
private transient Long contact__resolvedKey;
/** To-one relationship, resolved on first access. */
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
/** called by internal mechanisms, do not call yourself. */
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
@Generated(hash = 329922118)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getTeamContactBeanDao() : null;
}

    /* ---------------------------------
    // Generate
    // -------------------------------- */
}
