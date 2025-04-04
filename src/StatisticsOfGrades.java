import java.util.Scanner;
public class StatisticsOfGrades {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);


        //int[] grades= {2 ,20, 21, 22, 23, 30, 48, 49, 50, 55, 60, 65, 72, 63, 76, 80, 68, 90, 85, 98};

        System.out.println("Input: (The student's grades vary from 0 to 100)");
        String input = scanner.nextLine(); // Read full line

        // Split input string by spaces and convert to integer array
        String[] tokens = input.split(" ");
        int[] grades = new int[tokens.length];
        int n=grades.length;

        for (int i = 0; i < tokens.length; i++) {
            grades[i] = Integer.parseInt(tokens[i]); // Convert to integer
        }

        int[] stats= new int[5];
        int maximum=-1;
        int minimum=107;
        double average=0;
        int maxCount=-1;//highest frequency in each range

        for(int i=0;i < n; i++){

            if (grades[i]>maximum){
                maximum=grades[i];
            }

            if (grades[i]<minimum){
                minimum=grades[i];
            }

            if(0<=grades[i] && grades[i]<=20){
                stats[0]+=1; //0-20
            }
            if(21<=grades[i] && grades[i]<=40){
                stats[1]+=1; //21-40
            }
            if(41<=grades[i] && grades[i]<=60){
                stats[2]+=1; //41-60
            }

            if(61<=grades[i] && grades[i]<=80){
                stats[3]+=1; //61-80
            }

            if(81<=grades[i] && grades[i]<=100){
                stats[4]+=1; //81-100
            }

            average += grades[i];

        }
        average=average/n;

        for(int i=0;i<4;i++){
            if(stats[i]>maxCount){
                maxCount=stats[i];
            }
        }

        String[][] graph=new String[maxCount][5];

        for(int i=0;i<maxCount;i++){
            for(int j=0;j<5;j++){
                if (stats[j]>=i+1){
                    graph[i][j]="#######";
                }
                else{
                    graph[i][j]="       ";
                }
            }
        }

        System.out.printf("%nValues: %n");
        System.out.printf("The maximum grade is %d.%n", maximum);
        System.out.printf("The minimum grade is %d.%n", minimum);
        System.out.printf("The average grade is %f.%n", average);

        System.out.printf("%nGraph: %n");

        for(int i=maxCount-1;i>=0;i--){
            System.out.printf("%d>   %s   %s   %s   %s   %s%n",i+1,graph[i][0],graph[i][1],graph[i][2],graph[i][3],graph[i][4]);
        }
        System.out.println("+-----------+---------+---------+---------+---------+");
        System.out.println("I    0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");


    }
}
