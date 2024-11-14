package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters") // 유효성 검사 추가
    private String username;

    @Column(nullable = false, length = 64)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(nullable = false, length = 10)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(nullable = false, length = 13)
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "Phone number must follow the pattern 010-0000-0000")
    private String phoneNumber;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 1)
    private Character gender;

    @Column(nullable = false)
    @NotEmpty(message = "Address is required")
    private String address;

    @Column(nullable = false, length = 10)
    private String loginType;
}
