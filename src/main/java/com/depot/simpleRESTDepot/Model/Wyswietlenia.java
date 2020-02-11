package com.depot.simpleRESTDepot.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wyswietlenia")
public class Wyswietlenia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "iloscWyswietlen")
    @NotNull
    private Long iloscWyswietlen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produkt_id", referencedColumnName = "id")
    @JsonIgnore
    private Produkt produkt;
}
