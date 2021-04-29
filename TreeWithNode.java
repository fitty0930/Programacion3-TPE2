package ProgramacionIII.tp2;

public class TreeWithNode {

    private TreeNode root;

    public TreeWithNode() {
        this.root = null;
    }

    // TO DO
	/*  boolean hasElem(Object), boolean isEmpty(),
      void printPosOrder(), void printPreOrder(), void
    printInOrder(), List getLongestBranch(), List getFrontera(), , List
    getElemAtLevel(int) */

    // DOING
    // Object getMaxElem()

    // DONE
    /* Object getRoot(), int getHeight(), void insert(Object), boolean delete(Object), */

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

    public boolean deleteValue(int value) {
        return deleteValueNode(root, value);
    }

    private boolean deleteValueNode(TreeNode node, int valor) { // PROPAGAR EL RETORNO
        boolean findAndDelete=false;
        if (node == null) { // si el arbol esta vacio
            // no hago nada
            return false;
        } else if (valor < node.getValue()) { // si el valor es menor busco por la izq
            findAndDelete=deleteValueNode(node.getLeft(), valor); // GUARDAR
        } else if (valor > node.getValue()) { // si el valor es mayor busco por la der
            findAndDelete=deleteValueNode(node.getRight(), valor); // GUARDAR
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
        }else{
            // si no tiene padre CAMBIAR
            arbol=nodenuevo;
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
