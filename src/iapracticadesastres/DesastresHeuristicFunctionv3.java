package iapracticadesastres;

import aima.search.framework.HeuristicFunction;

public class DesastresHeuristicFunctionv3 implements HeuristicFunction  {

  public boolean equals(Object obj) {
      boolean retValue;
      
      retValue = super.equals(obj);
      return retValue;
  }
  
  public double getHeuristicValue(Object state) {
   DesastresBoardv3 board=(DesastresBoardv3)state;

   return board.getTime() + board.getMaxTimePriority()*16;
  }
  
}
