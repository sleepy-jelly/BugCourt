package com.sleepyjelly.pb.common.security;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ORIGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import com.sleepyjelly.pb.common.user.UserRole;

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig {	

		
	private static final String X_REQUESTED_WITH ="X-Requested-With";
		
	@Bean
	PasswordEncoder pwEncoder() {
		return new BCryptPasswordEncoder(10);
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
//				.requestMatchers(PathRequest.toH2Console()).permitAll()
				.requestMatchers("/", "/login/**").permitAll()
				.requestMatchers("/dash-board/**", "/api/dash-board/**").hasAnyAuthority(UserRole.USER,UserRole.MEMBERSHIP_USER,UserRole.ADMIN)
				.requestMatchers("/bbs/**", "/api/bbs/**").hasAnyAuthority(UserRole.USER,UserRole.MEMBERSHIP_USER,UserRole.ADMIN)
				.requestMatchers("/admins/**", "/api/admins/**").hasAnyAuthority(UserRole.ADMIN)
				.anyRequest().authenticated()
		)
//		.exceptionHandling((exceptionConfig) ->
//				exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler)
//		) 
		.formLogin((formLogin) ->
			formLogin
				.loginPage("/login/viewLogin") 
				.loginProcessingUrl("/login/loginProcess") 
				.usernameParameter("userId") 
				.passwordParameter("userPw") 
				.defaultSuccessUrl("/login/loginSuccessful", true)
		)
		.logout((logoutConfig) ->
			logoutConfig
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
		);
//		.userDetailsService(UserService); 
		return http.build();
    }
//
    
//    @Bean
//    UserDetailsService userDetailsService() {
//    	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		return manager;
//    }
//    
//    
  
    
    
    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");//  bug-court-react@0.0.0 dev 	 //	> vite
        
        
        config.setAllowedHeaders(List.of(ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN, CONTENT_TYPE, ACCEPT, AUTHORIZATION, X_REQUESTED_WITH, ACCESS_CONTROL_REQUEST_METHOD, ACCESS_CONTROL_REQUEST_HEADERS, ACCESS_CONTROL_ALLOW_CREDENTIALS));
        config.setExposedHeaders(List.of(ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN, CONTENT_TYPE, ACCEPT, AUTHORIZATION, X_REQUESTED_WITH, ACCESS_CONTROL_REQUEST_METHOD, ACCESS_CONTROL_REQUEST_HEADERS, ACCESS_CONTROL_ALLOW_CREDENTIALS));
//        config.setAllowedMethods(List.of(GET.name(), POST.name(), PUT.name(), PATCH.name(), DELETE.name(), OPTIONS.name()));
        
        config.addAllowedMethod("*");
      
      	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", config);

 
        return new CorsFilter(urlBasedCorsConfigurationSource);
    } 
    
    @Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mappers/**/*Mapper.xml"));
	    sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatisConfig.xml")); 
        
//	    org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//	    configuration.setMapUnderscoreToCamelCase(true);
//	    sessionFactory.setConfiguration(configuration);
	    
	    return sessionFactory.getObject();
	}
    
    
}

