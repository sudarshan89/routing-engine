package nz.co.tenzing.engine;

import java.util.function.Predicate;

/**
 * Created by s.sreenivasan on 11/19/2015.
 */
class ComplexContentCriteria implements Predicate<RequestHolder> {
    @Override
    public boolean test(RequestHolder input) {
        return false;
    }
}
