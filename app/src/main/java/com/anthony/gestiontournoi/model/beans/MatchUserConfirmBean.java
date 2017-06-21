package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(
        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "MATCH_USE_CONFIRM"
)
public class MatchUserConfirmBean {

    //Relationelle
    @ToOne(joinProperty = "matchId")
    private MatchBean matchBean;
    private Long matchId;

    //Relationelle
    @ToOne(joinProperty = "userId")
    private UserBean userBean;
    private Long userId;
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
@Generated(hash = 2077618104)
public void setUserBean(UserBean userBean) {
        synchronized (this) {
                this.userBean = userBean;
                userId = userBean == null ? null : userBean.getId();
                userBean__resolvedKey = userId;
        }
}
/** To-one relationship, resolved on first access. */
@Generated(hash = 1937470662)
public UserBean getUserBean() {
        Long __key = this.userId;
        if (userBean__resolvedKey == null
                        || !userBean__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
                }
                UserBeanDao targetDao = daoSession.getUserBeanDao();
                UserBean userBeanNew = targetDao.load(__key);
                synchronized (this) {
                        userBean = userBeanNew;
                        userBean__resolvedKey = __key;
                }
        }
        return userBean;
}
@Generated(hash = 1516158344)
private transient Long userBean__resolvedKey;
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 751771495)
public void setMatchBean(MatchBean matchBean) {
        synchronized (this) {
                this.matchBean = matchBean;
                matchId = matchBean == null ? null : matchBean.getId();
                matchBean__resolvedKey = matchId;
        }
}
/** To-one relationship, resolved on first access. */
@Generated(hash = 1106475200)
public MatchBean getMatchBean() {
        Long __key = this.matchId;
        if (matchBean__resolvedKey == null
                        || !matchBean__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
                }
                MatchBeanDao targetDao = daoSession.getMatchBeanDao();
                MatchBean matchBeanNew = targetDao.load(__key);
                synchronized (this) {
                        matchBean = matchBeanNew;
                        matchBean__resolvedKey = __key;
                }
        }
        return matchBean;
}
@Generated(hash = 86593835)
private transient Long matchBean__resolvedKey;
/** Used for active entity operations. */
@Generated(hash = 593740139)
private transient MatchUserConfirmBeanDao myDao;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public Long getUserId() {
        return this.userId;
}
public void setUserId(Long userId) {
        this.userId = userId;
}
public Long getMatchId() {
        return this.matchId;
}
public void setMatchId(Long matchId) {
        this.matchId = matchId;
}
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1433376265)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getMatchUserConfirmBeanDao() : null;
}
@Generated(hash = 1426310196)
public MatchUserConfirmBean(Long matchId, Long userId) {
        this.matchId = matchId;
        this.userId = userId;
}
@Generated(hash = 846989846)
public MatchUserConfirmBean() {
}
}
