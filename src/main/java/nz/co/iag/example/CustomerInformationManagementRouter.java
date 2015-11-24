package nz.co.iag.example;

import nz.co.iag.engine.Endpoint;
import nz.co.iag.engine.IRoutingEngine;
import nz.co.iag.engine.SimpleRoutingEngine;

import java.net.MalformedURLException;

/**
 * Created by si556244 on 19/11/2015.
 */
public class CustomerInformationManagementRouter {

    IRoutingEngine routingEngine;

    public void init() {
        routingEngine = new RoutesConfiguration().getRouteEngine();
    }

    public Endpoint route(String soapAction) {
        Endpoint endpoint = routingEngine.selectEndpoint(soapAction, "samplePayload", true);
        return endpoint;
    }
}
