package hu.unideb.inf.basketball_agency_szakdolgozat.configs;

import hu.unideb.inf.basketball_agency_szakdolgozat.repositories.UserRepository;
import hu.unideb.inf.basketball_agency_szakdolgozat.services.security.MySQLUserDetailsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder builder) throws Exception {
        http.sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        http.csrf(options -> options.ignoringRequestMatchers(antMatcher("/h2-console/*")));

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(antMatcher("/h2-console/*")).permitAll()
                        .requestMatchers(antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(antMatcher("/h2-console")).permitAll()
                        .requestMatchers(builder.pattern("/static/**")).permitAll()
                        .requestMatchers(builder.pattern("/regisztracio")).permitAll()
                        .requestMatchers(builder.pattern("/profile")).authenticated()
                        .requestMatchers(builder.pattern("/login")).permitAll()
                        .requestMatchers(builder.pattern("/logout")).permitAll()
                        .requestMatchers(builder.pattern("/edzo")).authenticated()
                        .requestMatchers(builder.pattern("/jatekos")).authenticated()
                        .requestMatchers(builder.pattern("/admin")).hasRole("ADMIN")
                        .requestMatchers(builder.pattern("/admin/**")).hasRole("ADMIN")
                        .requestMatchers(builder.pattern("/")).permitAll()
                        .anyRequest().permitAll()
            )
            .formLogin(login -> {
                login.permitAll();
                //login.failureUrl("/?login=true&error=loginError");
                login.loginPage("/?login=true");
                login.loginProcessingUrl("/login");
                login.failureHandler((HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)-> {
                    if (exception instanceof BadCredentialsException) {
                        response.sendRedirect("/?login=true&error=loginError");

                    } else if (exception instanceof LockedException) {
                        response.sendRedirect("/?login=true&error=approveError");

                    } else {
                        response.sendRedirect("/?login=true");
                    }
                });

            });

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();   // Bcrypt titkositas
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new MySQLUserDetailsService(userRepository);
    }
}
