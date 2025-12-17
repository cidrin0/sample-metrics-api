package br.com.grafana.sma.persistence.repository;

import br.com.grafana.sma.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query("SELECT p FROM Product p where p.active is true")
    List<ProductEntity> findAllProducts();

    @Query("SELECT p FROM Product p where p.code = :code and p.active is true")
    Optional<ProductEntity> findByCode(@Param("code") UUID code);

    @Modifying
    @Query("update Product p set p.active = false where p.code = :code and p.active is true")
    void deleteByCode(@Param("code") UUID code);
}
