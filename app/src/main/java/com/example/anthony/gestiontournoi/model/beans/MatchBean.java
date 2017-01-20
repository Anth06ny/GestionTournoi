package com.example.anthony.gestiontournoi.model.beans;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(

        active = true,
        generateConstructors = true,
        generateGettersSetters = true,
        nameInDb = "MATCH"
)
public class MatchBean {

    @Id(autoincrement = true)
    private Long id;

    private long date;
    private String duration;
    private String result;
    private int scoreTeam1;
    private int scoreTeam2;

    //Relationnel
    @ToOne(joinProperty = "team1Id")
    private TeamBean team1;
    @NotNull
    private long team1Id;

    @ToOne(joinProperty = "team2Id")
    private TeamBean team2;
    @NotNull
    private long team2Id;

    @ToOne(joinProperty = "fieldId")
    private FieldBean field;
    private Long fieldId;

    @ToOne(joinProperty = "matchstatusId")
    private MatchStatusEnumBean matchStatus;
    @NotNull
    private long matchstatusId;

    @ToOne(joinProperty = "tournamentId")
    private TournamentBean tournament;
    @NotNull
    private long tournamentId;
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
    @Generated(hash = 1626021110)
    public void setTournament(@NotNull TournamentBean tournament) {
        if (tournament == null) {
            throw new DaoException(
                    "To-one property 'tournamentId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.tournament = tournament;
            tournamentId = tournament.getId();
            tournament__resolvedKey = tournamentId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1893104069)
    public TournamentBean getTournament() {
        long __key = this.tournamentId;
        if (tournament__resolvedKey == null || !tournament__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TournamentBeanDao targetDao = daoSession.getTournamentBeanDao();
            TournamentBean tournamentNew = targetDao.load(__key);
            synchronized (this) {
                tournament = tournamentNew;
                tournament__resolvedKey = __key;
            }
        }
        return tournament;
    }

    @Generated(hash = 235429544)
    private transient Long tournament__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1858488143)
    public void setMatchStatus(@NotNull MatchStatusEnumBean matchStatus) {
        if (matchStatus == null) {
            throw new DaoException(
                    "To-one property 'matchstatusId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.matchStatus = matchStatus;
            matchstatusId = matchStatus.getId();
            matchStatus__resolvedKey = matchstatusId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 534671586)
    public MatchStatusEnumBean getMatchStatus() {
        long __key = this.matchstatusId;
        if (matchStatus__resolvedKey == null || !matchStatus__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MatchStatusEnumBeanDao targetDao = daoSession.getMatchStatusEnumBeanDao();
            MatchStatusEnumBean matchStatusNew = targetDao.load(__key);
            synchronized (this) {
                matchStatus = matchStatusNew;
                matchStatus__resolvedKey = __key;
            }
        }
        return matchStatus;
    }

    @Generated(hash = 1689452998)
    private transient Long matchStatus__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 863827323)
    public void setField(FieldBean field) {
        synchronized (this) {
            this.field = field;
            fieldId = field == null ? null : field.getId();
            field__resolvedKey = fieldId;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1018392834)
    public FieldBean getField() {
        Long __key = this.fieldId;
        if (field__resolvedKey == null || !field__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FieldBeanDao targetDao = daoSession.getFieldBeanDao();
            FieldBean fieldNew = targetDao.load(__key);
            synchronized (this) {
                field = fieldNew;
                field__resolvedKey = __key;
            }
        }
        return field;
    }

    @Generated(hash = 338712148)
    private transient Long field__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1449644733)
    public void setTeam2(@NotNull TeamBean team2) {
        if (team2 == null) {
            throw new DaoException(
                    "To-one property 'team2Id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.team2 = team2;
            team2Id = team2.getId();
            team2__resolvedKey = team2Id;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1302287948)
    public TeamBean getTeam2() {
        long __key = this.team2Id;
        if (team2__resolvedKey == null || !team2__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamBeanDao targetDao = daoSession.getTeamBeanDao();
            TeamBean team2New = targetDao.load(__key);
            synchronized (this) {
                team2 = team2New;
                team2__resolvedKey = __key;
            }
        }
        return team2;
    }

    @Generated(hash = 1875642404)
    private transient Long team2__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 473417715)
    public void setTeam1(@NotNull TeamBean team1) {
        if (team1 == null) {
            throw new DaoException(
                    "To-one property 'team1Id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.team1 = team1;
            team1Id = team1.getId();
            team1__resolvedKey = team1Id;
        }
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 626926737)
    public TeamBean getTeam1() {
        long __key = this.team1Id;
        if (team1__resolvedKey == null || !team1__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamBeanDao targetDao = daoSession.getTeamBeanDao();
            TeamBean team1New = targetDao.load(__key);
            synchronized (this) {
                team1 = team1New;
                team1__resolvedKey = __key;
            }
        }
        return team1;
    }

    @Generated(hash = 754364378)
    private transient Long team1__resolvedKey;

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1894975208)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMatchBeanDao() : null;
    }

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1422076968)
    private transient MatchBeanDao myDao;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setMatchstatusId(long matchstatusId) {
        this.matchstatusId = matchstatusId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public void setTeam2Id(long team2Id) {
        this.team2Id = team2Id;
    }

    public void setTeam1Id(long team1Id) {
        this.team1Id = team1Id;
    }

    public long getTournamentId() {
        return this.tournamentId;
    }

    public long getMatchstatusId() {
        return this.matchstatusId;
    }

    public Long getFieldId() {
        return this.fieldId;
    }

    public long getTeam2Id() {
        return this.team2Id;
    }

    public long getTeam1Id() {
        return this.team1Id;
    }

    public int getScoreTeam2() {
        return this.scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public int getScoreTeam1() {
        return this.scoreTeam1;
    }

    @Generated(hash = 650765788)
    public MatchBean(Long id, long date, String duration, String result, int scoreTeam1, int scoreTeam2,
                     long team1Id, long team2Id, Long fieldId, long matchstatusId, long tournamentId) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.result = result;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.fieldId = fieldId;
        this.matchstatusId = matchstatusId;
        this.tournamentId = tournamentId;
    }

    @Generated(hash = 1910626172)
    public MatchBean() {
    }
}
