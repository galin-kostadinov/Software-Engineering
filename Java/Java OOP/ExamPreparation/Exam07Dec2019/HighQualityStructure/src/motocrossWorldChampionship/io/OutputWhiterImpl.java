package motocrossWorldChampionship.io;

import motocrossWorldChampionship.io.interfaces.OutputWriter;

public class OutputWhiterImpl implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
