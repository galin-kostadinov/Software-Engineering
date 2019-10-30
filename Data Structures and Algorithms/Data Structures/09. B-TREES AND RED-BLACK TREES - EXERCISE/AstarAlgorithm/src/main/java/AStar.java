import java.util.*;

public class AStar {
    private char[][] maze;

    public AStar(char[][] map) {
        this.maze = map;
    }

    public static int getH(Node current, Node goal) {
        int deltaRow = Math.abs(current.getRow() - goal.getRow());
        int deltaCol = Math.abs(current.getCol() - goal.getCol());

        return deltaRow + deltaCol;
    }

    public Iterable<Node> getPath(Node start, Node goal) {
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        Map<Node, Node> parents = new HashMap<>();

        //Distance between start and current
        Map<Node, Integer> gCost = new HashMap<>();
        gCost.put(start, 0);
        parents.put(start, null);
        pQue.enqueue(start);

        while (pQue.size() > 0) {
            Node current = pQue.dequeue();

            if (current.equals(goal)) {
                break;
            }

            List<Node> neighborsNodes = this.GetNearbyNodes(current);

            int newCost = gCost.get(current) + 1;

            for (Node node : neighborsNodes) {
                if (!gCost.containsKey(node) || newCost < gCost.get(node)) {
                    node.setF(newCost + getH(node, goal));
                    parents.put(node, current);
                    gCost.put(node, newCost);
                    pQue.enqueue(node);
                }
            }
        }

        return this.reconstructPath(parents, start, goal);
    }

    private Iterable<Node> reconstructPath(Map<Node, Node> parents, Node start, Node goal) {
        ArrayDeque<Node> path = new ArrayDeque<>();

        if (!parents.containsKey(goal)) {
            path.add(start);
            return path;
        }

        Node current = parents.get(goal);

        path.push(goal);
        while (!current.equals(start)) {
            path.push(current);
            current = parents.get(current);
        }

        path.push(start);

        return path;
    }

    private List<Node> GetNearbyNodes(Node current) {
        int row = current.getRow();
        int col = current.getCol();

        int rowUp = row - 1;
        int rowDown = row + 1;
        int colLeft = col - 1;
        int colRight = col + 1;

        List<Node> result = new ArrayList<>();

        this.addToList(result, rowUp, col);
        this.addToList(result, rowDown, col);
        this.addToList(result, row, colLeft);
        this.addToList(result, row, colRight);

        return result;
    }

    private void addToList(List<Node> result, int row, int col) {
        if (isInBounds(row, col) && !isWall(row, col)) {
            Node newNode = new Node(row, col);
            result.add(newNode);
        }
    }

    private boolean isInBounds(int row, int col) {
        return (row >= 0 && row < this.maze.length) &&
                (col >= 0 && col < this.maze[row].length);
    }

    private boolean isWall(int row, int col) {
        return this.maze[row][col] == 'W';
    }
}
