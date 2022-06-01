package com.ecommerce.app.service.mapper;

import com.ecommerce.app.common.EntityMapper;
import com.ecommerce.app.model.Brand;
import com.ecommerce.app.service.dto.BrandDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface BrandMapper extends EntityMapper<BrandDTO, Brand> {



    default Brand fromId(Long id) {
        if (id == null) {
            return null;
        }
        Brand e = new Brand();
        e.setId(id);
        return e;
    }


}
