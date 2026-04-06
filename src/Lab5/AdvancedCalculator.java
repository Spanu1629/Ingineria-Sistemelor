package Lab5;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int state) {
        super(state);
    }

    public AdvancedCalculator divide(int value) {
        state = state / value;
        return this;
    }

    public AdvancedCalculator power(int value) {
        state = (int) Math.pow(state, value);
        return this;
    }

    public AdvancedCalculator root(int value) {
        state = (int) Math.pow(state, 1.0 / value);
        return this;
    }

    @Override
    public AdvancedCalculator add(int value) {
        state = state + value;
        return this;
    }

    @Override
    public AdvancedCalculator subtract(int value) {
        state = state - value;
        return this;
    }

    @Override
    public AdvancedCalculator multiply(int value) {
        state = state * value;
        return this;
    }

    @Override
    public AdvancedCalculator clear() {
        state = 0;
        return this;
    }
}