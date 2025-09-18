import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        Stack<String> temp = new Stack<>();

        String[] line = br.readLine().split("");
        for (String s : line) {
            stack.push(s);
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String command=br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L' :{
                    if (!stack.isEmpty())
                        temp.push(stack.pop());
                    break;
                }
                case 'D' : {
                    if (!temp.isEmpty())
                        stack.push(temp.pop());
                    break;
                }
                case 'B' : {
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                }
                case 'P' : {
                    stack.push(String.valueOf(command.charAt(2)));
                    break;
                }
                default :
                    break;
            }
        }

        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        while(!temp.isEmpty()){
            bw.write(temp.pop());
        }
        bw.flush();
        bw.close();
        br.close();


    }
}