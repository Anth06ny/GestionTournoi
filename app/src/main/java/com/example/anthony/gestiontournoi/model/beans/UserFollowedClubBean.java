package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "USER_FOLLOWED_CLUB"
)
public class UserFollowedClubBean {

    @ToOne(joinProperty = "userId")
    private UserBean user;
    @NotNull
    private long userId;

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
@Generated(hash = 1952179853)
public void setUser(@NotNull UserBean user) {
        if (user == null) {
                throw new DaoException(
                                "To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
                this.user = user;
                userId = user.getId();
                user__resolvedKey = userId;
        }
}
/** To-one relationship, resolved on first access. */
@Generated(hash = 1236192073)
public UserBean getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
                }
                UserBeanDao targetDao = daoSession.getUserBeanDao();
                UserBean userNew = targetDao.load(__key);
                synchronized (this) {
                        user = userNew;
                        user__resolvedKey = __key;
                }
        }
        return user;
}
@Generated(hash = 251390918)
private transient Long user__resolvedKey;
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 590708679)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserFollowedClubBeanDao()
                        : null;
}
/** Used for active entity operations. */
@Generated(hash = 628055524)
private transient UserFollowedClubBeanDao myDao;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public long getClubId() {
        return this.clubId;
}
public void setClubId(long clubId) {
        this.clubId = clubId;
}
public long getUserId() {
        return this.userId;
}
public void setUserId(long userId) {
        this.userId = userId;
}
@Generated(hash = 1046190842)
public UserFollowedClubBean(long userId, long clubId) {
        this.userId = userId;
        this.clubId = clubId;
}
@Generated(hash = 286148952)
public UserFollowedClubBean() {
}
}
