package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.ProductsServiceRequest;
import org.dnyanyog.dto.ProductsServiceResponse;
import org.dnyanyog.entity.Products;
import org.dnyanyog.repo.ProductsServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

	@Autowired
	ProductsServiceRepository repo;

	public ProductsServiceResponse addProduct(ProductsServiceRequest productsServiceRequest) {

		ProductsServiceResponse response = new ProductsServiceResponse();

		Products tableData = new Products();

		tableData.setProductName(productsServiceRequest.getProductName());
		tableData.setPrice(productsServiceRequest.getPrice());
		tableData.setQuantity(productsServiceRequest.getQuantity());

		tableData = repo.save(tableData);
		response.setStatus("Success");
		response.setMessage("Product Add Successfully");
		response.setProductId(tableData.getProductId());
		response.setProductName(tableData.getProductName());
		response.setPrice(tableData.getPrice());

		return response;

	}

	public ProductsServiceResponse updateUser(Long productId, Products request) {
		ProductsServiceResponse userResponse = new ProductsServiceResponse();
		Optional<Products> receivedData = repo.findById(productId);
		if (receivedData.isPresent()) {

			Products product = receivedData.get();
			product.setProductName(request.getProductName());
			product.setPrice(request.getPrice());

			product.setQuantity(request.getQuantity());

			product = repo.save(product);

			userResponse.setStatus("Success");
			userResponse.setMessage("ProductUpdated");
		} else {
			userResponse.setStatus("Fail");
			userResponse.setMessage("Product Not Found");

		}
		return userResponse;
	}
}
