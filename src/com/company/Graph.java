package com.company;
import java.util.*;

public class Graph {
    Map<Integer,Vertex> vetexs ;

    public Graph() {
        this.vetexs = new HashMap<>();
    }

    public Map<Integer,Vertex> getVetexs() {
        return vetexs;
    }


    public void addVertex(int value) {
        Vertex v = new Vertex(value);
        vetexs.put(value,v);
    }
    public void adEdge(int start, int end, int weight) {
        Vertex vFrom = vetexs.get(start);
        Vertex vTo = vetexs.get(end);
        Edege e = new Edege(vFrom,vTo,weight);
        vFrom.addEdge(e);
    }
    public void dfs(int value) {
        Vertex v = vetexs.get(value);
        Set<Vertex>visited = new HashSet<>();
        dfs(v, visited);
        System.out.println();
    }

    private void dfs(Vertex v, Set<Vertex> visited) {
        System.out.print(v.value+" ");
        visited.add(v);
        for (Edege edge : v.edges) {
            if(!visited.contains(edge.end)) {
                visited.add(edge.end);
                dfs(edge.end,visited);
            }
        }

    }

    public void bfs(int value) {
        Vertex v = vetexs.get(value);
        Set<Vertex>visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        bfs(visited,queue);
        System.out.println();
    }

    private void bfs(Set<Vertex> visited, Queue<Vertex> queue) {
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (!visited.contains(v)) {
                System.out.print(v.value+" ");
                visited.add(v);
                for (Edege edege : v.edges) {
                    if (!visited.contains(edege.end)) {
                        queue.add(edege.end);
                    }
                }
            }

        }
    }

    public void dijikastra(int source, int destination) {
        dijikastra(vetexs.get(source), vetexs.get(destination));
    }

    private void dijikastra(Vertex source, Vertex destination) {
        System.out.println();
        Set<Vertex> added = new HashSet<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>((x,y)->(x.cost.compareTo(y.cost)));
        Set<Vertex> visited = new HashSet<>();
        source.cost=0;
        pq.add(source);
        while(!pq.isEmpty()) {
            Vertex v = pq.poll();
            if (v.equals(destination)) {
                print(source,destination);
                return;
            }
            if(!visited.contains(v)) {
                visited.add(v);
                for (Edege edege :  v.edges) {
                    if (!visited.contains(edege.end)) {
                        int cost = v.cost+edege.weight;
                        if (cost<edege.end.cost) {
                            edege.end.cost=cost;
                            edege.end.prev=v;
                        }
                        if (!added.contains(edege.end)) {
                            pq.add(edege.end);
                            added.add(edege.end);
                        }

                    }
                }
            }

        }
    }

    private void print(Vertex source, Vertex temp) {
        if(temp== null) {
            return;
        }
        if(temp==source){
            System.out.print(temp.value+" ");
            return;
        }
        print(source,temp.prev);
        System.out.print(temp.value+" ");
    }
}

class Vertex {
    int value;
    Set<Edege> edges;
    Integer cost=Integer.MAX_VALUE;
    Vertex prev=null;
    public Vertex(int value) {
        this.value = value;
        edges = new HashSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;

        Vertex _obj = (Vertex) obj;
        return _obj.value == value;
    }

    @Override
    public int hashCode() {
        return value;
    }
    public void addEdge(Edege edege) {
        edges.add(edege);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Edege> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edege> edges) {
        this.edges = edges;
    }
}

class Edege {
    Vertex start;
    Vertex end;
    int weight=1;

    public Edege(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    public Edege(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Edege)) return false;

        Edege _obj = (Edege) obj;
        return _obj.start.equals(start) && _obj.end.equals(end) &&
                _obj.weight == weight;
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result +end.hashCode();
        result = 31 * result + weight;
        return result;
    }
}