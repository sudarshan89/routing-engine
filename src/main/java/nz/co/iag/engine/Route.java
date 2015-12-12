package nz.co.iag.engine;


import java.util.function.Predicate;

/**
 * Created by si556244 on 19/11/2015.
 */
public final class Route implements IRoute {

    private Endpoint endpoint;
    private Predicate criteria;

    Route(Endpoint endpoint, Predicate criteria) {
        this.endpoint = endpoint;
        this.criteria = criteria;
    }

    public static Route newRoute(Endpoint endpoint, Predicate routeCriteria){
        return new Route(endpoint,routeCriteria);
    }

    @Override
    public boolean isSatisfiedBy(String soapAction, String payload) {
        return criteria.test(new RequestHolder(soapAction, payload));
    }

    @Override
    public Endpoint getEndpoint(){
        return endpoint;
    }
}
