package com.depot.simpleRESTDepot.Repository;

import com.depot.simpleRESTDepot.Model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produkt, Integer> {
}
