package sk.stopangin.util.expense;

import org.apache.commons.beanutils.PropertyUtils;
import sk.stopangin.model.Category;
import sk.stopangin.model.Expense;
import sk.stopangin.to.CategoryDto;
import sk.stopangin.to.ExpenseDto;

/**
 * Created by myPC on 23. 5. 2015.
 */
public class DtoToEntityUtil {
    public static ExpenseDto createDtoFromEntity(Expense expense) {
        ExpenseDto result = new ExpenseDto();
        result.setTitle(expense.getTitle());
        result.setDesc(expense.getDesc());
        result.setCategory(createCategoryDtoFromCategory(expense.getCategory()));
        return result;
    }

    private static CategoryDto createCategoryDtoFromCategory(Category category){
        CategoryDto result = new CategoryDto();
        result.setName(category.getName());
        return result;
    }

    public static Expense createEntityFromDto(ExpenseDto expense) {
        Expense result = new Expense();
        result.setTitle(expense.getTitle());
        result.setDesc(expense.getDesc());
        result.setCategory(createCategoryFromCategoryDto(expense.getCategory()));
        return result;
    }

    private static Category createCategoryFromCategoryDto(CategoryDto category){
        Category result = new Category();
        if(category!=null) {
            result.setName(category.getName());
        }
        return result;
    }

}
