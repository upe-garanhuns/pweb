package br.upe.pweb;

import java.util.ArrayList;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WebConfig extends WebMvcConfigurationSupport {

  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/META-INF/resources/",
      "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

  public Docket controleacessoAPI() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("br.upe.pweb")).build().apiInfo(metaInfo());
  }

  @SuppressWarnings("rawtypes")
  private ApiInfo metaInfo() {

    ApiInfo apiInfo = new ApiInfo("Controle Acesso API REST", "API REST de controle de acesso.",
        "1.0", "Terms of Service",
        new Contact("Helaine Barreiros", "http://www.upe.br/garanhuns", "helaine.lins@upe.br"),
        "Apache License Version 2.0", "https://www.apache.org/license.html",
        new ArrayList<VendorExtension>());

    return apiInfo;
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
  }

}
