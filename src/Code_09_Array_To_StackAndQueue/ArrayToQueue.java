package Code_09_Array_To_StackAndQueue;

public class ArrayToQueue {

    private int[] arr;
    private int start = 0;
    private int end = 0;
    private int size = 0;

    public ArrayToQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("size need > 0");
        }
        this.arr = new int[size];
    }

    public Integer peek() {
        if (this.size == 0) {
            return null;
        }
        return this.arr[this.start];
    }

    public void push(int num) {
        if (this.size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        this.size++;
        this.arr[this.end] = num;
        if (this.end == this.arr.length - 1) {
            this.end = 0;
        } else {
            this.end++;
        }
    }

    public Integer poll() {
        if (this.size == 0) {
            return null;
        }
        int poll = this.arr[this.start];
        this.size--;
        if (this.start == 0) {
            this.start = this.arr.length - 1;
        } else {
            this.start--;
        }
        return poll;
    }

}
