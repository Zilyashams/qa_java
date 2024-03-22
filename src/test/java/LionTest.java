import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    Lion lion;

    @Mock
    Feline feline;

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals(expected, lion.getFood());
    }

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void getExceptionTest() {
        String expectedString = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Средний пол", feline));
        Assert.assertEquals(expectedString, exception.getMessage());
    }
}