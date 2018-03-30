package ua.com.abank.responsestub.config;

public class Mapping {

    private String path;
    private int code;
    private String body;

    public String getPath() {
        return path;
    }

    void setPath(String path) {
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    void setBody(String body) {
        this.body = body;
    }
}
