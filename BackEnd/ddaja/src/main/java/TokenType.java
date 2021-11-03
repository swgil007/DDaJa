

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.common.util.DateUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenType {
    ACCESS("access_token", 12) {
        @Override
        public String createToken(CommonJWT commonJWT, String secretKey) {
            Date now = new Date();
            SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
            return Jwts.builder()
                        .setSubject(commonJWT.getUserName())
                        .claim(Constants.CLAIMS_ROLE, commonJWT.getRole())
                        .claim(Constants.CLAIMS_USER_NAME, commonJWT.getUserName())
                        .claim(Constants.CLAIMS_USER_ID, commonJWT.getUserID())
                        .claim(Constants.CLAIMS_ID, commonJWT.getId())
                        .claim(Constants.CLAIMS_IS_SUPER, commonJWT.isSuper())
                        .setIssuedAt(now)
                        .setExpiration(DateUtil.addHours(now, getMaxHour()))
                        .signWith(key)
                        .compact();
        }
    }
    , REFRESH("refresh_token", 24 * 14) {};

    private String name;
    private int maxHour;

    public abstract String createToken(CommonJWT commonJWT, String secretKey);

    public String getTokenInCookie(HttpServletRequest request) {
        Optional<Cookie> cookie = Arrays.stream(request.getCookies()).filter(e -> e.getName().equals(name)).findAny();
        if(!cookie.isPresent()) return null;
        return cookie.get().getValue();
    }
}
