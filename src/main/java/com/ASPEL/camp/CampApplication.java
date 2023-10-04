package com.ASPEL.camp;

import com.ASPEL.camp.model.Role;
import com.ASPEL.camp.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampApplication {
	public static void main(String[] args) {
		SpringApplication.run(CampApplication.class, args);
	}

}
