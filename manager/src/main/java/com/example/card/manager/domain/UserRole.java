package com.example.card.manager.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@Table(name="USER_ROLE")
@NoArgsConstructor
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_ROLE_SEQUENCE")
    @SequenceGenerator(name="SEQ_USER_ROLE",allocationSize = 1)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant datetime;

    @ManyToOne
    private Role role;

    @ManyToOne
    private User user;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

}
