package com.depot.simpleRESTDepot.Controller;

import com.depot.simpleRESTDepot.Model.Produkt;
import com.depot.simpleRESTDepot.Results.ResponseWrapper;
import com.depot.simpleRESTDepot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequestMapping("/api/produkt")
public class ProductController {

    private static final String REGEX_FOR_ID="^[z0-9]{1,5}$";
    private static final String MESSAGE_FOR_WRONG_ID_FORMAT="Nieprawidłowy format id produktu.";


    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseWrapper<Produkt> getProductById(
            @Valid @Pattern(regexp = REGEX_FOR_ID, message = MESSAGE_FOR_WRONG_ID_FORMAT) @PathVariable(value = "id") String id )
    {
        return new ResponseWrapper<>(productService.getById(Integer.parseInt(id) ), HttpStatus.OK);
    }
}
