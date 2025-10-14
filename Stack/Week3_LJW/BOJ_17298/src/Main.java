import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] arr = s.split(" ");

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        int index =N-1;

        while(index>=0){

            while(!stack.isEmpty() && stack.peek()<=Integer.parseInt(arr[index])){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer.push(-1);
            }else{
                answer.push(stack.peek());
            }
            stack.push(Integer.parseInt(arr[index]));
            index--;
        }

        while(!answer.isEmpty()){
            bw.write(answer.pop()+" ");
        }
        bw.flush();
        bw.close();
    }
}