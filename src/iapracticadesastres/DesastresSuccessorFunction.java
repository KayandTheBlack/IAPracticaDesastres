package iapracticadesastres;

//~--- non-JDK imports --------------------------------------------------------


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi Mohan
 *
 */
public class DesastresSuccessorFunction implements SuccessorFunction {
    @SuppressWarnings("unchecked")
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoard             board  = (DesastresBoard) aState;
        DesastresHeuristicFunction TSPHF  = new DesastresHeuristicFunction();

        // No permitimos intercambiar la primera ciudad
        for (int i = 0; i < board.getNCities(); i++) {
            for (int j = i + 1; j < board.getNCities(); j++) {
                DesastresBoard newBoard = new DesastresBoard(board.getNCities(), board.getPath(), board.getDists());

                newBoard.swapCities(i, j);

                double    v = TSPHF.getHeuristicValue(newBoard);
                String S = DesastresBoard.INTERCAMBIO + " " + i + " " + j + " Coste(" + v + ") ---> " + newBoard.toString();

                retVal.add(new Successor(S, newBoard));
            }
        }

        return retVal;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
