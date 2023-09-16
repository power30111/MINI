package jwt.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   //내 서버가 응답할때 (ex, json) 을 자바 스크립트에서 처리할수 있게 할지를 설정하는것
                                            //예를들면 Ajax, patch, 엑시노트 등의 라이브러리로 요청이 오면 받을수있게할지 설정하는것
        config.addAllowedOrigin("*");       //모든 ip에 응답을 허용하는것
                                            
        config.addAllowedHeader("*");       //모든 header에 응답을 허용하는것

        config.addAllowedMethod("*");       //모든 post,get,put 등등의 요청을 허용하는것
        source.registerCorsConfiguration("/api/**",config);

        return new CorsFilter(source);
    }
}
