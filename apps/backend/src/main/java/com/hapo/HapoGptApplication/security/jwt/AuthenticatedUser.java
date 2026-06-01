package com.hapo.HapoGptApplication.security.jwt;

import java.util.UUID;

/**
 * The principal object stored in the SecurityContext after JWT validation.
 * Controllers can access this via:
 *
 *   @AuthenticationPrincipal AuthenticatedUser user
 *
 * or:
 *
 *   AuthenticatedUser user = (AuthenticatedUser)
 *       SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 */
public class AuthenticatedUser {

    private final UUID id;
    private final String email;
    private final String role;

    public AuthenticatedUser(UUID id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
