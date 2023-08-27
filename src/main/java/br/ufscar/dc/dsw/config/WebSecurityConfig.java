package br.ufscar.dc.dsw.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.security.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UsuarioDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

				
				http.csrf().disable().authorizeRequests()
				// Controladores REST
				.antMatchers("/api/clientes", "/locadoras", "/locacoes").permitAll()
				.antMatchers("/api/clientes/{\\d+}", "/locadoras/{\\d+}").permitAll()
				.antMatchers("/locacoes/{\\d+}").permitAll()
				.antMatchers("/locadoras/cidades/{\\w+}").permitAll()
				.antMatchers("/locacoes/clientes/{\\d+}").permitAll()
				.antMatchers("/locacoes/locadoras/{\\d+}").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/error", "/login/**", "/js/**", "/css/**", "/image/**", "/webjars/**", "/lista/**").permitAll()
				.antMatchers("/locacoes/**").hasAnyRole("Cliente", "Locadora")
				.antMatchers("/locadoras/**", "/clientes/**", "/usuarios/**").hasRole("Admin")
				.anyRequest().authenticated()
		 	.and()
				.formLogin().loginPage("/login").permitAll()
			.and()
				.logout().logoutSuccessUrl("/").permitAll();

		
				/*http.authorizeRequests()
				.antMatchers("/error", "/login/**", "/js/**", "/css/**", "/image/**", "/webjars/**", "/lista/**").permitAll()
				.antMatchers("/locacoes/**").hasAnyRole("Cliente", "Locadora")
				.antMatchers("/locadoras/**", "/clientes/**", "/usuarios/**").hasRole("Admin")
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll();*/
	}
}
