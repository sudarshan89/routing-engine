package nz.co.tenzing.engine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
public class SimpleRoutingEngineTest {

    @Test(expected = TooManyMatchingRoutesException.class)
    public  void givenEngineIsInStrictModel_whenEngineDetectsMultipleMatchingRoutes_itShouldThrowTooManyMatchingRoutesException(){
        IRoutesConfiguration routesConfiguration = new RoutesConfiguration();
        final IRoutingEngine routeEngine = routesConfiguration.getRouteEngine();
        routeEngine.selectEndpoint("simpleAmigoSOAPAction","dummyPayload",true);
    }

    @Test
    public  void givenEngineIsInLenientModel_whenEngineDetectsMultipleMatchingRoutes_itShouldReturnFirstSelectedRoute(){
        IRoutesConfiguration routesConfiguration = new RoutesConfiguration();
        final IRoutingEngine routeEngine = routesConfiguration.getRouteEngine();
        final Endpoint selectedEndpoint = routeEngine.selectEndpoint("simpleAmigoSOAPAction", "dummyPayload", false);
        assertThat(selectedEndpoint.getUrl().toString()).contains("amigo.com");


    }

    @Test(expected = NoMatchingRoutesFoundException.class)
    public  void whenEngineDetectsNoMatchingRoutes_itShouldThrowNoMatchingRoutesException(){
        IRoutesConfiguration routesConfiguration = new RoutesConfiguration();
        final IRoutingEngine routeEngine = routesConfiguration.getRouteEngine();
        routeEngine.selectEndpoint("simplePulseSOAPAction", "dummyPayload", false);
    }

    @Test
    public  void whenEngineDetectsExactlyOneMatchingRoute_itShouldReturnMatchedRoute(){
        IRoutesConfiguration routesConfiguration = new RoutesConfiguration();
        final IRoutingEngine routeEngine = routesConfiguration.getRouteEngine();
        final Endpoint selectedEndpoint = routeEngine.selectEndpoint("simpleHUONSOAPAction", "dummyPayload", true);
        assertThat(selectedEndpoint.getUrl().toString()).contains("huon.com");
    }

}