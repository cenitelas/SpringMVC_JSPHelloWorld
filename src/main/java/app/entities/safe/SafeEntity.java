package app.entities.safe;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "safe", schema = "test", catalog = "")
public class SafeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "hod", nullable = false)
    private Integer hod;
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date date;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_user", nullable = true)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "hod", nullable = true)
    public Integer getHod() {
        return hod;
    }

    public void setHod(Integer hod) {
        this.hod = hod;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeEntity that = (SafeEntity) o;
        return id == that.id &&
                Objects.equals(idUser, that.idUser) &&
                Objects.equals(hod, that.hod) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idUser, hod, date);
    }
}
