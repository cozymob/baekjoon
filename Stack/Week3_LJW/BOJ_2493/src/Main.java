import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer>  index= new Stack<>();
        int[] answer = new int[N];

        stack.push(0);
        index.push(0);

        String s = br.readLine();
        String[] arr = s.split(" ");
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }

        int cnt=0;

        while(cnt<N){
            if(stack.peek() < num[cnt]){
                stack.pop();
                index.pop();
                if(stack.isEmpty()){
                    stack.push(num[cnt]);
                    index.push(cnt+1);
                    answer[cnt]=0;
                    cnt++;
                }
            }else if(stack.peek() > num[cnt]){
                answer[cnt]=index.peek();
                stack.push(num[cnt]);
                index.push(cnt+1);
                cnt++;
            }
        }

        for(int i=0;i<N;i++){
            System.out.print(answer[i]+" ");
        }
    }
}