package semesterprojekt.demo.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //Initialize PasswordEncoder.
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    //Make login credentials for admin - (in memory).
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http.csrf().disable();
        http.headers().frameOptions().disable();


        http.authorizeRequests()
                .antMatchers("/adminmenu/**").hasRole("ADMIN")
                .antMatchers("/h2/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/adminlogin")
                .permitAll()
                .defaultSuccessUrl("/adminmenu")
                .failureUrl("/loginerror")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/adminlogin");
    }
}
