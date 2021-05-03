package ProgramacionIII.tp2;

import java.util.ArrayList;
import java.util.List;

public class TreeWithNode {

    private TreeNode root;

    public TreeWithNode() {
        this.root = null;
    }

    // TO DO
    /*    */

    // DOING
    //

    // DONE
    /* Object getRoot(), int getHeight(), void insert(Object), boolean delete(Object), Object getMaxElem()
     * boolean isEmpty(), boolean hasElem(Object), void printInOrder(), void printPreOrder(), void printPosOrder(),
     * List getLongestBranch(), List getElemAtLevel(int), List getFrontera() */

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
    public List<Integer> getFrontera(){
        ArrayList<Integer> retorno= obtenerFrontera(this.root);
        return retorno;
    }

    private ArrayList<Integer> obtenerFrontera(TreeNode actual){
        ArrayList<Integer> retorno= new ArrayList<Integer>();
        if(actual==null){
            return null;
        }
        if(actual.getLeft()==null && actual.getRight()==null){
            retorno.add(actual.getValue());
        }
        if(actual.getLeft()!=null){
            retorno.addAll(obtenerFrontera(actual.getLeft()));
        }
        if(actual.getRight()!=null){
            retorno.addAll(obtenerFrontera(actual.getRight()));
        }

        return retorno;
    }

    // OBTENER ELEMENTOS DE UN DETERMINADO NIVEL
    public List<Integer> getElemAtLevel(int nivel) {
        ArrayList<Integer> retorno = obtenerNodosDelNivel(this.root, nivel);
        return retorno;
    }

    private ArrayList<Integer> obtenerNodosDelNivel(TreeNode actual, int nivel) {
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        if (nivel == 0) {
            retorno.add(actual.getValue());
        } else {
            retorno.addAll(obtenerNodosDelNivel(actual.getLeft(), nivel - 1));
            retorno.addAll(obtenerNodosDelNivel(actual.getRight(), nivel - 1));
        }

        return retorno;
    }

    public List<Integer> getLongestBranch() {
        ArrayList<Integer> retorno = obtenerRamaMasLarga(this.root);
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

    public void printPreOrder() {
        imprimirPreOrdenado(this.root);
    }

    private void imprimirPreOrdenado(TreeNode actual) {
        if (actual == null) {
            return; // corto
        }
        System.out.println(actual.getValue()); // imprime
        imprimirPreOrdenado(actual.getLeft()); // busca izq
        imprimirPreOrdenado(actual.getRight()); // busca der
    }

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


    public Integer getRoot() {
        return this.root.getValue();
    }

    public int getHeight(TreeNode actual) {
        if (actual.getRight() == null && actual.getLeft() == null) {
            return 0;
        } else {
            int alturaIzq = 0;
            int alturaDer = 0;
            if (actual.getLeft() != null) {
                alturaIzq = 1 + this.getHeight(actual.getLeft());
            }
            if (actual.getRight() != null) {
                alturaDer = 1 + this.getHeight(actual.getRight());
            }

            int mayor = Math.max(alturaDer, alturaIzq);
            return mayor;
        }
    }

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

    public boolean isEmpty() {
        return this.root == null;
    }

    public int getMaxElem() {
        // TBC
        if (this.root.getRight() == null) {
            return this.root.getValue();
        } else {
            return buscarMax(this.root.getRight());
        }
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

    public boolean delete(int value) {
        return deleteValueNode(root, value);
    }

    private boolean deleteValueNode(TreeNode node, int valor) { // PROPAGAR EL RETORNO
        boolean findAndDelete = false;
        if (node == null) { // si el arbol esta vacio
            // no hago nada
            return false;
        } else if (valor < node.getValue()) { // si el valor es menor busco por la izq
            findAndDelete = deleteValueNode(node.getLeft(), valor); // GUARDAR
        } else if (valor > node.getValue()) { // si el valor es mayor busco por la der
            findAndDelete = deleteValueNode(node.getRight(), valor); // GUARDAR
        } else {
            eliminarNodo(node);
            return true;
        }

        return findAndDelete; // si jamas encontre al buscado
    }

    private void eliminarNodo(TreeNode node) {
        if (node.getRight() != null && node.getLeft() != null) { // si tiene 2 hijos
            TreeNode nodomenor = minimo(node.getRight());
            node.setValue(nodomenor.getValue());
            eliminarNodo(nodomenor);
        } else if (node.getLeft() != null) {
            // reemplazar
            reemplazar(node, node.getLeft());
            destroyNode(node);
        } else if (node.getRight() != null) {
            reemplazar(node, node.getRight());
            destroyNode(node);
        } else {
            reemplazar(node, null);
            destroyNode(node);
        }

    }

    private void reemplazar(TreeNode arbol, TreeNode nodenuevo) {
        if (arbol.getPadre() != null) {
            //asignamos nuevo hijo
            if (arbol.getValue() == arbol.getPadre().getLeft().getValue()) {
                arbol.getPadre().setLeft(nodenuevo);
            } else if (arbol.getValue() == arbol.getPadre().getRight().getValue()) {
                arbol.getPadre().setRight(nodenuevo);
            }
        } else {
            // si no tiene padre CAMBIAR
            arbol = nodenuevo;
        }
        if (nodenuevo != null) {
            // asignamos nuevo padre
            nodenuevo.setPadre(arbol.getPadre());
        }
    }

    // funcion para determinar el nodo mas izq posible
    private TreeNode minimo(TreeNode node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() != null) { // si tiene izq retornamos la parte mas izq
            return minimo(node.getLeft());
        } else return node; // si no tiene izq retorno el mismo nodo
    }

    private void destroyNode(TreeNode node) {
        node.setLeft(null);
        node.setRight(null);
        node.setPadre(null);

        node.setValue(0); // eliminarlo (?
    }


}
