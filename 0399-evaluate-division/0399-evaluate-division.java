import java.util.*;
import java.util.Map.*;
import java.util.concurrent.atomic.*;
class Solution {
    
      public static void createGraph(List<List<String>> equations, double[] values, HashMap<String, HashMap<String, Double>> graph)
    {
        AtomicInteger count = new AtomicInteger(0);
        equations.stream().forEach(
                res -> {
                    String from = res.get(0);
                    String to =res.get(1);
                    int counter = count.getAndIncrement();
                    if(graph.get(from) == null)
                    {
                        HashMap<String, Double> map = new HashMap<>();
                        map.put(to, values[counter]);
                        graph.put(from, map);
                    }
                    else {
                        HashMap<String, Double> map = graph.get(from);
                        map.put(to, values[counter]);
                        graph.put(from, map);
                    }

                    // bi-directional graph creation with opposite side having edge as 1/value
                    HashMap<String, Double> map;
                    if(graph.get(to) == null){
                        map = new HashMap<>();
                        map.put(from, 1/values[counter]);
                        graph.put(to, map);
                    }
                    else {
                        map = graph.get(to);
                        map.put(from, 1/values[counter]);
                        graph.put(to, map);
                    }
                }
        );
    }

    public static Double DFS(HashMap<String, HashMap<String, Double>> graph, String src, String des)
    {
        HashSet<String> visited =  new HashSet<>();
        HashMap<String, Double> vertices = graph.get(src);
        HashMap<String, String> parent = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();

        if(vertices == null) return Double.valueOf(-1);
        stack.push(src);

        while (!stack.isEmpty())
        {
            String u = stack.pop();
            vertices = graph.get(u); // get out edges of u
            if(vertices == null) return Double.valueOf(-1);
            for(Entry<String, Double> entry: vertices.entrySet()){
                if(des.equals(entry.getKey())){
                    String from = entry.getKey();
                    String to = u;
                    Double result = 1d;

                    while (!src.equals(from))
                    {
                        result *= graph.get(from).get(to);
                        from = to;
                        to = parent.get(to);
                    }
                    parent.put(entry.getKey(), u);
                    return 1/result;
                }
                if(!visited.contains(entry.getKey()))
                {
                    stack.push(entry.getKey());
                    parent.put(entry.getKey(), u);
                    visited.add(entry.getKey());
                }

            }
        }

        return Double.valueOf(-1);
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        createGraph(equations, values, graph);
        double res[] = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++)
        {
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);
            res[i] = DFS(graph, src, des);
        }
        return res;
        
    }
}