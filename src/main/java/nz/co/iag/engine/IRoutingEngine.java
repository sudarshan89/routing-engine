package nz.co.iag.engine;

/**
 * Created by si556244 on 19/11/2015.
 */
public interface IRoutingEngine {

    Endpoint selectEndpoint(String soapAction,String payload,boolean isStrict);
}
