package iapracticadesastres;

//~--- non-JDK imports --------------------------------------------------------


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jordi Armengol Estapé
 *
 */
public class DesastresSuccessorFunction implements SuccessorFunction {
    @SuppressWarnings("unchecked")
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoard             board  = (DesastresBoard) aState;
        DesastresHeuristicFunction DesHF  = new DesastresHeuristicFunction();
        
        ArrayList<ArrayList<ArrayList<Integer> > > travels = board.getTravels();
        
        // movAndDelete, swap
        for (int i = 0; i < travels.size(); i++) {
            for (int j1 = 0; j1 < travels.get(i).size(); j1++) {
                for (int j2 = 0; j2 < travels.get(i).size(); j2++) {
                    if (j1 != j2) {
                        for (int k = 0; k < travels.get(i).get(j1).size(); k++) {
                               int heli = i;
                               int f1 = j1;
                               int group = k;
                               int f2 = j2;
                               if (board.possibleMovAndDelete(heli, f1, group, f2)) {
                                    DesastresBoard board2 = (DesastresBoard) board.clone();
                                    board2.movAndDelete(heli, f1, group, f2);
                                    retVal.add(board2);
                                }
                               
                               
                               // swap
                               int g1 = group;
                               for (int k2 = 0; k2 < travels.get(i).get(j2).size(); k2++) {
                                   int g2 = k2;
                                   if (board.swap(heli, f1, g1, f2, g2)) {
                                        DesatresBoard board2 = board.clone();
                                        board2.swap(heli, f1, g1, f2, g2);
                                        retVal.add(board2);
                                   }
                               }
                                      
                        }
                    }
                }
            }
            
            // switchPilot
            for (int i2 = 0; i2 < travels.size(); i2++) {
                if (i1 != i2) {
                    for (int j = 0; j < travels.get(i2).size(); j++) {
                        int h1 = i;
                        int h2 = i2;
                        int f = j;
                        if (board.possibleSwitchPilot(h1, h2, f)) {
                            DesatresBoard board2 = board.clone();
                            board2.switchPilot(h1, h2, f);
                            retVal.add(board2);
                        }   
                    }
                    
                }
            }
            
            // swapOrder (only necessary for the second quality function)
            /*for (int j = 0; j < travels.get(i).size(); j++) {
                int h1 = i;
                int pos = j;
                if (board.swapOrder(h1, pos)) {
                    DesatresBoard board2 = board.clone();
                    board2.swapOrder(h1, pos);
                    retVal.add(board2);
                }
            }*/
        }
        
        return retVal;
    }
        

}