package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "USER_FOLLOWED_TEAM"
)
public class UserFollowedTeamBean {

    @ToOne(joinProperty = "userId")
    private UserBean user;
    @NotNull
    private long userId;

    @ToOne(joinProperty = "teamId")
    private TeamBean team;
    @NotNull
    private long teamId;
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
@Generated(hash = 1015633714)
public void setTeam(@NotNull TeamBean team) {
        if (team == null) {
                throw new DaoException(
                                "To-one property 'teamId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
                this.team = team;
                teamId = team.getId();
                team__resolvedKey = teamId;
        }
}
/** To-one relationship, resolved on first access. */
@Generated(hash = 441261818)
public TeamBean getTeam() {
        long __key = this.teamId;
        if (team__resolvedKey == null || !team__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
                }
                TeamBeanDao targetDao = daoSession.getTeamBeanDao();
                TeamBean teamNew = targetDao.load(__key);
                synchronized (this) {
                        team = teamNew;
                        team__resolvedKey = __key;
                }
        }
        return team;
}
@Generated(hash = 1834174654)
private transient Long team__resolvedKey;
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
/** Used for active entity operations. */
@Generated(hash = 1602215291)
private transient UserFollowedTeamBeanDao myDao;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public long getTeamId() {
        return this.teamId;
}
public void setTeamId(long teamId) {
        this.teamId = teamId;
}
public long getUserId() {
        return this.userId;
}
public void setUserId(long userId) {
        this.userId = userId;
}
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 920770569)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getUserFollowedTeamBeanDao() : null;
}
@Generated(hash = 512799064)
public UserFollowedTeamBean(long userId, long teamId) {
        this.userId = userId;
        this.teamId = teamId;
}
@Generated(hash = 575445100)
public UserFollowedTeamBean() {
}
}
