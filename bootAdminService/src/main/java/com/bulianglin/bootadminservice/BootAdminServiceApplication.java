package com.bulianglin.bootadminservice;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class BootAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminServiceApplication.class, args);
    }

}
