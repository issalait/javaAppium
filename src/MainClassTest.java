import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber() {
        Assert.assertTrue("Number is not equal 14!", mainClass.getLocalNumber() == 14);
    }

    @Test
    public void testGetClassNumber() {
        Assert.assertTrue("Number is less than 45!", mainClass.getClassNumber() > 45);
    }

    @Test
    public void testGetClassString() {
        String subString = mainClass.getClassString().substring(0, 5);
        System.out.println(subString);

        if (subString.equals("hello") || subString.equals("Hello"))
            showMessage("This string contains hello or Hello word");
        else Assert.fail("This string doesn't contain hello or Hello word");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
