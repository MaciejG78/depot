package com.depot.simpleRESTDepot.Controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductControllerTest {

    @Test
    public void givenProductNotFound() throws IOException {

        // Given
        int productId = 11111;
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/produkt/" + productId);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertEquals(
                httpResponse.getStatusLine().getStatusCode(),
                HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void givenProductIdHasNotPropertyFormat() throws IOException {

        // Given
        String productId = "1asd";
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/produkt/" + productId);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertEquals(
                httpResponse.getStatusLine().getStatusCode(),
                HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Test
    void givenProductByIdHasPropertyFormat() throws IOException {

        // Given
        int productId = 1;
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/produkt/" + productId);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertEquals(
                httpResponse.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }

    @Test
    void getProductById() throws IOException {

        // Given
        String jsonMimeType = "application/json";
        int productId = 1;
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/produkt/" + productId);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
        assertEquals(jsonMimeType, mimeType);
    }
}
