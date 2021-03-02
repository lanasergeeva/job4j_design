import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TriggerTest extends TestCase {
    @Test
    public void test() {
        Assert.assertEquals(1, new Trigger().someLogic());
    }

}