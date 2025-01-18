package org.example.cheapesttransferroute;

import org.springframework.boot.SpringApplication;

public class TestCheapestTransferRouteApplication {

	public static void main(String[] args) {
		SpringApplication.from(CheapestTransferRouteApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
