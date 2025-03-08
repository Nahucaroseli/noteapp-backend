package com.example.demo.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.cors(cors -> cors.configurationSource(corsFilter()))
	            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Permitir todas las rutas
	            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no usas formularios
	            .formLogin(form -> form.disable()) // Deshabilitar el formulario de login
	            .httpBasic(basic -> basic.disable()); // Deshabilitar autenticación básica
	        return http.build();
	    }
	 
	 
	 
	 @Bean
	 public CorsConfigurationSource corsFilter() {
		 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		 CorsConfiguration config = new CorsConfiguration();
		 config.setAllowCredentials(true);
		 config.addAllowedOriginPattern("*");
		 config.setAllowedHeaders(List.of("*"));
		 config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
		 source.registerCorsConfiguration("/**", config);
		 return source;

	 }

}
