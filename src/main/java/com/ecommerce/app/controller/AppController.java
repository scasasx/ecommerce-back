package com.ecommerce.app.controller;


import com.ecommerce.app.controller.request.SearchDTO;
import com.ecommerce.app.controller.responses.ReponseDTO;
import com.ecommerce.app.service.BrandService;
import com.ecommerce.app.service.PriceService;
import com.ecommerce.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class AppController {



    @Autowired
    private PriceService priceService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @GetMapping("price")
    public ResponseEntity<ReponseDTO> getAllPrices(){
        return ResponseEntity.ok(new ReponseDTO("success", priceService.findAll()));
    }

    @GetMapping("brand")
    public ResponseEntity<ReponseDTO> getAllBrands(){
        return ResponseEntity.ok(new ReponseDTO("success", brandService.findAll()));
    }

    @GetMapping("product")
    public ResponseEntity<ReponseDTO> getAllProducts(){
        return ResponseEntity.ok(new ReponseDTO("success", productService.findAll()));
    }

    @PostMapping("/search/price")
    public ResponseEntity<ReponseDTO> searchPrice(@RequestBody SearchDTO searchDTO){
        return ResponseEntity.ok(new ReponseDTO("success", priceService.search(searchDTO)));
    }


}