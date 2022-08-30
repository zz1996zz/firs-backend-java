package fastcampus.saladbank.config.jwt;

public interface JwtProperties {
    int EXPIRATION_TIME = 1000*60*10;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
