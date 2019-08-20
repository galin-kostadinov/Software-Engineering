package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lights = reader.readLine().split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[lights.length];

        for (int i = 0; i < trafficLights.length; i++) {
            trafficLights[i] = TrafficLight.valueOf(lights[i]);
        }

        int n = Integer.parseInt(reader.readLine());

        TrafficLight[] lightsValues = {TrafficLight.RED, TrafficLight.GREEN, TrafficLight.YELLOW};

        StringBuilder output = new StringBuilder();
        while (n-- > 0) {
            for (int j = 0; j < trafficLights.length; j++) {
                int nextIndex = (trafficLights[j].getValue() + 1) % 3;
                trafficLights[j] = lightsValues[nextIndex];
                output.append(trafficLights[j].toString() + " ");
            }
            output.append(System.lineSeparator());
        }

        System.out.println(output);
    }
}
