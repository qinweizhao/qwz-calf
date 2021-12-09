package com.qinweizhao.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qinweizhao
 * @since 2021/9/27
 */
@Component
@ConfigurationProperties(prefix = "qinweizhao.jwt")
public class JwtUtils {

    private long expire;
    private String secret;
    private String header;

    /**
     * 生成 jwt
     *
     * @param username 用户名
     * @return jwt
     */
    public String generateToken(String username) {

        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000 * expire);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(username)
                .setIssuedAt(nowDate)
                // 7天过期
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 解析jwt
     *
     * @param jwt jwt
     * @return Claims
     */
    public Claims getClaimByToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            throw new JwtException("解析jwt 异常" + e.getMessage());
        }
    }

    /**
     * jwt是否过期
     *
     * @param claims claims
     * @return b
     */
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }


    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
