package Code_09_Array_To_StackAndQueue;

public class ArrayToStack {

    private final int[] arr;
    private int size = 0;

    public ArrayToStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("size need > 0");
        }
        this.arr = new int[size];
    }

    public Integer peek() {
        if (this.size == 0) {
            return null;
        }
        return this.arr[this.size - 1];
    }

    public void push(int num) {
        if (this.size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        this.arr[this.size++] = num;
    }

    public Integer pop() {
        if (this.size == 0) {
            return null;
        }
        return this.arr[--this.size];
    }



}
