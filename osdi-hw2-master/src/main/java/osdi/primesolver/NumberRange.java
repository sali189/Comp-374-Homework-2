package osdi.primesolver;

import java.util.Iterator;

/*
 * You may modify this as you see fit
 */
/*
 * you may not use anything in java.util.concurrent.* you may only use locks from osdi.locks.*
 */
public class NumberRange implements Iterable<Long> {
    private final long maxValue;
    private final long startValue;

    public NumberRange(long startValue, long maxValue) {
        this.startValue = startValue;
        this.maxValue = maxValue;
    }

    @Override
    public Iterator<Long> iterator() {
        return new NumberIterator(startValue, maxValue);
    }

    private static class NumberIterator implements Iterator<Long> {
        private final long maxValue;
        private long currentValue;

        private NumberIterator(long startValue, long maxValue) {
            this.maxValue = maxValue;
            this.currentValue = startValue;
        }

        @Override
        public boolean hasNext() {
            return currentValue < maxValue;
        }

        @Override
        public Long next() {
            return (currentValue < maxValue) ? Long.MIN_VALUE : ++currentValue;
        }
    }
}
