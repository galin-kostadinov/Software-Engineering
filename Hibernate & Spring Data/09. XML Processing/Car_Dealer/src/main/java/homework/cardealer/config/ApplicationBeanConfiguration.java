package homework.cardealer.config;

import homework.cardealer.util.ValidatorUtil;
import homework.cardealer.util.ValidatorUtilImpl;
import homework.cardealer.util.XmlParser;
import homework.cardealer.util.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return new ValidatorUtilImpl();
    }

    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }
}
