package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "FIELD"
)
public class FieldBean {

    @Id
    private Long id;

    private String name;

    //Relationelle
    @ToOne(joinProperty = "placeId")
    private PlaceBean place;
    private Long placeId;
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
     * Used for active entity operations.
     */
    @Generated(hash = 1528920307)
    private transient FieldBeanDao myDao;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

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

    public Long getPlaceId() {
        return this.placeId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1070627900)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFieldBeanDao() : null;
    }

    @Generated(hash = 1359334510)
    public FieldBean(Long id, String name, Long placeId) {
        this.id = id;
        this.name = name;
        this.placeId = placeId;
    }

    @Generated(hash = 295781528)
    public FieldBean() {
    }
}
