package java.dynamicprogramming;

public class HasSubSum {

    public static boolean hasSubsetSum(int sum, int[] numbers) {

        //Matrix zur Veranschaulichung: https://www.youtube.com/watch?v=s6FhG--P7z0

        boolean[][] retVal = new boolean[sum + 1][numbers.length + 1];

        //basisfälle, falls summe 0 oder falls summe nicht 0 aber subset ist 0
        for(int i=0;i<=numbers.length;i++){
            retVal[0][i]=true;
        }


        // 1. spalte
        for(int i=1;i<=sum;i++){
            retVal[i][0]=false;
        }

        //matrix füllen
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=numbers.length;j++){

                retVal[i][j] = retVal[i][j-1];

                if(!retVal[i][j] && i >= numbers[j-1])
                    retVal[i][j] = retVal[i][j] || retVal[i-numbers[j-1]][j-1];
            }
        }

        return retVal[sum][numbers.length];
    }

    public static void main(String[] args) {

    }

}
