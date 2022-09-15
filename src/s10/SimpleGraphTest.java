package s10;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;


class SimpleGraphTest {

    @org.junit.jupiter.api.Test
    void depthFirstSearch() {

        SimpleGraph graph = new SimpleGraph(5);
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

        graph.vertex[0] = new Vertex(100);
        graph.vertex[1] = new Vertex(101);
        graph.vertex[2] = new Vertex(102);
        graph.vertex[3] = new Vertex(103);
        graph.vertex[4] = new Vertex(104);


        ArrayList<Vertex> listForTest = graph.DepthFirstSearch(0, 4);

       Assertions.assertTrue(listForTest.size() == 4);
        Assertions.assertEquals(listForTest.get(0), graph.vertex[0]);
       Assertions.assertTrue(listForTest.get(1).Value == 101);
       Assertions.assertTrue(listForTest.get(2).Value == 103);
       Assertions.assertTrue(listForTest.get(3).Value == 104);


        ArrayList<Vertex> listForTest1 = graph.DepthFirstSearch(0, 0);
        Assertions.assertTrue(listForTest1.size() == 1);
        Assertions.assertEquals(listForTest.get(0), graph.vertex[0]);

    }
}