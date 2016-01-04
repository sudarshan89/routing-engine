package nz.co.tenzing.engine;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by si556244 on 19/11/2015.
 */
public class Endpoint {

    private URL url;
    private String username;
    private String password;
    private String domain;
    private String token;

    Endpoint(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public Endpoint(URL url) {
        this.url = url;
    }

    public static Endpoint withURL(URL url) throws MalformedURLException {
        return new Endpoint(url);
    }

    public URL getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDomain() {
        return domain;
    }

    public String getToken() {
        return token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
