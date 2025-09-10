package com.example.card.manager.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name="PERSON")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PERSON_SEQUENCE")
    @SequenceGenerator(name = "PERSON_SEQUENCE",allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private String Oib;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;
}
