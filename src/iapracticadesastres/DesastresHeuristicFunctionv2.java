package iapracticadesastres;

import aima.search.framework.HeuristicFunction;

public class DesastresHeuristicFunctionv2 implements HeuristicFunction  {

  public boolean equals(Object obj) {
      boolean retValue;
      
      retValue = super.equals(obj);
      return retValue;
  }
  
  public double getHeuristicValue(Object state) {
   DesastresBoardv2 board=(DesastresBoardv2)state;

   return board.getTime();
  }
  
}
