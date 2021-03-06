package com.twoqubed.bob.processor;

import com.twoqubed.bob.sample.ObjectsSample;

import java.io.IOException;

public class ObjectsTest extends AbstractElementProcessorTestCase {

    private BuilderMetadata builderMetadata;

    @Override
    protected void setUp() throws IOException, BuilderException {
        super.setUp();
        builderMetadata = elementProcessor.handleAnnotatedClass(element);
    }

    @Override
    protected Class<?> classToCompile() {
        return ObjectsSample.class;
    }

    public void testProcessesStringParam() throws Exception {
        ConstructorParam aString = builderMetadata.getParameters().get(0);

        assertEquals("java.lang.String", aString.getType());
    }

    public void testProcessesDateParam() throws Exception {
        ConstructorParam aDate = builderMetadata.getParameters().get(1);

        assertEquals("java.util.Date", aDate.getType());
    }

    public void testProcessesCustomDateParam() throws Exception {
        ConstructorParam aDate = builderMetadata.getParameters().get(2);

        assertEquals("com.twoqubed.bob.sample.Date", aDate.getType());
    }
}
