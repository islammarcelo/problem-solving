import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights,
 * together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops.
 * If there is no such route, output -1.
 */

public class Dijkstra {
    class Node{
        int city, cost, stop;

        public Node(int city, int cost, int stop) {
            this.city = city;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(flights.length == 0) return -1;

        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int [] flight: flights){
            if (!graph.containsKey(flight[0]))
                graph.put(flight[0], new ArrayList<int[]>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return getShortPath(graph, src, dst, K);
    }

    private int getShortPath(HashMap<Integer, List<int[]>> graph, int src, int dst, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b) -> (a.cost - b.cost));
        queue.add(new Node(src, 0, -1));
        while (!queue.isEmpty()){
            Node curr = queue.poll();

            if (curr.city == dst)
                return curr.cost;

            if (curr.stop < k){
                List<int[]> nexts = graph.getOrDefault(curr.city, new ArrayList<>());
                for (int[] next : nexts)
                    queue.add(new Node(next[0], curr.cost + next[1], curr.stop+1));
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int [][] array = {{0,1,100},{1,2,100},{0,2,500}};
        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.findCheapestPrice(3,array,0,2,1));
    }

}
