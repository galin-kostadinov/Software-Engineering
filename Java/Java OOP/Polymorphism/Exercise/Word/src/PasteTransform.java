import java.util.function.Function;

public class PasteTransform implements TextTransform {
    private CutTransform cutTransform;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, this.cutTransform.getClipboard().toString());
    }

    public PasteTransform(CutTransform cutTransform) {
        this.cutTransform = cutTransform;
    }
}
