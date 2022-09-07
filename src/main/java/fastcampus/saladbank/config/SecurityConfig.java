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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("http://127.0.0.1:5173");
        configuration.addAllowedOriginPattern("http://127.0.0.1:5174");
        configuration.addAllowedOriginPattern("http://127.0.0.1:5175");
        configuration.addAllowedOriginPattern("https://glowing-bubblegum-467ed0.netlify.app/");
        configuration.addAllowedOriginPattern("https://sadaribankapp.netlify.app/");
        configuration.addAllowedOriginPattern("https://saladbanklink.netlify.app/");
        configuration.addAllowedOriginPattern("https://team4-mini-project-ivory.vercel.app/");
        configuration.addAllowedOriginPattern("https://team4-mini-project.vercel.app/ ");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.addExposedHeader("Authorization");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
        JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(authenticationManager(), memberRepository);
        jwtAuthenticationFilter.setSecret(secret);
        jwtAuthorizationFilter.setSecret(secret);

        http.csrf().disable();
        http.cors().configurationSource(corsConfigurationSource());
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(jwtAuthenticationFilter)
                .addFilter(jwtAuthorizationFilter)
                .authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/", "/login", "/register", "/duplicate", "/products/**", "/cards", "/loans", "/swagger-resources/**", "/swagger-ui/**", "/v3/**").permitAll()
                .anyRequest().access("hasRole('ROLE_USER')")
                .and()
                .logout()
                .logoutSuccessUrl("/do-logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
    }
}
