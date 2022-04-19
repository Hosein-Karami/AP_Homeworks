/**
 * this is main class.in this class we get inputs and process them and communicate with Graph class.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/10/2022
 */

import java.util.Scanner;

public class Main {

    /**
     * this method is start of our program to give inputs or show results.
     * @param args .
     */
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);//make a refrence of scanner class.
        Graph graph = new Graph();//make a refrence of Graph class.
        String choose;//for give user wishes.

        while(true){
            choose = scanner.next();
            choose = choose.toLowerCase();//lowercase all alphabets to avoid from error of user.

            if(choose.equals("exit"))
                break;

            else if(choose.equals("addvertex")){
                int newVertex = scanner.nextInt();
                scanner.nextLine();//avoid to ignore scanner.nextLine in continue.
                //search that this vertex exist in graph or not :
                if(graph.search(newVertex))
                    System.out.println("This vertex added before.");
                else
                    graph.addVertex(newVertex);
            }

            else if(choose.equals("addedge")){
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                scanner.nextLine();//avoid to ignore scanner.nextLine in continue.
                //search that source vertex exist in graph :
                if( ! graph.search(source))
                    System.out.println("Source vertex does not exist in graph.");
                //search that destination vertex exist in graph :
                else if( ! graph.search(destination))
                    System.out.println("Destination vertex does not exist in graph.");
                else {
                    //search that start and destination not neighbors now :
                    if (graph.searchNeighbors(source, destination))
                        System.out.println("These source and destination are neighbors now.");
                    else {
                        //search that these vertexes exist in graph or not :
                        if (graph.search(source) && graph.search(destination))
                            graph.addEdge(source, destination);
                        else
                            System.out.println("One or both vertexes are not added to graph.");
                    }
                }
            }

            else if(choose.equals("removeedge")){
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                scanner.nextLine();//avoid to ignore scanner.nextLine in continue.
                //search that these vertexes exist in graph or not :
                if(graph.search(source) && graph.search(destination)){
                    //search that destination vertex is neighbor of source vertex ot not :
                    if(graph.searchNeighbors(source,destination))
                        graph.removeEdge(source,destination);
                    else
                        System.out.println("Destination vertex is not a neighbor of the source vertex.");
                }
                else
                    System.out.println("One or both vertexes are not added to graph.");
            }

            else if(choose.equals("print"))
                graph.printGraph();

            else
                System.out.println("Your input is invalid.");
        }
    }
}
