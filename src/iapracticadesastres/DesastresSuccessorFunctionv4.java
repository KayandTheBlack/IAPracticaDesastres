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
public class DesastresSuccessorFunctionv4 implements SuccessorFunction { // This version checks all possible values
    @SuppressWarnings("unchecked")
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoardv3             board  = (DesastresBoardv3) aState;
        //DesastresHeuristicFunctionv3 DesHF  = new DesastresHeuristicFunctionv3();
        
        ArrayList<ArrayList<ArrayList<Integer> > > travels = board.getTravels();


        
        
        
        // movAndDelete, swap
        for (int h1 = 0; h1 < travels.size(); h1++) {
            for (int f1 = 0; f1 < travels.get(h1).size(); f1++) {
                for (int g1 = 0; g1 < travels.get(h1).get(f1).size(); g1++) {
                    for (int h2 = 0; h2 < travels.size(); h2++) {
                        for (int f2 = 0; f2 < travels.get(h2).size(); f2++) {
                            if(board.possibleMovAndDeletev2(h1,h2,f1,g1,f2)) {
                                DesastresBoardv3 board3 = board.clone();
                                board3.movAndDelete2(h1, h2, f1, g1, f2);
                                double v =-1;// DesHF.getHeuristicValue(board3);
                                String S = DesastresBoard.MOVANDDELETE + " heli " + h1 + " f1 " + f1 + " group " + g1 + " f2 " + f2 +  " Cost(" + v + ") ---> " + board3.toString();
                                retVal.add(new Successor(S, board3));
                            }
                            for (int g2 = 0; g2 < travels.get(h2).get(f2).size(); g2++) {
                                if(board.possibleSwapv2(h1, h2, f1, g1, f2, g2)) {
                                    DesastresBoardv3 board3 = board.clone();
                                    board3.swap2(h1, h2, f1, g1, f2, g2);
                                    //double    v = DesHF.getHeuristicValue(board2); //peta
                                    double v = -1;//DesHF.getHeuristicValue(board3);
                                    String S = DesastresBoard.SWAP + " h1 " + h1 + " f1 " + f1 + " g1 " + g1 + "h2" + h2 + " f2 " + f2 + " g2 " + g2 +  " Cost(" + v + ") ---> " + board3.toString();
                                    retVal.add(new Successor(S, board3));
                                }
        }   }   }   }   }   }
        // switchPilot
        for(int h1 =0; h1 < travels.size(); h1++) {
            for (int h2 = 0; h2 < travels.size(); h2++) {
                if (h1 != h2) {
                    for (int f = 0; f < travels.get(h1).size(); f++) {
                        if (board.possibleSwitchPilot(h1, h2, f)) {
                            DesastresBoardv3 board3 = board.clone();
                            board3.switchPilot(h1, h2, f);
                            double v =-1;// DesHF.getHeuristicValue(board3);
                            String S = DesastresBoard.SWITCHPILOT + " h1 " + h1 + " h2 " + h2 + " f " + f +  " Cost(" + v + ") ---> " + board3.toString();
                            retVal.add(new Successor(S, board3));
                        }   
                    }
                }
        }   }
        // heuristic 2, swapOrder(int h1, int pos)
        for (int h = 0; h < travels.size(); h++){
            for (int f = 0; f < travels.get(h).size()-1; f++) { // using -1 due to op restrictions
                DesastresBoardv3 board3 = board.clone();
                board3.swapOrder(h,f);
                double v = -1;//DesHF.getHeuristicValue(board3);
                String S = DesastresBoard.SWAPORDER + "heli" + h + "f" + f + "Cost(" + v + ") ---> " + board3.toString();
                retVal.add(new Successor(S,board3));
            }
        }
        
        return retVal;
    }
}