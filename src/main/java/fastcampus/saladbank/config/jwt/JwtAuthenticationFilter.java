package fastcampus.saladbank.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import fastcampus.saladbank.config.auth.PrincipalDetails;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private String secret;

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper om = new ObjectMapper();
        MemberForm memberForm = null;

        try {
            memberForm = om.readValue(request.getInputStream(), MemberForm.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberForm.getUsername(), memberForm.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        return authenticate;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        PrincipalDetails principal = (PrincipalDetails) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withClaim("id", principal.getMember().getMemberId())
                .withClaim("username", principal.getMember().getUsername())
                .sign(Algorithm.HMAC512(secret));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("accessToken", JwtProperties.TOKEN_PREFIX + jwtToken);

        response.getWriter().write(jsonObject.toString());
    }
}
