package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

@Entity(
        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "CLUB"
)
public class ClubBean {

    private Long id;

    private String name;
    private String picture;
    private String clubUrl;
    private long timestamp;

    //Relationelle
    @ToOne(joinProperty = "placeId")
    private PlaceBean place;
    private Long placeId;


    //Relationnelle Inverse table intermediaire
    @ToMany
    @JoinEntity(
            //Table intermediaire
            entity = ClubContactBean.class,
            //Id representant cette table dans la table intermediaire
            sourceProperty = "clubId",
            //Id representant la table voulu dans la table intermediraire
            targetProperty = "contactId"
    )
    private List<ContactBean> contactList;


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
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1466168391)
    public synchronized void resetContactList() {
        contactList = null;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 711419009)
    public void setPlace(PlaceBean place) {
        synchronized (this) {
            this.place = place;
            placeId = place == null ? null : place.getId();
            place__resolvedKey = placeId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 695328629)
    public PlaceBean getPlace() {
        Long __key = this.placeId;
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
    @Generated(hash = 1188674187)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getClubBeanDao() : null;
    }

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 98917592)
    private transient ClubBeanDao myDao;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

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

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1158142400)
    public List<ContactBean> getContactList() {
        if (contactList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactBeanDao targetDao = daoSession.getContactBeanDao();
            List<ContactBean> contactListNew = targetDao._queryClubBean_ContactList(id);
            synchronized (this) {
                if (contactList == null) {
                    contactList = contactListNew;
                }
            }
        }
        return contactList;
    }

    public Long getPlaceId() {
        return this.placeId;
    }

    public String getClubUrl() {
        return this.clubUrl;
    }

    public void setClubUrl(String clubUrl) {
        this.clubUrl = clubUrl;
    }

    @Generated(hash = 356415342)
    public ClubBean(Long id, String name, String picture, String clubUrl, Long placeId) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.clubUrl = clubUrl;
        this.placeId = placeId;
    }

    @Generated(hash = 1084389034)
    public ClubBean() {
    }
}
