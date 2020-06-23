package zrc.array.DigitGroup.src.zrc.array;
/*
作业：编写程序，使用一维数组，模拟栈数据结构
    1.在栈中可以存储Java中的任何引用数据类型
    2.在栈中提供push方法模拟压栈
    3.在栈中提供pop方法模拟弹栈
 */
public class ArrayStack {
    private Object[] elements;
    private int size;
    private int top = -1;
    int num = 0;

    public ArrayStack(int size) {
        elements = new Object[size];
        this.size = size;
    }

    public ArrayStack() {
        this(10);
    }

    public boolean isEmpty(){
        if (top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if (num == size){
            return true;
        }else {
            return false;
        }
    }

    public void push(Object o){
        if (isFull()){
            System.out.println("栈已满，无法压入");
        }else{
            elements[top + 1] = o;
            num++;
            top++;
        }
    }

    public Object pop(){
        if (isEmpty()){
            return null;
        }else{
            int temp = top;
            top--;
            num--;
            return elements[temp];
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        arrayStack.push(3);
        System.out.println(arrayStack.pop());
    }
}
