package iapracticadesastres;

import aima.search.framework.HeuristicFunction;

public class DesastresHeuristicFunction implements HeuristicFunction  {

  public boolean equals(Object obj) {
      boolean retValue;
      
      retValue = super.equals(obj);
      return retValue;
  }
  
  public double getHeuristicValue(Object state) {
   DesastresBoard board=(DesastresBoard)state;

   return board.getTime();
  }
  
}
