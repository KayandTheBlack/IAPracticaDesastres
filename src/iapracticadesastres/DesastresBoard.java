/*!
 * REpresentacion del estado del problema del viajante de comercio
 */
package iapracticadesastres;

import java.util.Random;
import IA.Desastres.Grupos;
import IA.Desastres.Grupo;
import IA.Desastres.Centros;
import IA.Desastres.Centro;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class DesastresBoard implements Cloneable {

  /// String que describe el operador

    /**
     *
     */
  public static String INTERCAMBIO = "Intercambio";
    
  /// Nuemro de ciudades
  //private int ncities;
  /// Orden entre las ciudades
  //private int [] path; 
  /// Distancias entre las ciudades
  //private int [][] dist; 
  
  private static Grupos gs;
  private static Centros cs;
  private static double groupdistances [][]; //from groups to groups (time)
  private static double centreGroupdistances [][]; //from centres to groups (time)
  
  
  private double time;
  
  private ArrayList<ArrayList<ArrayList<Integer> > > travels; //recheck class? maybe not arraylist!
  
  public DesastresBoard(ArrayList<ArrayList<ArrayList<Integer> > > travs, double t){
      travels = travs;
      time = t;
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
  public DesastresBoard(int nGrupos, int nCentros, int nHelis, int Seed) {
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
    //Eo initialisation, take outside for testing
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
      return time;
  }
  
// GROUP WISE OPERATORS  (assuming the checkers passed)
  /*!\Brief Cambia un grupo de vuelo (dentro del mismo helicoptero!)
   *
   * \pre heli < travels.size()
   * \pre f1,f2 < travels[heli].size()
   * \pre group < travels[heli][f1].size()
   */
  public void movAndDelete(int heli, int f1, int group, int f2) {
    double timef1 = computeFlightTime(f1,heli);
    double timef2 = computeFlightTime(f2,heli);
    time = time - timef1 - timef2;
    
    ArrayList<ArrayList<Integer> > tmp = travels.get(heli);
    ArrayList<Integer> tmp2=tmp.get(f2);
    Integer x = tmp.get(f1).remove(group);
    tmp2.add(x);
    time += computeFlightTime(f2,heli);
    if(tmp.get(f1).isEmpty()) {
        tmp.remove(f1);
        time -= 10;  // in the version with movements between helicopters, additional checks are needed
    } else {
        time += computeFlightTime(f1,heli);
    }
  }

  public void swap(int heli, int f1, int g1, int f2, int g2){
    ArrayList<ArrayList<Integer> > tmp = travels.get(heli);
    ArrayList<Integer> tmp1=tmp.get(f1);
    ArrayList<Integer> tmp2=tmp.get(f2);
    
    double time1 = computeFlightTime(f1,heli);
    double time2 = computeFlightTime(f2,heli);
    time = time -time1 -time2;
    
    int aux = tmp1.get(g1);
    tmp1.set(g1, tmp2.get(g2));
    tmp2.set(g2, aux);
    
    
    
  }
  
  public void permute (int heli, int flight, int n){
    ArrayList<Integer> f = travels.get(heli).get(flight);
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
  }
  
  //GROUP WISE OPERATORS CHECKER
  public Boolean possibleMovAndDelete (int heli, int f1, int group, int f2){
    if (f1==f2) return false; //bounding, removes useless op, can be done with swap
    ArrayList<ArrayList<Integer> > tmp = travels.get(heli);
    if(tmp.get(f2).size() >=3) return false;
    ArrayList<Integer> tmp2=tmp.get(f2);
    int pop = 0;
    for(int i=0; i<tmp2.size(); i++) {
        pop += gs.get(tmp2.get(i)).getNPersonas();
    }
    Integer x = tmp.get(f1).get(group); //.remove(group);
    if(pop + gs.get(x).getNPersonas() > 15) return false;
    //tmp2.add(x);
    //if(tmp.get(f1).isEmpty()) tmp.remove(f1);
    return true;
  }
  
  public Boolean possibleSwap (int heli, int f1, int g1, int f2, int g2){
    ArrayList<ArrayList<Integer> > tmp = travels.get(heli);
    ArrayList<Integer> tmp1=tmp.get(f1);
    ArrayList<Integer> tmp2=tmp.get(f2);
    
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
      travels.get(h2).add(travels.get(h1).remove(f));
  }
  public void swapOrder(int h1, int pos) { //pos < travels[h1].size-1
      ArrayList<Integer> aux = travels.get(h1).get(pos);
      travels.get(h1).set(pos, travels.get(h1).get(pos+1));
      travels.get(h1).set(pos+1, aux);
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
  
  public DesastresBoard clone() {//fixed
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
      DesastresBoard clonedBoard = new DesastresBoard(travs,time);
      return clonedBoard;
  }
  
  private double computeHelicopterTime(int heli) {
      double t = 0;
      int centre = heli/(getNHelis()/getNCentros());
      
      for (int i = 0; i < travels.get(heli).size(); i++) {
          t += centreGroupdistances[centre][travels.get(heli).get(i).get(0)];
          if ((i > 0) && (i != travels.get(heli).size()-1))
              t += 10;
          for (int j = 0; j < travels.get(heli).get(i).size(); j++) {
              t += gs.get(travels.get(heli).get(i).get(j)).getPrioridad() * gs.get(travels.get(heli).get(i).get(j)).getNPersonas();
          }
      }
      return t;
  }
  
  private double computeFlightTime(int flight, int heli) {
      double t = 0;
      int centre = heli/(getNHelis()/getNCentros());
      t += centreGroupdistances[centre][travels.get(heli).get(heli).get(0)];
      for (int j = 0; j < travels.get(heli).get(flight).size(); j++) {
              t += gs.get(travels.get(heli).get(flight).get(j)).getPrioridad() * gs.get(travels.get(heli).get(flight).get(j)).getNPersonas();
      }
      return t;
  }
  
}
