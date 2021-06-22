class ILS extends Coin {
    final double value = 0.28;
    @Override
    //Value getter
    public double getValue() {
        return value;
    }

    @Override
    //The actual calculator
    public double calculate(double input) {
        return input * getValue();
    }
}