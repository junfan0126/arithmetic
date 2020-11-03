import java.util.Stack;

/**
 * @author
 * @version 1.0
 * @date 2020/11/1 下午3:53
 * @description     两个栈实现一个队列
 **/

public class TwoStack {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void push(int node){
            stack1.push(node);
    }
    public int pop(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStack queue=new TwoStack();
        for(int i=0;i<5;i++){
            queue.push(i);
        }
        for(int i=0;i<5;i++){
            System.out.println(queue.pop());
        }
    }
}
