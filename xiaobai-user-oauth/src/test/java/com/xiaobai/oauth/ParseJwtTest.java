package com.xiaobai.oauth;

//import com.netflix.discovery.converters.Auto;

import com.xiaobai.user.feign.UserFeign;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

public class ParseJwtTest {


    @Test
    public void testParseToken() {
        //令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTU5OTIyNDc4NSwiYXV0aG9yaXRpZXMiOlsidmlwIiwidXNlciJdLCJqdGkiOiIxMDczOGI1MC00ZjNjLTQ5NzktODBlMS0wNmQyYWU5ZGY0YzYiLCJjbGllbnRfaWQiOiJ4aWFvYmFpIiwidXNlcm5hbWUiOiJ6aGFuZ3NhbiJ9.Gm0TGnzq1vNo1eQUoVbLR_yfVu-x3I7yNUyprleJF6BQLaUIvvLWeH4FFIb-Ufk48Mwvzb_9K67YIReTfP5Crdor8ssT7oGLQ49Pnqx6jZrKnmGrklXSneVAyBWahrJixHZte6YuNT9AYvMIiwyxw1zumhQWIRQJ8PuDJt59fKAjr1eEO5HZ2UFFEyyLqVlMh9Rca_Uy_nMUCCJRNa6cBCka0tNJ7D4JTJod3EfS7OAhMTkuw8gRQan1utZNLGRrcdLWGT2AF5jEAZnffzZ7p22-jgJD_E979LIycaLg7o8rWrPWZ-C4gSI4yHdB6i1bUs7gz1B2jvIk_VZ8FtE0xQ";
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsfO6cctfs/PQSdVqnreBoHGATFukcaXrJSkPuiC5vYKCPWHpBcak4WuROJE5MU9G2p6DnCsCokoC6ZWYJPmn8kwFZKC0K6YmEdULGrVnXWGo2ibnOD4vmmHy2GvkZIn2CjFeQ057C5YET5I7N+nmgt41mZOUIXnvgTjMigXHrz2ViZqGp+MGtsLC2FDG9AAg5XkT4Jorawgg89igJVXxcS1Mo/koQdRNUP7BYID8gXYhfGWVq2w7E1TwVFe8LmGZKUZ9Sq0E9gNpMkDKrKezrWVEi00nQtHLXfvaFrSitVaruiwcFpxDnigy2xDFZ9amgvJTSinzVvG73673fEColQIDAQAB-----END PUBLIC KEY-----";
        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容 载荷
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
