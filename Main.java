package ProgramacionIII.tp2;

import ProgramacionIII.tp1.MySimpleLinkedList;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println(4/2+1);
        System.out.println("----");
        int[] arr={1,2,30,14,5,2,63,24,6};
        OrderArray ordenar= new OrderArray(arr);
        arr=ordenar.quickSort(2,8);
        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }


        /*CheckArrayOrder check= new CheckArrayOrder(arr);
        System.out.println(check.isOrdered());*/

        MySimpleLinkedList lista123= new MySimpleLinkedList();
        lista123.insertFront(3);
        lista123.insertFront(2);
        lista123.insertFront(1);
        SearchItem search= new SearchItem(lista123);
        System.out.println("lista "+ search.findingList(4));

        System.out.println("array "+search.findingArray(5));

    }
}
