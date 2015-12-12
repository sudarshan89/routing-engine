package nz.co.iag.engine;

/**
 * Created by si556244 on 19/11/2015.
 */
class CustomerInformationManagementRouter {

    IRoutingEngine routingEngine;

    public void init() {
        routingEngine = new RoutesConfiguration().getRouteEngine();
    }

    public Endpoint route(String soapAction) {
        Endpoint endpoint = routingEngine.selectEndpoint(soapAction, "samplePayload", true);
        return endpoint;
    }
}
