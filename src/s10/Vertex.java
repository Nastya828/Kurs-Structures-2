package s10;

import java.util.ArrayList;
import java.util.Collections;


class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }
}


class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        Vertex node = new Vertex(value);
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = node;
                return;
            }
        }
    }


    public void RemoveVertex(int v) {

        if (v >= vertex.length) {
            return;
        }
        vertex[v] = null;
        for (int i = 0; i < m_adjacency.length; i++) {
            m_adjacency[i][v] = 0;
        }
        for (int i = 0; i < m_adjacency[0].length; i++) {
            m_adjacency[v][i] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {

        if (v1 >= vertex.length || v2 >= vertex.length) {
            return false;
        }
        return m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2) {

        if (IsEdge(v1, v2)) {
            return;
        }
        if (v1 < vertex.length && v2 < vertex.length) {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
    }


    public void RemoveEdge(int v1, int v2) {
        if (!IsEdge(v1, v2)) {
            return;
        }
        if (v1 < vertex.length && v2 < vertex.length) {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {

        if (VFrom >= vertex.length || VTo >= vertex.length) {
            return new ArrayList<>();
        }
        ArrayList<Vertex> stackForWay = new ArrayList<>();
        clearVertexHits();

//        if (!IsEdge(VFrom, VTo) && VFrom == VTo) {
//            return stackForWay;
//        }
        if (VFrom == VTo && IsEdge(VFrom, VTo)) {
            stackForWay.add(vertex[VFrom]);
            stackForWay.add(vertex[VTo]);
            return stackForWay;
        }
        if (!dfs(stackForWay, VFrom, VTo)) {
            return new ArrayList<>();
        }
        stackForWay.add(vertex[VFrom]);
        Collections.reverse(stackForWay);
        return stackForWay;
    }

    private boolean dfs(ArrayList<Vertex> list, int VFrom, int VTo) {
        if (vertex[VFrom] == vertex[VTo]) {
            return true;
        }
        vertex[VFrom].Hit = true;
        for (Integer v : listVertexD(VFrom)) {
            if (!vertex[v].Hit) {
                if (dfs(list, v, VTo)) {
                    list.add(vertex[v]);
                    return true;
                }
            }
        }
        return false;
    }


    private ArrayList<Integer> listVertexD(int v) {
        ArrayList<Integer> listVertex = new ArrayList<>();
        for (int i = 0; i < m_adjacency.length; i++) {
            if (m_adjacency[i][v] == 1 && !vertex[i].Hit) {
                listVertex.add(i);
            }
        }
        return listVertex;
    }

    private void clearVertexHits() {
        for (Vertex v : vertex) {
            v.Hit = false;
        }
    }


    @Override
    public String toString() {
        System.out.println("SimpleGraph{");
        for (int i = 0; i < m_adjacency.length; i++) {
            System.out.print((i) + ":");
            for (int j = 0; j < m_adjacency[0].length; j++) {
                System.out.print(m_adjacency[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("vertex = ");
        for (Vertex node : vertex) {
            if (node != null) {
                System.out.print(node.Value + ", ");
            } else {
                System.out.print(null + ", ");
            }
        }
        return "max_vertex = " + max_vertex +
                '}';
    }
}

