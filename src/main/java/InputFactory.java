public class InputFactory {
    public static Coin coinType(Coins choice){
        //Implementing the calculation according to the user's choice.
        return switch (choice) {
            case ILS -> new ILS();
            case USD -> new USD();
            case EUR -> new EUR();
        };
    }
}
