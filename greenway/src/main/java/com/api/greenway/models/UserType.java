package com.api.greenway.models;

import com.api.greenway.controllers.dtos.UserTypeRegisterDTO;
import com.api.greenway.controllers.dtos.UserTypeUpdateDTO;
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
@Table(name = "T_GRW_USER_TYPE")
@SequenceGenerator(name = "SEQ_GRW_USER_TYPE", sequenceName = "SEQ_GRW_USER_TYPE", allocationSize = 1)
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRW_USER_TYPE")
    @Column(name = "id_user_type")
    private Long idUserType;

    @Column(name = "ds_title")
    private String title;

    @Column(name = "dt_created_at")
    private LocalDateTime createdAt;

    @Column(name = "dt_updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "dt_finished_at")
    private LocalDateTime finishedAt;

    public UserType(UserTypeRegisterDTO userTypeRegisterDTO) {
        this.title = userTypeRegisterDTO.title();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(UserTypeUpdateDTO userTypeUpdateDTO) {
        if (userTypeUpdateDTO.title() != null) {
            this.title = userTypeUpdateDTO.title();
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.finishedAt = LocalDateTime.now();
    }

}
