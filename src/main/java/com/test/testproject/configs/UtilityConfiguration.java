package com.test.testproject.configs;

import com.test.testproject.utility.CBSEPassFailUtility;
import com.test.testproject.utility.ICSEPassFailUtility;
import com.test.testproject.utility.IUtility;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilityConfiguration {

    @Bean("CBSE-Utility")
    public IUtility getCBSEUtility()
    {
        return  new CBSEPassFailUtility();
    }


    @Bean("ICSE-Utility")
    public IUtility getICSEUtility()
    {
        return  new ICSEPassFailUtility();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student API")
                        .version("1.0")
                        .description("API for managing students")
                );
    }
}
