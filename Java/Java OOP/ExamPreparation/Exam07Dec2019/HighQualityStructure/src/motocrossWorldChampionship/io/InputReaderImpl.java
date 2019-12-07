package motocrossWorldChampionship.io;

import motocrossWorldChampionship.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {
    BufferedReader bufferedReader;

    public InputReaderImpl() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}
