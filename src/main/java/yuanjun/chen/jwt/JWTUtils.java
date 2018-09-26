/**
 * @Title: JWTUtils.java
 * @Package: yuanjun.chen.jwt
 * @Description: Json Web Token的生成和验证工具类
 * @author: 陈元俊
 * @date: 2018年9月11日 上午9:10:54
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @ClassName: JWTUtils
 * @Description: Json Web Token的生成和验证工具类
 * @author: 陈元俊
 * @date: 2018年9月11日 上午9:10:54
 */
public class JWTUtils {
    private static final Logger logger = LogManager.getLogger(JWTUtils.class);

    public static String generateTokenWithHead(Packet packet, String signingKey, Long expireMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setHeader(packet.getHead()).setSubject(packet.getSubject()).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey).setExpiration(new Date(now.getTime() + expireMillis)); // 1minutes有效
        String token = builder.compact();
        logger.info("token=" + token);
        return token;
    }

    @SuppressWarnings("unchecked")
    public static Packet directParse(String signingKey, String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
        String subject = claims.getBody().getSubject();
        Map<String, Object> head = claims.getHeader();
        logger.info("head = " + head);
        Packet packet = new Packet();
        packet.setHead(head);
        packet.setSubject(subject);
        return packet;
    }

    public static class Packet {
        private String subject;
        private Map<String, Object> head;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public Map<String, Object> getHead() {
            return head;
        }

        public void setHead(Map<String, Object> head) {
            this.head = head;
        }
    }

    public static void main(String[] args) throws Exception {
        
    }
}
