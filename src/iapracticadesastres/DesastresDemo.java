
package iapracticadesastres;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import java.util.ArrayList;


public class DesastresDemo {
    
    public static void printMainMenu(){
        System.out.println("Por favor escoja una acción:");
        System.out.println("1- Correr experimento 1");
        System.out.println("2- Correr experimento 2");
        System.out.println("3- Correr experimento 3");
        System.out.println("4- Correr experimento 4");
        System.out.println("5- Correr experimento 5");
        System.out.println("6- Correr experimento 6");
        System.out.println("7- Correr experimento 7");
        System.out.println("8- Correr experimento 8");
        System.out.println("9- Terminar sesión");
    }
    public static void exp1Menu(Scanner sc){
        System.out.println("Por favor, escoja una acción:");
        System.out.println("1- Correr experimento 1.1:");
        System.out.println("      Comparativa entre los conjuntos de operadores 1 y 3");
        System.out.println("2- Correr experimento 1.2");
        System.out.println("      Comparativa entre los conjuntos de operadores 3 y 5");
        System.out.println("3- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment1();
                    System.out.println("");
                    break;
                case 2:
                    experiment1_2();
                    System.out.println("");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp1Menu(sc);
            }
    }
    public static void exp2Menu(Scanner sc){
        System.out.println("Por favor, escoja una acción:");
        System.out.println("1- Correr experimento 2:");
        System.out.println("      Comparativa entre las 3 inicializaciones possibles");
        System.out.println("2- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment2();
                    System.out.println("");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp2Menu(sc);
            }
    }
    public static void exp3Menu(Scanner sc){
        System.out.println("Por favor, escoja una acción:");
        System.out.println("1- Correr experimento 3.1:");
        System.out.println("      Comparativa entre varias cantidades de steps previo a buscar k, lambda y stiter");
        System.out.println("2- Correr experimento 3.2:");
        System.out.println("      Comparativa entre varias cantidades de k (1, 5, 25, 125) con distintas lambdas (1, 0.01, 0.0001) y 20k steps");
        System.out.println("3- Correr experimento 3.3:");
        System.out.println("      Comparativa entre varias cantidades de k (1, 5, 10, 15) con distintas lambdas (0.001, 0.0001, 0.00001) y 20k steps");
        System.out.println("4- Correr experimento 3.4:");
        System.out.println("      Comparativa entre varias cantidades de stiter con 20k steps, k=5 y lambda=0.0001");
        System.out.println("5- Correr experimento 3.5:");
        System.out.println("      Comparativa entre varias cantidades de steps k=5, lambda=0.0001 y stiter=160");
        System.out.println("6- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment3_prevSteps_first();
                    System.out.println("");
                    break;
                case 2:
                    experiment3_kLambda2_first();
                    System.out.println("");
                    break;
                case 3:
                    experiment3_kLambda2_second();
                    System.out.println("");
                    break;
                case 4:
                    experiment3_stiter2_first();
                    System.out.println("");
                    break;
                case 5:
                    experiment3_prevSteps_second();
                    System.out.println("");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp3Menu(sc);
            }
    }
    public static void exp4Menu(Scanner sc){
        System.out.println("Por favor, escoja una acción:");
        System.out.println("1- Correr experimento 4.1:");
        System.out.println("      Comparativa entre varias cantidades de steps con 5 centros y 100 grupos en SA");
        System.out.println("2- Correr experimento 4.2:");
        System.out.println("      Comparativa entre varias cantidades de steps con 35 centros y 700 grupos en SA");
        System.out.println("3- Correr experimento 4.3:");
        System.out.println("      Comparativa entre varias cantidades de k (1, 5, 25, 125) con distintas lambdas (1, 0.01, 0.0001), 500k steps y stiter=100");
        System.out.println("4- Correr experimento 4.4:");
        System.out.println("      Comparativa entre varias cantidades de k (5, 25, 50, 75, 100, 125, 150, 175, 200) con lambda=0.0001, 500k steps y stiter=100");
        System.out.println("5- Correr experimento 4.5:");
        System.out.println("      Comparativa entre varias cantidades de stiter con k=175, lambda=0.0001 y 500k steps");
        System.out.println("6- Correr experimento 4.6:");
        System.out.println("      Comparativa entre varias cantidades de steps (100k, 500k, 1M, 2M) con k=175, lambda=0.0001 y stiter=100");
        System.out.println("7- Correr experimento 4.7:");
        System.out.println("      Comparativa entre varias cantidades de centros (5, 10, 15) y grupos (100, 150, 200) manteniendo la proporción 100:5, con HC y SA");
        System.out.println("8- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment4OnlySA(0,0);
                    System.out.println("");
                    break;
                case 2:
                    experiment4OnlySA(6,6);
                    System.out.println("");
                    break;
                case 3:
                    experiment3_kLambda2_third();
                    System.out.println("");
                    break;
                case 4:
                    experiment3_kLambda2_fourth();
                    System.out.println("");
                    break;
                case 5:
                    experiment3_stiter2_second();
                    System.out.println("");
                    break;
                case 6:
                    experiment43_prevSteps(6,6);
                    System.out.println("");
                    break;
                case 7:
                    experiment4(0,2);
                    System.out.println("");
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp4Menu(sc);
            }
    }
    public static void exp5Menu(Scanner sc){
        System.out.println("Por favor escoja una acción:");
        System.out.println("1- Correr experimento 5.1:");
        System.out.println("      Comparativa entre varias cantidades de grupos con 5 centros y 1 helicoptero por centro");
        System.out.println("2- Correr experimento 5.2");
        System.out.println("      Comparativa entre varias cantidades de centros con 1 helicoptero por centro y 100 grupos");
        System.out.println("3- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment5_esc1();
                    System.out.println("");
                    break;
                case 2:
                    experiment5_esc2();
                    System.out.println("");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp5Menu(sc);
            }
    }
    public static void exp6Menu(Scanner sc){
        System.out.println("Por favor, escoja una acción:");
        System.out.println("1- Correr experimento 6.1:");
        System.out.println("      Comparativa entre 100 grupos, 5 centros y 1 helicoptero por centro contra lo mismo pero con 5 helicopteros por centro");
        System.out.println("2- Correr experimento 6.2");
        System.out.println("      Comparativa entre 100 grupos, 5 centros y 5 helicoptero por centro contra lo mismo pero con 25 centros y un 1 helicoptero por centro");
        System.out.println("3- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment6_1();
                    System.out.println("");
                    break;
                case 2:
                    experiment6_2();
                    System.out.println("");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp6Menu(sc);
            }
    }
    public static void exp7Menu(Scanner sc){
        System.out.println("Por favor, escoja una acción:");
        System.out.println("1- Correr experimento 7.1:");
        System.out.println("      Comparativa entre heuristica 1 (sin segundo valor a optimizar) y heursitica 2.1 (con)");
        System.out.println("2- Correr experimento 7.2:");
        System.out.println("      Comparativa de varios valores de lambda = 2^(n-1) para n = [1..8]");
        System.out.println("3- Correr experimento 7.3:");
        System.out.println("      Comparativa de varios valores de lambda = 2^(n-1) para n = [1..16] pero solo con SA");
        System.out.println("4- Correr experimento 7.4:");
        System.out.println("      Comparativa entre la nueva heuristica y la version modificada de esta");
        System.out.println("5- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment7_1();
                    System.out.println("");
                    break;
                case 2:
                    experiment7_2();
                    System.out.println("");
                    break;
                case 3:
                    experiment7_3();
                    System.out.println("");
                    break;
                case 4:
                    experiment7_4();
                    System.out.println("");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp7Menu(sc);
            }
    }
    public static void exp8Menu(Scanner sc){
        System.out.println("Por favor escoja una acción:");
        System.out.println("1- Correr experimento 8.1:");
        System.out.println("      Correr el algoritmo con las condiciones de los experimentos 1 y 2 con seed 1234 y obtener las medias");
        System.out.println("2- Volver al menú principal");
        int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    experiment8();
                    System.out.println("");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
                    exp8Menu(sc);
            }
    }
    public static void main(String[] args){
        experiment4OnlySA(6,6);
        System.exit(0);
        Scanner sc = new Scanner(System.in);
        //Bienvenida//
        System.out.println("Bienvenido al menú interactivo de la práctica sobre búsqueda local de los alumnos:");
        System.out.println("      VICTOR GIMÉNEZ");
        System.out.println("      GUILLEM FERRER");
        System.out.println("      JORDI ARMENGOL");
        System.out.println("Puedes navegar a través de diversos apartados para ejecutar distintas partes de cada experimento.");
        System.out.println("Cada parte viene acompañada de una muy breve explicación de esta.");
        System.out.println("Dada su brevedad es recomendado leer la documentación de la práctica si alguna explicación resulta insatisfactoria");
        System.out.println("Dicho esto, bienvenido al menú principal:");
        //Fin Bienvenida//
        boolean theresMore = true;
        while (theresMore) {
            printMainMenu();
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    exp1Menu(sc);
                    break;
                case 2:
                    exp2Menu(sc);
                    break;
                case 3:
                    exp3Menu(sc);
                    break;
                case 4:
                    exp4Menu(sc);
                    break;
                case 5:
                    exp5Menu(sc);
                    break;
                case 6:
                    exp6Menu(sc);
                    break;
                case 7:
                    exp7Menu(sc);
                    break;
                case 8:
                    exp8Menu(sc);
                    break;
                case 9:
                    theresMore = false;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción dentro del rango.");
            }
        }
        
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
        //experiment6_1();
        //System.out.println("");
        //experiment6_2();
        //experiment7_1(); // exp7 comparison with old heuristic
        //experiment7_2(); // exp7 for n1 to n8 both HC and SA
        //experiment7_3(); // exp7 for n1 to n16 just SA
        //experiment7_4(); // exp7 comparison 2 heuristics n1 to n6
        //experiment4(0,2);
        //experiment5_esc2();
        //experiment4OnlySA(3,6);
        //experiment43_prevSteps(0,6);
        //experiment3_kLambda2();
        //experiment3_stiter2();
        //experiment43_prevSteps(6,6);
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

    public static void experiment6_1() {
        try {
            Random myRandom=new Random();
            ArrayList<Integer> seeds = new ArrayList(10);
            ArrayList<Long> times1 = new ArrayList(10);
            ArrayList<Double> x = new ArrayList(10);
            ArrayList<Long> times2 = new ArrayList(10);
            ArrayList<Double> y = new ArrayList(10);
            for (int i=0; i<10; i++) {
                // original
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
                
                // more helis per centre
                start_time = System.currentTimeMillis();
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,5,5,seed);
                DB2.init0(100, 5, 5);
                Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search2 = new HillClimbingSearch();
                SearchAgent agent2 = new SearchAgent(problem2,search2);
                end_time = System.currentTimeMillis();
                long difference2 = end_time-start_time;
                DesastresBoardv2 b2 = (DesastresBoardv2) search2.getGoalState();
                double time2 = b2.getTime(); 
                
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
    
    public static void experiment6_2() {
        try {
            Random myRandom=new Random();
            ArrayList<Integer> seeds = new ArrayList(10);
            ArrayList<Long> times1 = new ArrayList(10);
            ArrayList<Double> x = new ArrayList(10);
            ArrayList<Long> times2 = new ArrayList(10);
            ArrayList<Double> y = new ArrayList(10);
            for (int i=0; i<10; i++) {
                // original
                int seed = myRandom.nextInt(400);
                long start_time = System.currentTimeMillis();
                DesastresBoardv2 DB =new DesastresBoardv2(100,5,5,seed);
                DB.init0(100, 5, 5);
                Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search =  new HillClimbingSearch();
                SearchAgent agent = new SearchAgent(problem,search);
                long end_time = System.currentTimeMillis();
                long difference = end_time-start_time;
                DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                double time = b.getTime();
                
                // more centers, but same number of total helis
                start_time = System.currentTimeMillis();
                DesastresBoardv2 DB2 =new DesastresBoardv2(100,25,1,seed);
                DB2.init0(100, 25, 1);
                Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(),new DesastresHeuristicFunctionv2());
                Search search2 = new HillClimbingSearch();
                SearchAgent agent2 = new SearchAgent(problem2,search2);
                end_time = System.currentTimeMillis();
                long difference2 = end_time-start_time;
                DesastresBoardv2 b2 = (DesastresBoardv2) search2.getGoalState();
                double time2 = b2.getTime(); 
                
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
    
    private static void experiment7_4() {
        try {
            int n = 6;
            
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
            System.out.println("Heuristic without the extra 10m:");
            System.out.println();
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
            
            System.out.println();
            
            for (int i=0; i<10; i++) {
                //int seed = myRandom.nextInt(400);
                //System.out.println("Seed " + i + " is " + seed);
                //timer here
                
                for (int exp = 1; exp <= n; exp++){
                    
                    long start_time = System.currentTimeMillis();
                    DesastresBoardv4 DB =new DesastresBoardv4(100,5,1,seeds[i]);
                    DB.init0(100,5,1);
                    Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv5(), new DesastresGoalTest(),new DesastresHeuristicFunctionv4((2^(exp-1))));
                    Search search =  new HillClimbingSearch();
                    SearchAgent agent = new SearchAgent(problem,search);
                    long end_time = System.currentTimeMillis();
                    //agent stuff here
                    long difference = end_time-start_time;
                    DesastresBoardv4 b = (DesastresBoardv4) search.getGoalState();
                    DesastresHeuristicFunctionv4 DesHF  = new DesastresHeuristicFunctionv4((2^(exp-1)));
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
                        DesastresBoardv4 DB2 =new DesastresBoardv4(100,5,1,seeds[i]);
                        DB2.init0(100, 5, 1);
                        Problem problem2 = new Problem(DB2, new DesastresSuccessorFunctionSAv3(), new DesastresGoalTest(),new DesastresHeuristicFunctionv4((2^(exp-1))));
                        Search search2 = new SimulatedAnnealingSearch(30400, 160, 5, 0.0001); //params from experiment 3
                        SearchAgent agent2 = new SearchAgent(problem2,search2);
                        end_time = System.currentTimeMillis();
                        difference2 += end_time-start_time;
                        DesastresBoardv4 b2 = (DesastresBoardv4) search2.getGoalState();
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

                    //seeds[i] = seed;
                    //x.add(time);
                    //times1[i][exp-1] = 0;
                    times1[i][exp-1] = difference;
                    //y.add(time2);
                    times2[i][exp-1] = difference2;
                    
                }
                
                
            }
            //System.out.println("seeds time1 time2 exec1 exec2");
            System.out.println("Heuristic with the extra 10m:");
            System.out.println();
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
    
    private static void experiment7_3() {
        try {
            int n = 16;
            
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
                    //DesastresBoardv3 DB =new DesastresBoardv3(100,5,1,seed);
                    //DB.init0(100,5,1);
                    //Problem problem =  new Problem(DB,new DesastresSuccessorFunctionv4(), new DesastresGoalTest(),new DesastresHeuristicFunctionv3((2^(exp-1))));
                    //Search search =  new HillClimbingSearch();
                    //SearchAgent agent = new SearchAgent(problem,search);
                    long end_time = System.currentTimeMillis();
                    //agent stuff here
                    long difference = end_time-start_time;
                    //DesastresBoardv3 b = (DesastresBoardv3) search.getGoalState();
                    DesastresHeuristicFunctionv3 DesHF  = new DesastresHeuristicFunctionv3((2^(exp-1)));
                    //double time = DesHF.getHeuristicValue(b);
                    //h1Hill[i][exp-1] = b.getTime();
                    //h2Hill[i][exp-1] = b.getMaxTimePriority();
                    
                    h1Hill[i][exp-1] = 0;
                    h2Hill[i][exp-1] = 0;
                    
                    
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
                    times1[i][exp-1] = 0; //difference;
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
            int n = 8;
            
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
    
    private static void experiment7_1() {
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

    private static void experiment3_prevSteps_first() {
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
            int steps[] = {10000,20000,30000,60000,120000};

            // 3
            //int steps[] = {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};

            // 4
            //int steps[] = {1000000,1250000,1500000,1750000,2000000}

            int stiter = 100;
            double lambda = 0.005;
            int k = 20;

            // Paso final steps
            //int stiter = 160;
            //double lambda = 0.0001;
            //int k = 5;
            //int steps[] = {5120,10400,20000,30400,40000,80000,160000};

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
                        long start_time = System.currentTimeMillis();
                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());

                        SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(step, stiter, k, lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        valueMeanSA += b.getTime();
                        exec_timeMeanSA += exec_time;




                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        /*values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
                        used_steps_set.add(step);*/
                    }

                    DesastresBoardv2 DBHC = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                    DBHC.init0(nGrupos, nCentros, nHelis);
                    Problem problemHC = new Problem(DBHC, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                    long start_timeHC = System.currentTimeMillis();
                    HillClimbingSearch searchHC = new HillClimbingSearch();
                    SearchAgent agentHC = new SearchAgent(problemHC, searchHC);
                    long end_timeHC = System.currentTimeMillis();
                    long exec_timeHC = end_timeHC - start_timeHC;
                    DesastresBoardv2 bHC = (DesastresBoardv2) searchHC.getGoalState();
                    valueMeanHC = bHC.getTime();
                    exec_timeMeanHC = exec_timeHC;

                    valueMeanSA = valueMeanSA/nReps;
                    valueMeanHC= valueMeanHC;
                    exec_timeMeanSA = exec_timeMeanSA/nReps;
                    exec_timeMeanHC = exec_timeMeanHC;
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
    
    private static void experiment3_prevSteps_second() {
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
            int steps[] = {5120,10400,20000,30400,40000};

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
                        long start_time = System.currentTimeMillis();
                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());

                        SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(step, stiter, k, lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        valueMeanSA += b.getTime();
                        exec_timeMeanSA += exec_time;




                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        /*values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
                        used_steps_set.add(step);*/
                    }

                    DesastresBoardv2 DBHC = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                    DBHC.init0(nGrupos, nCentros, nHelis);
                    Problem problemHC = new Problem(DBHC, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                    long start_timeHC = System.currentTimeMillis();
                    HillClimbingSearch searchHC = new HillClimbingSearch();
                    SearchAgent agentHC = new SearchAgent(problemHC, searchHC);
                    long end_timeHC = System.currentTimeMillis();
                    long exec_timeHC = end_timeHC - start_timeHC;
                    DesastresBoardv2 bHC = (DesastresBoardv2) searchHC.getGoalState();
                    valueMeanHC = bHC.getTime();
                    exec_timeMeanHC = exec_timeHC;

                    valueMeanSA = valueMeanSA/nReps;
                    valueMeanHC= valueMeanHC;
                    exec_timeMeanSA = exec_timeMeanSA/nReps;
                    exec_timeMeanHC = exec_timeMeanHC;
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
                        long start_time = System.currentTimeMillis();
                        DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DB2.init0(nGrupos, nCentros, nHelis);
                        Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());

                        SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(step, stiter, k, lambda);
                        //search.traceOn();
                        SearchAgent agent = new SearchAgent(problem, search);
                        long end_time = System.currentTimeMillis();
                        long exec_time = end_time - start_time;
                        DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                        valueMeanSA += b.getTime();
                        exec_timeMeanSA += exec_time;




                        //printInstrumentation(agent.getInstrumentation());
                        //values_set.set(j*lambdas.length + h,b.getTime());
                        //exec_times_set.set(j*lambdas.length + h,exec_time);
                        /*values_set.add(b.getTime());
                        exec_times_set.add(exec_time);
                        used_steps_set.add(step);*/
                    }

                    DesastresBoardv2 DBHC = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                    DBHC.init0(nGrupos, nCentros, nHelis);
                    Problem problemHC = new Problem(DBHC, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                    long start_timeHC = System.currentTimeMillis();
                    HillClimbingSearch searchHC = new HillClimbingSearch();
                    SearchAgent agentHC = new SearchAgent(problemHC, searchHC);
                    long end_timeHC = System.currentTimeMillis();
                    long exec_timeHC = end_timeHC - start_timeHC;
                    DesastresBoardv2 bHC = (DesastresBoardv2) searchHC.getGoalState();
                    valueMeanHC = bHC.getTime();
                    exec_timeMeanHC = exec_timeHC;

                    valueMeanSA = valueMeanSA/nReps;
                    valueMeanHC= valueMeanHC;
                    exec_timeMeanSA = exec_timeMeanSA/nReps;
                    exec_timeMeanHC = exec_timeMeanHC;
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

    private static void experiment3_kLambda2_first() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);

            // 1 (comun en 3 y 4 - 3
            double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};
            // 2
            /*double lambdas[] = {0.001, 0.0001,0.00001};
            int ks[] = {1,5,10,15};*/

            // Experimento 3
            int steps = 20000;
            int stiter = 100;
            int nGrupos = 100;
            int nCentros = 5;

            // Segunda parte experimento 4 - 3
            //double lambdas[] = {0.0001};
           // int ks[] = {5,25,50,75,100,125,150,175,200};


            // Experimento 4 - 3
            //int steps = 500000;
          //  int stiter = 100;
           // int nGrupos = 700;
           // int nCentros = 35;





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
                System.out.println(seed);

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
    
    private static void experiment3_kLambda2_second() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);

            // 1 (comun en 3 y 4 - 3
            /*double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};*/
            // 2
            double lambdas[] = {0.001, 0.0001,0.00001};
            int ks[] = {1,5,10,15};

            // Experimento 3
            int steps = 20000;
            int stiter = 100;
            int nGrupos = 100;
            int nCentros = 5;

            // Segunda parte experimento 4 - 3
            //double lambdas[] = {0.0001};
            //int ks[] = {5,25,50,75,100,125,150,175,200};


            // Experimento 4 - 3
            //int steps = 500000;
           // int stiter = 100;
            //int nGrupos = 700;
           // int nCentros = 35;





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
                System.out.println(seed);

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
     
    private static void experiment3_kLambda2_third() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);

            // 1 (comun en 3 y 4 - 3
            double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};
            // 2
            /*double lambdas[] = {0.001, 0.0001,0.00001};
            int ks[] = {1,5,10,15};*/

            // Experimento 3
            /*int steps = 20000;
            int stiter = 100;
            int nGrupos = 100;
            int nCentros = 5;*/

            // Segunda parte experimento 4 - 3
            //double lambdas[] = {0.0001};
            //int ks[] = {5,25,50,75,100,125,150,175,200};


            // Experimento 4 - 3
            int steps = 500000;
            int stiter = 100;
            int nGrupos = 700;
            int nCentros = 35;





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
                System.out.println(seed);

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

    private static void experiment3_kLambda2_fourth() {
        try {
            int n = 10;
            int nReps = 3;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_ks = new ArrayList(n);
            ArrayList<ArrayList<Double>> used_lambdas = new ArrayList(n);

            // 1 (comun en 3 y 4 - 3
            /*double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};*/
            // 2
            /*double lambdas[] = {0.001, 0.0001,0.00001};
            int ks[] = {1,5,10,15};*/

            // Experimento 3
            /*int steps = 20000;
            int stiter = 100;
            int nGrupos = 100;
            int nCentros = 5;*/

            // Segunda parte experimento 4 - 3
            double lambdas[] = {0.0001};
            int ks[] = {5,25,50,75,100,125,150,175,200};


            // Experimento 4 - 3
            int steps = 500000;
            int stiter = 100;
            int nGrupos = 700;
            int nCentros = 35;





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
                System.out.println(seed);

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

            // 1 (comun en 3 y 4 - 3
            /*double lambdas[] = {1,0.01,0.0001};
            int ks[] = {1,5,25,125};*/
            // 2
            /*double lambdas[] = {0.001, 0.0001,0.00001};
            int ks[] = {1,5,10,15};*/

            // Experimento 3
            /*int steps = 20000;
            int stiter = 100;
            int nGrupos = 100;
            int nCentros = 5;*/

            // Segunda parte experimento 4 - 3
            double lambdas[] = {0.0001};
            int ks[] = {5,25,50,75,100,125,150,175,200};


            // Experimento 4 - 3
            int steps = 500000;
            int stiter = 100;
            int nGrupos = 700;
            int nCentros = 35;





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
                System.out.println(seed);

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

    private static void experiment3_stiter2_first() {
        try {
            int n = 5;
            int nReps = 1;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_stiters = new ArrayList(n);

            // Exp 3

            int stiters[] = {50,80,100,125,160,200,250,400,500,625,800,1000,1250};


            int steps = 20000;
            double lambda = 0.0001;
            int k = 5;
            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;

            // Exp 3 - 4


            /*int stiters[] = {50,100,125,200,250,500,800,1000,1500};

            int steps = 500000;
            double lambda = 0.0001;
            int k = 5;
            int nGrupos = 700;
            int nCentros = 35;
            int nHelis = 1;*/


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
                System.out.println(seed);

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

    private static void experiment3_stiter2_second() {
        try {
            int n = 5;
            int nReps = 1;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_stiters = new ArrayList(n);

            // Exp 3

            /*int stiters[] = {50,80,100,125,160,200,250,400,500,625,800,1000,1250};


            int steps = 20000;
            double lambda = 0.0001;
            int k = 5;
            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;*/

            // Exp 3 - 4


            int stiters[] = {50,100,125,200,250,500,800,1000,1500};

            int steps = 500000;
            double lambda = 0.0001;
            int k = 175;
            int nGrupos = 700;
            int nCentros = 35;
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
                System.out.println(seed);

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
    
    private static void experiment3_stiter2() {
        try {
            int n = 5;
            int nReps = 1;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_stiters = new ArrayList(n);

            // Exp 3

            /*int stiters[] = {50,80,100,125,160,200,250,400,500,625,800,1000,1250};


            int steps = 20000;
            double lambda = 0.0001;
            int k = 5;
            int nGrupos = 100;
            int nCentros = 5;
            int nHelis = 1;*/

            // Exp 3 - 4


            int stiters[] = {50,100,125,200,250,500,800,1000,1500};

            int steps = 500000;
            double lambda = 0.0001;
            int k = 5;
            int nGrupos = 700;
            int nCentros = 35;
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
                System.out.println(seed);

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
            int n = 10;
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


            /*5:100 para centros y grupos. Comenzad con 5 centros de distribución e incrementad el número de 5 en 5 hasta que se vea la tendencia*/


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
                    int nC = 5+5*j;
                    int nG=  20*nC;
                    System.out.println(s + " " + nC + " " + nG + " " + vSA + " " + vHC + " " +  etSA + " " + etHC);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void experiment4OnlySA(int lowerIt, int maxIt) {
        try {
            int n = 1;
            int nReps = 3;
            //int nCentrosAProbar = 1; // mantener proporcion 5:100 centros/grupos
            int nCentrosAProbar = maxIt-lowerIt+1;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> valuesSA = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_timesSA = new ArrayList(n);
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
                ArrayList<Long> exec_timesSA_set = new ArrayList(nCentrosAProbar);
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

                        System.out.println("SA" + z);
                    }

                    valueMeanSA = valueMeanSA/nReps;
                    exec_timeMeanSA = exec_timeMeanSA/nReps;
                    valuesSA_set.add(valueMeanSA);
                    exec_timesSA_set.add(exec_timeMeanSA);
                }
                valuesSA.add(valuesSA_set);
                exec_timesSA.add(exec_timesSA_set);

            }
            System.out.println("seed nCentros nGrupos costSA exec_timeSA");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < nCentrosAProbar; j++) {
                    //int nC = used_nCentros.get(i).get(j);
                    //int nG = used_nGrupos.get(i).get(j);
                    double vSA = valuesSA.get(i).get(j);
                    double etSA = exec_timesSA.get(i).get(j);
                    int nC = lowerIt*5 + 5+5*j;
                    int nG=  20*nC;
                    System.out.println(s + " " + nC + " " + nG + " " + vSA + " " +  etSA);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void experiment5_esc1() {
        try {
            int n = 1;
            int nGruposAProbar = 3;
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

                    long start_time = System.currentTimeMillis();
                    DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                    DB2.init0(nGrupos, nCentros, nHelis);
                    Problem problem = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());

                    HillClimbingSearch search = new HillClimbingSearch();
                    //search.traceOn();
                    SearchAgent agent = new SearchAgent(problem, search);
                    long end_time = System.currentTimeMillis();
                    long exec_time = end_time - start_time;
                    DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                    meanValue = b.getTime();
                    meanExecTime = exec_time;

                    values_set.add(meanValue);
                    exec_times_set.add(meanExecTime);
                    used_nGrupos_set.add(nGrupos);
                    System.out.println(j);
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
            int nCentrosAProbar = 10;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<Double>> values = new ArrayList(n);
            ArrayList<ArrayList<Long>> exec_times = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_nCentros = new ArrayList(n);

            int nGrupos = 100;
            int nCentros;
            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<Double> values_set = new ArrayList(nCentrosAProbar);
                ArrayList<Long> exec_times_set = new ArrayList(nCentrosAProbar);
                ArrayList<Integer> used_nCentros_set = new ArrayList(nCentrosAProbar);
                for (int j = 0; j < nCentrosAProbar; j++) {
                    nCentros = 5 + j*5;
                    double meanValue = 0;
                    long meanExecTime = 0;

                    long start_time = System.currentTimeMillis();
                    DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                    DB2.init0(nGrupos, nCentros, nHelis);
                    Problem problem = new Problem(DB2, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());

                    HillClimbingSearch search = new HillClimbingSearch();

                    SearchAgent agent = new SearchAgent(problem, search);
                    long end_time = System.currentTimeMillis();
                    long exec_time = end_time - start_time;
                    DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                    meanValue = b.getTime();
                    meanExecTime = exec_time;

                    values_set.add(meanValue);
                    exec_times_set.add(meanExecTime);
                    used_nCentros_set.add(nCentros);
                    System.out.println(j);
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

    private static void experiment43_prevSteps(int lowerIt, int maxIt) {
        try {
            int n = 5;
            int nReps = 1;
            int nGruposAProbar = maxIt - lowerIt + 1;
            Random myRandom = new Random();
            ArrayList<Integer> seeds = new ArrayList(n);
            ArrayList<ArrayList<ArrayList<Double>>> valuesSA = new ArrayList(n);
            ArrayList<ArrayList<ArrayList<Long>>> exec_timesSA = new ArrayList(n);
            ArrayList<ArrayList<Integer>> used_steps = new ArrayList(n);

            /*
            // para el paso final
            ArrayList<ArrayList<ArrayList<Double>>> valuesHC = new ArrayList(n);
            ArrayList<ArrayList<ArrayList<Long>>> exec_timesHC = new ArrayList(n);*/

            /*int stiter = 100;
            double lambda = 0.005;
            int k = 20;*/

            //int steps[] = {1000,5000,10000,30000,60000,120000,500000,1000000,2000000};

            // paso final experiment43

            int stiter = 1000;
            double lambda = 0.0001;
            int k = 175;
            int steps[] = {100000,500000,1000000,2000000};


            int nHelis = 1;
            for (int i = 0; i < n; i++) {
                int seed = myRandom.nextInt(400);
                //seeds.set(i,seed);
                seeds.add(seed);
                ArrayList<ArrayList<Double>> valuesSA_setSet = new ArrayList(steps.length);
                ArrayList<ArrayList<Long>> exec_timesSA_setSet = new ArrayList(steps.length);
                ArrayList<Integer> used_steps_set = new ArrayList(steps.length);

                /*
                // para el paso final
                ArrayList<ArrayList<Double>> valuesHC_setSet = new ArrayList(steps.length);
                ArrayList<ArrayList<Long>> exec_timesHC_setSet = new ArrayList(steps.length);*/


                for (int j = 0; j < steps.length; j++) {
                    int step = steps[j];
                    ArrayList<Double> valuesSA_set = new ArrayList(nGruposAProbar);
                    ArrayList<Long> exec_timesSA_set = new ArrayList(nGruposAProbar);

                    /*
                    // para el paso final
                    ArrayList<Double> valuesHC_set = new ArrayList(nGruposAProbar);
                    ArrayList<Long> exec_timesHC_set = new ArrayList(nGruposAProbar);*/

                    //for (int o = 0; o < nGruposAProbar; o++) {
                    for (int o = lowerIt; o <= maxIt; o++) {
                        int nCentros = 5 + o*5;
                        int nGrupos = nCentros * 20;

                        double valueMeanSA = 0;
                        long exec_timeMeanSA = 0;

                        for (int z = 0; z < nReps; z++) {
                            long start_time = System.currentTimeMillis();
                            DesastresBoardv2 DB2 = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                            DB2.init0(nGrupos, nCentros, nHelis);
                            Problem problem = new Problem(DB2, new DesastresSuccessorFunctionSA(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(step, stiter, k, lambda);
                            //search.traceOn();
                            SearchAgent agent = new SearchAgent(problem, search);
                            long end_time = System.currentTimeMillis();
                            long exec_time = end_time - start_time;
                            DesastresBoardv2 b = (DesastresBoardv2) search.getGoalState();
                            valueMeanSA += b.getTime();
                            exec_timeMeanSA += exec_time;
                        }
                        valueMeanSA = valueMeanSA / nReps;
                        exec_timeMeanSA = exec_timeMeanSA / nReps;
                        valuesSA_set.add(valueMeanSA);
                        exec_timesSA_set.add(exec_timeMeanSA);

                        System.out.println("SA done");

                        /*
                        // para el paso final
                        long start_timeHC = System.currentTimeMillis();
                        DesastresBoardv2 DBHC = new DesastresBoardv2(nGrupos, nCentros, nHelis, seed);
                        DBHC.init0(nGrupos, nCentros, nHelis);
                        Problem problemHC = new Problem(DBHC, new DesastresSuccessorFunctionv2(), new DesastresGoalTest(), new DesastresHeuristicFunctionv2());
                        HillClimbingSearch searchHC = new HillClimbingSearch();
                        SearchAgent agentHC = new SearchAgent(problemHC, searchHC);
                        long end_timeHC = System.currentTimeMillis();
                        long exec_timeHC = end_timeHC - start_timeHC;
                        DesastresBoardv2 bHC = (DesastresBoardv2) searchHC.getGoalState();
                        double valueHC = bHC.getTime();
                        valuesHC_set.add(valueHC);
                        exec_timesHC_set.add(exec_timeHC);*/

                    }
                    System.out.println(step);
                    used_steps_set.add(step);
                    valuesSA_setSet.add(valuesSA_set);
                    exec_timesSA_setSet.add(exec_timesSA_set);

                    /*
                    // para el paso final
                    valuesHC_setSet.add(valuesHC_set);
                    exec_timesHC_setSet.add(exec_timesHC_set);*/

                }
                /*values.set(i,values_set);
                exec_times.set(i,exec_times_set);*/
                valuesSA.add(valuesSA_setSet);
                exec_timesSA.add(exec_timesSA_setSet);
                used_steps.add(used_steps_set);

                /*
                // para el paso final
                valuesHC.add(valuesHC_setSet);
                exec_timesHC.add(exec_timesHC_setSet);*/

            }
            System.out.println("seed nCentros nGrupos steps costSA exec_timeSA");
            //System.out.println("seed nCentros nGrupos steps costSA exec_timeSA costHC exec_timeHC");
            for (int i = 0; i < n; i++) {
                int s = seeds.get(i);
                for (int j = 0; j < steps.length; j++) {
                    int st = used_steps.get(i).get(j);
                    for (int o = 0; o < nGruposAProbar; o++) {
                        int nC = 5 + 5*o;
                        int nG = nC * 20;
                        double vSA = valuesSA.get(i).get(j).get(o);
                        double etSA = exec_timesSA.get(i).get(j).get(o);
                        System.out.println(s + " " + nC + " " + nG + " " + st + " " + vSA + " " + etSA);

                        /*
                        double vHC = valuesHC.get(i).get(j).get(o);
                        double etHC = exec_timesHC.get(i).get(j).get(o);
                        System.out.println(s + " " + nC + " " + nG + " " + st + " " + vSA + " " + etSA + " " + vHC + " " + etHC);*/
                    }

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


