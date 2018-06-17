package ru.stc.day0303;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.stc.api.Storage;
import ru.stc.impl.MockStorage;

@Configuration
@ComponentScan("ru.stc")
public class MyConfiguration {

    @Bean
    Storage storage() {
        return new MockStorage(21);
    }
}
