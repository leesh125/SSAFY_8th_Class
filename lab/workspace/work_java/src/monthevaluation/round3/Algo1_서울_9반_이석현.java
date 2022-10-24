import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo1_서울_9반_이석현 {
	
	static int origin_num;
	static int N,rest,ans,min;
	static Stack<Integer> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        stack = new Stack<>();
        stack.add(64);
        N = Integer.parseInt(br.readLine());
        rest = 64; ans = 0; min = 0;

        while(true) {
            if(rest == N) {
                sb.append(stack.size());
                System.out.println(sb.toString());
                break;
            }
            min = stack.pop();
            rest -= min;
            int temp = min / 2;

            if(temp + rest >= N) {
                stack.push(temp);
                rest += temp;
            }else {
                stack.push(temp);
                stack.push(temp);
                rest += min;
            }
        }
    }
}