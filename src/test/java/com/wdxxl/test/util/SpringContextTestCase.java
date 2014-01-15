package com.wdxxl.test.util;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ActiveProfiles(value="prod")
public abstract class SpringContextTestCase extends AbstractJUnit4SpringContextTests {
}
