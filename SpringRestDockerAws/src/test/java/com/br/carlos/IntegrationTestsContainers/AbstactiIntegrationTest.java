package com.br.carlos.IntegrationTestsContainers;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

@ContextConfiguration(initializers = AbstactiIntegrationTest.Initializer.class)
public class AbstactiIntegrationTest {

	public class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{
		
		static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.29");
		
		private static void startContainers() {
			
			Startables.deepStart(Stream.of(mySQLContainer)).join();
		}
		
		private static Map<String, String> createConnectionConfiguration() {
			
			return Map.of(
					"spring.datasource.url", mySQLContainer.getJdbcUrl(),
					"spring.datasource.username", mySQLContainer.getUsername(),
					"spring.datasource.pasword", mySQLContainer.getPassword() 
					);
		}

		@Override
		@SuppressWarnings({"unchecked", "rawtypes"})
		public void initialize(ConfigurableApplicationContext applicationContext) {
			
			startContainers();
			ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
			MapPropertySource mapPropertySource = new MapPropertySource(
					"mapPropertySource", 
						(Map) createConnectionConfiguration());
			
			configurableEnvironment.getPropertySources().addFirst(mapPropertySource);
		}


	}

}
