package app.entities.safe;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "safe_number", schema = "test", catalog = "")
public class SafeNumberEntity {
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
    @Column(name = "s1", nullable = false)
    private Integer s1;
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "s2", nullable = false)
    private Integer s2;
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "s3", nullable = false)
    private Integer s3;
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "s4", nullable = false)
    private Integer s4;

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
    @Column(name = "s1", nullable = true)
    public Integer getS1() {
        return s1;
    }

    public void setS1(Integer s1) {
        this.s1 = s1;
    }

    @Basic
    @Column(name = "s2", nullable = true)
    public Integer getS2() {
        return s2;
    }

    public void setS2(Integer s2) {
        this.s2 = s2;
    }

    @Basic
    @Column(name = "s3", nullable = true)
    public Integer getS3() {
        return s3;
    }

    public void setS3(Integer s3) {
        this.s3 = s3;
    }

    @Basic
    @Column(name = "s4", nullable = true)
    public Integer getS4() {
        return s4;
    }

    public void setS4(Integer s4) {
        this.s4 = s4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeNumberEntity that = (SafeNumberEntity) o;
        return id == that.id &&
                Objects.equals(idUser, that.idUser) &&
                Objects.equals(s1, that.s1) &&
                Objects.equals(s2, that.s2) &&
                Objects.equals(s3, that.s3) &&
                Objects.equals(s4, that.s4);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idUser, s1, s2, s3, s4);
    }
}
