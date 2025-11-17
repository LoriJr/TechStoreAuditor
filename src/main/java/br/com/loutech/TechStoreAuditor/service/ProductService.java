package br.com.loutech.TechStoreAuditor.service;

import br.com.loutech.TechStoreAuditor.dto.ProductResponseDTO;
import br.com.loutech.TechStoreAuditor.mapper.ProductMapper;
import br.com.loutech.TechStoreAuditor.model.ProductEntity;
import br.com.loutech.TechStoreAuditor.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductResponseDTO> findActiveProducts(){
        return repository.findAll()
                .stream()
                .filter(ProductEntity::isActive)
                .map(product -> {
                    product.setName(product.getName().toUpperCase());
                    return mapper.toDTO(product);
                })
                .collect(Collectors.toList());
    }

    public Optional<ProductEntity> findById(Long id){
        return repository.findById(id);
    }

    public ProductEntity saveProduct(ProductEntity product){
        return repository.save(product);
    }

    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    public ProductEntity updateProduct(Long id, ProductEntity product){
        ProductEntity current = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product with ID {{id}} not found" + id));

        if(product.getName() != null) current.setName(product.getName());
        if(product.getPrice() != null) current.setPrice(product.getPrice());

        ProductEntity update = repository.save(current);
        return update;
    }

}
