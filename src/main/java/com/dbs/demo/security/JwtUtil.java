//package com.dbs.demo.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//// https://jwt.io/introduction
//
//@Service
//public class JwtUtil {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	private String SECRET_KEY = "mySecret";
//
//	public String extractUsername(String token) {
//		LOG.info("extractUsername");
//		return extractClaim(token, Claims::getSubject);
//	}
//
//	public Date extractExpiration(String token) {
//		LOG.info("extractExpiration");
//		return extractClaim(token, Claims::getExpiration);
//	}
//
//	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//		LOG.info("extractClaim");
//		final Claims claims = extractAllClaims(token);
//		return claimsResolver.apply(claims);
//	}
//
//	private Claims extractAllClaims(String token) {
//		LOG.info("extractAllClaims");
//		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//	}
//
//	private Boolean isTokenExpired(String token) {
//		LOG.info("isTokenExpired");
//		return extractExpiration(token).before(new Date());
//	}
//
//	public String generateToken(UserDetails userDetails) {
//		LOG.info("generateToken");
//		Map<String, Object> claims = new HashMap<>();
//		return createToken(claims, userDetails.getUsername());
//	}
//
//	private String createToken(Map<String, Object> claims, String subject) {
//		LOG.info("createToken");
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // valid for 10 hours - edit
//																							// only this time duration
//				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
//	}
//
//	public Boolean validateToken(String token, UserDetails userDetails) {
//		LOG.info("validateToken");
//		final String username = extractUsername(token);
//		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
//}