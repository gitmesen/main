package seedu.address.testutil;

import java.util.Optional;

import seedu.address.model.ExpenseTracker;
import seedu.address.model.expense.Expense;

/**
 * A utility class to help with building Expensetracker objects.
 * Example usage: <br>
 *     {@code ExpenseTracker ab = new ExpenseTrackerBuilder().withExpense("Have lunch", "Books").build();}
 */
public class ExpenseTrackerBuilder {

    private ExpenseTracker expenseTracker;

    public ExpenseTrackerBuilder() {
        expenseTracker = new ExpenseTracker(ModelUtil.TEST_USERNAME, Optional.empty());
    }

    public ExpenseTrackerBuilder(ExpenseTracker expenseTracker) {
        this.expenseTracker = expenseTracker;
    }

    /**
     * Adds a new {@code Expense} to the {@code ExpenseTracker} that we are building.
     */
    public ExpenseTrackerBuilder withExpense(Expense expense) {
        expenseTracker.addExpense(expense);
        return this;
    }

    public ExpenseTracker build() {
        return expenseTracker;
    }
}