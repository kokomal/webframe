/**
 * @Title: JwtSinglyTest.java
 * @Package: yuanjun.chen.jwt
 * @Description: 测试JWT的单体加解密
 * @author: 陈元俊
 * @date: 2018年9月11日 上午9:50:00
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.jwt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import yuanjun.chen.jwt.JWTUtils.Packet;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JwtSinglyTest
 * @Description: 测试JWT的单体加解密
 * @author: 陈元俊
 * @date: 2018年9月11日 上午9:50:00
 */
public class JwtSinglyTest {
    private static final String SIGN_KEY = "SecretKeyOnlyKeptBetweenYouAndMeEyesOnly";
    private static final String SIGN_KEY_HEAVY =
            "SecretKeyOnlyKeptBetweenYouAndMeEyesOnlySecretKeyOnlyKeptBetweenYouAndMeEyesOnlySecretKeyOnlyKeptBetweenYouAndMeEyesOnlySecretKeyOnlyKeptBetweenYouAndMeEyesOnlySecretKeyOnlyKeptBetweenYouAndMeEyesOnly";
    private static final Logger logger = LogManager.getLogger(JwtSinglyTest.class);

    /**
     * @throws Exception
     * @Title: testJwt
     * @Description: 测试JWT的自包含加密，好处在于JWT是自解释的密钥，缺点是加密有一点慢
     * @return: void
     */
    @Test
    public void testJwt() throws Exception {
        Long t1 = System.currentTimeMillis();

        Packet packet = new Packet();
        packet.setSubject("lorem ipsum");
        Map<String, Object> head = new HashMap<>();
        head.put("UserAgent", "Macintosh; PPC Mac OS X");
        head.put("Pragma", "no-cache");
        head.put("Cache-Control", "no-cache");
        packet.setHead(head);

        String token = JWTUtils.generateTokenWithHead(packet, SIGN_KEY, 2000L);
        Long t2 = System.currentTimeMillis();
        logger.info("encrypt time = " + (t2 - t1) + "ms");

        Packet packet2 = JWTUtils.directParse(SIGN_KEY, token);
        Long t3 = System.currentTimeMillis();
        logger.info("decrypted time = " + (t3 - t2) + "ms");
        logger.info("extracted subject = {" + packet2.getSubject() + "} and header = " + packet.getHead());

        Thread.sleep(2000L);

        try {
            Packet packet3 = JWTUtils.directParse(SIGN_KEY, token);
        } catch (Exception e) {
            logger.info("error!" + e);
        }
    }

    @Test
    public void testJwtHeavy() {
        Long t1 = System.currentTimeMillis();

        Packet packet = new Packet();
        packet.setSubject(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Map<String, Object> head = new HashMap<>();
        head.put("UserAgent", "Macintosh; PPC Mac OS X");
        head.put("Pragma", "no-cache");
        head.put("Cache-Control1", "no-cache");
        head.put("Cache-Control2", "no-cache");
        head.put("Cache-Control3", "no-cache");
        head.put("Cache-Control4", "no-cache");
        head.put("Cache-Control5", "no-cache");
        head.put("Cache-Control6", "no-cache");
        head.put("Cache-Control7", "no-cache");
        head.put("Cache-Control8", "no-cache");
        head.put("Cache-Control9", "no-cache");
        head.put("Cache-Control10", "no-cache");
        packet.setHead(head);

        String token = JWTUtils.generateTokenWithHead(packet, SIGN_KEY_HEAVY, 10000L);
        Long t2 = System.currentTimeMillis();
        logger.info("token len = " + token.length());
        logger.info("encrypt time = " + (t2 - t1) + "ms");

        Packet packet2 = JWTUtils.directParse(SIGN_KEY_HEAVY, token);
        Long t3 = System.currentTimeMillis();
        logger.info("decrypted time = " + (t3 - t2) + "ms");
        logger.info("extracted subject = {" + packet2.getSubject() + "} and header = " + packet.getHead());
    }
}
