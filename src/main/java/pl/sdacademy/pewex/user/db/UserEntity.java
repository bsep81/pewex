package pl.sdacademy.pewex.user.db;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table (name = "user")

public class UserEntity {
    @Id
    private String userName;

    private String password;

    private String role;

}













