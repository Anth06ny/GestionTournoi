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
        nameInDb = "CLUB_CONTACT"
)
public class ClubContactBean {

    @ToOne(joinProperty = "contactId")
    private ContactBean contact;
    @NotNull
    private long contactId;

    @ToOne(joinProperty = "clubId")
    private ClubBean club;
    @NotNull
    private long clubId;
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

    /**
     * To-one relationship, resolved on first access.
     */
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1493384071)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getClubContactBeanDao() : null;
    }

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1576657980)
    private transient ClubContactBeanDao myDao;
    /**
     * Used to resolve relations
     */
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

    @Generated(hash = 317673643)
    public ClubContactBean(long contactId, long clubId) {
        this.contactId = contactId;
        this.clubId = clubId;
    }

    @Generated(hash = 719800878)
    public ClubContactBean() {
    }
}
