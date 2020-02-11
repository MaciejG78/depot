package com.depot.simpleRESTDepot.Repository;

import com.depot.simpleRESTDepot.Model.Wyswietlenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WyswietleniaRepository extends JpaRepository<Wyswietlenia, Integer> {
}
