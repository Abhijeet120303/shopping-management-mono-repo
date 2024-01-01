package org.dnyanyog.controller;

import org.dnyanyog.dto.OrderServiceRequest;
import org.dnyanyog.dto.OrderServiceResponse;

import org.dnyanyog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

	@Autowired
	OrderService orderService;

	@PostMapping(path = "/api/v1/order/place", consumes = { "application/json", "application/xml" }, produces = {"application/json", "application/xml" })
	public OrderServiceResponse placeOrder(@RequestBody OrderServiceRequest orderServiceRequest) {
		return orderService.placeOrder(orderServiceRequest);

	}

	@PostMapping(path = "/api/v1/order/add", consumes = { "application/json", "application/xml" }, produces = {"application/json", "application/xml" })
	public OrderServiceResponse addOrder(@RequestBody OrderServiceRequest productsServiceRequest) {
		return orderService.addProduct(productsServiceRequest);

	}

	@DeleteMapping(path = "/api/v1/order/cancle/{orderId}", consumes = { "application/json","application/xml" }, produces = { "application/json", "application/xml" })
	public OrderServiceResponse cancleOrder(@PathVariable Long orderId) {
		return orderService.cancleOrder(orderId);

	}

}
