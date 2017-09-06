package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "CONTACT"
)
public class ContactBean {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String facebookPage;
    private String website;
    private String phoneNumber;
    private long timeStamp;
    @Transient
    private boolean isDelete;

    

     /* ---------------------------------
    // Generate
    // -------------------------------- */

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 1178828343)
private transient ContactBeanDao myDao;
@Generated(hash = 685213178)
public ContactBean(Long id, String firstName, String lastName, String email,
        String facebookPage, String website, String phoneNumber,
        long timeStamp) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.facebookPage = facebookPage;
    this.website = website;
    this.phoneNumber = phoneNumber;
    this.timeStamp = timeStamp;
}
@Generated(hash = 1283900925)
public ContactBean() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getFirstName() {
    return this.firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public String getLastName() {
    return this.lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public String getEmail() {
    return this.email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getFacebookPage() {
    return this.facebookPage;
}
public void setFacebookPage(String facebookPage) {
    this.facebookPage = facebookPage;
}
public String getWebsite() {
    return this.website;
}
public void setWebsite(String website) {
    this.website = website;
}
public String getPhoneNumber() {
    return this.phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
public long getTimeStamp() {
    return this.timeStamp;
}
public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
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
public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 184130640)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getContactBeanDao() : null;
    }
}