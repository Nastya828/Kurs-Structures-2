package s11;

public class Task11 {
    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(5);
        System.out.println(graph);
        for (int i = 0; i < graph.max_vertex; i++) {
            graph.AddVertex(i+100);
        }
        graph.AddEdge(0,1);
        graph.AddEdge(0,2);
        graph.AddEdge(0,3);
        graph.AddEdge(1,0);
        graph.AddEdge(1,3);
        graph.AddEdge(1,4);
        graph.AddEdge(2,0);
        graph.AddEdge(2,3);
        graph.AddEdge(3,0);
        graph.AddEdge(3,1);
        graph.AddEdge(3,2);
        graph.AddEdge(3,3);
        graph.AddEdge(3,4);
        graph.AddEdge(4,1);
        graph.AddEdge(4,3);


        System.out.println(graph);
        int n = 0;
        int m = 1;
        System.out.println("From " + n + " to " + m);
        for(Vertex i : graph.BreadthFirstSearch(n,m)){
            System.out.print(i.Value + " ");
        }
        System.out.println();
        for(Vertex i : graph.BreadthFirstSearch(m,n)){
            System.out.print(i.Value + " ");
        }

        System.out.println("\nFrom " + 0 + " to " + 3);
        for(Vertex i : graph.BreadthFirstSearch(0,3)){
            System.out.print(i.Value + " ");
        }
        System.out.println();
        for(Vertex i : graph.BreadthFirstSearch(3,0)){
            System.out.print(i.Value + " ");
        }

        System.out.println("\nFrom " + 0 + " to " + 2);
        for(Vertex i : graph.BreadthFirstSearch(0,2)){
            System.out.print(i.Value + " ");
        }
        System.out.println();
        for(Vertex i : graph.BreadthFirstSearch(2,0)){
            System.out.print(i.Value + " ");
        }

        System.out.println("\nFrom " + 0 + " to " + 4);
        for(Vertex i : graph.BreadthFirstSearch(0,4)){
            System.out.print(i.Value + " ");
        }
        System.out.println();
        for(Vertex i : graph.BreadthFirstSearch(4,0)){
            System.out.print(i.Value + " ");
        }

        System.out.println("\nFrom " + 1 + " to " + 2);
        for(Vertex i : graph.BreadthFirstSearch(1,2)){
            System.out.print(i.Value + " ");
        }
        System.out.println();
        for(Vertex i : graph.BreadthFirstSearch(2,1)){
            System.out.print(i.Value + " ");
        }

        System.out.println("\nFrom " + 4 + " to " + 3);
        for(Vertex i : graph.BreadthFirstSearch(4,3)){
            System.out.print(i.Value + " ");
        }
        System.out.println();
        for(Vertex i : graph.BreadthFirstSearch(3,4)){
            System.out.print(i.Value + " ");
        }

    }
}
