package sk.stopangin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sk.stopangin.repository.ExpenseDao;
import sk.stopangin.to.ExpenseDto;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Controller
public class ExpenseController {

    @Autowired
    ExpenseDao expenseDao;

    @RequestMapping(value = "/createExpense", method = RequestMethod.POST)
    public String createExpense(@RequestParam ExpenseDto expenseDto){
        expenseDao.createExpense(expenseDto);
        return "OK";
    }

}
