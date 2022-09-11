package s08;

public class Task8 {

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(5);
        System.out.println(graph);
        for(int i = 1; i <= graph.max_vertex; i++){
            graph.AddVertex(i);
        }
        System.out.println(graph);
        graph.AddVertex(99);
        System.out.println(graph);
        System.out.println(graph.IsEdge(2, 3));

        graph.AddEdge(1,2);
        System.out.println(graph);
        System.out.println("1,2: " + graph.IsEdge(1, 2));
        graph.AddEdge(2,3);
        System.out.println(graph);
        System.out.println("2,3: " + graph.IsEdge(2, 3));
        graph.AddEdge(3,3);
        System.out.println(graph);
        System.out.println("3,3: " + graph.IsEdge(3, 3));
        graph.AddEdge(4,3);
        System.out.println(graph);
        System.out.println("4,3: " + graph.IsEdge(4, 3));
        graph.RemoveVertex(3);
        System.out.println(graph);
        graph.AddVertex(66);
        graph.AddEdge(4, 3);
        System.out.println(graph);
        graph.RemoveEdge(4,3);
        System.out.println(graph);
        graph.AddEdge(2,2);
        System.out.println(graph.IsEdge(2, 3));
        System.out.println(graph.IsEdge(2, 66));
        System.out.println(graph.IsEdge(2, 2));
        System.out.println(graph);




    }
}
