package pl.sdacademy.pewex.db;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 150, unique = true)
    private String userName;

    @Column(length = 150, unique = true)
    private String password;

    @Column(length = 150, unique = true)
    private String role;

    @Column(length = 150, unique = true)
    private int id_adress;

    @Column(length = 150, unique = true)
    private String createdBy;

    @Column(length = 150, unique = true)
    private LocalDate createdDate;

    @Column(length = 150, unique = true)
    private String modifiedBy;

    @Column(length = 150, unique = true)
    private LocalDate modifiedDate;

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getId_adress() {
        return id_adress;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", id_adress=" + id_adress +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
