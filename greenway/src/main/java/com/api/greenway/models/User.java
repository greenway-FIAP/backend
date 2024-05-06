package com.api.greenway.models;

import com.api.greenway.controllers.dtos.UserRegisterDTO;
import com.api.greenway.controllers.dtos.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "T_GRW_USER")
public class User {

    @Column(name = "id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_password")
    private String password;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime finishedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_type")
    private UserType userType;


    public User(UserRegisterDTO userRegisterDTO) {
        this.email = userRegisterDTO.email();
        this.password = userRegisterDTO.password();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO.email() != null) {
            this.email = userUpdateDTO.email();
        }

        if (userUpdateDTO.password() != null) {
            this.password = userUpdateDTO.password();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
