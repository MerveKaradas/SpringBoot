package com.doyur.demo.security;

import com.doyur.demo.configuration.PasswordEncoderConfig;
import com.doyur.demo.model.Role;
import com.doyur.demo.service.concretes.UserDetailsServiceImpl;
import com.doyur.demo.service.concretes.UserSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity //Spring Security'nin web güvenliğini etkinleştirir
@EnableMethodSecurity //metod seviyesinde güvenlik ayarlarını etkinleştirir
public class SecurityConfig {

  /*  @Bean
    public SecurityFilterChain filterChain(HttpSecurity security, HandlerMappingIntrospector introspector) throws Exception {

        security
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x ->
                        x.requestMatchers("/public/**").permitAll()
                                .requestMatchers("/private/**").hasAnyAuthority(Role.ROLE_ADMIN.name())
                                .anyRequest().authenticated()
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        //      .formLogin(form -> form.loginPage("/login")).loginProcessingUrl("/login")
        //      .defaultSuccessUrl("/").permitAll()
        //      .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
        //      .logoutRequestMatcher(new AntPathRequestMatcher("/login"))
        //      .logoutSuccessUrl("/login?logout")).permitAll();

        return security.build();
    } */



    PasswordEncoderConfig passwordEncoderConfig;
	UserSuccessHandler userSuccessHandler;     //CustomSuccessHandler customSuccessHandler;
	UserDetailsServiceImpl userDetailServiceImpl; //CustomUserDetailsService customUserDetailsService;

	public SecurityConfig(UserDetailsServiceImpl userDetailServiceImpl,UserSuccessHandler userSuccessHandler, PasswordEncoderConfig passwordEncoderConfig) {
        this.userDetailServiceImpl = userDetailServiceImpl;
        this.userSuccessHandler = userSuccessHandler;
        this.passwordEncoderConfig = passwordEncoderConfig;
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

		http.csrf(c -> c.disable())

		.authorizeHttpRequests(request -> request
                .requestMatchers("/admin-page").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/user-page").hasAuthority("ROLE_USER")
				.requestMatchers("/registration", "/css/**").permitAll()
				.anyRequest().authenticated())

		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
				.successHandler(userSuccessHandler).permitAll())

		.logout(form -> form.
				invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll());


		return http.build();

	}

	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncoderConfig.bCryptPasswordEncoder());
	}
}
