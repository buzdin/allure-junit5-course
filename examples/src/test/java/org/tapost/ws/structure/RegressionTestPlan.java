package org.tapost.ws.structure;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;

//@RunWith(JUnitPlatform.class)
@SelectClasses(StructureTests.class)
@IncludeTags(Regression.NAME)
public class RegressionTestPlan {
}
