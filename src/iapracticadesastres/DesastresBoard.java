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
public class DesastresBoard {

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
  
  private ArrayList<ArrayList<ArrayList<Integer> > > travels; //recheck class? maybe not arraylist!
  
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
            groupdistances[i][j] = dist*0.0006;
            groupdistances[j][i] = groupdistances[i][j];
        }
        for(int j=0; j<nCentros; j++) {
            Centro b = cs.get(j);
            double dist = Math.hypot(
                    Math.abs(a.getCoordX()-b.getCoordX()), 
                    Math.abs(a.getCoordY()-b.getCoordY()));
            centreGroupdistances[j][i] = dist*0.0006;
        }
    }
    //Eo initialisation
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
    //TODO: lacking the auxiliar array of order of flights between helicopters!
    //TODO: {
    //  Also add time for each helicopter, recomputate when needed? might reduce calculation time in exchange for space
    // }
    
    //TSP code...
    /*Random myRandom=new Random();
    int d;
    
    path=new int[nc];
    dist= new int[nc][nc];
    ncities=nc;
    
    for (int i = 0; i < nc; i++) path[i]=i;
    
    for (int i = 0; i < nc; i++)
      for (int j = i; j < nc; j++)
        if (i==j) dist[i][j]=0;
        else {
          d=  myRandom.nextInt(50)+10;
          dist[i][j]=d;
          dist[j][i]=d;
        }
 */
  }

  /*!\brief Retorna el numero de ciudades de la instancia
   *
   */
  //public int getNCities(){return(ncities);}
  
  /*!\brief Retorna el camino entre las ciudades
   *
   */
  //public int [] getPath(){return(path);}
  
  /*!\brief Retorna la matriz de distancias
   *
   */
  //public int [][] getDists(){return(dist);}
   
  /*!\brief Retorna la distancia entre la ciudad i y la siguiente ciudad en el camino
   *
   */
  //public int distCities(int i){
    //if (i<ncities-1) return(dist[path[i]][path[i+1]]);
    //else return(dist[path[i]][path[0]]);
  //  return 0;
  //}
// GROUP WISE OPERATORS
  /*!\Brief Cambia un grupo de vuelo (dentro del mismo helicoptero!)
   *
   * \pre heli < travels.size()
   * \pre f1,f2 < travels[heli].size()
   * \pre group < travels[heli][f1].size()
   * \@return true if movAndDelete is effective
   */
  public Boolean movAndDelete(int heli, int f1, int group, int f2){ //TODO: change in spec! Might give problems with heli times! Maybe do it bool for GenSucc?
    if (f1==f2) return false; //bounding, removes useless op, can be done with swap
    ArrayList<ArrayList<Integer> > tmp = travels.get(heli);
    if(tmp.get(f2).size() >=3) return false;
    ArrayList<Integer> tmp2=tmp.get(f2);
    int pop = 0;
    for(int i=0; i<tmp2.size(); i++) {
        pop += gs.get(tmp2.get(i)).getNPersonas();
    }
    Integer x = tmp.get(f1).remove(group);
    if(pop + gs.get(x).getNPersonas() > 15) return false;
    tmp2.add(x);
    if(tmp.get(f1).isEmpty()) tmp.remove(f1);
    return true;
  }

  public Boolean swap(int heli, int f1, int g1, int f2, int g2){
    ArrayList<ArrayList<Integer> > tmp = travels.get(heli);
    ArrayList<Integer> tmp1=tmp.get(f1);
    ArrayList<Integer> tmp2=tmp.get(f2);
    
    int pop1=0; int pop2=0;
    for(int i=0; i<tmp1.size(); i++) pop1 += gs.get(tmp1.get(i)).getNPersonas();
    for(int i=0; i<tmp2.size(); i++) pop2 += gs.get(tmp2.get(i)).getNPersonas();
    int gpop1 = gs.get(tmp1.get(g1)).getNPersonas(); int gpop2 = gs.get(tmp2.get(g2)).getNPersonas();
    if(pop1-gpop1+gpop2 > 15 || pop2-gpop2+gpop1 > 15) return false; //>15 pips on a flight
    
    int aux = tmp1.get(g1);
    tmp1.set(g1, tmp2.get(g2));
    tmp2.set(g2, aux);
    return true;
  }
  
  // permute is not being done! subset with swap does not need it!
  
// FLIGHT WISE OPERATORS
  public Boolean switchPilot(int h1, int h2, int f) {
      if(h1==h2) return false;
      travels.get(h2).add(travels.get(h1).remove(f));
      return true;
  }
  public Boolean swapOrder(int h1, int pos) { //pos < travels[h1].size-1
      ArrayList<Integer> aux = travels.get(h1).get(pos);
      travels.get(h1).set(pos, travels.get(h1).get(pos+1));
      travels.get(h1).set(pos+1, aux);
      return true;
  }
}
