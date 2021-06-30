package com.basic.management.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.basic.management.vo.user.UserInfo;
import lombok.extern.slf4j.Slf4j;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 *
 * @author fujie
 */
@Slf4j
public class TokenUtils {

    /**
     * 密钥
     */
    private static final String SECRET = "sdjhakdhajdklsl;o653632";

    /**
     * 过期时间:秒
     */
    private static final int EXPIRE = 5;

    /**
     * 用户名常量
     */
    private static final String USER_NAME = "name";

    /**
     * 密码常量
     */
    private static final String PASSWORD = "password";

    /**
     * 人员编号
     */
    private static final String NO = "no";

    /**
     * 生成Token
     * @param name 用户名
     * @param password 密码
     * @param no 用户编号
     * @return  String
     * @throws Exception 异常
     */
    public static String createToken(String name, String password, String no) throws Exception {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                //头
                .withHeader(map)
                .withClaim(USER_NAME, name)
                .withClaim(PASSWORD, password)
                .withClaim(NO,no)
                .withSubject("测试")
                //签名时间
                .withIssuedAt(new Date())
                //过期时间
                .withExpiresAt(expireDate)
                //签名
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证Token是否过期
     * @param token 密钥信息
     * @return Map<String, Claim>
     * @throws Exception 异常
     */
    public static boolean verifyToken(String token)throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try {
            verifier.verify(token);
        }catch (Exception e){
            log.error("凭证已过期，请重新登录");
            return false;
        }
        return true;
    }

    /**
     * 解析Token
     * @param token 密钥
     * @return Map<String, Claim>
     */
    public static UserInfo parseToken(String token){
        DecodedJWT decode = JWT.decode(token);
        Map<String, Claim> claims = decode.getClaims();
        return UserInfo.builder()
                .name(claims.get(USER_NAME).asString())
                .password(claims.get(PASSWORD).asString())
                .no(claims.get(NO).asString())
                .build();
    }
}
