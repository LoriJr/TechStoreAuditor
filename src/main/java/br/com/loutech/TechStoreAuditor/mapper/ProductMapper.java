package br.com.loutech.TechStoreAuditor.mapper;

import br.com.loutech.TechStoreAuditor.dto.ProductResponseDTO;
import br.com.loutech.TechStoreAuditor.model.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductResponseDTO dto);
    ProductResponseDTO toDTO(ProductEntity entity);
}
