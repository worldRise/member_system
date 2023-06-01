package com.auther.fan.member_system.util;

import com.alibaba.fastjson2.JSON;
import com.auther.fan.member_system.sys.entity.Admin;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtils {

    private static long time = 10000 * 60 * 60 * 24;
    private static String signature = "admin";

    /**
     * 使用jwt生成token
     * @param admin admin对象
     * @return 返回一个token
     */
    public static String jwtEncode(Admin admin){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //heard
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("user",admin)
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //Signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }


    /**
     *对jwt生成的一个token进行解码
     * @return 返回一个用户对象
     */
    public static Object jwtDecode(String token){
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InVzZXIuZ2V0VXNlcm5hbWUoKSIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2ODMxMzM5MzUsImp0aSI6ImVhZTNhMjVjLTE0ZGQtNDU3OS1iMmVhLTRmZmExZDhjMTFkMSJ9.J-B5WXlevdAxHm0f2BlHRvS68HC-HgoOnSZnQT8kht4";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Object user = claims.get("user");
        return user;
    }


}
//@Component
//public class JwtUtils {
//    // 有效期
//    private static final long JWT_EXPIRE = 30*60*1000L;  //半小时
//    // 令牌秘钥
//    private static final String JWT_KEY = "123456";
//
//    public  String createToken(Object data){
//        // 当前时间
//        long currentTime = System.currentTimeMillis();
//        // 过期时间
//        long expTime = currentTime+JWT_EXPIRE;
//        // 构建jwt
//        JwtBuilder builder = Jwts.builder()
//                .setId(UUID.randomUUID()+"")
//                .setSubject(JSON.toJSONString(data))
//                .setIssuer("system")
//                .setIssuedAt(new Date(currentTime))
//                .signWith(SignatureAlgorithm.HS256, encodeSecret(JWT_KEY))
//                .setExpiration(new Date(expTime));
//        return builder.compact();
//    }
//
//    private SecretKey encodeSecret(String key){
//        byte[] encode = Base64.getEncoder().encode(key.getBytes());
//        SecretKeySpec aes = new SecretKeySpec(encode, 0, encode.length, "AES");
//        return  aes;
//    }
//
//    public  Claims parseToken(String token){
//        Claims body = Jwts.parser()
//                .setSigningKey(encodeSecret(JWT_KEY))
//                .parseClaimsJws(token)
//                .getBody();
//        return body;
//    }
//
//    public <T> T parseToken(String token,Class<T> clazz){
//        Claims body = Jwts.parser()
//                .setSigningKey(encodeSecret(JWT_KEY))
//                .parseClaimsJws(token)
//                .getBody();
//        return JSON.parseObject(body.getSubject(),clazz);
//    }
//
//}
