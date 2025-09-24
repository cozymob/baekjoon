import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[2];
        for(int i = 0; i < 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        int N = arr[0];
        int K = arr[1];

        LinkedList<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            list.add(i+1);
        }

        int index=K-1;
        //int flag=index;
        while(!list.isEmpty()) {

            if(list.size() > index) {
                queue.add(list.remove(index));
                index+=K-1;

            }else {
                index-=list.size();

            }
        }
        System.out.print("<");
        while(queue.size()!=1) {
            bw.write(queue.remove()+", ");
        }
        bw.write(queue.remove()+">");
        bw.flush();
        bw.close();




    }
}