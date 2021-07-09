package com.example.demo;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message="is required")
    @Column(name="first_name")
    private String firstName;

    @NotBlank(message="is required")
    @Column(name="last_name")
    private String lastName;

    @NotBlank(message="is required")
    @Column(name="email")
    private String email;


}
