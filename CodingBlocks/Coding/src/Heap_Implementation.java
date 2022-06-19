import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Heap {
    private int[] H;
    private int index;

    public Heap(int size) {
        this.H = new int[size+1];
        Arrays.fill(this.H,Integer.MAX_VALUE);
        this.index = 0;
    }

    public void insert(int data) {
        H[++index] = data;
        heapifyUp(index);
    }
    public void heapifyUp(int pos){
        if(pos>1) {
            if(H[parent(pos)]>H[pos]){
               int temp=H[parent(pos)];
               H[parent(pos)]=H[pos];
               H[pos]=temp;
               heapifyUp(parent(pos)); 
            }
        }
    }
    public void print(){
        for (int i = 1; i <=index; i++) {
            System.out.print(H[i]+" ");
        }
        System.out.println();
    }
    public int remove() {
        int popped = H[1];
        H[1] = H[index--];
        minHeapify(1);
        return popped;
    }

    private void minHeapify(int pos) {
        if (2*pos<=index) {
            if (H[pos] > H[leftChild(pos)]
                    || H[pos] > H[rightChild(pos)]) {
                if (H[leftChild(pos)] < H[rightChild(pos)]) {
                    int temp = H[leftChild(pos)];
                    H[leftChild(pos)] = H[pos];
                    H[pos] = temp;
                    minHeapify(leftChild(pos));
                } else {
                    int temp=H[rightChild(pos)];
                    H[rightChild(pos)]=H[pos];
                    H[pos]=temp;
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    private int parent(int pos){
        return (pos/2);
    }
    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }
}

public class Heap_Implementation {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Heap h = new Heap(n);
        for (int i = 0; i < n; i++) {
            h.insert(A[i]);
        }
        h.print();
        //System.out.println(h.remove());
        for (int i = 0; i < n; i++) {
            System.out.print(h.remove()+" ");
        }
        System.out.println();
        sc.close();
    }
}