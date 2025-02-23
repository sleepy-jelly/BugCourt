package com.sleepyjelly.pb.common.security;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.sleepyjelly.pb.common.user.UserRole;
	 
	@Configuration
	@EnableWebSecurity
	public class SecurityConfig {	

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
				.requestMatchers("/bbs/**", "/api/v1/bbs/**").hasAnyAuthority(UserRole.USER,UserRole.MEMBERSHIP_USER,UserRole.ADMIN)
				.requestMatchers("/admins/**", "/api/v1/admins/**").hasAnyAuthority(UserRole.ADMIN)
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
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");//  bug-court-react@0.0.0 dev 	 //	> vite
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    } 
    
    @Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mappers/**/*Mapper.xml"));
	    sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatisConfig.xml")); 
        

	    
//	    if  mybatis.configuration.map-underscore-to-camel-case=true not working try this ...
//	    org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//	    configuration.setMapUnderscoreToCamelCase(true);
//	    sessionFactory.setConfiguration(configuration);
	    
	    return sessionFactory.getObject();
	}
    
    
}

