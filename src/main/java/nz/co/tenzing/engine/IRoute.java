package nz.co.tenzing.engine;

/**
 * Created by si556244 on 19/11/2015.
 */
public interface IRoute {

    boolean isSatisfiedBy(String soapAction, String payload);
    Endpoint getEndpoint();
}
