package BackendOnJavaTest;

import BackendOnJava.PalindromeChecker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {

    private PalindromeChecker palindrome;
    private String input;

    @BeforeAll
    public void setUp() throws Exception {

        input = null;
        palindrome = new PalindromeChecker();

    }

    @AfterAll
    public void tearDown() throws Exception {

    }

    @Test(expected = NullPointerException.class)
    public void nullStringTest() throws Exception {

        palindrome.isPalindrome(null);

    }

    @Test
    public void emptyStringTest() throws Exception {

        input = "";


        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void multipleWhiteSpaceTest() throws Exception {

        input = "A roza upala na Lapu Azora";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void singleCharTest() throws Exception {

        input = "B";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void punctuationTest() throws Exception {

        input = "A roza upala na Lapu, Azora";

        assertFalse(palindrome.isPalindrome(input));

    }

    @Test
    public void alphaNumericPalindromeTest() throws Exception {

        input = "Air 2 an a2ria";

        assertTrue(palindrome.isPalindrome(input));
    }

    @Test
    public void validPalindromeTest() throws Exception {

        input = "No lemon no melon";

        assertTrue(palindrome.isPalindrome(input));
    }

    @Test
    public void invalidPalindromeTest() throws Exception {

        input = "Shla Sash po Shosse";

        assertFalse(palindrome.isPalindrome(input));
    }

}
