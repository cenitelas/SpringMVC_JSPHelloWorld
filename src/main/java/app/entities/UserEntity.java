package app.entities;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import  java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "test", catalog = "")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Size(min=3, max=50)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "year", nullable = false)
    private String year;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date date;
    @Size(min=3, max=50)
    @Column(name = "pass", nullable = false)
    private String pass;
    @Column(name = "hashcode", nullable = false)
    private int hashcode;

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "year", nullable = false, length = 20)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "pass", nullable = false, length = 200)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "hashcode", nullable = false)
    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
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

    public boolean checkUser(UserEntity user){
    if(this.hashCode()!=user.hashCode()) return false;
    if(!this.equals(user)) return false;
    return true;
    }

    @Override
    public String toString() {
        return "UserEntity [id=" + userId + ", name=" + name + ", joiningDate="
                + date + ", pass=" + pass + "]";
    }
}
