import java.util.List;

public abstract class ArithmeticOperation implements Operation{
    protected List<Integer> operands;
    private int result;

    public ArithmeticOperation(List<Integer> operands, int result) {
        this.operands = operands;
        this.result = result;
    }
}
