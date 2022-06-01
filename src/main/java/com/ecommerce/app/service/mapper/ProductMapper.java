package com.ecommerce.app.service.mapper;

import com.ecommerce.app.common.EntityMapper;
import com.ecommerce.app.model.Product;
import com.ecommerce.app.service.dto.ProductDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {



    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product e = new Product();
        e.setId(id);
        return e;
    }


}
