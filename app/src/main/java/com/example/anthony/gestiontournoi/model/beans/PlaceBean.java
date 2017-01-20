package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(
        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "PLACE"
)
public class PlaceBean {

    @Id(autoincrement = true)
    private Long id;

    private String name;
    private String address;
    private double latitude;
    private double longitude;
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
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1552361209)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlaceBeanDao() : null;
}
/** Used for active entity operations. */
@Generated(hash = 1183025549)
private transient PlaceBeanDao myDao;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public double getLongitude() {
        return this.longitude;
}
public void setLongitude(double longitude) {
        this.longitude = longitude;
}
public double getLatitude() {
        return this.latitude;
}
public void setLatitude(double latitude) {
        this.latitude = latitude;
}
public String getAddress() {
        return this.address;
}
public void setAddress(String address) {
        this.address = address;
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
@Generated(hash = 2000587341)
public PlaceBean(Long id, String name, String address, double latitude,
                double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
}
@Generated(hash = 1530304682)
public PlaceBean() {
}
}
