package s10;


public class Task10 {
    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(5);
        System.out.println(graph);
        for (int i = 0; i < graph.max_vertex; i++) {
            graph.AddVertex(i);
        }
        //graph.AddEdge(0, 0);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);

        System.out.println(graph);

        for(Vertex i : graph.DepthFirstSearch(4,0)){
            System.out.print(i.Value + " ");

        }


//        if(graph.DepthFirstSearch(3,1).isEmpty()){
//            System.out.println(graph.DepthFirstSearch(3, 1));
//        }
    }
}
