package ProgramacionIII.tp2;

import ProgramacionIII.tp1.MyIterator;
import ProgramacionIII.tp1.MySimpleLinkedList;

public class SearchItem {
    private MySimpleLinkedList lista;
    private int[] arr;

    public SearchItem(MySimpleLinkedList lista) {
        this.lista = lista;
        arr=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    }

    public SearchItem(int[] arr) {
        this.arr = arr;
    }

    public int findingList(int buscado){
        int i=0;
        return finderList(buscado,i);
    }

    public int findingArray(int buscado){
        int i=0;
        return finderArray(buscado,i, arr.length);
    }

    public int finderList(int buscado, int pos){
        if(lista.get(pos)==buscado){
            return pos;
        }else{
            if(pos<lista.size()-1){
                return finderList(buscado,pos+1);
            }
        }
        return -1;
    }

    public int finderArray(int buscado, int inicio, int largo){ // HACER BUSQUEDA BINARIA
        if(buscado<=arr[largo/2+1]){

        }else{

        }
        return -1;
    }
}
