package com.depot.simpleRESTDepot.Model;


import com.fasterxml.jackson.annotation.*;
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
@Table(name = "produkty")
@JsonIgnoreType
public class Produkt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
    private int id;

    @Column(name = "nazwa")
    @NotNull
    @JsonProperty
    private String nazwa;

    @Column(name = "opis")
    @JsonProperty
    private String opis;

    @OneToOne(mappedBy = "produkt", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonManagedReference("produkt")
    @JsonProperty
    private Wyswietlenia wyswietlenia;

    @Enumerated
    @JsonProperty
    private Typ typ;

    @NotNull
    @Column(name = "cena")
    @JsonProperty
    private double cena;

    @JsonValue
    public String toJson(){
        return this.toString();
    }

    @Override
    public String toString() {
        return "DaneSzczgoloweProduktu{" +
                "nazwaProduktu: " + nazwa +
                ", opisProduktu: '" + opis +
                ", typProduktu: " + typ +
                ", cenaPoRabacie: " + String.format("%.2f", cena) + " zł" +
                ", iloscWyswietlen: " + wyswietlenia.getIloscWyswietlen() +
                '}';
    }
}
