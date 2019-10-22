package milkAI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matos
 */
public class Node {
  
    
    State station;
    private Node nodeFather;
    private int depth;
    private int cost;

    public Node(State station, Node nodeFather, int depth, int cost) {
        this.station = station;
        this.nodeFather = nodeFather;
        this.depth = depth;
        this.cost = cost;
    }
    
 public List<Node> expand(){
     List<Node> nodes = new ArrayList<>();
     for (State node : this.station.expand()) {
         Node no = new Node(node, this, this.depth++, this.cost);
         nodes.add(no);
     }
//     this.station.expand().stream().map((node) -> new Node(node, this, this.depth++, this.cost)).forEachOrdered((no) -> {
//         nodes.add(no);
//        });
//        return nodes;
//             }
        return nodes;
 }
    @Override
    public String toString() {
        return "Node{" + "station=" + station + ", nodeFather=" + nodeFather + ", depth=" + depth + ", cost=" + cost + '}';
    }
 
 

    public State getStation() {
        return station;
    }

    public void setStation(State station) {
        this.station = station;
    }

    public Node getNodeFather() {
        return nodeFather;
    }

    public void setNodeFather(Node nodeFather) {
        this.nodeFather = nodeFather;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

             
    
   
 


}
