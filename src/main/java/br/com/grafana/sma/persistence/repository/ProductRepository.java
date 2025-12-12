package br.com.grafana.sma.persistence.repository;

import br.com.grafana.sma.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("SELECT p FROM Product p")
    List<ProductEntity> findAllProducts();

}
