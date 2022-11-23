package com.example.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableJdbcHttpSession
public class WishlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishlistApplication.class, args);
    }

}
