package iapracticadesastres;

//~--- non-JDK imports --------------------------------------------------------

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//~--- JDK imports ------------------------------------------------------------

/**
 * @author Jordi Armengol Estapé
 *
 */


public class DesastresSuccessorFunctionSAv2 implements SuccessorFunction {
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoardv3             board  = (DesastresBoardv3) aState;
        //DesastresHeuristicFunctionv3 DesHF  = new DesastresHeuristicFunctionv3();
        Random myRandom=new Random();

        ArrayList<ArrayList<ArrayList<Integer> > > travels = board.getTravels();


        int swapOrderSpace = 0;
        
        int nHelis = board.getNHelis();
        int nFlights = 0; // = board.getNFlights();
        for (int i = 0; i < travels.size(); i++) {
            int fs = travels.get(i).size();
            nFlights += fs;
            if (fs > 1)
                swapOrderSpace += fs - 1;
        }
        int nGroups = board.getNGrupos();

        int movAndDeleteSpace = nGroups*nFlights;
        int swapSpace = nGroups*nGroups;
        int switchPilotSpace = nFlights*nHelis;
        
        int space = movAndDeleteSpace + swapSpace + switchPilotSpace + swapOrderSpace;
        int random;


        boolean op = false;

        while (!op) {

            random = myRandom.nextInt(space);

            if (random < movAndDeleteSpace) { // movAndDelete

                int group = random / nFlights;
                int flight = random % nFlights;


                int groupCounter = 0;
                int flightCounter = 0;
                int h1 = 0, h2 = 0, f1 = 0, g = 0, f2 = 0;

                boolean gFound = false;
                boolean f2Found = false;
                boolean found = false;

                for (int i = 0; !found && i < travels.size(); i++) {
                    for (int h = 0; !f2Found && h < travels.get(i).size();h++) {
                        if (flight == flightCounter) {
                            h2 = i;
                            f2 = h;
                            f2Found = true;
                            found = gFound;
                        }
                        flightCounter++;
                    }


                    for (int j = 0; !gFound && j < travels.get(i).size(); j++) {
                        for (int k = 0; !gFound && k < travels.get(i).get(j).size(); k++) {
                            if (group == groupCounter) {
                                h1 = i;
                                f1 = j;
                                g = k;
                                gFound = true;
                                found = f2Found;
                            }
                            groupCounter++;
                        }


                    }
                }


                if (found && board.possibleMovAndDeletev2(h1, h2, f1, g, f2)) {
                    DesastresBoardv3 board2 = board.clone();
                    board2.movAndDelete2(h1, h2, f1, g, f2);
                    double v = -1;//DesHF.getHeuristicValue(board2);
                    String S = DesastresBoard.MOVANDDELETE + " heli " + h1 + " f1 " + f1 + " group " + g + " f2 " + f2 +  " Cost(" + v + ") ---> " + board2.toString();
                    retVal.add(new Successor(S, board2));
                    //System.out.println(S);
                    op = true;
                }



            } else if (random >= movAndDeleteSpace && random < (movAndDeleteSpace + swapSpace)) { // swap
                random -= movAndDeleteSpace;
                int group1 = random % nGroups;
                int group2 = random / nGroups;
                int groupCounter = 0;
                int h1 = 0, h2 = 0, f1 = 0, g1 = 0, f2 = 0, g2 = 0;
                boolean g1Found = false;
                boolean g2Found = false;
                boolean found = false;
                for (int i = 0; !found && i < travels.size(); i++) {
                    for (int j = 0; !found && j < travels.get(i).size(); j++) {
                        for (int k = 0; !found && k < travels.get(i).get(j).size(); k++) {
                            if (groupCounter == group1) {
                                h1 = i;
                                f1 = j;
                                g1 = k;
                                g1Found = true;
                                found = g2Found;
                            }
                            if (groupCounter == group2) {
                                h2 = i;
                                f2 = j;
                                g2 = k;
                                g2Found = true;
                                found = g1Found;
                            }
                            groupCounter++;

                        }



                    }
                }

                if (found && board.possibleSwapv2(h1, h2, f1, g1, f2, g2)) {
                    DesastresBoardv3 board2 = board.clone();
                    board2.swap2(h1, h2, f1, g1, f2, g2);
                    double v = -1;//DesHF.getHeuristicValue(board2);
                    String S = DesastresBoard.SWAP + " h1 " + h1 + " f1 " + f1 + " g1 " + g1 + "h2" + h2 + " f2 " + f2 + " g2 " + g2 + " Cost(" + v + ") ---> " + board2.toString();
                    //System.out.println(S);
                    retVal.add(new Successor(S, board2));
                    op = true;
                }

            } else  if (random < (movAndDeleteSpace + swapSpace + switchPilotSpace)){ // switchPilot
                random = random - (movAndDeleteSpace + swapSpace);
                int flight = random % nFlights;
                int heli2 = random / nFlights;

                int flightCounter = 0;
                int h1 = 0, f = 0;
                int h2 = heli2;

                boolean fFound = false;




                for (int i = 0; !fFound && i < travels.size(); i++) {
                    for (int j = 0; !fFound && j < travels.get(i).size(); j++) {
                        if (flightCounter == flight) {
                            h1 = i;
                            f = j;
                            fFound = true;
                        }
                        flightCounter++;
                    }



                }
                if (fFound && board.possibleSwitchPilot(h1, h2, f)) {
                    DesastresBoardv3 board2 = board.clone();
                    board2.switchPilot(h1, h2, f);
                    double v =-1;// DesHF.getHeuristicValue(board2);
                    String S = DesastresBoard.SWITCHPILOT + " h1 " + h1 + " h2 " + h2 + " f " + f +  " Cost(" + v + ") ---> " + board2.toString();
                    //System.out.println(S);
                    retVal.add(new Successor(S, board2));
                    op = true;
                }


            }else { //swapOrder
                int fnum = random - (movAndDeleteSpace + swapSpace + switchPilotSpace);
                for (int i = 0; i < travels.size(); i++) {
                    int fs = travels.get(i).size()-1;
                    if (fs > 0){
                        if (fnum >= fs) //fnum = how many flights remaining until the chosen one
                            fnum -= fs;
                        else{
                            int flight = fnum;
                            int heli = i;
                            DesastresBoardv3 board3 = board.clone();
                            board3.swapOrder(heli,flight);
                            double v = -1;//DesHF.getHeuristicValue(board3);
                            String S = DesastresBoard.SWAPORDER + "heli" + heli + "f" + flight + "Cost(" + v + ") ---> " + board3.toString();
                            retVal.add(new Successor(S,board3));
                            i = travels.size();
                            op = true;
                        }
                    }
                }
            }

        }

        return retVal;
    }
}