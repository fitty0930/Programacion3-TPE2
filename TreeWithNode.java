package ProgramacionIII.tp2;

import java.util.*;

public class TreeWithNode {

    private TreeNode root;

    public TreeWithNode() {
        this.root = null;
    }

    // constructor pedido para las pruebas
    // tiene complejidad computacional O(n*l) donde n es el costo comp de cada add (max n=altura del arbol)
    // y l es el largo del array
    public TreeWithNode(int[] arr) {
        this.root = null;
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i]);
        }
    }

    // Complejidad O(n) donde n es la altura del arbol
    // a lo sumo debo recorrer la altura del arbol si el valor a insertar va al final de la rama
    // mas larga
    public void add(int value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    private void add(TreeNode actual, int value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
                temp.setPadre(actual);
            } else {
                add(actual.getLeft(), value);
            }
        } else {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
                temp.setPadre(actual);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    // Complejidad O(n) donde n es la cantidad de nodos del arbol
    // debo recorrer todos los nodos del arbol hasta llegar a sus hojas
    public List<Integer> getFrontera() {
        ArrayList<Integer> retorno = obtenerFrontera(this.root);
        return retorno;
    }

    private ArrayList<Integer> obtenerFrontera(TreeNode actual) {
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        if (actual == null) {
            return null;
        }
        if (actual.getLeft() == null && actual.getRight() == null) {
            retorno.add(actual.getValue());
        }
        if (actual.getLeft() != null) {
            retorno.addAll(obtenerFrontera(actual.getLeft()));
        }
        if (actual.getRight() != null) {
            retorno.addAll(obtenerFrontera(actual.getRight()));
        }

        return retorno;
    }

    // Complejidad O(n) donde n es el numero de nodos del arbol, el peor de los casos
    // es que me pidan el ultimo nivel
    public List<Integer> getElemAtLevel(int nivel) {
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        if (this.root != null) {
            retorno = obtenerNodosDelNivel(this.root, nivel);
        }
        return retorno;
    }

    private ArrayList<Integer> obtenerNodosDelNivel(TreeNode actual, int nivel) {
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        if(actual==null){return null;}
        if (nivel == 0) {
            retorno.add(actual.getValue());
        } else {
            if(actual.getLeft()!=null){
                retorno.addAll(obtenerNodosDelNivel(actual.getLeft(), nivel - 1));
            }
            if(actual.getRight()!=null){
                retorno.addAll(obtenerNodosDelNivel(actual.getRight(), nivel - 1));
            }
        }

        return retorno;
    }

    // Complejidad O(n+l) donde n es el alto del arbol
    // una n por recorrerlo y l por el reverse del arraylist
    public List<Integer> getLongestBranch() {
        ArrayList<Integer> retorno = obtenerRamaMasLarga(this.root);
        Collections.reverse(retorno);
        return retorno;
    }

    private ArrayList<Integer> obtenerRamaMasLarga(TreeNode actual) {
        if (actual == null) {
            ArrayList<Integer> retorno = new ArrayList<>();
            return retorno;
        }
        ArrayList<Integer> right = obtenerRamaMasLarga(actual.getRight());
        ArrayList<Integer> left = obtenerRamaMasLarga(actual.getLeft());

        if (right.size() < left.size()) {
            left.add(actual.getValue());
        } else {
            right.add(actual.getValue());
        }


        if (left.size() >= right.size()) {
            return left;
        } else {
            return right;
        }
    }

    // Complejidad de O(n) donde n es la cantidad de nodos del arbol
    public void printInOrder() {
        imprimirOrdenado(this.root);
    }

    private void imprimirOrdenado(TreeNode actual) {
        if (actual == null) {
            return;
        }
        imprimirOrdenado(actual.getLeft()); // busca izq
        System.out.println(actual.getValue()); // imprime
        imprimirOrdenado(actual.getRight()); // busca der
    }

    // Complejidad de O(n) donde n es la cantidad de nodos del arbol
    public void printPreOrder() {
        imprimirPreOrdenado(this.root);
    }

    private void imprimirPreOrdenado(TreeNode actual) {
        if (actual == null) {
            System.out.println("-");
            return; // corto
        }
        System.out.println(actual.getValue()); // imprime
        imprimirPreOrdenado(actual.getLeft()); // busca izq
        imprimirPreOrdenado(actual.getRight()); // busca der
        // chequear POR LAS DUDAS
    }

    // Complejidad de O(n) donde n es la cantidad de nodos del arbol
    public void printPosOrder() {
        imprimirPosOrdenado(this.root);
    }

    private void imprimirPosOrdenado(TreeNode actual) {
        if (actual == null) {
            return;
        }
        imprimirPosOrdenado(actual.getLeft());
        imprimirPosOrdenado(actual.getRight());
        System.out.println(actual.getValue());
    }

    // Complejidad O(1)
    public Integer getRoot() {
        return this.root.getValue();
    }

    // Complejidad O(n) donde n es la cantidad de nodos del arbol
    // el peor caso es que me pidan que le calcule la altura a un arbol enredadera
    public int getHeight() {
        if (this.root != null) {
            return this.getAltura(this.root);
        } else {
            return 0;
        }
    }

    private int getAltura(TreeNode actual) {
        if (actual.getRight() == null && actual.getLeft() == null) {
            return 0;
        } else {
            int alturaIzq = 0;
            int alturaDer = 0;
            if (actual.getLeft() != null) {
                alturaIzq = 1 + this.getAltura(actual.getLeft());
            }
            if (actual.getRight() != null) {
                alturaDer = 1 + this.getAltura(actual.getRight());
            }

            int mayor = Math.max(alturaDer, alturaIzq);
            return mayor;
        }
    }

    // Complejidad O(n) donde n es la altura del arbol
    public boolean hasElem(int numero) {
        boolean encontrado = false;
        if (this.getRoot() == numero) {
            return true;
        } else if (this.getRoot() > numero) {
            // buscar a izq
            encontrado = buscar(this.root.getLeft(), numero);
        } else if (this.getRoot() < numero) {
            // buscar a derecha
            encontrado = buscar(this.root.getRight(), numero);
        }
        return encontrado;
    }

    private boolean buscar(TreeNode actual, int numero) {
        boolean encontrado = false;
        if (actual.getValue() == numero) {
            return true;
        } else if (actual.getValue() > numero) {
            encontrado = buscar(actual.getLeft(), numero);
        } else if (actual.getValue() < numero) {
            encontrado = buscar(actual.getRight(), numero);
        }
        return encontrado;
    }

    // Complejidad O(1)
    public boolean isEmpty() {
        return this.root == null;
    }

    // Complejidad O(n) donde n es la altura del arbol
    public int getMaxElem() {
        if (this.root != null) {
            if (this.root.getRight() == null) {
                return this.root.getValue();
            } else {
                return buscarMax(this.root.getRight());
            }
        } else return -1;
    }

    private int buscarMax(TreeNode actual) {
        int max = 0;
        if (actual.getRight() != null) {
            max = buscarMax(actual.getRight());
        } else {
            return actual.getValue();
        }
        return max;
    }

    // Complejidad O(n) donde n es a lo sumo el valor de la altura del arbol
    public boolean delete(int value) {
        return deleteNode(this.root, value);
    }

    public boolean deleteNode(TreeNode root, int key) {
        boolean retorno=false;
        if (root == null) return false;
            if (key > root.getValue()) { // moverse a derecha
                retorno=deleteNode(root.getRight(), key);
            } else if (key < root.getValue()) { // moverse a izq
                retorno=deleteNode(root.getLeft(), key);
            } else { //encontrado
                if (root.getLeft() == null && root.getRight() == null) { // es una hoja

                    if(root.getPadre()!=null){
                        TreeNode padre=root.getPadre();
                        if(padre.getRight()==root){
                            padre.setRight(null);
                        }else{
                            padre.setLeft(null);
                        }
                    }else{
                        this.root=null;
                    }

                    retorno= true;

                } else if (root.getRight() != null) {
                    root.setValue(successor(root)); // le busco sucesor a la derecha
                    deleteNode(root.getRight(), root.getValue());
                    retorno=true;

                } else { // si no tiene sucesor le busco un predecesor
                    root.setValue(predecessor(root));
                    deleteNode(root.getLeft(), root.getValue());
                    retorno=true;

                }

            }


        return retorno;
    }

    private int successor(TreeNode root) {
        root = root.getRight();
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getValue();
    }

    private int predecessor(TreeNode root) {
        root = root.getLeft();
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root.getValue();
    }
}
