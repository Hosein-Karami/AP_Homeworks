/**
 * this is Graph class to make and do diffrent work with a Double sided graph and saves information of it.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/10/2022
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph {
    private final HashMap<Integer, ArrayList<Integer>> informations = new HashMap<>();//for save vertex and their neighbors.

    /**
     * this method give a vertex number and add it to graph.
     * @param vertex : Vertex that should add to graph vertexes.
     */
    void addVertex(int vertex){
        informations.put(vertex,new ArrayList<>());
    }

    /**
     * this method give a start vertex and a destination vertex and add destination vertex to neighbors of start vertex.
     * @param source : this is the start vertex.
     * @param destination : this is destination vertex.
     */
    void addEdge(int source,int destination){
        informations.get(source).add(destination);
    }

    /**
     * this method give a start vertex and a destination vertex and delete destination vertex from neighbors of start vertex.
     * @param source : this is the start vertex.
     * @param destination : this is destination vertex.
     */
    void removeEdge(int source,int destination){
        informations.get(source).remove((Integer) destination);
    }

    /**
     * this method is used to print vertexes with their neighbors by treemap which naturally sorted.
     */
    void sortPrint(){
        TreeMap<Integer,ArrayList<Integer>> sort = new TreeMap<>();
        sort.putAll(informations);
        for(Map.Entry<Integer,ArrayList<Integer>> entry : sort.entrySet()){
            System.out.print( entry.getKey() + " : ");
            for(Object y : entry.getValue())
                System.out.print( y + " ");
            System.out.println();//go to next line
        }
    }
    /**
     * this method print all vertexes of graph with their neighbors.
     */
    void printGraph(){
        System.out.println("Graph {");
        sortPrint();
        System.out.println("}");
    }

    /**
     * this method search about a particular vertex in graph.
     * @param vertex : the number of vertex which we want to search if exist in graph or not.
     * @return boolean value that shows source vertex exist in graph or not.
     */
    boolean search(int vertex){
        for(int x : informations.keySet()){
            if(x == vertex)
                return true;
        }
        return false;
    }

    /**
     * this method is used to check that source and destination are neighbors or not.
     * @param source : this is the start vertex.
     * @param destination : this is destination vertex.
     * @return boolean value that shows destination vertex is in source neighbors or not.
     */
    boolean searchNeighbors(int source,int destination){
        if(informations.get(source).contains(destination))
            return true;
        else
            return false;
    }
}
