package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ProductsServiceRepository extends JpaRepository<Products, Long> {

	List<Products> findByProductId(long Id);

}
