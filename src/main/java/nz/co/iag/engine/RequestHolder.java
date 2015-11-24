package nz.co.iag.engine;

/**
 * Created by si556244 on 19/11/2015.
 */
public class RequestHolder {

    private String soapAction;
    private String payload;

    public RequestHolder(String soapAction, String payload) {
        this.soapAction = soapAction;
        this.payload = payload;
    }

    public String getSoapAction() {
        return soapAction;
    }

    public String getPayload() {
        return payload;
    }
}
