package leville.ville.mappers.impl;

import leville.ville.domain.Product;
import leville.ville.domain.dto.ProductDTO;
import leville.ville.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImp implements Mapper<Product, ProductDTO> {

    private ModelMapper modelMapper;

    public ProductMapperImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO mapTo(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Product mapFrom(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);

    }
}
