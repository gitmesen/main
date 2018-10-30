package seedu.address.storage;
//@@author winsonhys

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.model.budget.TotalBudgetTest.INVALID_BUDGET;
import static seedu.address.model.budget.TotalBudgetTest.VALID_BUDGET;
import static seedu.address.model.expense.CategoryTest.INVALID_CATEGORY;
import static seedu.address.model.expense.CategoryTest.VALID_CATEGORY;

import org.junit.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.budget.CategoryBudget;
import seedu.address.storage.budget.XmlAdaptedCategoryBudget;
import seedu.address.testutil.Assert;


public class XmlAdaptedCategoryBudgetTest {

    @Test
    public void equals() {
        XmlAdaptedCategoryBudget validXmlAdaptedTotalBudget =
            new XmlAdaptedCategoryBudget(new CategoryBudget(VALID_CATEGORY, VALID_BUDGET));

        String anotherValidBudgetString = "3.00";
        String anotherValidCategoryString = "Harlow";
        assertNotEquals(validXmlAdaptedTotalBudget,
            new XmlAdaptedCategoryBudget(new CategoryBudget(anotherValidCategoryString, anotherValidBudgetString)));
        assertEquals(validXmlAdaptedTotalBudget, validXmlAdaptedTotalBudget);
        assertNotEquals(validXmlAdaptedTotalBudget, new Object());
    }

    @Test
    public void toModelType_validCategoryValidBudget_returnsCategoryBudget() throws IllegalValueException {
        CategoryBudget validCBudget = new CategoryBudget(VALID_CATEGORY, VALID_BUDGET);
        XmlAdaptedCategoryBudget cBudget = new XmlAdaptedCategoryBudget(validCBudget);
        assertEquals(validCBudget, cBudget.toModelType());
    }

    @Test
    public void toModelType_invalidCategory_throwsIllegalValueException() {
        XmlAdaptedCategoryBudget cBudget =
            new XmlAdaptedCategoryBudget(INVALID_CATEGORY, VALID_BUDGET);
        String expectedMessage = XmlAdaptedCategoryBudget.MESSAGE_INVALID_FIELDS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, cBudget::toModelType);
    }

    @Test
    public void toModelType_invalidBudget_throwsIllegalValueException() {
        XmlAdaptedCategoryBudget cBudget =
            new XmlAdaptedCategoryBudget(VALID_CATEGORY, INVALID_BUDGET);
        String expectedMessage = XmlAdaptedCategoryBudget.MESSAGE_INVALID_FIELDS;
        Assert.assertThrows(IllegalValueException.class, expectedMessage, cBudget::toModelType);
    }
}
