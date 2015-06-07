package sk.stopangin.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.stopangin.log.LoggableDebug;
import sk.stopangin.model.Expense;
import sk.stopangin.repository.generic.GenericDao;
import sk.stopangin.spring.security.util.SecurityContextUtil;
import sk.stopangin.to.ExpenseDto;
import sk.stopangin.util.expense.DtoToEntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Repository
public class ExpenseDao{
    @PersistenceContext
    EntityManager entityManager;

    @LoggableDebug
    @Transactional
    public void createExpense(ExpenseDto expenseDto) {
        final Expense expense = DtoToEntityUtil.createEntityFromDto(expenseDto);
        expense.setUserName(SecurityContextUtil.getUserName());
        entityManager.persist(expense);
//        super.create(expense);
    }

}
