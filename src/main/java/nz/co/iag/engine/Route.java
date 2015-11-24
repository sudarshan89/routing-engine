package nz.co.iag.engine;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

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
    public Optional<Endpoint> isSatisfiedBy(String soapAction, String payload) {
        if (criteria.apply(new RequestHolder(soapAction, payload)))
            return Optional.of(endpoint);
        else
            return Optional.absent();
    }
}
