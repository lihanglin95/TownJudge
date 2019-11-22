import org.junit.Assert;
import java.util.Iterator;
import java.util.LinkedList;

public class Judge {

    /**
     * This method is to find the judge using Adjacency Matrix graph
     * @param n This is the number of people
     * @param trust This the the array of trust pairs
     * @return This returns the label of the judge
     */
    public static int findJudgeWithMatrix(int n, int[][] trust){
        if(trust == null || trust.length<=0 || trust[0].length!=2)
            throw new IllegalArgumentException("trust invalid");
        int res = -1;
        int[][] matrix = new int[n+1][n+1];

        //build adj matrix
        for (int[] i: trust){
            matrix [i[0]] [i[1]] = 1;
        }

        //find judge in matrix
        for (int i =1; i <= n; i++){
            if(matrix[i][i]==0){
                boolean found = true;
                for(int j = 1; j<= n ; j++){
                    if(matrix[i][j]!=0){
                        found = false;
                        break;
                    }
                }
                if(found) {
                    for (int k = 1; k <= n; k++) {
                        if (i != k && matrix[k][i] != 1){
                            found = false;
                            break;
                        }
                    }
                }
                if(found)
                    return i;
            }
        }
        return res;
    }

    /**
     * This method is to find the judge using Adjacency List graph
     * @param n This is the number of people
     * @param trust This the the array of trust pairs
     * @return This returns the label of the judge
     */
    public static int findJudgeWithList(int n, int[][] trust){
        if(trust == null || trust.length<=0 || trust[0].length!=2)
            throw new IllegalArgumentException("trust invalid");
        int res = -1;

        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        for(int i = 0; i<adjList.length; i++){
            adjList[i] = new LinkedList<>();
        }
        //build adj matrix
        for (int[] point: trust){   //int i = 0; i< trust.length; i++{ trust[i]}

            adjList[point[0]].add(point[1]);
        }

        //find judge in matrix
        int[] numOfTrust = new int[n+1];
        for(LinkedList<Integer> vertex: adjList){
            Iterator it = vertex.iterator();
            while(it.hasNext()){
                numOfTrust[(int) it.next()]++;
            }
        }
        for (int i = 1; i<numOfTrust.length; i++){
            if(numOfTrust[i]==(n-1)&&adjList[i].size()==0)
                return i;
        }

        return res;
    }

    /**
     * This method is to print the trust table and the result
     * @param array This the the array of trust pairs
     * @param res This is the label of the judge
     */
    private static void printDoubleLoop(int[][] array, int res){
        for(int i = 0; i < array.length; i++){
            for(int element = 0; element < array[i].length; element++){
                if(element == 0){
                    System.out.print(array[i][element] + ", ");
                }else{
                    System.out.print(array[i][element]);
                }
            }
            System.out.println();
        }
        if(res != -1){
            System.out.println(res + " is the judge.");
        }else {
            System.out.println("There is no judge.");
        }
    }

    /*
    Main class
     */
    public static void main(String[] args) {
        Judge judge = new Judge();
        int[][] example1 = {{1,2}};
        int[][] example2 = {{1,3}, {2,3}};
        int[][] example3 = {{1,3}, {2,3}, {3,1}};
        int[][] example4 = {{1,2}, {2,3}};
        int[][] example5 = {{1,3},{1,4}, {2,3}, {2,4}, {4,3}};

        Assert.assertEquals(2, judge.findJudgeWithList(2, example1));
        Assert.assertEquals(2, judge.findJudgeWithMatrix(2, example1));
        printDoubleLoop(example1, findJudgeWithList(2, example1));
        System.out.println("Pass the first test.\n");

        Assert.assertEquals(3, judge.findJudgeWithList(3, example2));
        Assert.assertEquals(3, judge.findJudgeWithMatrix(3, example2));
        printDoubleLoop(example2, findJudgeWithList(3, example2));
        System.out.println("Pass the second test.\n");

        Assert.assertEquals(-1, judge.findJudgeWithList(3, example3));
        Assert.assertEquals(-1, judge.findJudgeWithMatrix(3, example3));
        printDoubleLoop(example3, findJudgeWithList(3, example3));
        System.out.println("Pass the third test.\n");

        Assert.assertEquals(-1, judge.findJudgeWithList(3, example4));
        Assert.assertEquals(-1, judge.findJudgeWithMatrix(3, example4));
        printDoubleLoop(example4, findJudgeWithList(3, example4));
        System.out.println("Pass the fourth test.\n");

        Assert.assertEquals(3, judge.findJudgeWithList(4, example5));
        Assert.assertEquals(3, judge.findJudgeWithMatrix(4, example5));
        printDoubleLoop(example5, findJudgeWithList(4, example5));
        System.out.println("Pass all the tests.\n");
    }

}
