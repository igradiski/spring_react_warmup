package com.example.card.manager.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="MANAGER_USER")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_SEQUENCE")
    @SequenceGenerator(name="USER_SEQUENCE",allocationSize = 1)
    private Long id;

    private String username;

    private String password;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Instant updatedDate;

    @OneToMany(mappedBy = "user")
    private Set<RefreshToken> refreshToken;

    @OneToMany(mappedBy="user")
    private List<UserRole> userRoles;

}
