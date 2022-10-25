package ru.ifuture.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "account", schema = "account_schema")
@NoArgsConstructor
public class Account {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * value at account
     */
    @Column(name = "value")
    private Long value;
}
