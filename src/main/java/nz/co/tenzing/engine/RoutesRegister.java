package nz.co.tenzing.engine;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
public class RoutesRegister implements IRoutesRegister<Route> {

    private Collection<Route> routes = Lists.newArrayList();

    public static RoutesRegister newRegister(){
        return new RoutesRegister();
    }

    @Override
    public RoutesRegister addRoute(Route route){
        routes.add(route);
        return this;
    }

    @Override
    public Collection<Route> getRoutes() {
        return routes;
    }
}
