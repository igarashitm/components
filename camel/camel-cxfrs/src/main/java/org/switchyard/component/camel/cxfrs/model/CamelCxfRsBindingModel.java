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
package org.switchyard.component.camel.cxfrs.model;

import java.net.URI;

import org.switchyard.component.camel.common.model.CamelBindingModel;

/**
 * Camel CXFRS binding model.
 */
public interface CamelCxfRsBindingModel extends CamelBindingModel {
    /**
     * Gets cxfRsURI.
     * @return cxfRsURI
     */
    URI getCxfRsURI();

    /**
     * Sets cxfRsURI.
     * @param cxfRsURI cxfRsURI
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setCxfRsURI(URI cxfRsURI);

    /**
     * Gets resource classes.
     * @return resource classes
     */
    String getResourceClasses();

    /**
     * Sets resource classes.
     * @param classes resource classes
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setResourceClasses(String classes);

    /**
     * Gets httpClientAPI.
     * @return httpClientAPI
     */
    Boolean isHttpClientAPI();

    /**
     * Sets httpClientAPI.
     * @param httpclientapi httpClientAPI
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setHttpClientAPI(Boolean httpclientapi);

    /**
     * Gets synchronous.
     * @return sunchronous
     */
    Boolean isSynchronous();

    /**
     * Sets synchronous.
     * @param synchronous synchronous
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setSynchronous(Boolean synchronous);

    /**
     * Gets throwExceptionOnFailure.
     * @return throwExceptionOnFailure
     */
    Boolean isThrowExceptionOnFailure();

    /**
     * Sets throw ExceptionOnFailure
     * @param exceptiononfailure throwExceptionOnFailure
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setThrowExceptionOnFailure(Boolean exceptiononfailure);

    /**
     * Gets maxClientCacheSize.
     * @return maxClientCacheSize
     */
    Integer getMaxClientCacheSize();

    /**
     * Sets maxClientCacheSize.
     * @param size maxClientCacheSize
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setMaxClientCacheSize(Integer size);

    /**
     * Gets setDefaultBus.
     * @return setDefaultBus
     */
    Boolean isSetDefaultBus();

    /**
     * Sets setDefaultBus.
     * @param set setDefaultBus
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setSetDefaultBus(Boolean set);

    /**
     * Gets bus.
     * @return bus
     */
    String getBus();

    /**
     * Sets bus.
     * @param bus bus
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setBus(String bus);

    /**
     * Gets bindingStyle.
     * @return bindingStyle
     */
    String getBindingStyle();

    /**
     * Sets bindingStyle.
     * @param style bindingStyle
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setBindingStyle(String style);

    /**
     * Gets providers.
     * @return providers
     */
    String getProviders();

    /**
     * Sets providers.
     * @param providers providers
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setProviders(String providers);

    /**
     * Gets schemaLocations.
     * @return schemaLocations
     */
    String getSchemaLocations();

    /**
     * Sets schemaLocations.
     * @param locations schemaLocations
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setSchemaLocations(String locations);

    /**
     * Gets features.
     * @return features
     */
    String getFeatures();

    /**
     * Sets features.
     * @param features features
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setFeatures(String features);

    /**
     * Gets properties.
     * @return properties
     */
    String getProperties();

    /**
     * Sets properties.
     * @param properties properties
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setProperties(String properties);

    /**
     * Gets inInterceptors.
     * @return inInterceptors
     */
    String getInInterceptors();

    /**
     * Sets inInterceptors.
     * @param inInterceptors inInterceptors
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setInInterceptors(String inInterceptors);

    /**
     * Gets outInterceptors.
     * @return outInterceptors
     */
    String getOutInterceptors();

    /**
     * Sets outInterceptors.
     * @param outInterceptors outInterceptors
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setOutInterceptors(String outInterceptors);

    /**
     * Gets inFaultInterceptors.
     * @return inFaultInterceptors
     */
    String getInFaultInterceptors();

    /**
     * Sets inFaultInterceptors.
     * @param inFaultInterceptors inFaultInterceptors
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setInFaultInterceptors(String inFaultInterceptors);

    /**
     * Gets outFaultInterceptors
     * @return outFaultInterceptors
     */
    String getOutFaultInterceptors();

    /**
     * Sets outFaultInterceptors
     * @param outFaultInterceptors outFaultInterceptors
     * @return this BindingModel (useful for chaining)
     */
    CamelCxfRsBindingModel setOutFaultInterceptors(String outFaultInterceptors);
}
