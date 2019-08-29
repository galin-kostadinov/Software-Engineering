import loggerlib.layout.SimpleLayout;
import loggerlib.layout.interfeces.Layout;

public class Main {
    public static void main(String[] args) {

        Layout layout = new SimpleLayout();
        System.out.println(
                layout.format("3/26/2015 2:08:11 PM",
                "ERROR",
                "Error parsing JSON."));
    }
}
