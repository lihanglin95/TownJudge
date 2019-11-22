import org.junit.Assert;
import org.junit.Test;

public class Tests {

    /**
     * This is the junit test
     */
    @Test
    public void test(){
        Judge judge = new Judge();
        int[][] example1 = {{1,2}};
        int[][] example2 = {{1,3}, {2,3}};
        int[][] example3 = {{1,3}, {2,3}, {3,1}};
        int[][] example4 = {{1,2}, {2,3}};
        int[][] example5 = {{1,3},{1,4}, {2,3}, {2,4}, {4,3}};
        Assert.assertEquals(2, judge.findJudgeWithList(2, example1));
        Assert.assertEquals(2, judge.findJudgeWithMatrix(2, example1));
        System.out.println("Pass the first test./n");

        Assert.assertEquals(3, judge.findJudgeWithList(3, example2));
        Assert.assertEquals(3, judge.findJudgeWithMatrix(3, example2));
        System.out.println("Pass the second test./n");

        Assert.assertEquals(-1, judge.findJudgeWithList(3, example3));
        Assert.assertEquals(-1, judge.findJudgeWithMatrix(3, example3));
        System.out.println("Pass the third test./n");

        Assert.assertEquals(-1, judge.findJudgeWithList(3, example4));
        Assert.assertEquals(-1, judge.findJudgeWithMatrix(3, example4));
        System.out.println("Pass the fourth test./n");

        Assert.assertEquals(3, judge.findJudgeWithList(4, example5));
        Assert.assertEquals(3, judge.findJudgeWithMatrix(4, example5));
        System.out.println("Pass all the tests./n");
    }


}
