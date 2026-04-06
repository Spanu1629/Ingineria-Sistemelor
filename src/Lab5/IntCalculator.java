package Lab5;

public class IntCalculator {
    protected int state;

    public IntCalculator(int state) {
        this.state = state;
    }

    public IntCalculator add(int value) {
        state = state + value;
        return this;
    }

    public IntCalculator subtract(int value) {
        state = state - value;
        return this;
    }

    public IntCalculator multiply(int value) {
        state = state * value;
        return this;
    }

    public int result() {
        return state;
    }

    public IntCalculator clear() {
        state = 0;
        return this;
    }
}