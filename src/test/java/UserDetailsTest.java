import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sk.stopangin.repository.ExpenseDao;
import sk.stopangin.spring.security.repository.UserDao;
import sk.stopangin.to.CategoryDto;
import sk.stopangin.to.ExpenseDto;

/**
 * Created by myPC on 23. 5. 2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class UserDetailsTest{

    @Autowired
    UserDao userDao;

    @Autowired
    ExpenseDao expenseDao;


    @Value("${default.schema}")
    private String defaultSchema;

    @Autowired
    Environment env;


    @Test
    public void createExpense() {
        ExpenseDto expenseDto = new ExpenseDto();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("category");
        expenseDto.setCategory(categoryDto);
        expenseDto.setDesc("expense desc");
        expenseDto.setTitle("expense title");
        expenseDao.createExpense(expenseDto);
    }



}

