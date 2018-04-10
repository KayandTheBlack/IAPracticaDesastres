
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
        //Random myRandom=new Random();
        //DesastresBoard DB =new DesastresBoard(5,1,2,1234); //modify for thingy
        //System.out.println("Original time:" + DB.getTime());
        //PrintArrayList(DB.getTravels());
        //TSPHillClimbingSearch(DB);
        //TSPSimulatedAnnealingSearch(DB);
        //experiment1();
        //experiment1_2();
        //DesastresBoardv2 DB =new DesastresBoardv2(10,5,2,1234);
        //DB.init2(10,5,2);
        //PrintArrayList(DB.getTravels());
        //experiment2();
        //experiment8();
        //experiment33();
        //experiment3_steps();
        //experiment3_prevSteps();
        //experiment3_kLambda2();
        //experiment888();
        //experiment88();
        //experiment3_prevSteps();
        //experiment7();
        //experiment7_2();
        experiment4(0,2);
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
    
    private static void experiment1() {
        try {
            Random myRandom=new Random();
            ArrayList<Integer> seeds = new ArrayList(10);
            ArrayList<Long> times1 = new ArrayList(10);
            ArrayList<Double> x = new ArrayList(10);
            ArrayList<Long> times2 = new ArrayList(10);
            ArrayList<Double> y = new ArrayList(10);
            for (int i=0; i<10; i++) {
                int seed = myRandom.nextInt(400);
                //System.out.println("Seed " + i + " is " + seed);
                //timer here
                long start_time = System.currentTimeMillis();
                DesastresBoard DB =new DesastresBoard(100,5,1,seed);
                Problem problem =  new Problem(DB,new DesastresSuccessorFunction(), new DesastresGoalTest(),new DesastresHeuristicFunction());
                Search search =  new HillClimbingSearch();
                SearchAgent agent = new SearchAgent(problem,search);
                long end_time = System.currentTimeMillis();
                //agent stuff here
                long difference = end_time-start_time;
                DesastresBoard b = (DesastresBoard) search.getGoalState();
                double time = b.getTime();
                
                // test2
                start_time = System.currentTimeMillis();
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,1,seed);
                DB2.init0(100, 5, 1);
                Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search2 = new HillClimbingSearch();
                SearchAgent agent2 = new SearchAgent(problem2,search2);
                end_time = System.currentTimeMillis();
                long difference2 = end_time-start_time;
                DesastresBoardv2 b2 = (DesastresBoardv2) search2.getGoalState();
                double time2 = b2.getTime(); 
                //System.out.println(time2);
                //System.out.println(difference + " " + difference2);
                /*double debug = b2.computeTotalTime();
                if(time2 != debug) System.out.println("ERRORTIME : " + time2 +' '+ debug);*/
                
                seeds.add(seed);
                x.add(time);
                times1.add(difference);
                y.add(time2);
                times2.add(difference2);
            }
            System.out.println("seeds time1 time2 exec1 exec2");
            for(int i=0; i<10; i++) {
                System.out.println(seeds.get(i) + " " + x.get(i) + " " + y.get(i) + " " + times1.get(i) + " " + times2.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void experiment1_2() {
        try {
            Random myRandom=new Random();
            ArrayList<Integer> seeds = new ArrayList(10);
            ArrayList<Long> times1 = new ArrayList(10);
            ArrayList<Double> x = new ArrayList(10);
            ArrayList<Long> times2 = new ArrayList(10);
            ArrayList<Double> y = new ArrayList(10);
            for (int i=0; i<10; i++) {
                int seed = myRandom.nextInt(400);
                //System.out.println("Seed " + i + " is " + seed);
                //timer here
                long start_time = System.currentTimeMillis();
                DesastresBoardv2 DB =new DesastresBoardv2(100,5,1,seed);
                DB.init0(100, 5, 1);
                Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search =  new HillClimbingSearch();
                SearchAgent agent = new SearchAgent(problem,search);
                long end_time = System.currentTimeMillis();
                //agent stuff here
                long difference = end_time-start_time;
                DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                double time = b.getTime();
                
                // test2
                start_time = System.currentTimeMillis();
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,1,seed);
                DB2.init0(100, 5, 1);
                Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionv3(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search2 = new HillClimbingSearch();
                SearchAgent agent2 = new SearchAgent(problem2,search2);
                end_time = System.currentTimeMillis();
                long difference2 = end_time-start_time;
                DesastresBoardv2 b2 = (DesastresBoardv2) search2.getGoalState();
                double time2 = b2.getTime(); 
                //System.out.println(time2);
                //System.out.println(difference + " " + difference2);
                /*double debug = b2.computeTotalTime();
                if(time2 != debug) System.out.println("ERRORTIME : " + time2 +' '+ debug); //DEBUGGER!*/
                
                seeds.add(seed);
                x.add(time);
                times1.add(difference);
                y.add(time2);
                times2.add(difference2);
            }
            System.out.println("seeds time1 time2 exec1 exec2");
            for(int i=0; i<10; i++) {
                System.out.println(seeds.get(i) + " " + x.get(i) + " " + y.get(i) + " " + times1.get(i) + " " + times2.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void experiment2() {
        try {
            Random myRandom=new Random();
            ArrayList<Integer> seeds = new ArrayList(10);
            ArrayList<Long> times1 = new ArrayList(10);
            ArrayList<Double> x = new ArrayList(10);
            ArrayList<Long> times2 = new ArrayList(10);
            ArrayList<Double> y = new ArrayList(10);
            ArrayList<Long> times3 = new ArrayList(10);
            ArrayList<Double> z = new ArrayList(10);
            for (int i=0; i<30; i++) {
                //init0
                int seed = myRandom.nextInt(400);
                long start_time = System.currentTimeMillis();
                DesastresBoardv2 DB =new DesastresBoardv2(100,5,1,seed);
                DB.init0(100, 5, 1);
                Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search =  new HillClimbingSearch();
                SearchAgent agent = new SearchAgent(problem,search);
                long end_time = System.currentTimeMillis();
                long difference = end_time-start_time;
                DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                double time = b.getTime();
                
                // init1
                start_time = System.currentTimeMillis();
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,1,seed);
                DB2.init1(100, 5, 1);
                Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search2 = new HillClimbingSearch();
                SearchAgent agent2 = new SearchAgent(problem2,search2);
                end_time = System.currentTimeMillis();
                long difference2 = end_time-start_time;
                DesastresBoardv2 b2 = (DesastresBoardv2) search2.getGoalState();
                double time2 = b2.getTime(); 
                // init2
                start_time = System.currentTimeMillis();
                DesastresBoardv2 DB3 =new DesastresBoardv2(100,5,1,seed);
                DB3.init2(100, 5, 1);
                Problem problem3 = new Problem(DB3, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search3 = new HillClimbingSearch();
                SearchAgent agent3 = new SearchAgent(problem3,search3);
                end_time = System.currentTimeMillis();
                long difference3 = end_time-start_time;
                DesastresBoardv2 b3 = (DesastresBoardv2) search3.getGoalState();
                double time3 = b3.getTime(); 
                
                seeds.add(seed);
                x.add(time);
                times1.add(difference);
                y.add(time2);
                times2.add(difference2);
                z.add(time3);
                times3.add(difference3);
            }
            System.out.println("seeds time1 time2 time3 exec1 exec2 exec3");
            for(int i=0; i<10; i++) {
                System.out.println(seeds.get(i) + " " + x.get(i) + " " + y.get(i) + " " + z.get(i) + " " + times1.get(i) + " " + times2.get(i) + " " + times3.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void experiment7() {
        try {
            int n = 1;
            
            Random myRandom=new Random();
            int seeds [] = new int[10];
            
            long times1 [][]= new long[10][n];
            //ArrayList<Double> x = new ArrayList(10);
            long times2 [][] = new long[10][n];
            //ArrayList<Double> y = new ArrayList(10);
            
            double h1Hill [][]= new double[10][n];
            double h2Hill [][]= new double[10][n];
            double h1SA [][]= new double[10][n];
            double h2SA [][]= new double[10][n];
            
            for (int i=0; i<10; i++) {
                int seed = myRandom.nextInt(400);
                //System.out.println("Seed " + i + " is " + seed);
                //timer here
                
                for (int exp = 1; exp <= n; exp++){
                    
                    long start_time = System.currentTimeMillis();
                    DesastresBoardv3 DB =new DesastresBoardv3(100,5,1,seed);
                    DB.init0(100,5,1);
                    Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv4(), new DesastresGoalTest(),new DesastresHeuristicFunctionv3((2^(exp-1))));
                    Search search =  new HillClimbingSearch();
                    SearchAgent agent = new SearchAgent(problem,search);
                    long end_time = System.currentTimeMillis();
                    //agent stuff here
                    long difference = end_time-start_time;
                    DesastresBoardv3 b = (DesastresBoardv3) search.getGoalState();
                    DesastresHeuristicFunctionv3 DesHF  = new DesastresHeuristicFunctionv3((2^(exp-1)));
                    double time = DesHF.getHeuristicValue(b);
                    h1Hill[i][exp-1] = b.getTime();
                    h2Hill[i][exp-1] = b.getMaxTimePriority();
                    
                    //h1Hill[i][exp-1] = 0;
                    //h2Hill[i][exp-1] = 0;
                    
                    
                    // test2
                    //have to modify so it does SA

                    long difference2 = 0;
                    double time2 = 0;
                    double tmph1SA = 0;
                    double tmph2SA = 0;

                    for (int j = 0; j < 3; j++){

                        start_time = System.currentTimeMillis();
                        DesastresBoardv3 DB2 =new DesastresBoardv3(100,5,1,seed);
                        DB2.init0(100, 5, 1);
                        Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionSAv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv3((2^(exp-1))));
                        Search search2 = new SimulatedAnnealingSearch(30400, 160, 5, 0.0001); //params from experiment 3
                        SearchAgent agent2 = new SearchAgent(problem2,search2);
                        end_time = System.currentTimeMillis();
                        difference2 += end_time-start_time;
                        DesastresBoardv3 b2 = (DesastresBoardv3) search2.getGoalState();
                        time2 += DesHF.getHeuristicValue(b2);
                        tmph1SA += b2.getTime();
                        tmph2SA += b2.getMaxTimePriority();
                    }

                    time2 = time2 / 3.0;
                    difference2 = difference2 / 3;
                    h1SA[i][exp-1] = tmph1SA/3.0;
                    h2SA[i][exp-1] = tmph2SA/3.0;

                    //System.out.println(time2);
                    //System.out.println(difference + " " + difference2);
                    /*double debug = b2.computeTotalTime();
                    if(time2 != debug) System.out.println("ERRORTIME : " + time2 +' '+ debug);*/

                    seeds[i] = seed;
                    //x.add(time);
                    //times1[i][exp-1] = 0;
                    times1[i][exp-1] = difference;
                    //y.add(time2);
                    times2[i][exp-1] = difference2;
                    
                }
                
                
            }
            //System.out.println("seeds time1 time2 exec1 exec2");
            System.out.print("seeds");
            for (int exp = 1; exp <= n; exp++){
                System.out.print(" HillH1_"+exp+ " HillH2_"+exp + " HillHT_"+exp+ " HillExec"+exp+" SAH1_"+exp+ " SAH2_"+exp + " SAHT_"+exp+ " SAExec"+exp );
            }
            System.out.println();
            
            for(int i=0; i<10; i++) {
                System.out.print(seeds[i]+" ");
                for (int exp = 1; exp <= n; exp++){
                    double tmphHill = h1Hill[i][exp-1] + (h2Hill[i][exp-1]*(2^(exp-1)));
                    double tmphSA = h1SA[i][exp-1] + (h2SA[i][exp-1]*(2^(exp-1)));
                    System.out.print(h1Hill[i][exp-1]+" "+ h2Hill[i][exp-1]+" " + tmphHill +" " + times1[i][exp-1]+" " + h1SA[i][exp-1]+" "+ h2SA[i][exp-1]+" " + tmphSA +" " + times2[i][exp-1]+" " );
                }
                System.out.println();
                //System.out.println(seeds.get(i) + " " + x.get(i) + " " + y.get(i) + " " + times1.get(i) + " " + times2.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void experiment7_2() {
        try {
            int n = 1;
            
            Random myRandom=new Random();
            int seeds [] = new int[10];
            
            long times1 [][]= new long[10][n];
            //ArrayList<Double> x = new ArrayList(10);
            long times2 [][] = new long[10][n];
            //ArrayList<Double> y = new ArrayList(10);
            
            double h1Hill [][]= new double[10][n];
            double h2Hill [][]= new double[10][n];
            double h1SA [][]= new double[10][n];
            double h2SA [][]= new double[10][n];
            
            for (int i=0; i<10; i++) {
                int seed = myRandom.nextInt(400);
                //System.out.println("Seed " + i + " is " + seed);
                //timer here
                
                for (int exp = 1; exp <= n; exp++){
                    
                    long start_time = System.currentTimeMillis();
                    DesastresBoardv3 DB =new DesastresBoardv3(100,5,1,seed);
                    DB.init0(100,5,1);
                    Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv4(), new DesastresGoalTest(),new DesastresHeuristicFunctionv3((2^(exp-1))));
                    Search search =  new HillClimbingSearch();
                    SearchAgent agent = new SearchAgent(problem,search);
                    long end_time = System.currentTimeMillis();
                    //agent stuff here
                    long difference = end_time-start_time;
                    DesastresBoardv3 b = (DesastresBoardv3) search.getGoalState();
                    DesastresHeuristicFunctionv3 DesHF  = new DesastresHeuristicFunctionv3((2^(exp-1)));
                    double time = DesHF.getHeuristicValue(b);
                    h1Hill[i][exp-1] = b.getTime();
                    h2Hill[i][exp-1] = b.getMaxTimePriority();
                    
                    //h1Hill[i][exp-1] = 0;
                    //h2Hill[i][exp-1] = 0;
                    
                    
                    // test2
                    //have to modify so it does SA

                    long difference2 = 0;
                    double time2 = 0;
                    double tmph1SA = 0;
                    double tmph2SA = 0;

                    for (int j = 0; j < 3; j++){

                        start_time = System.currentTimeMillis();
                        DesastresBoardv3 DB2 =new DesastresBoardv3(100,5,1,seed);
                        DB2.init0(100, 5, 1);
                        Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionSAv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv3((2^(exp-1))));
                        Search search2 = new SimulatedAnnealingSearch(30400, 160, 5, 0.0001); //params from experiment 3
                        SearchAgent agent2 = new SearchAgent(problem2,search2);
                        end_time = System.currentTimeMillis();
                        difference2 += end_time-start_time;
                        DesastresBoardv3 b2 = (DesastresBoardv3) search2.getGoalState();
                        time2 += DesHF.getHeuristicValue(b2);
                        tmph1SA += b2.getTime();
                        tmph2SA += b2.getMaxTimePriority();
                    }

                    time2 = time2 / 3.0;
                    difference2 = difference2 / 3;
                    h1SA[i][exp-1] = tmph1SA/3.0;
                    h2SA[i][exp-1] = tmph2SA/3.0;

                    //System.out.println(time2);
                    //System.out.println(difference + " " + difference2);
                    /*double debug = b2.computeTotalTime();
                    if(time2 != debug) System.out.println("ERRORTIME : " + time2 +' '+ debug);*/

                    seeds[i] = seed;
                    //x.add(time);
                    //times1[i][exp-1] = 0;
                    times1[i][exp-1] = difference;
                    //y.add(time2);
                    times2[i][exp-1] = difference2;
                    
                }
                
                
            }
            
            long times1_2 []= new long[10];
            //ArrayList<Double> x = new ArrayList(10);
            long times2_2 [] = new long[10];
            //ArrayList<Double> y = new ArrayList(10);
            
            double h1Hill_2 []= new double[10];
            double h1SA_2 []= new double[10];
            
            for (int i=0; i<10; i++) {
                    long start_time = System.currentTimeMillis();
                    DesastresBoardv2 DB =new DesastresBoardv2(100,5,1,seeds[i]);
                    DB.init0(100,5,1);
                    Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                    Search search =  new HillClimbingSearch();
                    SearchAgent agent = new SearchAgent(problem,search);
                    long end_time = System.currentTimeMillis();
                    //agent stuff here
                    long difference = end_time-start_time;
                    DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                    DesastresHeuristicFunctionv2 DesHF  = new DesastresHeuristicFunctionv2();
                    double time = DesHF.getHeuristicValue(b);
                    h1Hill_2[i] = b.getTime();
                    
                    //h1Hill[i][exp-1] = 0;
                    //h2Hill[i][exp-1] = 0;
                    
                    
                    // test2
                    //have to modify so it does SA

                    long difference2 = 0;
                    double time2 = 0;
                    double tmph1SA = 0;

                    for (int j = 0; j < 3; j++){

                        start_time = System.currentTimeMillis();
                        DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,1,seeds[i]);
                        DB2.init0(100, 5, 1);
                        Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                        Search search2 = new SimulatedAnnealingSearch(30400, 160, 5, 0.0001); //params from experiment 3
                        SearchAgent agent2 = new SearchAgent(problem2,search2);
                        end_time = System.currentTimeMillis();
                        difference2 += end_time-start_time;
                        DesastresBoardv2 b2 = (DesastresBoardv2) search2.getGoalState();
                        time2 += DesHF.getHeuristicValue(b2);
                        tmph1SA += b2.getTime();
                    }

                    time2 = time2 / 3.0;
                    difference2 = difference2 / 3;
                    h1SA_2[i] = tmph1SA/3.0;

                    //System.out.println(time2);
                    //System.out.println(difference + " " + difference2);
                    /*double debug = b2.computeTotalTime();
                    if(time2 != debug) System.out.println("ERRORTIME : " + time2 +' '+ debug);*/

                    //seeds[i] = seed;
                    //x.add(time);
                    //times1[i][exp-1] = 0;
                    times1_2[i] = difference;
                    //y.add(time2);
                    times2_2[i] = difference2;
                
                
            }
            
            
            //System.out.println("seeds time1 time2 exec1 exec2");
            System.out.print("seeds");
            for (int exp = 1; exp <= n; exp++){
                System.out.print(" HillH1_"+exp+ " HillH2_"+exp + " HillHT_"+exp+ " HillExec"+exp+" SAH1_"+exp+ " SAH2_"+exp + " SAHT_"+exp+ " SAExec"+exp );
            }
            System.out.print(" HillH1_Old HillExec_Old SAH1_Old SAExec_Old");
            System.out.println();
            
            for(int i=0; i<10; i++) {
                System.out.print(seeds[i]+" ");
                for (int exp = 1; exp <= n; exp++){
                    double tmphHill = h1Hill[i][exp-1] + (h2Hill[i][exp-1]*(2^(exp-1)));
                    double tmphSA = h1SA[i][exp-1] + (h2SA[i][exp-1]*(2^(exp-1)));
                    System.out.print(h1Hill[i][exp-1]+" "+ h2Hill[i][exp-1]+" " + tmphHill +" " + times1[i][exp-1]+" " + h1SA[i][exp-1]+" "+ h2SA[i][exp-1]+" " + tmphSA +" " + times2[i][exp-1]+" " );
                }
                System.out.print(" " + h1Hill_2[i] +" "+times1_2[i]+" "+h1SA_2[i]+" "+times2_2[i] );
                System.out.println();
                //System.out.println(seeds.get(i) + " " + x.get(i) + " " + y.get(i) + " " + times1.get(i) + " " + times2.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void experiment8(){
        try{
            double time=0; long exectime =0;
            for(int i=0; i<10; i++){
                long start_time = System.currentTimeMillis();
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,1,1234);
                DB2.init2(100, 5, 1);
                Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search2 = new HillClimbingSearch();
                SearchAgent agent2 = new SearchAgent(problem2,search2);
                long end_time = System.currentTimeMillis();
                exectime += end_time-start_time;
                DesastresBoardv2 b = (DesastresBoardv2) search2.getGoalState();
                time += b.getTime();
            }
            System.out.println("Mean problem time: " + time/10. + ";  Mean execution time: " + exectime/10);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

/*

    public static void experiment33(){
        Random myRandom=new Random();
        //DesastresBoard DB =new DesastresBoard(5,1,2,1234); //modify for thingy
        DesastresBoardv2 DB =new DesastresBoardv2(100,5,1,1234);
        DB.init2(100, 5, 1);
        System.out.println("Original time:" + DB.getTime());
        //PrintArrayList(DB.getTravels());
        //TSPHillClimbingSearch(DB);
        TSPHillClimbingSearch2(DB);
        TSPSimulatedAnnealingSearch(DB);
        //experiment1();
        //experiment1_2();
        //DesastresBoardv2 DB =new DesastresBoardv2(10,5,2,1234);
        //DB.init2(10,5,2);
        //PrintArrayList(DB.getTravels());

    }
    private static void TSPHillClimbingSearch(DesastresBoard TSPB) {
        System.out.println("\nTSP HillClimbing  -->");
        try {
            Problem problem =  new Problem(TSPB,new DesastresSuccessorFunction(), new DesastresGoalTest(),new DesastresHeuristicFunction());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);

            System.out.println();
            DesastresBoard b = (DesastresBoard) search.getGoalState();
            //printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
            System.out.println("Initial time = " + TSPB.getTime() + "Final time:" + b.getTime());
            //PrintArrayList(b.getTravels());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void TSPHillClimbingSearch2(DesastresBoardv2 TSPB) {
        System.out.println("\nTSP HillClimbing  -->");
        try {


            Problem problem =  new Problem(TSPB,new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
            long start_time = System.currentTimeMillis();
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            long end_time = System.currentTimeMillis();
            long exectime = end_time-start_time;
            System.out.println();
            DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
            //printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
            System.out.println("Initial time = " + TSPB.getTime() + "Final time:" + b.getTime());
            System.out.println("exectime = " + exectime);
            //PrintArrayList(b.getTravels());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void TSPSimulatedAnnealingSearch(DesastresBoardv2 TSPB) {
        System.out.println("\nTSP Simulated Annealing  -->");
        try {
            Problem problem =  new Problem(TSPB,new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
            long start_time = System.currentTimeMillis();
            SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(2000,100,5,0.001);

            //search.traceOn();
            SearchAgent agent = new SearchAgent(problem,search);
            long end_time = System.currentTimeMillis();
            long exectime = end_time-start_time;
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
            DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
            System.out.println("Initial time = " + TSPB.getTime() + "Final time:" + b.getTime());
            System.out.println("exectime = " + exectime);


            //PrintArrayList(b.getTravels());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

*/

    private static void experiment3_prevSteps() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> valuesSA = new ArrayList(n);
            ArrayList<ArrayList<Double>> valuesHC = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_timesSA = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_timesHC = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_steps = new ArrayList(n);

            // 1
            // int steps[] = {5000,10000,20000,30000};

            // 2
            //int steps[] = {10000,20000,30000,60000,120000};

            // 3
            //int steps[] = {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};

            // 4
            //int steps[] = {1000000,1250000,1500000,1750000,2000000}

            /*int stiter = 100;
            double lambda = 0.005;
            int k = 20;*/

            // Paso final steps
            int stiter = 160;
            double lambda = 0.0001;
            int k = 5;
            int steps[] = {5120,10400,20000,30400,40000,80000,160000};

            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> valuesSA_set = new ArrayList(steps.length);
                ArrayList<Double> valuesHC_set = new ArrayList(steps.length);
                ArrayList<Long> exec_timesSA_set = new ArrayList(steps.length);
                ArrayList<Long> exec_timesHC_set = new ArrayList(steps.length);
                ArrayList<Integer> used_steps_set = new ArrayList(steps.length);
                for (int j = 0; j < steps.length; j++) {
                    int step = steps[j];
                    double valueMeanSA = 0;
                    double valueMeanHC = 0;
                    long exec_timeMeanSA = 0;
                    long exec_timeMeanHC = 0;

                    for (int z = 0; z < nReps; z++) {
                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(step, stiter, k, lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        valueMeanSA += b.getTime();
                        exec_timeMeanSA += exec_time;



                        DesastresBoardv2 DBHC = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DBHC.init0(nGrupos, nCentros, nHelis);
                        Problem problemHC = new Problem(DBHC, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        long start_timeHC = System.currentTimeMillis();
                        HillClimbingSearch searchHC = new HillClimbingSearch();
                        SearchAgent agentHC = new SearchAgent(problemHC, searchHC);
                        long end_timeHC = System.currentTimeMillis();
                        long exec_timeHC = end_timeHC - start_timeHC;
                        DesastresBoardv2 bHC = (DesastresBoardv2) searchHC.getGoalState();
                        valueMeanHC += bHC.getTime();
                        exec_timeMeanHC += exec_timeHC;
                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        /*values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
                        used_steps_set.add(step);*/
                    }
                    valueMeanSA = valueMeanSA/nReps;
                    valueMeanHC= valueMeanHC/nReps;
                    exec_timeMeanSA = exec_timeMeanSA/nReps;
                    exec_timeMeanHC = exec_timeMeanHC/nReps;
                    valuesSA_set.add(valueMeanSA);
                    valuesHC_set.add(valueMeanHC);
                    exec_timesSA_set.add(exec_timeMeanSA);
                    exec_timesHC_set.add(exec_timeMeanHC);
                    used_steps_set.add(step);
                }
                /*values.set(i,values_set);
                exec_times.set(i,exec_times_set);*/
                valuesSA.add(valuesSA_set);
                valuesHC.add(valuesHC_set);
                exec_timesSA.add(exec_timesSA_set);
                exec_timesHC.add(exec_timesHC_set);
                used_steps.add(used_steps_set);

            }
            System.out.println("seed steps costSA costHC exec_timeSA exec_timeHC");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < steps.length; j++) {
                    int st = used_steps.get(i).get(j);
                    double vSA = valuesSA.get(i).get(j);
                    double vHC = valuesHC.get(i).get(j);
                    double etSA = exec_timesSA.get(i).get(j);
                    double etHC = exec_timesHC.get(i).get(j);
                    System.out.println(s + " " + st + " " + vSA + " " + vHC + " " +  etSA + " " + etHC);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void experiment3_kLambda2() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);

            // 1
            /*double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};*/
            // 2
            double lambdas[] = {0.001, 0.0001,0.00001};
            int ks[] = {1,5,10,15};


            int steps = 20000;
            int stiter = 100;
            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> values_set = new ArrayList(lambdas.length*ks.length);
                ArrayList<Long> exec_times_set = new ArrayList(lambdas.length*ks.length);
                ArrayList<Integer> used_ks_set = new ArrayList(lambdas.length*ks.length);
                ArrayList<Double> used_lambdas_set = new ArrayList(lambdas.length*ks.length);
                for (int j = 0; j < lambdas.length; j++) {
                    double lambda = lambdas[j];
                    for (int h = 0; h < ks.length; h++) {
                        int k = ks[h];
                        double meanValue = 0;
                        long meanExecTime = 0;
                        for (int z = 0; z < nReps; z++) {

                            DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                            DB2.init0(nGrupos, nCentros, nHelis);
                            Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                            long start_time = System.currentTimeMillis();
                            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(steps, stiter, k, lambda);
                            //search.traceOn();
                            SearchAgent agent = new SearchAgent(problem, search);
                            long end_time = System.currentTimeMillis();
                            long exec_time = end_time - start_time;
                            DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                            meanValue += b.getTime();
                            meanExecTime += exec_time;
                        }
                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        values_set.add(meanValue/nReps);
                        exec_times_set.add(meanExecTime/nReps);
                        used_ks_set.add(k);
                        used_lambdas_set.add(lambda);
                    }
                }
                /*values.set(i,values_set);
                exec_times.set(i,exec_times_set);*/
                values.add(values_set);
                exec_times.add(exec_times_set);
                used_ks.add( used_ks_set);
                used_lambdas.add(used_lambdas_set);

            }
            System.out.println("seed lambda k value exec_time");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < lambdas.length*ks.length; j++) {
                    double l = used_lambdas.get(i).get(j);
                    int k = used_ks.get(i).get(j);
                    double v = values.get(i).get(j);
                    double et = exec_times.get(i).get(j);
                    System.out.println(s + " " + " " + l + " " + k + " " + v + " " + et);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void experiment3_stiter2() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_stiters = new ArrayList(n);

            int stiters[] = {50,80,100,125,160,200,250,400,500,625,800,1000,1250};

            int steps = 20000;
            double lambda = 0.0001;
            int k = 5;
            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> values_set = new ArrayList(stiters.length);
                ArrayList<Long> exec_times_set = new ArrayList(stiters.length);
                ArrayList<Integer> used_stiter_set = new ArrayList(stiters.length);
                for (int j = 0; j < stiters.length; j++) {
                    int stiter = stiters[j];
                    double meanValue = 0;
                    long meanExecTime = 0;

                    for (int z = 0; z < nReps; z++) {

                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(steps, stiter, k, lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        meanValue += b.getTime();
                        meanExecTime += exec_time;
                    }
                    //printInstrumentation(agent.getInstrumentation());
                    //values_set.set(j*lambdas.length + h,b.getTime());
                    //exec_times_set.set(j*lambdas.length + h,exec_time);
                    values_set.add(meanValue/nReps);
                    exec_times_set.add(meanExecTime/nReps);
                    used_stiter_set.add(stiter);
                }
                /*values.set(i,values_set);
                exec_times.set(i,exec_times_set);*/
                values.add(values_set);
                exec_times.add(exec_times_set);
                used_stiters.add(used_stiter_set);

            }
            System.out.println("seed stiter value exec_time");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < stiters.length; j++) {
                    int st = used_stiters.get(i).get(j);
                    double v = values.get(i).get(j);
                    double et = exec_times.get(i).get(j);
                    System.out.println(s + " " + st + " " + v + " " + et);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void experiment4(int lowerIt, int maxIt) {
        try {
            int n = 1;
            int nReps = 3;
            //int nCentrosAProbar = 1; // mantener proporcion 5:100 centros/grupos
            int nCentrosAProbar = maxIt-lowerIt+1;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> valuesSA = new ArrayList(n);
            ArrayList<ArrayList<Double>> valuesHC = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_timesSA = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_timesHC = new ArrayList(n);
            //ArrayList<ArrayList<Integer>> used_nGrupos = new ArrayList(n);
            //ArrayList<ArrayList<Integer>> used_nCentros = new ArrayList(n);




            /*5:100
para centros y grupos. Comenzad con 5 centros de distribución e incrementad el número de 5 en 5
hasta que se vea la tendencia*/


            int steps = 30400;
            int stiter = 160;
            int k = 5;
            double lambda = 0.0001;

            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> valuesSA_set = new ArrayList(nCentrosAProbar);
                ArrayList<Double> valuesHC_set = new ArrayList(nCentrosAProbar);
                ArrayList<Long> exec_timesSA_set = new ArrayList(nCentrosAProbar);
                ArrayList<Long> exec_timesHC_set = new ArrayList(nCentrosAProbar);
                //ArrayList<Integer> used_nGrupos_set = new ArrayList(nCentrosAProbar);
                //ArrayList<Integer> used_nCentros_set = new ArrayList(nCentrosAProbar);
                //for (int j = 0; j < nCentrosAProbar; j++) {
                for (int j = lowerIt; j <= maxIt; j++) {
                    int nCentros = 5 + j*5;
                    int nGrupos = nCentros * 20;
                    double valueMeanSA = 0;
                    double valueMeanHC = 0;
                    long exec_timeMeanSA = 0;
                    long exec_timeMeanHC = 0;
                    System.out.println("Test suite with " + nCentros + "c, " + nGrupos+"g");
                    for (int z = 0; z < nReps; z++) {
                        long start_time = System.currentTimeMillis();
                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(steps, stiter, k, lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        valueMeanSA += b.getTime();
                        exec_timeMeanSA += exec_time;

                        System.out.print("SA" + z);
                    }
                    //HC
                    long start_timeHC = System.currentTimeMillis();
                     DesastresBoardv2 DBHC = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                     DBHC.init0(nGrupos, nCentros, nHelis);
                     Problem problemHC = new Problem(DBHC, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                     HillClimbingSearch searchHC = new HillClimbingSearch();
                     SearchAgent agentHC = new SearchAgent(problemHC, searchHC);
                     long end_timeHC = System.currentTimeMillis();
                     long exec_timeHC = end_timeHC - start_timeHC;
                     DesastresBoardv2 bHC = (DesastresBoardv2) searchHC.getGoalState();
                     valueMeanHC += bHC.getTime();
                     exec_timeMeanHC += exec_timeHC;
                     System.out.println(" HC");
                     
                    valueMeanSA = valueMeanSA/nReps;
                    exec_timeMeanSA = exec_timeMeanSA/nReps;
                    valuesSA_set.add(valueMeanSA);
                    valuesHC_set.add(valueMeanHC);
                    exec_timesSA_set.add(exec_timeMeanSA);
                    exec_timesHC_set.add(exec_timeMeanHC);
                }
                valuesSA.add(valuesSA_set);
                valuesHC.add(valuesHC_set);
                exec_timesSA.add(exec_timesSA_set);
                exec_timesHC.add(exec_timesHC_set);

            }
            System.out.println("seed nCentros nGrupos costSA costHC exec_timeSA exec_timeHC");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < nCentrosAProbar; j++) {
                    //int nC = used_nCentros.get(i).get(j);
                    //int nG = used_nGrupos.get(i).get(j);
                    double vSA = valuesSA.get(i).get(j);
                    double vHC = valuesHC.get(i).get(j);
                    double etSA = exec_timesSA.get(i).get(j);
                    double etHC = exec_timesHC.get(i).get(j);
                    System.out.println(s + " " + 5+5*j + " " + 20*(5+5*j) + " " + vSA + " " + vHC + " " +  etSA + " " + etHC);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void experiment5_esc1() {
        try {
            int n = 10;
            int nReps = 3;
            int nGruposAProbar = 4;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_nGrupos = new ArrayList(n);

            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> values_set = new ArrayList(nGruposAProbar);
                ArrayList<Long> exec_times_set = new ArrayList(nGruposAProbar);
                ArrayList<Integer> used_nGrupos_set = new ArrayList(nGruposAProbar);
                for (int j = 0; j < nGruposAProbar; j++) {
                    nGrupos = nGrupos + j*50;
                    double meanValue = 0;
                    long meanExecTime = 0;

                    for (int z = 0; z < nReps; z++) {

                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        HillClimbingSearch search = new HillClimbingSearch();
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        meanValue += b.getTime();
                        meanExecTime += exec_time;
                    }
                    values_set.add(meanValue/nReps);
                    exec_times_set.add(meanExecTime/nReps);
                    used_nGrupos_set.add(nGrupos);
                }
                values.add(values_set);
                exec_times.add(exec_times_set);
                used_nGrupos.add(used_nGrupos_set);

            }
            System.out.println("seed nCentros nGrupos value exec_time");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < nGruposAProbar; j++) {
                    int nG = used_nGrupos.get(i).get(j);
                    double v = values.get(i).get(j);
                    double et = exec_times.get(i).get(j);
                    System.out.println(s + " " + nCentros + " " + nG + " " + v + " " + et);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void experiment5_esc2() {
        try {
            int n = 10;
            int nReps = 3;
            int nCentrosAProbar = 4;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_nCentros = new ArrayList(n);

            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> values_set = new ArrayList(nCentrosAProbar);
                ArrayList<Long> exec_times_set = new ArrayList(nCentrosAProbar);
                ArrayList<Integer> used_nCentros_set = new ArrayList(nCentrosAProbar);
                for (int j = 0; j < nCentrosAProbar; j++) {
                    nCentros = nCentros + j*5;
                    double meanValue = 0;
                    long meanExecTime = 0;

                    for (int z = 0; z < nReps; z++) {

                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        HillClimbingSearch search = new HillClimbingSearch();
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        meanValue += b.getTime();
                        meanExecTime += exec_time;
                    }
                    values_set.add(meanValue/nReps);
                    exec_times_set.add(meanExecTime/nReps);
                    used_nCentros_set.add(nCentros);
                }
                values.add(values_set);
                exec_times.add(exec_times_set);
                used_nCentros.add(used_nCentros_set);

            }
            System.out.println("seed nCentros nGrupos value exec_time");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < nCentrosAProbar; j++) {
                    int nC = used_nCentros.get(i).get(j);
                    double v = values.get(i).get(j);
                    double et = exec_times.get(i).get(j);
                    System.out.println(s + " " + nC + " " + nGrupos + " " + v + " " + et);

                }
            }

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


