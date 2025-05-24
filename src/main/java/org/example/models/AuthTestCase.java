package org.example.models;

public class AuthTestCase {
    private final String title;
    private final AuthRequest request;
    private final boolean shouldSucceed;

    public AuthTestCase(String title, AuthRequest request, boolean shouldSucceed) {
        this.title = title;
        this.request = request;
        this.shouldSucceed = shouldSucceed;
    }

    public String getTitle() {
        return title;
    }

    public AuthRequest getRequest() {
        return request;
    }

    public boolean isShouldSucceed() {
        return shouldSucceed;
    }
}
