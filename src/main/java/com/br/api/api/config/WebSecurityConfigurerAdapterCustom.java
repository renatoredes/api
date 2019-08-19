package com.br.api.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
@EnableWebSecurity
@EnableResourceServer
@Configuration
public class WebSecurityConfigurerAdapterCustom extends WebSecurityConfigurerAdapter {
<<<<<<< HEAD
	 @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    @Autowired
	    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
	        // Usuario em memoria
	        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("USER");
	    }

	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	//o recurso categorias não é nescessario autenticação
	        http.authorizeRequests().antMatchers("/categorias").permitAll().anyRequest().authenticated().and()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/categorias");
	    }
=======
>>>>>>> parent of 8644336... WebSecurityConfigurerAdapterCustom

	}
<<<<<<< HEAD
=======

}
>>>>>>> parent of 8644336... WebSecurityConfigurerAdapterCustom
