package app.entities;

import javax.persistence.*;
import  java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "test", catalog = "test")
public class UserEntity {
    private int userId;
    private String name;
    private String year;
    private Date date;
    private String pass;

    @Id
    @Column(name = "USER_ID",nullable = false, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "YEAR", nullable = false, length = 20)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "PASS", nullable = false, length = 20)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(name, that.name) &&
                Objects.equals(year, that.year) &&
                Objects.equals(date, that.date) &&
                Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, name, year, date, pass);
    }
}
