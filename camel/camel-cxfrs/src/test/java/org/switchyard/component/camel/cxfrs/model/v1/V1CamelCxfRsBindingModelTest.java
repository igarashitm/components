/* 
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.switchyard.component.camel.cxfrs.model.v1;

import static junit.framework.Assert.assertEquals;

import java.net.URI;
import java.text.ParseException;
import java.util.Collections;

import org.apache.camel.component.cxf.jaxrs.CxfRsEndpoint;
import org.switchyard.component.camel.config.test.v1.V1BaseCamelServiceBindingModelTest;
import org.switchyard.component.camel.cxfrs.model.CamelCxfRsNamespace;
import org.switchyard.component.camel.cxfrs.model.v1.V1CamelCxfRsBindingModel;

/**
 * Test of cxfrs binding model.
 */
public class V1CamelCxfRsBindingModelTest extends V1BaseCamelServiceBindingModelTest<V1CamelCxfRsBindingModel, CxfRsEndpoint> {

    private static final String CAMEL_XML = "/v1/switchyard-cxfrs-binding.xml";

    private static final String CAMEL_URI = 
        "cxfrs://http://localhost:8080/testRS?"
            + "resourceClasses=org.switchyard.component.camel.cxfrs.HelloWorldService"
            + "&httpClientAPI=true"
            + "&synchronous=true"
            + "&throwExceptionOnFailure=true"
            + "&maxClientCacheSize=5"
            + "&setDefaultBus=true"
            + "&bindingStyle=SimpleConsumer"
            + "&properties.foo=bar";

    private static final URI CXFRSURI = URI.create("http://localhost:8080/testRS");
    private static final String RESOURCECLASSES = "org.switchyard.component.camel.cxfrs.HelloWorldService";
    private static final boolean HTTPCLIENTAPI = true;
    private static final boolean SYNCHRONOUS = true;
    private static final boolean THROWEXCEPTIONONFAILURE = true;
    private static final int MAXCLIENTCACHESIZE = 5;
    private static final boolean SETDEFAULTBUS = true;
    private static final String BINDINGSTYLE = "SimpleConsumer";

    public V1CamelCxfRsBindingModelTest() throws ParseException {
        super(CxfRsEndpoint.class, CAMEL_XML);
    }

    @Override
    protected void createModelAssertions(V1CamelCxfRsBindingModel model) {
        assertEquals(CXFRSURI, model.getCxfRsURI());
        assertEquals(RESOURCECLASSES, model.getResourceClasses());
        assertEquals(HTTPCLIENTAPI, (boolean)model.isHttpClientAPI());
        assertEquals(SYNCHRONOUS, (boolean)model.isSynchronous());
        assertEquals(THROWEXCEPTIONONFAILURE, (boolean)model.isThrowExceptionOnFailure());
        assertEquals(MAXCLIENTCACHESIZE, (int)model.getMaxClientCacheSize());
        assertEquals(SETDEFAULTBUS, (boolean)model.isSetDefaultBus());
        assertEquals(BINDINGSTYLE, model.getBindingStyle());
    }

    @Override
    protected V1CamelCxfRsBindingModel createTestModel() {
        V1CamelCxfRsBindingModel abm = new V1CamelCxfRsBindingModel(CamelCxfRsNamespace.V_2_0.uri());
        abm.setAdditionalUriParameters(createAdditionalUriParametersModel(CamelCxfRsNamespace.V_2_0.uri(), Collections.singletonMap("properties.foo", "bar")));
        abm
                                    .setCxfRsURI(CXFRSURI)
                                    .setResourceClasses(RESOURCECLASSES)
                                    .setHttpClientAPI(HTTPCLIENTAPI)
                                    .setSynchronous(SYNCHRONOUS)
                                    .setThrowExceptionOnFailure(THROWEXCEPTIONONFAILURE)
                                    .setMaxClientCacheSize(MAXCLIENTCACHESIZE)
                                    .setSetDefaultBus(SETDEFAULTBUS)
                                    .setBindingStyle(BINDINGSTYLE);
        return abm;
    }

    @Override
    protected String createEndpointUri() {
        return CAMEL_URI;
    }

}
