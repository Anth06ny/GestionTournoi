package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import java.util.List;

@Entity(
        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "PLACE"
)
public class PlaceBean {

    @Id
    private Long id;

    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private long timeStamp;
    @Transient
    private boolean isDelete;

    //Relationelle Inverse
    @ToMany(referencedJoinProperty = "placeId")
    @OrderBy("id ASC")
    private List<ClubBean> clubList;
     /* ---------------------------------
    // Generate
    // -------------------------------- */

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1183025549)
    private transient PlaceBeanDao myDao;


    @Generated(hash = 16433847)
    public PlaceBean(Long id, String name, String address, double latitude, double longitude,
                     long timeStamp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeStamp = timeStamp;
    }

    @Generated(hash = 1530304682)
    public PlaceBean() {
    }


    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1683132693)
    public List<ClubBean> getClubList() {
        if (clubList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClubBeanDao targetDao = daoSession.getClubBeanDao();
            List<ClubBean> clubListNew = targetDao._queryPlaceBean_ClubList(id);
            synchronized (this) {
                if (clubList == null) {
                    clubList = clubListNew;
                }
            }
        }
        return clubList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1363018792)
    public synchronized void resetClubList() {
        clubList = null;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1552361209)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlaceBeanDao() : null;
    }
}
