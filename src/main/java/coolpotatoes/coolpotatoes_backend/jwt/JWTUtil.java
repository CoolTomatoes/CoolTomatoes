package coolpotatoes.coolpotatoes_backend.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
/*새날지기 코드 가져온거*/
//@Component
//public class JWTUtil {
//
//    private final SecretKey secretKey;
//
//    /* access token 유효시간 */
//    private final long accessTokenValidity = 1000 * 60 * 60; // 60분
//
//
//    /* SecretKey 설정 */
//    public JWTUtil(@Value("${spring.jwt.secret}") String secret) {
//        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
//    }
//
//    /* token에서 username 꺼내기 */
//    public String getUsername(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("username", String.class);
//    }
//
//    /* token 만료시간 확인 */
//    public Boolean isExpired(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
//    }
//
//    /* 유효한 token인지 확인 */
//    public boolean validateToken(String token, String username) {
//        return (username.equals(getUsername(token)) && !isExpired(token));
//    }
//
//    /* AccessToken 발급 */
//    public String createAccessToken(String username) {
//        return Jwts.builder()
//                .claim("username", username)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + accessTokenValidity))
//                .signWith(secretKey)
//                .compact();
//    }
//}

@Component
public class JWTUtil {

    private SecretKey secretKey;

    public JWTUtil(@Value("${spring.jwt.secret}")String secret) {

        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String getUsername(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("username", String.class);
    }

    public String getRole(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role", String.class);
    }
    /* access token 유효시간 */
    private final long accessTokenValidity = 1000 * 60 * 30; // 30분

    public Boolean isExpired(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }


    /* AccessToken 발급 */
    public String createAccessToken(String studentId) {
        return Jwts.builder()
                .claim("studentId", studentId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + accessTokenValidity))
                .signWith(secretKey)
                .compact();
    }
}