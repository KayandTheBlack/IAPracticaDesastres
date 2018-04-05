
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
        experiment3_kLambda_4();
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
            for (int i=0; i<10; i++) {
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
    public static void experiment3(){
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

    private static void experiment3_kLambda_ini() {
        try {
            int n = 10;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);
            double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};
            int steps = 15000;
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

                        DesastresBoardv2 DB2 =new DesastresBoardv2(nGrupos,nCentros,nHelis,seed);
                        DB2.init2(nGrupos, nCentros, nHelis);
                        Problem problem =  new Problem(DB2,new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(steps,stiter,k,lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem,search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time-start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
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

    private static void experiment3_kLambda_4() {
        try {
            int n = 10;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);
            double lambdas[] = {0.01,0.001,0.0001};
            int ks[] = {1,3,5,10,15,20,30};
            int steps = 15000;
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

                        DesastresBoardv2 DB2 =new DesastresBoardv2(nGrupos,nCentros,nHelis,seed);
                        DB2.init2(nGrupos, nCentros, nHelis);
                        Problem problem =  new Problem(DB2,new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(steps,stiter,k,lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem,search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time-start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
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

    // lambda bo: al voltant 0.01, k no queda clar

    private static void experiment3_kLambda2() {
        try {
            int n = 10;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);
            double lambdas[] = {0.1,0.01,0.001};
            int ks[] = {1,5,25,125};
            int steps = 15000;
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

                        DesastresBoardv2 DB2 =new DesastresBoardv2(nGrupos,nCentros,nHelis,seed);
                        DB2.init2(nGrupos, nCentros, nHelis);
                        Problem problem =  new Problem(DB2,new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(steps,stiter,k,lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem,search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time-start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
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

    private static void experiment3_kLambda3() {
        try {
            int n = 10;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);
            double lambdas[] = {0.001};
            int ks[] = {1,5,25,50,100,125};
            int steps = 15000;
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

                        DesastresBoardv2 DB2 =new DesastresBoardv2(nGrupos,nCentros,nHelis,seed);
                        DB2.init2(nGrupos, nCentros, nHelis);
                        Problem problem =  new Problem(DB2,new DesastresSuccessorFunctionSA(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                        long start_time = System.currentTimeMillis();
                        SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(steps,stiter,k,lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem,search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time-start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
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


