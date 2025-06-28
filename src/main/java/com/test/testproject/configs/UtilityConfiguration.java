package com.test.testproject.configs;

import com.test.testproject.utility.CBSEPassFailUtility;
import com.test.testproject.utility.ICSEPassFailUtility;
import com.test.testproject.utility.IUtility;
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
}
