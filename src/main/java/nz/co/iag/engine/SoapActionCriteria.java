package nz.co.iag.engine;

import com.google.common.base.Predicate;

/**
 * Created by si556244 on 19/11/2015.
 */
public class SoapActionCriteria implements Predicate<RequestHolder> {

    private String soapAction;

    public SoapActionCriteria(String soapAction) {
        this.soapAction = soapAction;
    }

    @Override public boolean apply(RequestHolder requestHolder) {
        return requestHolder.getSoapAction().equalsIgnoreCase(soapAction);
    }
}
