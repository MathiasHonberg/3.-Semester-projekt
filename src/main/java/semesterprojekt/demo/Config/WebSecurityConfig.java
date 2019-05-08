package semesterprojekt.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers("/").permitAll();

        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userCreate").access("hasRole('ROLE_USER')");

        // For ADMIN only.
        http.authorizeRequests().antMatchers("/adminMenu").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/editItem").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/itemList").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/updateItem/{updated}").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/updateSending").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/deleteSending").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/deleteItem").access("hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/download").access("hasRole('ROLE_ADMIN')");


        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/")//
                //.successHandler(customizeAuthenticationSuccessHandler)
                .failureUrl("/?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

    }



}
