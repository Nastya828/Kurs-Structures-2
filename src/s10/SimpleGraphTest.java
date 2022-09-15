package s10;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;


class SimpleGraphTest {

    @org.junit.jupiter.api.Test
    void depthFirstSearch() {
        ArrayList<Vertex> list = new ArrayList<>();
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 3);
        graph.AddEdge(2, 2);
        graph.AddEdge(0, 0);
        graph.AddEdge(4, 3);
        for (int i = 0; i < graph.max_vertex; i++) {
            graph.AddVertex(i + 100);
        }

        list.add(new Vertex(100));
        list.add(new Vertex(100));
//        list.add(new Vertex(100));
//
        for (int i = 0; i < list.size(); i++) {

            Assertions.assertTrue(list.get(i).Value == graph.DepthFirstSearch(0, 0).get(i).Value);
        }

        ArrayList<Vertex> list2 = new ArrayList<>();
        list2.add(new Vertex(101));
        list2.add(new Vertex(103));
        list2.add(new Vertex(104));

        for (int i = 0; i < list.size(); i++) {
            Assertions.assertTrue(list2.get(i).Value == graph.DepthFirstSearch(1, 4).get(i).Value);
        }

    }
}