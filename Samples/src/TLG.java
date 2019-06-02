import java.util.Scanner;

public class TLG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        int scores1[] = new int[rounds];
        int scores2[] = new int[rounds];
        int leads[] = new int[rounds];
        for(int i=0;i<rounds;i++){
            scores1[i] = sc.nextInt();
            scores2[i] = sc.nextInt();
        }
        leads[0] = scores2[0]-scores1[0];
        for(int i=1;i<rounds;i++) {
            scores2[i] += scores2[i-1];
            scores1[i] += scores1[i-1];
            leads[i] = scores2[i]-scores1[i];
        }
        int maxLead=0; int winner = 1;
        for(int i=0;i<rounds;i++){
            if(Math.abs(leads[i])>maxLead){
                maxLead = Math.abs(leads[i]);
                if(leads[i]<0){
                    winner = 1;
                }else{
                    winner = 2;
                }
            }
        }
        System.out.println(winner+ " "+maxLead);
    }
}
