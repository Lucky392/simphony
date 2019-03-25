package com.simphony.challenge.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.simphony.challenge.constants.SimphonyRouter;
import com.simphony.challenge.security.constants.Role;
import com.simphony.challenge.service.UserDetailsServiceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsServiceImpl userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers(SimphonyRouter.USER, "/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**", "/login").permitAll()
				.antMatchers(SimphonyRouter.DISLIKED, SimphonyRouter.LIKED, SimphonyRouter.FAVORITES, SimphonyRouter.REVIEWS).hasAnyRole(Role.USER, Role.ADMIN)
				.antMatchers(HttpMethod.POST, SimphonyRouter.HOTEL).hasRole(Role.ADMIN)
				.antMatchers(HttpMethod.PUT, SimphonyRouter.HOTEL).hasRole(Role.ADMIN)
				.antMatchers(HttpMethod.PATCH, SimphonyRouter.HOTEL).hasRole(Role.ADMIN)
				.antMatchers(HttpMethod.GET, SimphonyRouter.HOTEL + "/**").hasRole(Role.USER)
			.anyRequest().authenticated()
			.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()))
				// this disables session creation on Spring Security
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}
