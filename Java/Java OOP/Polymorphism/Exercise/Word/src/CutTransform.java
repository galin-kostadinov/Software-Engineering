public class CutTransform implements TextTransform {
    StringBuilder clipboard;

    public StringBuilder getClipboard() {
        return this.clipboard;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.clipboard = new StringBuilder();
        clipboard.append(text, startIndex, endIndex);

        text.delete(startIndex, endIndex);
    }
}

