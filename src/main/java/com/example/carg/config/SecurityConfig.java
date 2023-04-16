package com.example.carg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public AuthenticationSuccessHandler customSuccessHandler;

    @Bean
    public UserDetailsService getuserDetailsService() {
        return new UserDetailServiceImpl();

    }

    @Bean
    public BCryptPasswordEncoder getpasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getuserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(getpasswordEncoder());
        return daoAuthenticationProvider;

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getDaoAuthProvider());
    }

//        @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/", "/shop/**", "/register/**").permitAll()
//                .antMatchers("/admin**").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/signin")
//                .loginProcessingUrl("/login")
//                .permitAll()
//                //login fail hole login page eri jabe with error
//                .failureUrl("/login?error=true")
//                //login successfull hole home e jabe
//                .defaultSuccessUrl("/")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
////                .invalidateHttpSession(true)
////                .deleteCookies("JESSIONID")
////                .and()
////                .exceptionHandling()
//                .and()
//                .csrf()
//                .disable();
//        //http.headers().frameOptions().disable();
//
//    }
//}
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                  .antMatchers("/", "/shop/**", "/register/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/**").permitAll()
//
//                 .and()
//                .formLogin()
//                .loginPage("/signin")
//                .loginProcessingUrl("/login")
////                .permitAll()
//                .failureUrl("/login?error=true")
//               .successHandler(customSuccessHandler)
//
//
//
////                .defaultSuccessUrl("/")
//
//                .and()
//                .csrf()
//                .disable();//login er pore user page dekhabe
//    }
//}


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/cart").authenticated()
                .antMatchers("/", "/shop/**", "/register/**").permitAll()
                //.antMatchers("/**")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/login")
//                .successHandler(customSuccessHandler)
                .defaultSuccessUrl("/shop")

                .and()
                .csrf()
                .disable();//login er pore user page dekhabe
    }
}
