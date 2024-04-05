package leville.ville.database;

import leville.ville.domain.Product;

public final class TestDataUtil {
    public static Product createProductA(){
         return Product.builder().id(1L).name("Galaxy S4")
                .description("Samsung smartphone")
                .type("phone").unit(1)
                .price(20.2)
                .available(true)
                .supplier("Telcel")
                .build();
    }

    public static Product createProductB(){
        return Product.builder().id(2L).name("Galaxy S22")
                .description("Samsung smartphone")
                .type("phone").unit(1)
                .price(200.2)
                .available(true)
                .supplier("Tigo")
                .build();
    }
}
