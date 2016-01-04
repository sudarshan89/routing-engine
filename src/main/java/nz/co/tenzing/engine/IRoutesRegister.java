package nz.co.tenzing.engine;

import java.util.Collection;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
public interface IRoutesRegister<T extends IRoute> {

    IRoutesRegister addRoute(T route);

    Collection<T> getRoutes();
}
