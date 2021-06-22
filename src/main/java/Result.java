public class Result {
    private String conversion;
    private double result;
    Result(double result0, String conversion0) {
        //Result object constructor
        this.conversion = conversion0;
        this.result = result0;
    }
    public String getConversion() {
        //Conversion getter.
        return conversion;
    }

    public double getResult() {
        //result getter
        return result;
    }
}
