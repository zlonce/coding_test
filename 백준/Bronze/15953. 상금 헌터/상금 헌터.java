import java.util.Scanner;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int num =  sc.nextInt();

    for(int i = 0; i < num; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();

      int aPrize = findPrizeA(a);
      int bPrize = findPrizeB(b);

      int total = aPrize + bPrize;
      System.out.println(total);
    }
  }

  public static int findPrizeA(int a){
    if(a == 1) return 5000000;
    else if(1 < a && a <= 3) return 3000000;
    else if(3 < a && a <= 6) return 2000000;
    else if(6 < a && a <= 10) return 500000;
    else if(10 < a && a <= 15) return 300000;
    else if(15 < a && a <= 21) return 100000;
    else return 0;
  }

  public static int findPrizeB(int b){
    if(b == 1) return 5120000;
    else if(1 < b && b <= 3) return 2560000;
    else if(3 < b && b <= 7) return 1280000;
    else if(7 < b && b <= 15) return 640000;
    else if(15 < b && b <= 31) return 320000;
    else return 0;
  }
}
