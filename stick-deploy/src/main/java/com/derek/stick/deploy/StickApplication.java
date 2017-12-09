package com.derek.stick.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author derek.wu
 * @date 2017-11-08
 * @since v1.0.0
 */
@SpringBootApplication(scanBasePackages = { "com.derek.stick" })
public class StickApplication {

    public static void main(String[] args) {
        SpringApplication.run(StickApplication.class, args);
    }
}
