package cinevore.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class JwtAuthService {
	
	private static final String SECRET_KEY = System.getenv("JWT_SECRET_KEY");
	
    public Claims extractAllClaims(String token) {
    	return Jwts
    			.parserBuilder()
    			.setSigningKey(getSignInKey())
    			.build()
    			.parseClaimsJws(token)
    			.getBody();
           
    }
    
    private Key getSignInKey() {
    	byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    	return Keys.hmacShaKeyFor(keyBytes);
    }
        
    public String extractUsername(String token) {
    	return extractClaim(token, Claims::getSubject);
    }
    
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    	final Claims claims = extractAllClaims(token);
    	return claimsResolver.apply(claims);
    }
    
    public String generateToken(String username) {
    	return generateToken(new HashMap<>(), username);
    }

    public String generateToken(Map<String, Object> extraClaims, String username) {
        return Jwts
        		.builder()
        		.setClaims(extraClaims)
        		.setSubject(username)
        		.setIssuedAt(new Date(System.currentTimeMillis()))
        		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        		.signWith(getSignInKey(), SignatureAlgorithm.HS256)
        		.compact();
    }
    
    public boolean isTokenValid(String token, String username) {
    	if(isTokenExpired(token)) {
    		return false;
    	}
        String comparedUsername = extractUsername(token);
    	return comparedUsername.equals(username);
    }
    
    public boolean isTokenExpired(String token) {
    	try {
    		return extractExpiration(token).before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }
    
    private Date extractExpiration(String token) {
    	System.out.println("extract");
    	System.out.println(extractClaim(token, Claims::getExpiration));
    	return extractClaim(token, Claims::getExpiration);
    }

}
