import org.itis.hib.domain.Order;
import org.itis.hib.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.spring.itis.validator.OrderValidator;
import org.springframework.validation.Errors;

public class OrderValidatorTest {
    //проверка того, что все поля правильно заполнены
    @Test
    public void testCorrect() {
        OrderValidator userValidator = new OrderValidator();
        User user=new User();
        user.setId(1);
        user.setFirstname("Диана");
        user.setLastname("Давлетшина");
        user.setAge(23);
        Order order = new Order();
        order.setName("HP");
        order.setUser(user);
        order.setPrice(222223);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(order, "order");
        userValidator.validate(order, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(false, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void testNotEmptyLabelsCorrect() {
        OrderValidator orderValidator = new OrderValidator();
        Order order = new Order();
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(order, "order");
        orderValidator.validate(order, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void test2NotEmptyLabelsCorrect() {
        OrderValidator orderValidator = new OrderValidator();
        Order order = new Order();
        order.setName("HP");
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(order, "order");
        orderValidator.validate(order, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void test3NotEmptyLabelsCorrect() {
        OrderValidator orderValidator = new OrderValidator();
        Order order = new Order();
        order.setPrice(120000);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(order, "order");
        orderValidator.validate(order, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что поле price заполнено правильно
    @Test
    public void testLabelPriceCorrect() {
        OrderValidator orderValidator = new OrderValidator();
        Order order = new Order();
        order.setPrice(0);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(order, "order");
        orderValidator.validate(order, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что поле price заполнено правильно
    @Test
    public void test2LabelPriceCorrect() {
        OrderValidator orderValidator = new OrderValidator();
        Order order = new Order();
        order.setPrice(-20000);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(order, "order");
        orderValidator.validate(order, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
}
