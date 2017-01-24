package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TEAM"
)
public class TeamBean {

    @Id(autoincrement = true)
    private Long id;

    private String name;
    private String picture;

    //Relationelle
    @ToOne(joinProperty = "contactId")
    private ContactBean contact;
    private long contactId;

    @ToOne(joinProperty = "clubId")
    private ClubBean club;
    private long clubId;

    //Relationnelle Inverse table intermediaire
    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = UserTeamBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "teamId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "userId"
    )
    private List<TeamBean> userList;

    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = TournamentTeamBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "teamId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "tournamentId"
    )
    private List<TournamentBean> tournamentList;
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
@Generated(hash = 1267102543)
public synchronized void resetTournamentList() {
        tournamentList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1550927501)
public List<TournamentBean> getTournamentList() {
    if (tournamentList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        TournamentBeanDao targetDao = daoSession.getTournamentBeanDao();
        List<TournamentBean> tournamentListNew = targetDao._queryTeamBean_TournamentList(id);
        synchronized (this) {
            if(tournamentList == null) {
                tournamentList = tournamentListNew;
            }
        }
    }
    return tournamentList;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1517531020)
public synchronized void resetUserList() {
        userList = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 2040979637)
public List<TeamBean> getUserList() {
    if (userList == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        TeamBeanDao targetDao = daoSession.getTeamBeanDao();
        List<TeamBean> userListNew = targetDao._queryTeamBean_UserList(id);
        synchronized (this) {
            if(userList == null) {
                userList = userListNew;
            }
        }
    }
    return userList;
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 237480699)
public void setClub(@NotNull ClubBean club) {
        if (club == null) {
                throw new DaoException(
                                "To-one property 'clubId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
                this.club = club;
                clubId = club.getId();
                club__resolvedKey = clubId;
        }
}

/** To-one relationship, resolved on first access. */
@Generated(hash = 1630220085)
public ClubBean getClub() {
        long __key = this.clubId;
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

/** To-one relationship, resolved on first access. */
@Generated(hash = 231313235)
public ContactBean getContact() {
        long __key = this.contactId;
        if (contact__resolvedKey == null || !contact__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
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

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1877237120)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeamBeanDao() : null;
}

/** Used for active entity operations. */
@Generated(hash = 1301191607)
private transient TeamBeanDao myDao;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

public long getClubId() {
        return this.clubId;
}

public void setClubId(long clubId) {
        this.clubId = clubId;
}

public long getContactId() {
        return this.contactId;
}

public void setContactId(long contactId) {
        this.contactId = contactId;
}

public String getPicture() {
        return this.picture;
}

public void setPicture(String picture) {
        this.picture = picture;
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

@Generated(hash = 707795695)
public TeamBean(Long id, String name, String picture, long contactId,
                long clubId) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.contactId = contactId;
        this.clubId = clubId;
}

@Generated(hash = 1659287080)
public TeamBean() {
}
}