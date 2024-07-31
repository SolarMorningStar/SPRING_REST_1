package com.solarmaster.star.util.constants;

public class Constants {
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    // Default Pagination and Sorting
    public static final int DEFAULT_PAGE_LIMIT = 15;
    public static final int DEFAULT_PAGE_NUMBER = 1;
    public static final boolean DEFAULT_SORT_ORDER = true;

    // Application Settings
    public static final String APP_VERSION = "1.0.0";
    public static final String API_BASE_URL = "https://api.example.com";
    public static final int API_TIMEOUT_SECONDS = 30;
    public static final int MAX_FILE_UPLOAD_SIZE_MB = 10;

    // Error Messages
    public static final String ERROR_USER_NOT_FOUND = "User not found";
    public static final String ERROR_INVALID_INPUT = "Invalid input provided";
    public static final String ERROR_INTERNAL_ERROR = "Internal server error";

    // Regular Expressions
    public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String REGEX_PHONE = "^[0-9]{10}$";

    // Security and Authentication
    public static final String JWT_SECRET_KEY = "ZAJSKTIONRKI16726HUANSYBSK"; // Use environment variables or a secure vault in real applications
    public static final long JWT_EXPIRATION_MS = 86400000; // 24 hours

    // File Paths
    public static final String CONFIG_FILE_PATH = "/etc/app/config.yaml";
    public static final String LOG_FILE_PATH = "/var/log/app.log";

    // Feature Flags
    public static final boolean FEATURE_X_ENABLED = true;
}
