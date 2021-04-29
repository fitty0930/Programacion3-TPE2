package ProgramacionIII.tp2;

public class CheckArrayOrder {
    private int[]arr;

    public CheckArrayOrder(int[] arr){
        this.arr=arr;
    }

    public boolean isOrdered(){
       int i=0;
       return Compare(i);
    }

    private boolean Compare(int i){
        System.out.println(arr[i]+" comparo con  "+arr[i+1]);
        if(arr[i]<arr[i+1] ){
            if(i+1<arr.length-1){ return this.Compare(i+1);}
            else {
                return true;
            }
        }else{
            return false;
        }
    }
}
