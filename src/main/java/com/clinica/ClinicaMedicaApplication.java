package com.clinica;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class ClinicaMedicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaMedicaApplication.class, args);
	}

}
