package iapracticadesastres;

//~--- non-JDK imports --------------------------------------------------------

import iapracticadesastres.DesastresHeuristicFunction;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Javier Bejar
 *
 */
public class DesastresSuccessorFunctionSA implements SuccessorFunction {
    public List getSuccessors(Object aState) {
        ArrayList                retVal = new ArrayList();
        DesastresBoard             board  = (DesastresBoard) aState;
        DesastresHeuristicFunction TSPHF  = new DesastresHeuristicFunction();
        Random myRandom=new Random();
        int i,j;
        
        // Nos ahorramos generar todos los sucesores escogiendo un par de ciudades al azar
        
       i=myRandom.nextInt(board.getNCities());
       
       do{
              j=myRandom.nextInt(board.getNCities());
       } while (i==j);
        

       DesastresBoard newBoard = new DesastresBoard(board.getNCities(), board.getPath(), board.getDists());

       newBoard.swapCities(i, j);

       double   v = TSPHF.getHeuristicValue(newBoard);
       String S = DesastresBoard.INTERCAMBIO + " " + i + " " + j + " Coste(" + v + ") ---> " + newBoard.toString();

      retVal.add(new Successor(S, newBoard));

      return retVal;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
