package tests.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utilities.Listeners.class)
public class ListenerTest {

    @Test
    public void test01() {
        System.out.println("Test Case 1-PASS");
        Assert.assertTrue(true);//pass
    }

    @Test
    public void test02() {
        System.out.println("Test Case 2 -FAILED");
        Assert.assertTrue(false);//fail
    }

    @Test
    public void test03() {
        System.out.println("Test Case 3 -SKIPPED");
        throw new SkipException("Skip Edilecek");//skip
    }
}
