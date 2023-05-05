package springbootrestfulwebservices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "SpringBoot REST API",
				description = "SpringBoot REST api documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Beabkal",
						email = "b3abkal@gmail.com"
				)
		)
)
public class SpringbootRestfulWebservicesApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
