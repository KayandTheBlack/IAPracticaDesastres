package iapracticadesastres;

import aima.search.framework.HeuristicFunction;

public class DesastresHeuristicFunctionv4 implements HeuristicFunction  {

  private int n = 1;
  public boolean equals(Object obj) {
      boolean retValue;
      
      retValue = super.equals(obj);
      return retValue;
  }
  
  public double getHeuristicValue(Object state) {
   DesastresBoardv4 board=(DesastresBoardv4)state;

   return board.getTime() + board.getMaxTimePriority()*n;
  }
  
  public DesastresHeuristicFunctionv4 (int mult){
      n = mult;
  }
  
  
}
