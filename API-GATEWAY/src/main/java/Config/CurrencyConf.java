package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CurrencyConfig implements WebMvcConfigurer {

    @Bean
    @Primary
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        // Puedes agregar otros convertidores según tus necesidades

        return conversionService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Aquí puedes agregar más convertidores si es necesario
    }
}
