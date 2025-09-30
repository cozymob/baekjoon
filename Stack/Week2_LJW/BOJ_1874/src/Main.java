import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<String> answer = new Stack<>();

        while (N-- > 0) {
            String s = br.readLine();
            stack1.push(Integer.parseInt(s));
        }

        while(true) {
            stack2.push(stack1.pop());
            answer.push("-");
            if (!stack1.isEmpty()) {
                if (stack1.peek() < stack2.peek()) {
                    while (true) {
                        stack3.push(stack2.pop());
                        answer.push("+");
                        if (!stack2.isEmpty()) {
                            if (stack3.peek() - 1 != stack2.peek()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else {
                while (true) {
                    stack3.push(stack2.pop());
                    answer.push("+");
                    if (!stack2.isEmpty()) {
                        if (stack3.peek() - 1 != stack2.peek()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            }
        }

        if(!stack2.isEmpty()){
            System.out.println("NO");
        }else{
            while(!answer.isEmpty()){
                System.out.println(answer.pop());
            }
        }

    }
}
