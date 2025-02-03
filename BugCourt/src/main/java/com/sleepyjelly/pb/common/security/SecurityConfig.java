package com.sleepyjelly.pb.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.sleepyjelly.pb.common.user.UserRole;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig {	

    @Bean
    BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
		.csrf((csrfConfig) ->
				csrfConfig.disable()
		) 
		.headers((headerConfig) ->
				headerConfig.frameOptions(frameOptionsConfig ->
						frameOptionsConfig.disable()
				)
		)
		.authorizeHttpRequests((authorizeRequests) ->
				authorizeRequests
//						.requestMatchers(PathRequest.toH2Console()).permitAll()
						.requestMatchers("/", "/login/**").permitAll()
						.requestMatchers("/bbs/**", "/toRoot/v1/bbs/**").hasAnyAuthority(UserRole.USER,UserRole.MEMBERSHIP_USER,UserRole.ADMIN)
						.requestMatchers("/admins/**", "/toRoot/v1/admins/**").hasAnyAuthority(UserRole.ADMIN)
						.anyRequest().authenticated()
		)
//		.exceptionHandling((exceptionConfig) ->
//				exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler)
//		) 
		.formLogin((formLogin) ->
				formLogin
						.loginPage("/login/viewLogin") 
						.usernameParameter("username") 
						.passwordParameter("password") 
						.loginProcessingUrl("/login/loginProcess") 
						.defaultSuccessUrl("/", true)
		)
		.logout((logoutConfig) ->
				logoutConfig.logoutSuccessUrl("/")
		);
//		.userDetailsService(UserService); 

		return http.build();
    }

    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");//  bug-court-react@0.0.0 dev 	 //	> vite
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
    
}

