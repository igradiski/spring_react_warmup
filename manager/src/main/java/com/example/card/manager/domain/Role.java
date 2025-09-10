package com.example.card.manager.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="ROLE")
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ROLE_SEQUENCE")
    @SequenceGenerator(name="ROLE_SEQUENCE",allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy="role")
    private List<UserRole> userRoles;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole roleName;
}
