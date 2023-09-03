package br.com.example.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.example.api.utils.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Value("${info.name}")
    private String nome;

    @Value("${info.description}")
    private String descricao;

    @Value("${info.version}")
    private String versao;

	@Value("${info.package}")
    private String pacote;

    @Value("${info.contact.site}")
    private String site;

    @Value("${info.contact.name}")
    private String desenvolvedor;

    @Value("${info.contact.email}")
    private String email;

    @Value("${info.license}")
    private String licenca;
    
    @Value("${info.license.url}")
    private String licancaUrl;

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage(this.pacote))
				.paths(PathSelectors.regex("/api/.*"))
				.build()
				.apiInfo(metaInfo());
		
	}
	
	private ApiInfo metaInfo(){
		return new ApiInfoBuilder()
			.title(StringUtils.toCaptalize(this.nome))
			.description(this.descricao)
			.version(this.versao)
			.contact(new Contact(this.desenvolvedor,
				this.site, this.email))
			.license(this.licenca)
			.licenseUrl(this.licancaUrl)
			.build();
	}

}
