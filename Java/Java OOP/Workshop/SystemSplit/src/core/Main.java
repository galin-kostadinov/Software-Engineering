package core;

import core.engine.Engine;
import core.system.DumpExtension;
import core.system.SystemSplit;
import io.reader.ConsoleReader;
import io.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        SystemSplit systemSplit = new DumpExtension();
        Engine engine = new Engine(systemSplit, reader);
        engine.run();
    }
}
