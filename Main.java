package ProgramacionIII.tp2;

import ProgramacionIII.tp1.MySimpleLinkedList;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        // PRUEBAS DE ARBOL BINARIO
        int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
        TreeWithNode miArbol= new TreeWithNode(valoresIniciales);
        /*int[] valoresIniciales = new int[] {2, 3, 10, 7};
        TreeWithNode miArbol= new TreeWithNode(valoresIniciales);
        System.out.println(miArbol.delete(10));
        miArbol.printPreOrder();*/



        System.out.println("preorden");
        miArbol.printPreOrder();
        System.out.println("maxelem");
        System.out.println( miArbol.getMaxElem() );
        System.out.println("altura");
        System.out.println( miArbol.getHeight());
        System.out.println("rama mas larga");
        System.out.println( miArbol.getLongestBranch() );
        System.out.println("elementos del nivel 2");
        System.out.println( miArbol.getElemAtLevel(2) );
        System.out.println("frontera");
        System.out.println( miArbol.getFrontera() );

        miArbol.add(23);
        miArbol.add(3);
        miArbol.delete(6);
        miArbol.delete(30);

        System.out.println("preorden");
        miArbol.printPreOrder();
        System.out.println("maxelem");
        System.out.println( miArbol.getMaxElem() );
        System.out.println("altura");
        System.out.println( miArbol.getHeight() );
        System.out.println("rama mas larga");
        System.out.println( miArbol.getLongestBranch() );
        System.out.println("elementos del nivel 2");
        System.out.println( miArbol.getElemAtLevel(2) );
        System.out.println("frontera");
        System.out.println( miArbol.getFrontera() );

        miArbol.add(65);
        miArbol.delete(5);
        miArbol.delete(15);
        miArbol.add(55);

        System.out.println("preorden");
        miArbol.printPreOrder();
        System.out.println("maxelem");
        System.out.println( miArbol.getMaxElem() );
        System.out.println("altura");
        System.out.println( miArbol.getHeight() );
        System.out.println("rama mas larga");
        System.out.println( miArbol.getLongestBranch() );
        System.out.println("elementos del nivel 2");
        System.out.println( miArbol.getElemAtLevel(2) );
        System.out.println("frontera");
        System.out.println( miArbol.getFrontera() );

        System.out.println(miArbol.getElemAtLevel(9));
    }
}
