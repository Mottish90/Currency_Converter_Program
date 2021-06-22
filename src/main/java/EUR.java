public class EUR extends Coin{
    final double value = 4.23;
    @Override
    //Value getter
    public double getValue(){
        return value;
    }
    @Override
    //The actual calculator
    public double calculate(double input){
        return  input * getValue();
    }
}
