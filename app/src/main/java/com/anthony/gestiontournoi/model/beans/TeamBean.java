package com.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "TEAM"
)
public class TeamBean {
    @Id
    private Long id;

    private String name;
    private String picture;
    private long timeStamp;

    //Relationelle
    @ToOne(joinProperty = "contactId")
    private ContactBean contact;
    private long contactId;

    @ToOne(joinProperty = "clubId")
    private ClubBean club;
    private long clubId;

    @Transient
    private boolean isDelete;

    @ToMany
    @JoinEntity(
            entity = TeamMatchsBean.class,
            sourceProperty = "teamId",
            targetProperty = "matchsId"

    )
    private List<MatchBean> matchsList;
    @Transient
    private List<Long> matchsId;

    @ToMany
    @JoinEntity(
            entity = TeamContactBean.class,
            sourceProperty = "teamId",
            targetProperty = "contactId"

    )
    private List<ContactBean> contactList;
    @Transient
    private List<Long> contactsId;

//    @ToMany
//    @JoinEntity(
//            //Table intermediaire
//            entity = TournamentTeamBean.class,
//            //Id representant cette table dans la table intermediaire
//            sourceProperty = "teamId",
//            //Id representant la table voulu dans la table intermediraire
//            targetProperty = "tournamentId"
//    )
//    private List<TournamentBean> tournamentList;
    //---------------------------
    // GENERATED
    //---------------------------

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1301191607)
    private transient TeamBeanDao myDao;

    @Generated(hash = 1752905364)
    public TeamBean(Long id, String name, String picture, long timeStamp,
                    long contactId, long clubId) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.timeStamp = timeStamp;
        this.contactId = contactId;
        this.clubId = clubId;
    }

    @Generated(hash = 1659287080)
    public TeamBean() {
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

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getContactId() {
        return this.contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getClubId() {
        return this.clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    @Generated(hash = 321829790)
    private transient Long contact__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 231313235)
    public ContactBean getContact() {
        long __key = this.contactId;
        if (contact__resolvedKey == null || !contact__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactBeanDao targetDao = daoSession.getContactBeanDao();
            ContactBean contactNew = targetDao.load(__key);
            synchronized (this) {
                contact = contactNew;
                contact__resolvedKey = __key;
            }
        }
        return contact;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1968726297)
    public void setContact(@NotNull ContactBean contact) {
        if (contact == null) {
            throw new DaoException(
                    "To-one property 'contactId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.contact = contact;
            contactId = contact.getId();
            contact__resolvedKey = contactId;
        }
    }

    @Generated(hash = 1772927184)
    private transient Long club__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1630220085)
    public ClubBean getClub() {
        long __key = this.clubId;
        if (club__resolvedKey == null || !club__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
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
//
//    /**
//     * To-many relationship, resolved on first access (and after reset).
//     * Changes to to-many relations are not persisted, make changes to the target entity.
//     */
//    @Generated(hash = 1550927501)
//    public List<TournamentBean> getTournamentList() {
//        if (tournamentList == null) {
//            final DaoSession daoSession = this.daoSession;
//            if (daoSession == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            TournamentBeanDao targetDao = daoSession.getTournamentBeanDao();
//            List<TournamentBean> tournamentListNew = targetDao
//                    ._queryTeamBean_TournamentList(id);
//            synchronized (this) {
//                if (tournamentList == null) {
//                    tournamentList = tournamentListNew;
//                }
//            }
//        }
//        return tournamentList;
//    }
//
//    /**
//     * Resets a to-many relationship, making the next get call to query for a fresh result.
//     */
//    @Generated(hash = 1267102543)
//    public synchronized void resetTournamentList() {
//        tournamentList = null;
//    }

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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1166419901)
    public List<MatchBean> getMatchsList() {
        if (matchsList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MatchBeanDao targetDao = daoSession.getMatchBeanDao();
            List<MatchBean> matchsListNew = targetDao._queryTeamBean_MatchsList(id);
            synchronized (this) {
                if (matchsList == null) {
                    matchsList = matchsListNew;
                }
            }
        }
        return matchsList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 448563022)
    public synchronized void resetMatchsList() {
        matchsList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 535289041)
    public List<ContactBean> getContactList() {
        if (contactList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactBeanDao targetDao = daoSession.getContactBeanDao();
            List<ContactBean> contactListNew = targetDao._queryTeamBean_ContactList(id);
            synchronized (this) {
                if (contactList == null) {
                    contactList = contactListNew;
                }
            }
        }
        return contactList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1466168391)
    public synchronized void resetContactList() {
        contactList = null;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1877237120)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeamBeanDao() : null;
    }
}