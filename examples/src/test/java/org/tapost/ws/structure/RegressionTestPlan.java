package org.tapost.ws.structure;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses(StructureTests.class)
@IncludeTags(Regression.NAME)
public class RegressionTestPlan {
}
