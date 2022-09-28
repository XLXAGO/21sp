package flik;
import org.junit.Test;
import org.junit.Assert;

public class FlikTest {
    @Test
    public void test1() {
        int a = 500;
        int b = 500;
        boolean cond = (a == b);
        Assert.assertTrue(cond);
        System.out.println("test1 passed");

        boolean cond2 = Flik.isSameNumber(a, b);
        Assert.assertTrue(cond2);
        System.out.println("test2 passed");
    }
}
