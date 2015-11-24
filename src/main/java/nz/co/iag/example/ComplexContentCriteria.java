package nz.co.iag.example;

import com.google.common.base.Predicate;
import nz.co.iag.engine.RequestHolder;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
public class ComplexContentCriteria implements Predicate<RequestHolder> {
    @Override
    public boolean apply(RequestHolder input) {
        return false;
    }
}
