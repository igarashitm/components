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

import java.net.URI;
import java.util.List;

import org.switchyard.component.camel.common.QueryString;
import org.switchyard.component.camel.common.model.v1.V1BaseCamelBindingModel;
import org.switchyard.component.camel.cxfrs.model.CamelCxfRsBindingModel;
import org.switchyard.config.Configuration;
import org.switchyard.config.model.Descriptor;

/**
 * V1Camel CXFRS binding model.
 */
public class V1CamelCxfRsBindingModel extends V1BaseCamelBindingModel
    implements CamelCxfRsBindingModel {

    /**
     * The name of this binding type ("binding.cxfrs").
     */
    public static final String CXFRS = "cxfrs";
    private static final String CXFRSURI = "cxfRsURI";
    private static final String SETDEFAULTBUS = "setDefaultBus";
    private static final String BUS = "bus";
    private static final String SYNCHRONOUS = "synchronous";
    private static final String RESOURCECLASSES = "resourceClasses";
    private static final String HTTPCLIENTAPI = "httpClientAPI";
    private static final String THROWEXCEPTIONONFAILURE = "throwExceptionOnFailure";
    private static final String MAXCLIENTCACHESIZE = "maxClientCacheSize";
    private static final String BINDINGSTYLE = "bindingStyle";
    private static final String PROVIDERS = "providers";
    private static final String SCHEMALOCATIONS = "schemaLocations";
    private static final String FEATURES = "features";
    private static final String PROPERTIES = "properties";
    private static final String ININTERCEPTORS = "inInterceptors";
    private static final String OUTINTERCEPTORS = "outInterceptors";
    private static final String INFAULTINTERCEPTORS = "inFaultInterceptors";
    private static final String OUTFAULTINTERCEPTORS = "outFaultInterceptors";

    /**
     * Create a new CxfrsBindingModel.
     * @param namespace namespace
     */
    public V1CamelCxfRsBindingModel(String namespace) {
        super(CXFRS, namespace);

        setModelChildrenOrder(CXFRSURI, RESOURCECLASSES, HTTPCLIENTAPI, SYNCHRONOUS, THROWEXCEPTIONONFAILURE,
                MAXCLIENTCACHESIZE, SETDEFAULTBUS, BUS, BINDINGSTYLE, PROVIDERS, SCHEMALOCATIONS, FEATURES,
                PROPERTIES, ININTERCEPTORS, OUTINTERCEPTORS, INFAULTINTERCEPTORS, OUTFAULTINTERCEPTORS);
    }

    /**
     * Create a CxfRsBindingModel from the specified configuration and descriptor.
     * 
     * @param config The switchyard configuration instance.
     * @param desc The switchyard descriptor instance.
     */
    public V1CamelCxfRsBindingModel(Configuration config, Descriptor desc) {
        super(config, desc);
    }

    @Override
    public URI getCxfRsURI() {
        String uriStr = getConfig(CXFRSURI);
        if (uriStr != null) {
            return URI.create(uriStr);
        } else {
            return null;
        }
    }

    @Override
    public V1CamelCxfRsBindingModel setCxfRsURI(URI cxfRsURI) {
        setConfig(CXFRSURI, cxfRsURI);
        return this;
    }

    @Override
    public Boolean isSetDefaultBus() {
        return getBooleanConfig(SETDEFAULTBUS);
    }

    @Override
    public V1CamelCxfRsBindingModel setSetDefaultBus(Boolean setDefaultBus) {
        setConfig(SETDEFAULTBUS, setDefaultBus);
        return this;
    }


    @Override
    public String getBus() {
        return getConfig(BUS);
    }

    @Override
    public V1CamelCxfRsBindingModel setBus(String bus) {
        setConfig(BUS, bus);
        return this;
    }

    @Override
    public Boolean isSynchronous() {
        return getBooleanConfig(SYNCHRONOUS);
    }

    @Override
    public V1CamelCxfRsBindingModel setSynchronous(Boolean synchronous) {
        setConfig(SYNCHRONOUS, synchronous);
        return this;
    }

    @Override
    public String getResourceClasses() {
        return getConfig(RESOURCECLASSES);
    }

    @Override
    public CamelCxfRsBindingModel setResourceClasses(String classes) {
        setConfig(RESOURCECLASSES, classes);
        return this;
    }

    @Override
    public Boolean isHttpClientAPI() {
        return getBooleanConfig(HTTPCLIENTAPI);
    }

    @Override
    public CamelCxfRsBindingModel setHttpClientAPI(Boolean httpclientapi) {
        setConfig(HTTPCLIENTAPI, httpclientapi);
        return this;
    }

    @Override
    public Boolean isThrowExceptionOnFailure() {
        return getBooleanConfig(THROWEXCEPTIONONFAILURE);
    }

    @Override
    public CamelCxfRsBindingModel setThrowExceptionOnFailure(Boolean exceptiononfailure) {
        setConfig(THROWEXCEPTIONONFAILURE, exceptiononfailure);
        return this;
    }

    @Override
    public Integer getMaxClientCacheSize() {
        return getIntegerConfig(MAXCLIENTCACHESIZE);
    }

    @Override
    public CamelCxfRsBindingModel setMaxClientCacheSize(Integer size) {
        setConfig(MAXCLIENTCACHESIZE, size);
        return this;
    }

    @Override
    public String getBindingStyle() {
        return getConfig(BINDINGSTYLE);
    }

    @Override
    public CamelCxfRsBindingModel setBindingStyle(String style) {
        setConfig(BINDINGSTYLE, style);
        return this;
    }

    @Override
    public String getProviders() {
        return getConfig(PROVIDERS);
    }

    @Override
    public CamelCxfRsBindingModel setProviders(String providers) {
        setConfig(PROVIDERS, providers);
        return this;
    }

    @Override
    public String getSchemaLocations() {
        return getConfig(SCHEMALOCATIONS);
    }

    @Override
    public CamelCxfRsBindingModel setSchemaLocations(String locations) {
        setConfig(SCHEMALOCATIONS, locations);
        return this;
    }

    @Override
    public String getFeatures() {
        return getConfig(FEATURES);
    }

    @Override
    public CamelCxfRsBindingModel setFeatures(String features) {
        setConfig(FEATURES, features);
        return this;
    }

    @Override
    public String getProperties() {
        return getConfig(PROPERTIES);
    }

    @Override
    public CamelCxfRsBindingModel setProperties(String properties) {
        setConfig(PROPERTIES, properties);
        return this;
    }

    @Override
    public String getInInterceptors() {
        return getConfig(ININTERCEPTORS);
    }

    @Override
    public CamelCxfRsBindingModel setInInterceptors(String inInterceptors) {
        setConfig(ININTERCEPTORS, inInterceptors);
        return this;
    }

    @Override
    public String getOutInterceptors() {
        return getConfig(OUTINTERCEPTORS);
    }

    @Override
    public CamelCxfRsBindingModel setOutInterceptors(String outInterceptors) {
        setConfig(OUTINTERCEPTORS, outInterceptors);
        return this;
    }

    @Override
    public String getInFaultInterceptors() {
        return getConfig(INFAULTINTERCEPTORS);
    }

    @Override
    public CamelCxfRsBindingModel setInFaultInterceptors(String inFaultInterceptors) {
        setConfig(INFAULTINTERCEPTORS, inFaultInterceptors);
        return this;
    }

    @Override
    public String getOutFaultInterceptors() {
        return getConfig(OUTFAULTINTERCEPTORS);
    }

    @Override
    public CamelCxfRsBindingModel setOutFaultInterceptors(String outFaultInterceptors) {
        setConfig(OUTFAULTINTERCEPTORS, outFaultInterceptors);
        return this;
    }

    @Override
    public URI getComponentURI() {
        Configuration modelConfiguration = getModelConfiguration();
        List<Configuration> children = modelConfiguration.getChildren();

        String baseUri = CXFRS + "://" + getCxfRsURI();

        QueryString queryStr = new QueryString();
        traverseConfiguration(children, queryStr, CXFRSURI);

        return URI.create(baseUri + queryStr.toString());
    }
}
