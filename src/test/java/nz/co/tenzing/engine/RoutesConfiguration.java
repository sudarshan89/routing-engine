package nz.co.tenzing.engine;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
class RoutesConfiguration implements IRoutesConfiguration{

    IRoutingEngine routingEngine;

    public RoutesConfiguration() {
        try {
            init();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() throws MalformedURLException {

        /**
         * All the endpoints are defined here
         */
        Endpoint huonEndpoint = Endpoint.withURL(new URL("http:\\www.huon.com"));
        Endpoint exigenEndpoint = Endpoint.withURL(new URL("http:\\www.exigen.com"));
        Endpoint amigoEndpoint = Endpoint.withURL(new URL("http:\\www.amigo.com"));

        Endpoint secondAmigoEndpoint = Endpoint.withURL(new URL("http:\\www.amigotwo.com"));
        /**
         * Create the routes register using the endpoints defined above and the criteria's
         */
        IRoutesRegister routesRegister = RoutesRegister.newRegister()
                .addRoute(Route.newRoute(huonEndpoint, new SoapActionCriteria("simpleHUONSOAPAction")))
                .addRoute(Route.newRoute(exigenEndpoint, new SoapActionCriteria("simpleExigenSOAPAction")))
                .addRoute(Route.newRoute(amigoEndpoint, new SoapActionCriteria("simpleAmigoSOAPAction")))
                .addRoute(Route.newRoute(amigoEndpoint, new ComplexContentCriteria()))
                .addRoute(Route.newRoute(amigoEndpoint, new SoapActionCriteria("simpleAmigoSOAPAction").and(new ComplexContentCriteria())))
                .addRoute(Route.newRoute(secondAmigoEndpoint, new SoapActionCriteria("simpleAmigoSOAPAction").or(new ComplexContentCriteria())));

        /**
         * Use the routes register to create a routing engine
         */
        routingEngine = new SimpleRoutingEngine(routesRegister);

    }

    @Override
    public IRoutingEngine getRouteEngine() {
        return routingEngine;
    }


}
