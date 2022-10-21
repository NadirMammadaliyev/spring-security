package az.nadir.restapi.config.security;

//@Configuration
public class SecurityInMemoryConfig {
  /*  static final String USER = "USER";
    static final String ADMIN = "ADMIN";

  //  @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles(USER)
                .username("admin")
                .password("password")
                .roles(ADMIN)
                .build();
        return new InMemoryUserDetailsManager(user);
    }

 //   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET,"/user/get-by-id").hasRole(ADMIN)
                .antMatchers(HttpMethod.POST, "/message/**").hasRole(USER)
                .antMatchers(HttpMethod.POST, "/slack/send").hasRole(ADMIN)
                .and()
                .csrf().disable()
                .formLogin().disable();
        return http.build();
    }
*/

    //https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
    //extends WebSecurityConfigurerAdapter ishlederek yazmaq uchun olan kod'lar
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles(USER)
                .and()
                .withUser("admin").password("{noop}password").roles(USER, ADMIN);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                    .antMatchers(HttpMethod.GET,"/user/get-by-id").permitAll()
                    .antMatchers(HttpMethod.POST, "/message/**").hasRole(USER)
                    .antMatchers(HttpMethod.POST, "/slack/send").hasRole(ADMIN)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }*/

}
