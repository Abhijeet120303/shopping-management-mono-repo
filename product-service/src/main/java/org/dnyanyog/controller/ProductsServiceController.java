package org.dnyanyog.controller;

import org.dnyanyog.dto.ProductsServiceRequest;
import org.dnyanyog.dto.ProductsServiceResponse;
import org.dnyanyog.entity.Products;
import org.dnyanyog.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsServiceController {

	@Autowired
	ProductsService productsService;

	@PostMapping(path = "/api/v1/product/add", consumes = { "application/json", "application/xml" }, produces = {"application/json", "application/xml" })

	public ProductsServiceResponse addProducts(@RequestBody ProductsServiceRequest productsServiceRequest) {
		return productsService.addProduct(productsServiceRequest);

	}

	@PostMapping(path = "/api/v1/product/update/{productId}")
	public ProductsServiceResponse updateProduct(@PathVariable Long productId, @RequestBody Products request) {
		return productsService.updateUser(productId, request);

	}

}
