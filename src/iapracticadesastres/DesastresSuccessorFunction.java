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
public class DesastresSuccessorFunction implements SuccessorFunction { // This version checks all possible values
    @SuppressWarnings("unchecked")
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoard             board  = (DesastresBoard) aState;
        DesastresHeuristicFunction DesHF  = new DesastresHeuristicFunction();
        
        ArrayList<ArrayList<ArrayList<Integer> > > travels = board.getTravels();

        //System.out.println(board.getTime()); //comment this
        /*if (board.getTime() != board.computeTotalTime()) {
            System.out.println(board.getTime() + " != " + board.computeTotalTime());
            System.exit(1);
        }
        else
            System.out.println("OK");*/
        
        
        
        // movAndDelete, swap
        for (int i = 0; i < travels.size(); i++) {
            for (int j1 = 0; j1 < travels.get(i).size(); j1++) {
                for (int j2 = 0; j2 < travels.get(i).size(); j2++) {
                        for (int k = 0; k < travels.get(i).get(j1).size(); k++) {
                               int heli = i;
                               int f1 = j1;
                               int group = k;
                               int f2 = j2;
                               if (j1 != j2) {
                                    if (board.possibleMovAndDelete(heli, f1, group, f2)) {
                                        DesastresBoard board2 = board.clone();
                                        board2.movAndDelete(heli, f1, group, f2);
                                        double    v = DesHF.getHeuristicValue(board2);
                                        String S = DesastresBoard.MOVANDDELETE + " heli " + heli + " f1 " + f1 + " group " + group + " f2 " + f2 +  " Cost(" + v + ") ---> " + board2.toString();

                                        retVal.add(new Successor(S, board2));
                                    }
                               }
                               
                               
                               // swap
                               int g1 = group;
                               for (int k2 = 0; k2 < travels.get(i).get(j2).size(); k2++) {
                                   int g2 = k2;
                                   if (board.possibleSwap(heli, f1, g1, f2, g2)) {
                                        DesastresBoard board2 = board.clone();
                                        board2.swap(heli, f1, g1, f2, g2);
                                        double    v = DesHF.getHeuristicValue(board2);
                                        String S = DesastresBoard.SWAP + " heli " + heli + " f1 " + f1 + " g1 " + g1 + " f2 " + f2 + " g2 " + g2 +  " Cost(" + v + ") ---> " + board2.toString();

                                        retVal.add(new Successor(S, board2));
                                   }
                               }
                                      
                        }
                    
                }
            }
            
            // switchPilot
            for (int i2 = 0; i2 < travels.size(); i2++) {
                if (i != i2) {
                    for (int j = 0; j < travels.get(i).size(); j++) {
                        int h1 = i;
                        int h2 = i2;
                        int f = j;
                        if (board.possibleSwitchPilot(h1, h2, f)) {
                            DesastresBoard board2 = board.clone();
                            board2.switchPilot(h1, h2, f);
                            double    v = DesHF.getHeuristicValue(board2);
                            String S = DesastresBoard.SWITCHPILOT + " h1 " + h1 + " h2 " + h2 + " f " + f +  " Cost(" + v + ") ---> " + board2.toString();

                            retVal.add(new Successor(S, board2));
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
                    double    v = DesHF.getHeuristicValue(board2);
                    String S = DesastresBoard.SWAPORDER + " h1 " + h1 + " pos " + pos +  " Cost(" + v + ") ---> " + board2.toString();

                    retVal.add(new Successor(S, board2));
                }
            }*/
        }
        return retVal;
    }
        

}