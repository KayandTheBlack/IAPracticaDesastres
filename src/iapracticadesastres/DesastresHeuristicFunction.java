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
   int sum=0,nc;
   nc=board.getNCities();

   for(int i=0;i<nc;i++) sum=sum+board.distCities(i);

   return (sum);
  }
  
}
