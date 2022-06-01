package com.ecommerce.app.controller.responses;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReponseDTO {

    public ReponseDTO(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    private String status;

    private Object data;


}