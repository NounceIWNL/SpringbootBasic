package org.itstep;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25)
    @ColumnDefault("'David'")
    @Generated(GenerationTime.INSERT) //Значение по умолчанию добавляется при вставке
    // alternately @Column(columnDefinition = "VARCHAR(25) DEFAULT 'David'")
    private String firstName;


    @Column(length = 25)
    @ColumnDefault("'Smith'")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
} 