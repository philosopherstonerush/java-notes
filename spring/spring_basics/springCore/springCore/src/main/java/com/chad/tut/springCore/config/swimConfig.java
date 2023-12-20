package com.chad.tut.springCore.config;

import com.chad.tut.springCore.common.swimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swimConfig {

    // @Bean(<custom-bean-id)
    @Bean("swim")
    public swimCoach getSwimCoach() {
        return new swimCoach();
    }

}
