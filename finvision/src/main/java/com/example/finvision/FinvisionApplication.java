package com.example.finvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* <h1>FinVision</h1>
* O API do FinVision realiza métotodos CRUD, garantindo que os dados recebidos pelo pelas requisições sejam tratados e devolvidos na devida forma solicitada.
*/

@SpringBootApplication
public class FinvisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinvisionApplication.class, args);
	}

}
