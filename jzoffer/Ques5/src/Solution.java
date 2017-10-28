import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解题思路
 * 两个栈,第一个用来保存添加的元素,模拟入队。
 * 当需要出队时,将第一个栈中的元素压入第二个栈中,顺序就是正序,再弹出就是出队
 * 注意:第一个栈必须一次性将数据压入第二个栈中,当第二个栈不为空时,不能向第二个栈中压入数据
 */
public class Solution {
    //stack1作为push栈
    Stack<Integer> stackPush = new Stack<Integer>();
    //stack2作为pop栈
    Stack<Integer> stackPop = new Stack<Integer>();
    
    public void push(int node) {
        stackPush.push(node);
    }
    
    public int pop() {
        if(stackPush.empty() && stackPop.empty()){
            return 0;
        }else if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
}