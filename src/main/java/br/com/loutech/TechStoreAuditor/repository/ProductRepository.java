package br.com.loutech.TechStoreAuditor.repository;

import br.com.loutech.TechStoreAuditor.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
