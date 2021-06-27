package pl.sdacademy.pewex.db;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 150,unique = true)
    private String userName;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private String createdBy;
    @Column
    private LocalDate createdDate;
    @Column
    private String modifiedBy;
    @Column LocalDate modifiedDate;
}













