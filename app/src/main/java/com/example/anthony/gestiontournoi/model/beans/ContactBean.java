package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "CONTACT"
)
public class ContactBean {

    @Id(autoincrement = true)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String facebookpage;
    private String website;
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
@Generated(hash = 184130640)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getContactBeanDao() : null;
}
/** Used for active entity operations. */
@Generated(hash = 1178828343)
private transient ContactBeanDao myDao;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public String getWebsite() {
        return this.website;
}
public void setWebsite(String website) {
        this.website = website;
}
public String getFacebookpage() {
        return this.facebookpage;
}
public void setFacebookpage(String facebookpage) {
        this.facebookpage = facebookpage;
}
public String getEmail() {
        return this.email;
}
public void setEmail(String email) {
        this.email = email;
}
public String getLastname() {
        return this.lastname;
}
public void setLastname(String lastname) {
        this.lastname = lastname;
}
public String getFirstname() {
        return this.firstname;
}
public void setFirstname(String firstname) {
        this.firstname = firstname;
}
public Long getId() {
        return this.id;
}
public void setId(Long id) {
        this.id = id;
}
@Generated(hash = 601225157)
public ContactBean(Long id, String firstname, String lastname, String email,
                String facebookpage, String website) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.facebookpage = facebookpage;
        this.website = website;
}
@Generated(hash = 1283900925)
public ContactBean() {
}
}