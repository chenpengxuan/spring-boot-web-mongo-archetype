package ${package};

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * Main application class.
 *
 * @author sempere
 */
@Slf4j
@EnableSwagger2
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${app.key}")
	public String appKey;

	@Value("${info.build.version}")
	public String buildVersion;

	// *************************************************************************
	//
	// Launcher
	//
	// *************************************************************************

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().sources(Application.class).run(args);
	}

	// *************************************************************************
	//
	// Swagger
	//
	// *************************************************************************

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				//.groupName("base-api")
				.select()
				.apis(withClassAnnotation(RestController.class))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("${appName} (" + this.appKey + ") API")
				.version(this.buildVersion)
				.build();
	}
	// *************************************************************************
	//
	// Methods from CommandLineRunner interface
	//
	// *************************************************************************

	@Override
	public void run(String... strings) throws Exception {
		log.info("application {} is available for use.", this.appKey);
	}
}
