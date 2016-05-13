import org.itis.hib.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.spring.itis.validator.UserValidator;
import org.springframework.validation.Errors;

public class UserValidatorTest {

    //проверка того, что все поля правильно заполнены
    @Test
    public void testCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setFirstname("Диана");
        user.setLastname("Давлетшина");
        user.setAge(23);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(false, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void testNotEmptyLabelsCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void test2NotEmptyLabelsCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setFirstname("Полина");
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void test3NotEmptyLabelsCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setLastname("Дубровина");
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что все поля заполнены
    @Test
    public void test4NotEmptyLabelsCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setAge(12);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что поле age заполнено правильно
    @Test
    public void testLabelAgeCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setAge(0);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
    //проверка того, что поле age заполнено правильно
    @Test
    public void test2LabelAgeCorrect() {
        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setAge(-12);
        Errors result = new org.springframework.validation.BeanPropertyBindingResult(user, "user");
        userValidator.validate(user, result);
        boolean isIncorrect = result.hasErrors();
        Assert.assertEquals(true, isIncorrect);
    }
}
