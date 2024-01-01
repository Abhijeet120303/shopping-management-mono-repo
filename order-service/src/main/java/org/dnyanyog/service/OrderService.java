package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.OrderServiceRequest;
import org.dnyanyog.dto.OrderServiceResponse;
import org.dnyanyog.entity.Orders;
import org.dnyanyog.repo.OrdersServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrdersServiceRepository repo;

	public OrderServiceResponse placeOrder(OrderServiceRequest orderServiceRequest) {

		OrderServiceResponse response = new OrderServiceResponse();
		Orders Orders = new Orders();

		Orders.setName(orderServiceRequest.getName());
		Orders.setQuantity(orderServiceRequest.getQuantity());
		Orders.setPrice(orderServiceRequest.getPrice());
		Orders.setProductId(orderServiceRequest.getProductId());
		Orders.setName(orderServiceRequest.getName());

		System.out.println("Quantity :" + Orders.getQuantity());
		System.out.println("Price :" + Orders.getPrice());

		int a = Orders.getPrice();
		int b = Orders.getQuantity();
		int c = a * b;

		Orders.setTotalPrice(c);

		Orders = repo.save(Orders);

		response.setStatus("Success");
		response.setMessage("Placed Order Successfully");
		response.setOrderId(Orders.getOrderId());

		return response;

	}

	public OrderServiceResponse addProduct(OrderServiceRequest productsServiceRequest) {

		OrderServiceResponse response = new OrderServiceResponse();

		Orders tableData = new Orders();

		tableData.setPrice(productsServiceRequest.getPrice());
		tableData.setQuantity(productsServiceRequest.getQuantity());

		tableData = repo.save(tableData);
		response.setStatus("Success");
		response.setMessage("Product Add Successfully");
		response.setProductId(tableData.getProductId());
		response.setOrderId(tableData.getOrderId());

		return response;

	}

	public OrderServiceResponse cancleOrder(Long orderId) {

		OrderServiceResponse response = new OrderServiceResponse();

		Optional<Orders> liCustomer = repo.findByOrderId(orderId);

		if (liCustomer.isPresent()) {
			Orders order = liCustomer.get();
			response.setOrderId(order.getOrderId());
			repo.delete(order);
			response.setStatus("Success");
			response.setMessage("Oredr Cancled Successfully");
		} else {
			response.setStatus("Fail");
			response.setMessage("Order Not Found");
		}

		return response;

	}
}
