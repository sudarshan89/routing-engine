package nz.co.iag.example;

import com.google.common.base.Predicates;
import nz.co.iag.engine.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
public class RoutesConfiguration implements IRoutesConfiguration{

    IRoutingEngine routingEngine;

    public void init() throws MalformedURLException {

        /**
         * All the endpoints are defined here
         */
        Endpoint huonEndpoint = Endpoint.withURL(new URL("huon"));
        Endpoint exigenEndpoint = Endpoint.withURL(new URL("exigen"));
        Endpoint amigoEndpoint = Endpoint.withURL(new URL("amigo"));

        /**
         * Create the routes register using the endpoints defined above and the criteria's
         */
        IRoutesRegister routesRegister = RoutesRegister.newRegister()
                .addRoute(Route.newRoute(huonEndpoint, new SoapActionCriteria("simpleHUONSOAPAction")))
                .addRoute(Route.newRoute(exigenEndpoint, new SoapActionCriteria("simpleExigenSOAPAction")))
                .addRoute(Route.newRoute(amigoEndpoint, new SoapActionCriteria("simpleAmigoSOAPAction")))
                .addRoute(Route.newRoute(amigoEndpoint, new ComplexContentCriteria()))
                .addRoute(Route.newRoute(amigoEndpoint, Predicates.and(new SoapActionCriteria("AndExample"),new ComplexContentCriteria())))
                .addRoute(Route.newRoute(amigoEndpoint, Predicates.or(new SoapActionCriteria("OrExample"),new ComplexContentCriteria())));

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
