package com.hapo.HapoGptApplication.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {

    private final SecretKey signingKey;
    private final long expirationMs;

    public JwtUtil(
            @Value("${app.jwt.secret}") String secret,
            @Value("${app.jwt.expiration-ms:86400000}") long expirationMs) {
        this.signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    /**
     * Generate a signed JWT for the given user.
     *
     * @param userId   the user's UUID
     * @param email    the user's email (used as subject)
     * @param role     the user's role (e.g. "USER", "ADMIN")
     * @return signed JWT string
     */
    public String generateToken(UUID userId, String email, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .subject(email)
                .claim("userId", userId.toString())
                .claim("role", role)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(signingKey)
                .compact();
    }

    /**
     * Validate the token and return its claims.
     * Throws JwtException if the token is invalid or expired.
     *
     * @param token the JWT string (without "Bearer " prefix)
     * @return parsed Claims
     */
    public Claims validateAndExtractClaims(String token) {
        return Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Extract the email (subject) from a token without full validation.
     * Use validateAndExtractClaims for secure extraction.
     */
    public String extractEmail(String token) {
        return validateAndExtractClaims(token).getSubject();
    }

    /**
     * Extract the userId claim from a token.
     */
    public UUID extractUserId(String token) {
        String userId = validateAndExtractClaims(token).get("userId", String.class);
        return UUID.fromString(userId);
    }

    /**
     * Extract the role claim from a token.
     */
    public String extractRole(String token) {
        return validateAndExtractClaims(token).get("role", String.class);
    }

    /**
     * Check if a token is valid (not expired, not tampered).
     *
     * @param token the JWT string
     * @return true if valid, false otherwise
     */
    public boolean isTokenValid(String token) {
        try {
            validateAndExtractClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
