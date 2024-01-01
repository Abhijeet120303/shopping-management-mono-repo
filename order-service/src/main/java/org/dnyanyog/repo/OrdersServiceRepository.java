package org.dnyanyog.repo;

import java.util.Optional;

import org.dnyanyog.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface OrdersServiceRepository extends JpaRepository<Orders, Long> {

	Optional<Orders> findByOrderId(Long Id);

}
