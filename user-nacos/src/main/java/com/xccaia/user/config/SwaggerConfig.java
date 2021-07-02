package com.xccaia.user.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：xccaia
 * @ Date       ：2021-03-24
 * @ Description： swagger 测试使用
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  //扫描路径
  private final String SWAGGER_SCAN_BASE_PACKAGE = "com.xccaia.user.controller";
  //开关
  @Value("${swagger.enable:true}")
  private Boolean enable;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enable(enable)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("xccaia的swagger测试项目 demo API")
        .version("1.0.0")
        .build();
  }
}