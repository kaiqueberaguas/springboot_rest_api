package br.com.example.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppStartTests {

	@Test
	@DisplayName("Teste de inicializacao da aplicacao")
	void contextLoads() {
		Assertions.assertDoesNotThrow(() -> AppStart.main(new String[0]));
	}

}
