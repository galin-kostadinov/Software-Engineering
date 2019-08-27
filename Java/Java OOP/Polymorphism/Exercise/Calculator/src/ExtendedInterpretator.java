import java.util.ArrayDeque;

public class ExtendedInterpretator extends InputInterpreter {
    private ArrayDeque<Integer> memory;

    public ExtendedInterpretator(CalculationEngine engine) {
        super(engine);
        this.memory = new ArrayDeque<>();
    }

    @Override
    public Operation getOperation(String operand) {
        Operation operation = super.getOperation(operand);

        if (operation == null) {
            if (operand.equals("/")) {
                return new DivisionOperation();
            } else if (operand.equals("ms")) {
                return new MemorySaveOperation(this.memory);
            } else if (operand.equals("mr")) {
                return new MemoryRecallOperation(this.memory);
            }
        }

        return operation;
    }
}
