package s10;


public class Task10 {
    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(5);
        System.out.println(graph);
        for (int i = 0; i < graph.max_vertex; i++) {
            graph.AddVertex(i+100);
        }
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 2);
        //graph.AddEdge(0, 0);
        graph.AddEdge(4, 3);


        System.out.println(graph);
        int n = 0;
        int m = 0;
        System.out.println("From " + n + " to " + m);
        for(Vertex i : graph.DepthFirstSearch(n,m)){
            System.out.print(i.Value + " ");
        }


//        if(graph.DepthFirstSearch(3,1).isEmpty()){
//            System.out.println(graph.DepthFirstSearch(3, 1));
//        }
    }
}
