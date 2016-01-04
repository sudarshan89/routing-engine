package nz.co.tenzing.engine;

import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by si556244 on 19/11/2015.
 */
public class SimpleRoutingEngine implements IRoutingEngine {

    private IRoutesRegister routesRegister;

    public SimpleRoutingEngine(IRoutesRegister routesRegister) {
        this.routesRegister = routesRegister;
    }

    @Override
    public Endpoint selectEndpoint(String soapAction, String payload, boolean isStrict) {
        Collection<Route> routes = routesRegister.getRoutes();
        Preconditions.checkState(routes.size()>1);
        final List<Route> matchingRoutes = routes.stream().filter(candidateRoute ->
                candidateRoute.isSatisfiedBy(soapAction, payload)).collect(Collectors.toList());
        if(isStrict && matchingRoutes.size() > 1){
            throw new TooManyMatchingRoutesException();
        }
        else if(matchingRoutes.isEmpty()){
            throw new NoMatchingRoutesFoundException();
        }
        return matchingRoutes.get(0).getEndpoint();
    }
}
