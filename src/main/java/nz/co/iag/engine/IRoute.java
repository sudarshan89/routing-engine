package nz.co.iag.engine;

import com.google.common.base.Optional;

/**
 * Created by si556244 on 19/11/2015.
 */
public interface IRoute {

    Optional<Endpoint> isSatisfiedBy(String soapAction, String payload);
}
