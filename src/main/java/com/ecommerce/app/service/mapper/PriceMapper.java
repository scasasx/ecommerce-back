package com.ecommerce.app.service.mapper;

import com.ecommerce.app.common.EntityMapper;
import com.ecommerce.app.model.Price;
import com.ecommerce.app.service.dto.PriceDTO;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {})
public interface PriceMapper extends EntityMapper<PriceDTO, Price> {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "product.id",target = "productId")
    PriceDTO toDto(Price movimiento);

    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "productId",target = "product.id")
    Price toEntity(PriceDTO priceDTO);

    default Price fromId(Long id) {
        if (id == null) {
            return null;
        }
        Price e = new Price();
        e.setId(id);
        return e;
    }


}
