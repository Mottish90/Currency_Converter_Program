class USD extends Coin{
    final double value = 3.52;
    @Override
    //Value getter
    public double getValue(){
        return value;
    }
    @Override
    //The actual calculator
    public double calculate(double input){
        return input * getValue();
    }
}
