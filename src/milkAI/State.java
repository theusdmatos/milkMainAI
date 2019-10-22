package milkAI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matos
 */
public class State {

    
    int jar3L;
    int jar5L;
    int jar8L;

    int J3, J5, J8;

    public State(int jar3L, int jar5L, int jar8L) {
        this.jar3L = jar3L;
        this.jar5L = jar5L;
        this.jar8L = jar8L;
    }

    static State stationI = new State(0, 0, 8);

    public State stationNow() {
        State stationNow = new State(jar5L, jar3L, jar8L);
        return stationNow;
    }

    public List<State> expand() {
        List<State> jarS = new ArrayList<>();

        State proxStation;

        int conditionJAR3L = 3 - jar3L;
        int conditionJAR5L = 5 - jar5L;
        int conditionJAR8L = 8 - jar8L;
        
        //JAR5
        
        if (jar5L != 0) {
            if (jar5L <= conditionJAR3L) {
                J3 = jar3L + jar5L;
                J5 = 0;
                proxStation = new State(J5, J3, jar8L);
                jarS.add(proxStation);
            } else {
                J3 = jar3L + conditionJAR3L;
                J5 = jar5L - conditionJAR3L;

                proxStation = new State(J5, J3, jar8L);
                jarS.add(proxStation);
            }

        }

        if (jar5L <= conditionJAR8L) {
            J8 = jar8L + jar5L;
            J5 = 0;
            proxStation = new State(J5, jar3L, J8);
            jarS.add(proxStation);
        } else {
            J8 = jar8L + conditionJAR8L;
            J5 = jar5L - conditionJAR8L;

            proxStation = new State(J5, jar3L, J8);
            jarS.add(proxStation);
        }

        /// JAR3
        if (jar3L != 0) {
            if (jar3L <= conditionJAR5L) {
                J5 = jar5L + jar3L;
                J3 = 0;

                proxStation = new State(J5, J3, jar8L);
                jarS.add(proxStation);
            } else {
                J5 = jar5L + conditionJAR5L;
                J3 = jar3L - conditionJAR5L;

                proxStation = new State(J5, J3, jar8L);
                jarS.add(proxStation);
            }

            if (jar3L <= conditionJAR8L) {
                J8 = jar8L + jar3L;
                J3 = 0;
                proxStation = new State(jar5L, J3, J8);
                jarS.add(proxStation);
            } else {
                J8 = jar8L + conditionJAR8L;
                J3 = jar3L - conditionJAR8L;

                proxStation = new State(jar5L, J3, J8);
                jarS.add(proxStation);
            }
        }

        // JAR8
        if (jar8L != 0) {
            if (jar8L <= conditionJAR5L) {
                J5 = jar5L + jar8L;
                J8 = 0;
                proxStation = new State(J5, jar3L, J8);
                jarS.add(proxStation);
            } else {
                J5 = jar5L + conditionJAR5L;
                J8 = jar8L - conditionJAR5L;

                proxStation = new State(J5, jar3L, J8);
                jarS.add(proxStation);
            }

        }

        if (jar8L <= conditionJAR3L) {
            J3 = jar8L + jar3L;
            J8 = 0;
            proxStation = new State(jar5L, J3, J8);
            jarS.add(proxStation);
        } else {
            J3 = jar3L + conditionJAR3L;
            J8 = jar8L - conditionJAR3L;

            proxStation = new State(jar5L, J3, J8);
            jarS.add(proxStation);
        }

        return jarS;

    }

    public boolean isGoal() {
        return jar5L == 4 || jar8L == 4;
    }

    @Override
    public String toString() {
        return "JARRA de 5L = " + jar3L + "L" + "\n" + "JARRA DE 3L = " + jar5L + "L" + "\n" + "JARRA DE 8L = " + jar8L + "L" ;
    }

}
