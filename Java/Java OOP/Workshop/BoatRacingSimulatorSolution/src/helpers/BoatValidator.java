package helpers;

public class BoatValidator {
    public static boolean validateModel(String model) {
        return model.length() >= 5;
    }

    public static boolean validateParam(int param) {
        return param > 0;
    }

    public static boolean validateSailEfficiency(int efficiency) {
        return efficiency > 0 && efficiency < 101;
    }
}