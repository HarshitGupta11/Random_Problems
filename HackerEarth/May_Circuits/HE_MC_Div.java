//The solution runs in O(Q*log(N)/log(K)).
/*
The sum always follows the relation: sum(n,k)=sum(1 to n) - sum(k,2*k,3*k,...(n/k)*k) + sum(1 to n/k)
                                     sum(n,k)=(n*(n+1))/2 -(k*(n/k)*(n/k+1))/2 + sum(n/k,k) if n!=0
                                               0                                            if n=0
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HE_MC_Div {
    public static long rec_sum(long n,long k,long sum){
        //System.out.println(sum+" "+n+" "+k);
        if (n==0) return 0;
        else return ((n*(n+1))/2)-((k*(n/k)*(n/k+1))/2)+rec_sum(n/k,k,sum);
    }
    public static void main(String args[] ) throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        String inp[];
        long n,k;
        for(int tests=0;tests<t;tests++){
            inp=in.readLine().split(" ");
            n=Long.parseLong(inp[0]);
            k=Long.parseLong(inp[1]);
            System.out.println(rec_sum(n,k,0));
        }
    }
}
