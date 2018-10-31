package seedu.address.logic.parser;
//@@author winsonhys

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.model.budget.TotalBudgetTest.INVALID_BUDGET;
import static seedu.address.model.budget.TotalBudgetTest.VALID_BUDGET;

import org.junit.Test;

import seedu.address.logic.commands.SetBudgetCommand;
import seedu.address.model.budget.TotalBudget;



public class SetBudgetCommandParserTest {
    private SetBudgetCommandParser parser = new SetBudgetCommandParser();

    @Test
    public void parse_validBudget_returnsSetBudgetCommand() {
        assertParseSuccess(parser, " " + VALID_BUDGET, new SetBudgetCommand(new TotalBudget(VALID_BUDGET)));
    }

    @Test
    public void parse_invalidBudget_throwsParseError() {
        assertParseFailure(parser, " " + INVALID_BUDGET, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            SetBudgetCommand.MESSAGE_USAGE));
    }

}
