package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.expense.Category;
import seedu.address.model.expense.Cost;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Name;
import seedu.address.model.expense.Person;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_CATEGORY = "Default";
    public static final String DEFAULT_COST = "321.00";
    public static final String DEFAULT_DATE = "01-10-2018";

    private Name name;
    private Category category;
    private Cost cost;
    private Date date;
    private Set<Tag> tags;

    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        category = new Category(DEFAULT_CATEGORY);
        cost = new Cost(DEFAULT_COST);
        date = new Date();
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        category = personToCopy.getCategory();
        cost = personToCopy.getCost();
        date = personToCopy.getDate();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Cost} of the {@code Person} that we are building.
     */
    public PersonBuilder withCost(String cost) {
        this.cost = new Cost(cost);
        return this;
    }

    /**
     * Sets the {@code Category} of the {@code Person} that we are building.
     */
    public PersonBuilder withCategory(String category) {
        this.category = new Category(category);
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Person} that we are building.
     */
    public PersonBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    public Person build() {
        return new Person(name, category, cost, date, tags);
    }

}
