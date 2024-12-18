package com.OneMeal.OneMeal_be.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters")
    private String username;

    @Column(nullable = false, length = 64)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(nullable = false, length = 10)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(nullable = false, length = 13)
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "Phone number must follow the pattern 010-0000-0000")
    private String phone_number;

    private Date birth_date;
    private Character gender;
    private Integer zone_code;
    private String address;
    private String detail_address;

    @Column(nullable = false, length = 10)
    private String login_type;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Favorite> favorites = new ArrayList<>();
}
