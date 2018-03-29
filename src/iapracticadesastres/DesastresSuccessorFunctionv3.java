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
public class DesastresSuccessorFunctionv3 implements SuccessorFunction { // This version checks all possible values
    @SuppressWarnings("unchecked")
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoardv2             board  = (DesastresBoardv2) aState;
        DesastresHeuristicFunction DesHF  = new DesastresHeuristicFunction();
        
        ArrayList<ArrayList<ArrayList<Integer> > > travels = board.getTravels();


        
        
        
        // movAndDelete, swap
        for (int h1 = 0; h1 < travels.size(); h1++) {
            for (int f1 = 0; f1 < travels.get(h1).size(); f1++) {
                for (int g1 = 0; g1 < travels.get(h1).get(f1).size(); g1++) {
                    for (int h2 = 0; h2 < travels.size(); h2++) {
                        for (int f2 = 0; f2 < travels.get(h2).size(); f2++) {
                            if(board.possibleMovAndDeletev2(h1,h2,f1,g1,f2)) {
                                DesastresBoardv2 board2 = board.clone();
                                board2.movAndDelete2(h1, h2, f1, g1, f2);
                                double v = board2.getTime();
                                String S = DesastresBoard.MOVANDDELETE + " heli " + h1 + " f1 " + f1 + " group " + g1 + " f2 " + f2 +  " Cost(" + v + ") ---> " + board2.toString();
                                retVal.add(new Successor(S, board2));
                            }
                }   }   }   
                for(int i=1; i<= 5; i++){
                    if(board.possiblePermute(h1,f1,i)) {
                        DesastresBoardv2 board2 = board.clone();
                        board2.permute(h1, f1, i);
                        double v = board2.getTime();
                        String S = "PERMUTE" + " heli " + h1 + " f1 " + f1 + " rotation " + i +  " Cost(" + v + ") ---> " + board2.toString();
                        retVal.add(new Successor(S, board2));
                    }
                }
        }   }   
        // switchPilot
        for(int h1 =0; h1 < travels.size(); h1++) {
            for (int h2 = 0; h2 < travels.size(); h2++) {
                if (h1 != h2) {
                    for (int f = 0; f < travels.get(h1).size(); f++) {
                        if (board.possibleSwitchPilot(h1, h2, f)) {
                            DesastresBoardv2 board2 = board.clone();
                            board2.switchPilot(h1, h2, f);
                            double    v = board2.getTime();
                            String S = DesastresBoard.SWITCHPILOT + " h1 " + h1 + " h2 " + h2 + " f " + f +  " Cost(" + v + ") ---> " + board2.toString();
                            retVal.add(new Successor(S, board2));
                        }   
                    }
                }
        }   }
        return retVal;
    }
}