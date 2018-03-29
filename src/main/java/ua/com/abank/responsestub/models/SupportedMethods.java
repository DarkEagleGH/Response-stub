package ua.com.abank.responsestub.models;

public enum SupportedMethods {
    ALL("ALL"),
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private String methodName;

    SupportedMethods(String methodName) {
        this.methodName = methodName;
    }

    public static SupportedMethods byName(String methodName) {
        return SupportedMethods.valueOf(methodName.toUpperCase());
    }

    public String toString() {
        return this.methodName;
    }
}
