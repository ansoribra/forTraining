package com.qyubix.controller;

/**
 * Spring Web security configuration class
 * 
 * @author Sarath Muraleedharan
 *
 */
/*
@Configurable
@EnableWebSecurity */
// Modifying or overriding the default spring boot security.
public class WebSecurityConfig /* extends WebSecurityConfigurerAdapter*/ {
/*
	@Autowired
	DataSource dataSource;
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select user_name,user_password, enabled from user where user_name=?")
				.authoritiesByUsernameQuery("select u.user_name, p.role from user u" +
						" inner join user_roles p" +
						" on u.id = p.user_id where u.user_name=?");;
	}

	// This method is for overriding some configuration of the WebSecurity
	// If you want to ignore some request or request patterns then you can
	// specify that inside this method
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				// ignoring the "/", "/index.html", "/app/**", "/register",
				// "/favicon.ico"
				.antMatchers("/", "/index.html", "/app/**", "/register", "/authenticate", "/favicon.ico","/product/**",
						"/public/**","/login");
	}

	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.antMatchers("/product").hasIpAddress("localhost")
		.anyRequest().authenticated();
	}*/
}
