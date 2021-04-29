package ProgramacionIII.tp2;

import ProgramacionIII.tp1.MyPusheableLinkedList;
import ProgramacionIII.tp1.MySimpleLinkedList;

public class Tree {

    private Integer value;
    private Tree left;
    private Tree right;

	/* Object getRoot(), boolean hasElem(Object), boolean isEmpty(), void insert(Object),
    boolean delete(Object), int getHeight(), void printPosOrder(), void printPreOrder(), void
    printInOrder(), List getLongestBranch(), List getFrontera(), Object getMaxElem(), List
    getElemAtLevel(int) */

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public void add(int newValue) {
        if (newValue < this.value) {
            if (this.left == null)
                this.left = new Tree(newValue);
            else
                this.left.add(newValue);
        } else {
            if (this.right == null)
                this.right = new Tree(newValue);
            else
                this.right.add(newValue);
        }
    }

    public int getHeight() {
        int alturaIzq = 0;
        int alturaDer = 0;
        if (this.left != null) {
            alturaIzq = 1 + this.left.getHeight();
        }
        if (this.right != null) {
            alturaDer = 1 + this.right.getHeight();
        }

        int mayor = Math.max(alturaDer, alturaIzq);
        return mayor;
    }

    public boolean hasElem(int buscado) {
        if (value == buscado) {
            return true;
        } else {
            if (buscado < value) {
                left.hasElem(buscado);
            } else {
                right.hasElem(buscado);
            }
        }
        return false;
    }

    public int getRoot() {
        return this.value;
    }

    public boolean isEmpty() {
        return value == null ;
    }

    public boolean delete(int valor){
        if(this.getValue()>valor){
            this.left.delete(valor);
        }else if(this.getValue()<valor){
            this.right.delete(valor);
        }else{

            return true;
        }

        return false;
    }








}
