package com.alexandre.cursos.conf;

import com.alexandre.cursos.domain.Pagamento_Com_Boleto;
import com.alexandre.cursos.domain.Pagamento_Com_Cartao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(Pagamento_Com_Cartao.class);
                objectMapper.registerSubtypes(Pagamento_Com_Boleto.class);
                super.configure(objectMapper);
            };
        };
        return builder;
    }
}