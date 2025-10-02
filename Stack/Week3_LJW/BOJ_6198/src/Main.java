import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = N-1; i>=0 ; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();


        int[] answer = new int[N];

        int cnt=0;

        int n = 0;
        int ind=0;

        while(cnt<N){
            if(cnt==0){
                stack.push(arr[cnt]);
                index.push(N-cnt-1);
                cnt++;
            } else if(stack.peek() < arr[cnt] ){
                stack.pop();
                ind=index.pop();
                n++;
                if(answer[N-ind-1]!=0){
                    n=n+answer[N-ind-1];
                }
                if(stack.isEmpty()){
                    stack.push(arr[cnt]);
                    answer[cnt]=n;
                    n=0;
                    index.push(N-cnt-1);
                    cnt++;
                }
            }else {
                stack.push(arr[cnt]);
                index.push(N-cnt-1);
                answer[cnt]=n;
                n=0;
                cnt++;
            }
        }

        long sum=0;
        for(int i=0 ; i<N ; i++){
            sum+=answer[i];
        }
        System.out.println(sum);
    }
}