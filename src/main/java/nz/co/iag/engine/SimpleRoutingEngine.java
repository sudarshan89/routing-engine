package nz.co.iag.engine;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

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
        List<Endpoint> candidateEndpoints = Lists.newArrayList();
        for(IRoute route : routes){
            Optional<Endpoint> endpointOptional = route.isSatisfiedBy(soapAction, payload);
            if(endpointOptional.isPresent()){
                candidateEndpoints.add(endpointOptional.get());
                if(isStrict && candidateEndpoints.size()>1){
                    throw new TooManyMatchingRoutesException();
                }
            }
        }
        if(candidateEndpoints.isEmpty()){
            throw new NoMatchingRoutesFoundException();
        }
        return candidateEndpoints.get(0);
    }
}
