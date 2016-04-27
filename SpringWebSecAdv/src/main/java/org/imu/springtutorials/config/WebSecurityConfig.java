package org.imu.springtutorials.config;

import org.imu.springtutorials.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
			.userDetailsService(customUserDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	

	@Override
	public void configure(WebSecurity web)
			throws Exception {
		web
		.ignoring()
		.antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.authorizeRequests()
        .antMatchers("/anonymous*").anonymous()
        .antMatchers("/login*").permitAll()
        .antMatchers("/**").authenticated()
        //.anyRequest().anonymous()
        .and()
        //This will generate a login form if none is supplied.
        .formLogin()
        //this will using login form from us supplied
        .usernameParameter("j_username")
        .passwordParameter("j_password")
        .loginProcessingUrl("/perform_login")
        .defaultSuccessUrl("/homepage").loginPage("/login").failureUrl("/login?error=true")
        //.successHandler(new MySimpleUrlAuthenticationSuccessHandler())
        .and()
        .logout().logoutUrl("/perform_logout")
        .deleteCookies("JSESSIONID")
        //.logoutSuccessHandler(new CustomLogoutSuccessHandler())
        .and()
        .sessionManagement().maximumSessions(2).expiredUrl("/sessionExpired").and().and()
        .rememberMe().tokenValiditySeconds(86400).key("uniqueAndSecret")
        .and().csrf().disable();
        */
		 http
		    .csrf().disable()
		    .authorizeRequests()
		        .antMatchers("/login","/login/**","/register","/logout").permitAll() // #4
		        .antMatchers("/admin","/admin/**").hasRole("ADMIN") // #6
		        .anyRequest().authenticated() // 7
		        .and()
		    .formLogin()  // #8
		        .loginPage("/login") // #9
		        .loginProcessingUrl("/login")
		        .failureUrl("/login?error")
		        .permitAll() // #5
		 	.and()
		 	.logout().deleteCookies("JSESSIONID")
	        .and()
	        .sessionManagement().maximumSessions(2).expiredUrl("/sessionExpired");
	        //.and().rememberMe().tokenValiditySeconds(86400).key("uniqueAndSecret");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean  
	public ShaPasswordEncoder passwordEncoder() throws Exception {  
	  return new ShaPasswordEncoder();  
	}  
}
