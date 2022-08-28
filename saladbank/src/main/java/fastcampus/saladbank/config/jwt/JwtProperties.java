package fastcampus.saladbank.config.jwt;

public interface JwtProperties {
    int EXPIRATION_TIME = 600000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
