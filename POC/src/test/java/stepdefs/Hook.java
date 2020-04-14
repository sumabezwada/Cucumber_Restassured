package stepdefs;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil {

private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initialization()
    {
        System.out.println(" before method is displaying");

    }

    @After
    public void teardown()
    {
        System.out.println(" after method is displaying");
    }
}
