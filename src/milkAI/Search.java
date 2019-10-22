package milkAI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matos
 */
public class Search {

    public void SearchGoal() {

        List<Node> fringe = new ArrayList<>();
        Node node = new Node(State.stationI, null, 0, 0);
        fringe.add(node);

        while (true) {
            if (fringe.isEmpty()) {
                System.out.println("VAZIO");
                break;
            }

            node = fringe.get(0);
            fringe.remove(0);
            if (node.getStation().isGoal()) {
                System.out.println(node.getStation().toString());
                System.out.println("Caminho");
                while(node.getNodeFather() != null){
                    node = node.getNodeFather();
                    
                    System.out.println("\n");
                    System.out.println(node.station.toString());
                      
                }
                System.out.println("GOAL!");
                break;

            }

            fringe.addAll(node.expand());

        }

    }

}
