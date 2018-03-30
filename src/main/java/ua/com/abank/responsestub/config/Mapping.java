package ua.com.abank.responsestub.config;

import ua.com.abank.responsestub.models.SupportedMethods;

public class Mapping {
//    private SupportedMethods method;
    private String path;
    private int code;
    private String data;

//    public SupportedMethods getMethod() {
//        return method;
//    }

//    public void setMethod(String method) {
//        this.method = SupportedMethods.byName(method);
//    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
