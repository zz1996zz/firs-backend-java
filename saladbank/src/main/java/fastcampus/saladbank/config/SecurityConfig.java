package fastcampus.saladbank.config;

import fastcampus.saladbank.biz.repository.MemberRepository;
import fastcampus.saladbank.config.jwt.JwtAuthenticationFilter;
import fastcampus.saladbank.config.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberRepository memberRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
        JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(authenticationManager(), memberRepository);
        jwtAuthenticationFilter.setSecret(secret);
        jwtAuthorizationFilter.setSecret(secret);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(jwtAuthenticationFilter)
                .addFilter(jwtAuthorizationFilter)
                .authorizeRequests()
                .antMatchers("/register", "/products/**", "/swagger-resources/**", "/swagger-ui/**", "/v3/**").permitAll()
                .anyRequest().access("hasRole('ROLE_USER')")
//                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/do-logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
    }
}
