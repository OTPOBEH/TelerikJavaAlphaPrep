import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ChervenataShapchica {
    private static boolean[] visited;
    private static int maxIndex;
    private static int[] money;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nodesNumberINput = reader.readLine();

        String[] inputCoinsByNode = reader.readLine().split(" ");

        int nodeNumber = inputCoinsByNode.length;

        //Indexing nodes:
        Node[] nodes = new Node[nodeNumber + 1]; //Nodes are 1-N, so index 0 will be empty
        for (int i = 0; i < inputCoinsByNode.length; i++) {
            nodes[i + 1] = new Node(i + 1, Integer.parseInt(inputCoinsByNode[i]));//Nodes are 1-N, so index 0 will be empty
        }

        for (int i = 0; i < nodeNumber - 1; i++) {
            String[] edgeInput = reader.readLine().split(" ");

            int firstEnd = Integer.parseInt(edgeInput[0]);
            int secondEnd = Integer.parseInt(edgeInput[1]);

            nodes[firstEnd].neighbours.add(nodes[secondEnd]);
            nodes[secondEnd].neighbours.add(nodes[firstEnd]);
        }

        visited = new boolean[nodeNumber + 1];
        money = new int[nodeNumber + 1];

        dfs(nodes[1]);

        // money = new int[nodeNumber + 1];

        visited = new boolean[nodeNumber + 1];

        money[maxIndex] = nodes[maxIndex].coins;

        dfs(nodes[maxIndex]);

        System.out.println(max);
    }

    private static void dfs(Node node) {
        if (visited[node.index]) return;

        visited[node.index] = true;

        for (Node neighbour : node.neighbours) {
            if(!visited[neighbour.index]){
                money[neighbour.index] = money[node.index] + neighbour.coins;

                if (money[neighbour.index] > max) {
                    maxIndex = neighbour.index;
                    max = money[neighbour.index];
                }
                dfs(neighbour);
            }
        }
    }

    static class Node {
        int index;
        Set<Node> neighbours = new HashSet<>();
        int coins;

        Node(int index, int coins) {
            this.index = index;
            this.coins = coins;
        }
    }
}