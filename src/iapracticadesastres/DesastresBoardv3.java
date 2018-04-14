/*!
 * REpresentacion del estado del problema del viajante de comercio
 */
package iapracticadesastres;

import IA.Desastres.Grupos;
import IA.Desastres.Grupo;
import IA.Desastres.Centros;
import IA.Desastres.Centro;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class DesastresBoardv3 implements Cloneable {

  /// String que describe el operador

    /**
     *
     */

  public static String MOVANDDELETE = "Mov and delete";
  public static String SWAP = "Swap";
  public static String SWITCHPILOT = "Switch pilot";
  public static String SWAPORDER = "Swap order";

  private static Grupos gs;
  private static Centros cs;
  private static double groupdistances [][]; //from groups to groups (time)
  private static double centreGroupdistances [][]; //from centres to groups (time)
  
  
  private double time;
  private double maxTimePriority;
  private double timePriority [];
  
  private ArrayList<ArrayList<ArrayList<Integer> > > travels; //recheck class? maybe not arraylist!
  
  public DesastresBoardv3(ArrayList<ArrayList<ArrayList<Integer> > > travs, double t, double timeP [], double maxTimeP){
      travels = travs;
      time = t;
      timePriority = timeP;
      maxTimePriority = maxTimeP;
  }
  
  
  /*!\brief Genera una instancia del problema Desastres
   *
   * Crea una nueva instancia del problema Desastres con los parametros especificados
   * usando la estrategia de un helicoptero, G viajes de 1 grupo cada uno
   * 
   * @param [in] nGrupos Numero de grupos
   *             nCentros Numero de centros
   *             nHelis Numero de helicopteros por centro
   *             Seed Numero aleatorio usado en generación del problema
   */
  public DesastresBoardv3(int nGrupos, int nCentros, int nHelis, int Seed) {
    gs = new Grupos(nGrupos, Seed);
    cs = new Centros(nCentros, nHelis, Seed);
    groupdistances = new double[nGrupos][nGrupos]; //For fast calculus
    centreGroupdistances = new double[nCentros][nGrupos];
    for(int i=0; i<nGrupos; i++) {
        groupdistances[i][i]=0;
        Grupo a = gs.get(i);
        for(int j=i+1; j < nGrupos; j++) {
            Grupo b = gs.get(j);
            //Euclidean distance between the 2 points
            double dist = Math.hypot(
                    Math.abs(a.getCoordX()-b.getCoordX()), 
                    Math.abs(a.getCoordY()-b.getCoordY()));
            groupdistances[i][j] = dist*0.6; //Km and minutes
            groupdistances[j][i] = groupdistances[i][j];
        }
        for(int j=0; j<nCentros; j++) {
            Centro b = cs.get(j);
            double dist = Math.hypot(
                    Math.abs(a.getCoordX()-b.getCoordX()), 
                    Math.abs(a.getCoordY()-b.getCoordY()));
            centreGroupdistances[j][i] = dist*0.6; //Km and minutes
        }
    }
    
  }
  public void init0(int nGrupos, int nCentros, int nHelis) { //original
    int totalHelis = nHelis*nCentros;
    travels = new ArrayList (totalHelis);
    ArrayList<ArrayList<Integer> > firstHeli = new ArrayList(nGrupos);
    for(int i=0; i<nGrupos; i++) {
        ArrayList<Integer> flight = new ArrayList(1);
        flight.add(i);
        firstHeli.add(flight);
    }
    travels.add(firstHeli);
    for(int i=1; i<totalHelis; i++) {
        travels.add(new ArrayList());
    }
    int h0 = 0;
    time = computeHelicopterTime(h0);
    //heuristica 2
    maxTimePriority = 0;
    timePriority = new double [totalHelis];
    for (int i = 0; i<totalHelis; i++)
        timePriority[i] = 0;
    recomputeMaxTimePriority(h0);
    
  }
  public void init1(int nGrupos, int nCentros, int nHelis) { //Full round robin
    int totalHelis = nHelis*nCentros;
    travels = new ArrayList(totalHelis);
    for(int i=0; i<totalHelis; i++) {
        travels.add(new ArrayList(nGrupos/totalHelis)); //expected load factor
    }
    for(int i=0; i<nGrupos; i++) {
        ArrayList<Integer> flight =new ArrayList(1);
        flight.add(i);
        travels.get(i%totalHelis).add(flight);
    }
    time = computeTotalTime();
    //heuristica 2
    maxTimePriority = 0;
    timePriority = new double [totalHelis];
    for (int i = 0; i<totalHelis; i++){
        timePriority[i] = 0;
        recomputeMaxTimePriority(i);
    }
        
  }
  public void init2(int nGrupos, int nCentros, int nHelis) {
    int totalHelis = nHelis*nCentros;
    travels = new ArrayList(totalHelis);
    for(int i=0; i<totalHelis; i++) {
        travels.add(new ArrayList(nGrupos/totalHelis)); //expected load factor with random distribution of centres and groups
    }
    ArrayList<Integer> robin = new ArrayList(nCentros);
    for(int i=0; i<nCentros; i++) {
        robin.add(0); //all to 0
    }
    for(int i=0; i<nGrupos; i++) {
        ArrayList<Integer> flight = new ArrayList(1);
        flight.add(i);
        int mini=-1; double minTime = 1000000000000.;
        for (int c =0; c < nCentros; c++) {
            if(centreGroupdistances[c][i] < minTime) {
                mini=c; 
                minTime = centreGroupdistances[c][i];
            }
        }
        if(mini==-1) System.out.println("Fuuuuuuuuck"); //BUG
        //mini is closest centre
        Integer heli = robin.get(mini);
        robin.set(mini, (heli+1)%nHelis);
        travels.get(mini*nHelis+heli).add(flight);
    }
    time = computeTotalTime();
    //heuristica 2
    maxTimePriority = 0;
    timePriority = new double [totalHelis];
    for (int i = 0; i<totalHelis; i++){
        timePriority[i] = 0;
        recomputeMaxTimePriority(i);
    }
    
  }
  public int getNGrupos(){
    return gs.size();
  }
  
  public int getNCentros(){
    return cs.size();
  }
  
  public int getNHelis(){
    return travels.size();
  }
  
  public ArrayList<ArrayList<ArrayList<Integer> > > getTravels(){
    return travels;
  }
  
  public double getTime() {
    return (Math.round(time*100)/100.);
  }
  
  public double getMaxTimePriority(){
    return (Math.round(maxTimePriority*100)/100.);
  }
  
// GROUP WISE OPERATORS  (assuming the checkers passed)
  /*!\Brief Cambia un grupo de vuelo (NO NECESARIAMENTE MISMO HELICÓPTERO!)
   *
   * \pre heli < travels.size()
   * \pre f1,f2 < travels[heli].size()
   * \pre group < travels[heli][f1].size()
   */
  public void movAndDelete2(int h1, int h2, int f1, int group, int f2) {
      if(h1==h2) {
            double timef1 = computeFlightTime(f1,h1);
            double timef2 = computeFlightTime(f2,h1);
            time = time - timef1 - timef2;
            ArrayList<ArrayList<Integer> > tmp = travels.get(h1);
            ArrayList<Integer> tmp2=tmp.get(f2);
            Integer x = tmp.get(f1).remove(group);
            tmp2.add(x);
            time += computeFlightTime(f2,h1);
            if(tmp.get(f1).isEmpty()) {
              tmp.remove(f1);
              time -= 10;
            } else {
              time += computeFlightTime(f1,h1);
            }
            //heuristic 2
            recomputeMaxTimePriority(h1);
      } else {
            ArrayList<ArrayList<Integer> > tmp1 = travels.get(h1);
            ArrayList<Integer> fl1 = tmp1.get(f1);
            ArrayList<ArrayList<Integer> > tmp2 = travels.get(h2);
            ArrayList<Integer> fl2 = tmp2.get(f2);
            double timef1 = computeFlightTime(f1,h1);
            double timef2 = computeFlightTime(f2,h2);
            time = time - timef1 - timef2;
            fl2.add(fl1.remove(group));
            time += computeFlightTime(f2,h2);
            if (fl1.isEmpty()) {
                tmp1.remove(f1);
                if(!tmp1.isEmpty()) time -= 10; //still 1 heli left!!
            } else time += computeFlightTime(f1,h1);
            //heuristic 2
            recomputeMaxTimePriority(h1);
            recomputeMaxTimePriority(h2);
      }
  }

  public void swap2(int h1, int h2, int f1, int g1, int f2, int g2){
        if (h1==h2) {
            ArrayList<ArrayList<Integer> > tmp = travels.get(h1);
            ArrayList<Integer> tmp1=tmp.get(f1);
            ArrayList<Integer> tmp2=tmp.get(f2);
            if (f1 != f2) { //case same, double difference bug
                double time1 = computeFlightTime(f1,h1);
                double time2 = computeFlightTime(f2,h1);
                time = time -time1 -time2;
            } else time -= computeFlightTime(f1,h1);

            int aux = tmp1.get(g1);
            tmp1.set(g1, tmp2.get(g2));
            tmp2.set(g2, aux);
            if (f1 != f2) {
                double time1 = computeFlightTime(f1,h1);
                double time2 = computeFlightTime(f2,h2);
                time = time + time1 + time2;
            } else time += computeFlightTime(f1,h1);
            //heuristic 2
            recomputeMaxTimePriority(h1);
        } else {
            ArrayList<ArrayList<Integer> > heli1 = travels.get(h1);
            ArrayList<ArrayList<Integer> > heli2 = travels.get(h2);
            ArrayList<Integer> tmp1=heli1.get(f1);
            ArrayList<Integer> tmp2=heli2.get(f2);

            double time1 = computeFlightTime(f1,h1);
            double time2 = computeFlightTime(f2,h2);
            time = time -time1 -time2;

            int aux = tmp1.get(g1);
            tmp1.set(g1, tmp2.get(g2));
            tmp2.set(g2, aux);

            time1 = computeFlightTime(f1,h1);
            time2 = computeFlightTime(f2,h2);
            time = time + time1 + time2;
            // heuristic 2
            recomputeMaxTimePriority(h1);
            recomputeMaxTimePriority(h2);
        }
  }
  public void permute (int heli, int flight, int n){
    ArrayList<Integer> f = travels.get(heli).get(flight);
    double ftime = computeFlightTime(flight, heli);
    int aux;
    switch(n){ 
        case 0: //21 //swap the two elements of the flight
            aux = f.get(0);
            f.set(0, f.get(1));
            f.set(1, aux);
            break;
        case 1: // 132
            aux = f.get(1);
            f.set(1, f.get(2));
            f.set(2, aux);
            break;
        case 2: // 213
            aux = f.get(0);
            f.set(0, f.get(1));
            f.set(1, aux);
            break;
        case 3: //231
            aux = f.get(0);
            f.set(0, f.get(1));
            f.set(1, f.get(2));
            f.set(2, aux);
            break;
        case 4: // 312
            aux = f.get(2);
            f.set(2, f.get(1));
            f.set(1, f.get(0));
            f.set(0, aux);
            break;
        case 5: // 321
            aux = f.get(0);
            f.set(0, f.get(2));
            f.set(2, aux);
            break;
          
      }
    time += computeFlightTime(flight, heli)-ftime;
    //heuristic 2
    recomputeMaxTimePriority(heli);
  }
  
  //GROUP WISE OPERATORS CHECKER
  public Boolean possibleMovAndDeletev2 (int h1, int h2, int f1, int group, int f2) {
    if (f1==f2 && h1 == h2) return false; //bounding, removes useless op, can be done with swap
    ArrayList<ArrayList<Integer> > tmp = travels.get(h2);
    if(tmp.get(f2).size() >=3) return false;
    ArrayList<Integer> tmp2=tmp.get(f2);
    int pop = 0;
    for(int i=0; i<tmp2.size(); i++) {
        pop += gs.get(tmp2.get(i)).getNPersonas();
    }
    Integer x = travels.get(h1).get(f1).get(group);
    if(pop + gs.get(x).getNPersonas() > 15) return false;
    //tmp2.add(x);
    //if(tmp.get(f1).isEmpty()) tmp.remove(f1);
    return true;
  }
  
  public Boolean possibleSwapv2 (int h1, int h2, int f1, int g1, int f2, int g2){
    if(h1 == h2 && f1 == f2) {
        if(g1 == g2) return false; //useless op
        return true; //no conditions, can do
    }
    ArrayList<Integer> tmp1=travels.get(h1).get(f1);
    ArrayList<Integer> tmp2=travels.get(h2).get(f2);
    
    int pop1=0; int pop2=0;
    for(int i=0; i<tmp1.size(); i++) pop1 += gs.get(tmp1.get(i)).getNPersonas();
    for(int i=0; i<tmp2.size(); i++) pop2 += gs.get(tmp2.get(i)).getNPersonas();
    int gpop1 = gs.get(tmp1.get(g1)).getNPersonas(); int gpop2 = gs.get(tmp2.get(g2)).getNPersonas();
    if(pop1-gpop1+gpop2 > 15 || pop2-gpop2+gpop1 > 15) return false; //>15 pips on a flight
    
    /*int aux = tmp1.get(g1);
    tmp1.set(g1, tmp2.get(g2));
    tmp2.set(g2, aux);*/
    return true;
  }

  public Boolean possiblePermute (int heli, int flight, int n){
    ArrayList<Integer> f = travels.get(heli).get(flight);
    if (f.size() < 2) return false;
    if (f.size() == 2 && n != 0) return false;
    if (f.size() == 3 && (n < 1 || n > 5)) return false;
    if (n < 0 || n > 5) return false;
    return true;
  }
  
  
  
// FLIGHT WISE OPERATORS
  public void switchPilot(int h1, int h2, int f) {


      /*double getTimePre = getTime();
      double computeTotalTimePre = computeTotalTime();*/
      
      
      int nFlightsH1 = travels.get(h1).size();
      int nFlightsH2 = travels.get(h2).size();
      int centre1 = h1/(getNHelis()/getNCentros());
      int centre2 = h2/(getNHelis()/getNCentros());

      double tF1 = computeFlightTime(f,h1);
      time -= tF1;
      if (nFlightsH1 > 1) {
          time -= 10;
      }




      double tF2 = tF1 - centreGroupdistances[centre1][travels.get(h1).get(f).get(0)] - centreGroupdistances[centre1][travels.get(h1).get(f).get(travels.get(h1).get(f).size()-1)];

      travels.get(h2).add(travels.get(h1).remove(f));
      tF2 = tF2 + centreGroupdistances[centre2][travels.get(h2).get(nFlightsH2).get(0)] + centreGroupdistances[centre2][travels.get(h2).get(nFlightsH2).get(travels.get(h2).get(nFlightsH2).size()-1)];
      time += tF2;
      if (nFlightsH2 > 0) {
          time += 10;
      }


       /*if (((getTime()-getTimePre) - (computeTotalTime()-computeTotalTimePre)) > 1) {
          System.out.println((getTime()-getTimePre) - (computeTotalTime()-computeTotalTimePre));
          System.exit(3);
      }*/
    //heuristic 2
    recomputeMaxTimePriority(h1);
    recomputeMaxTimePriority(h2);
  }

  // Not used in this version. Time NOT tested.
  //pos < travels[h1].size-1
  public void swapOrder(int h1, int pos) {
      time -= computeHelicopterTime(h1);
      ArrayList<Integer> aux = travels.get(h1).get(pos);
      travels.get(h1).set(pos, travels.get(h1).get(pos+1));
      travels.get(h1).set(pos+1, aux);
      time += computeHelicopterTime(h1);
      //heuristic 2
      recomputeMaxTimePriority(h1);
  }
  
  // FLIGHT WISE OPERATORS CHECKER
  public Boolean possibleSwitchPilot(int h1, int h2, int f) {
      if(h1==h2) return false;
      return true;
  }
  public Boolean possibleSwapOrder(int h1, int pos) {
      if (!(pos < travels.get(h1).size()-1)) return false;
      return true;
  }
  
  public DesastresBoardv3 clone() {//fixed
      ArrayList<ArrayList<ArrayList<Integer> > > travs = new ArrayList (travels.size());
      for (int i = 0; i < travels.size(); i++){
          ArrayList<ArrayList<Integer> > currI = travels.get(i);
          travs.add(new ArrayList (currI.size()));
          ArrayList<ArrayList<Integer> > travsI = travs.get(i);
          for (int j = 0; j < currI.size(); j++){
              ArrayList<Integer> currJ = currI.get(j);
              travsI.add(new ArrayList (currJ.size()));
              ArrayList<Integer> travsJ = travsI.get(j);
              for (int k = 0; k < currJ.size(); k++){
                  Integer currK = currJ.get(k);
                  travsJ.add(currK);
              }
          }
      }
      //modified for heuristic 2, cloning a 1D array of primitives is simple
      DesastresBoardv3 clonedBoard = new DesastresBoardv3(travs,time, timePriority.clone(),maxTimePriority);
      return clonedBoard;
  }



  private double computeHelicopterTime(int heli) {
        double t = 0;

        for (int i = 0; i < travels.get(heli).size(); i++) {
            t += computeFlightTime(i,heli);
            if ((i > 0))
                t += 10;
        }
        return t;
    }


    private double computeFlightTime(int flight, int heli) {
        double t = 0;
        int centre = heli/(getNHelis()/getNCentros());
        t = t + centreGroupdistances[centre][travels.get(heli).get(flight).get(0)] + centreGroupdistances[centre][travels.get(heli).get(flight).get(travels.get(heli).get(flight).size()-1)];
        for (int j = 0; j < travels.get(heli).get(flight).size(); j++) {
            if (j != (travels.get(heli).get(flight).size() -1))
                t += groupdistances[travels.get(heli).get(flight).get(j)][travels.get(heli).get(flight).get(j+1)];
            int p;
            if (gs.get(travels.get(heli).get(flight).get(j)).getPrioridad() == 1)
                p = 2;
            else
                p = 1;
            t += p * gs.get(travels.get(heli).get(flight).get(j)).getNPersonas();
        }
        return t;
    }

    // USED IN INIT1 AND 2!
    public double computeTotalTime() {
        double t = 0;
        for (int i = 0; i < getNHelis(); i++) {
            t += computeHelicopterTime(i);
        }
        return t;
    }
    
    private void recomputeMaxTimePriority(int h){
        boolean wasMax = timePriority[h] == maxTimePriority;
        double tmptime = 0;
        double max = 0;
        //int lastpriorityflight = -1;
        ArrayList <ArrayList < Integer > > heli = travels.get(h);
        int c = h/(getNHelis()/getNCentros());
        for (int i = 0; i < heli.size(); i++){ //for each flight a heli has
            boolean prio = false;
            tmptime += centreGroupdistances[c][heli.get(i).get(0)];
            if (i>0)
                tmptime += 10; //10m from previous flight, as this is not its first flight
            for (int j = 0; j < heli.get(i).size(); j++){ //for each group in it
                if (gs.get(heli.get(i).get(j)).getPrioridad() == 1){
                    prio = true;
                    //lastpriorityflight = i;
                    tmptime += gs.get(heli.get(i).get(j)).getNPersonas();
                }
                tmptime += gs.get(heli.get(i).get(j)).getNPersonas();
                if (j != heli.get(i).size()-1)  //if it's not the last we sum the time to go to the next group
                    tmptime += groupdistances[heli.get(i).get(j)][heli.get(i).get(j+1)];
                else //otherwise sum the time to go back to the center
                    tmptime += centreGroupdistances[c][heli.get(i).get(j)];
            }
            if (prio) { //if the flight had a priority 1 group, tmptime will be the time they were rescued
                max = tmptime;
            }
        }
        //extra time for heuristics2.1
        //if (lastpriorityflight != -1){
        //    for (int g = 0; g < heli.get(lastpriorityflight).size();g++){
        //        if (gs.get(heli.get(lastpriorityflight).get(g)).getPrioridad() == 1)
        //            max+=10;
        //    }
        //}
        timePriority[h] = max;
        if (wasMax) { //the helicopter whose schedule was modified was potentially the one who took the longest to rescue a priority group
            max = 0;  //so we need to find who is the next who took longest, which might be him again
            for (int i = 0; i < timePriority.length; i++){
                if (timePriority[i]>max)
                    max = timePriority[i];
            }
            maxTimePriority = max;
        } else if (maxTimePriority < timePriority[h]) { //otherwise if it took longer than the one who did so before, he's the new max
            maxTimePriority = timePriority[h];
        } //otherwise since he wasn't the one who took longest and still isn't, we don't need to recompute the max
    }
  
}
