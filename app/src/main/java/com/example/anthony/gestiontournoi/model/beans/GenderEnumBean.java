package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "GENDER"
)
public class GenderEnumBean {
    private Long id;

    private String genderLabel;
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
@Generated(hash = 526778724)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGenderEnumBeanDao() : null;
}

/** Used for active entity operations. */
@Generated(hash = 1569066800)
private transient GenderEnumBeanDao myDao;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

public String getGenderLabel() {
        return this.genderLabel;
}

public void setGenderLabel(String genderLabel) {
        this.genderLabel = genderLabel;
}

public Long getId() {
        return this.id;
}

public void setId(Long id) {
        this.id = id;
}

@Generated(hash = 1495932264)
public GenderEnumBean(Long id, String genderLabel) {
        this.id = id;
        this.genderLabel = genderLabel;
}

@Generated(hash = 1884156291)
public GenderEnumBean() {
}
}
