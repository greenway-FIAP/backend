package com.api.greenway.models;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "T_GRW_MEA")
@SequenceGenerator(name = "SEQ_GRW_USER", sequenceName = "SEQ_GRW_USER", allocationSize = 1)
public class Meassurement {
}
