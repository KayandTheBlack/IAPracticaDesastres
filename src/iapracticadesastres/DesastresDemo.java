
package iapracticadesastres;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import java.util.ArrayList;


public class DesastresDemo {
    
    public static void main(String[] args){
        Random myRandom=new Random();
        DesastresBoard DB =new DesastresBoard(5,1,2,1234); //modify for thingy
        System.out.println("Original time:" + DB.getTime());
        PrintArrayList(DB.getTravels());
        TSPHillClimbingSearch(DB);
        //TSPSimulatedAnnealingSearch(DB);
        //experiment1();
    }
    public static void PrintArrayList (ArrayList<ArrayList<ArrayList<Integer>>> x) {
        System.out.println("[");
        for(int i=0; i<x.size(); i++) {
            System.out.println("[");
            for (int j=0; j<x.get(i).size(); j++) {
                System.out.print("[");
                for (int k=0; k<x.get(i).get(j).size(); k++) {
                    System.out.print(x.get(i).get(j).get(k));
                }
                System.out.println("]");   
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
    
    public static void PrintArrayList (Object x) {}
    private static void experiment1() {
        try {
            Random myRandom=new Random();
            for (int i=0; i<10; i++) {
                int seed = myRandom.nextInt(400);
                System.out.println("Seed " + i + " is " + seed);
                //timer here
                DesastresBoard DB =new DesastresBoard(100,5,1,seed);
                Problem problem =  new Problem(DB,new DesastresSuccessorFunction(), new DesastresGoalTest(),new DesastresHeuristicFunction());
                Search search =  new HillClimbingSearch();
                SearchAgent agent = new SearchAgent(problem,search);
                //endtimer!
                //agent stuff here
                
                // test2
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,1,seed);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void TSPHillClimbingSearch(DesastresBoard TSPB) {
        System.out.println("\nTSP HillClimbing  -->");
        try {
            Problem problem =  new Problem(TSPB,new DesastresSuccessorFunction(), new DesastresGoalTest(),new DesastresHeuristicFunction());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            
            System.out.println();
            DesastresBoard b = (DesastresBoard) search.getGoalState();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
            System.out.println("Final time:" + b.getTime());
            PrintArrayList(b.getTravels());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void TSPSimulatedAnnealingSearch(DesastresBoard TSPB) {
        System.out.println("\nTSP Simulated Annealing  -->");
        try {
            Problem problem =  new Problem(TSPB,new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunction());
            SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(2000,100,5,0.001);
            //search.traceOn();
            SearchAgent agent = new SearchAgent(problem,search);
            
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }
        
    }
    
    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i).toString();
            System.out.println(action);
        }
    }
    
    
}


