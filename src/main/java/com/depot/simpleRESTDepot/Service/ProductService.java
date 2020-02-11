package com.depot.simpleRESTDepot.Service;

import com.depot.simpleRESTDepot.Exception.ResourceNotFoundException;
import com.depot.simpleRESTDepot.Model.Produkt;
import com.depot.simpleRESTDepot.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Produkt getById(int id) {
        Produkt produkt = checkIfIdIsPresentAndReturnProduct(id);
        produkt.getWyswietlenia().setIloscWyswietlen(produkt.getWyswietlenia().getIloscWyswietlen() + 1);
        productRepository.saveAndFlush(produkt);
        produkt.setCena(produkt.getCena() - calculateDiscount(produkt));
        return produkt;
    }

    private double calculateDiscount(Produkt produkt) {
        switch (produkt.getTyp()) {
            case KID:
                return produkt.getCena() * 0.1;
            case MALE:
            case FEMALE:
                return produkt.getCena() * 0.05;
            default:
                return 0;
        }
    }

    private Produkt checkIfIdIsPresentAndReturnProduct(int id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Product with id: " + id + " not found.");
        }
    }
}
