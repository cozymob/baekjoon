import java.io.*;
import java.util.Stack;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");

            for(int j = 0; j < arr.length; j++) {
                switch(arr[j]) {
                    case "<":
                        if(!stack1.isEmpty())
                            stack2.push(stack1.pop());
                        break;
                    case ">" :
                        if(!stack2.isEmpty())
                            stack1.push(stack2.pop());
                        break;
                    case "-" :
                        if(!stack1.isEmpty()) {
                            stack1.pop();
                        }
                        break;
                    default :
                        stack1.push(arr[j]);
                        break;
                }
            }

            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            while(!stack2.isEmpty()) {
                bw.write(stack2.pop());
            }
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
    }
}