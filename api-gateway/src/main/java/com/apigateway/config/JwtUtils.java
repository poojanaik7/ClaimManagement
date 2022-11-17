package com.apigateway.config;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${claimmgt.app.jwtSecret}")
	private String jwtSecret;

	@Value("${claimmgt.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	private Key key;

	private String secretKey;

	@PostConstruct
	public void init(){
		//this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		secretKey = Base64.getEncoder().encodeToString(jwtSecret.getBytes());	}


//	public Claims getAllClaimsFromToken(String token) {
//		return Jwts.parser()
//				.setSigningKey(key)
//				.parseClaimsJws(token)
//				.getBody();
//	}

	public Claims getAllClaimsFromToken(String token) {
		String jwtToken = token.substring(7);
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(jwtToken)
				.getBody();
		return claims;
	}

	private boolean isTokenExpired(String token) {
			try {
				String jwtToken = token.substring(7);
				Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
				return false;
			} catch (SignatureException e) {
				logger.error("Invalid JWT signature: {}", e.getMessage());
			} catch (MalformedJwtException e) {
				logger.error("Invalid JWT token: {}", e.getMessage());
			} catch (ExpiredJwtException e) {
				logger.error("JWT token is expired: {}", e.getMessage());
			} catch (UnsupportedJwtException e) {
				logger.error("JWT token is unsupported: {}", e.getMessage());
			} catch (IllegalArgumentException e) {
				logger.error("JWT claims string is empty: {}", e.getMessage());
			}
			return true;
	}

	public boolean isInvalid(String token) {
		return this.isTokenExpired(token);
	}
}
