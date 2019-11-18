package loggerlib.parsecommand;

import loggerlib.layout.SimpleLayout;
import loggerlib.layout.XmlLayout;
import loggerlib.layout.interfeces.Layout;

public class LayoutParser {
    public static Layout createLayout(String type) {
        Layout layout = null;

        if (type.equals("SimpleLayout")) {
            layout = new SimpleLayout();
        } else if (type.equals("XmlLayout")) {
            layout = new XmlLayout();
        }

        return layout;
    }
}
