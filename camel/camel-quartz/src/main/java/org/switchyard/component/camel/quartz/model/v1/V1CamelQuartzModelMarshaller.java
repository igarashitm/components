/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
 * You should have received a copy of the GNU Lesser General Public License, 
 * v.2.1 along with this distribution; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.switchyard.component.camel.quartz.model.v1;

import static org.switchyard.component.camel.quartz.model.CamelQuartzBindingModel.QUARTZ;
import static org.switchyard.component.camel.quartz.Constants.QUARTZ_NAMESPACE_V1;

import org.switchyard.component.camel.common.marshaller.BaseModelMarshaller;
import org.switchyard.component.camel.common.marshaller.ModelCreator;
import org.switchyard.config.Configuration;
import org.switchyard.config.model.Descriptor;

/**
 * Camel quartz v1 model marshaler.
 */
public class V1CamelQuartzModelMarshaller extends BaseModelMarshaller {

    /**
     * Creates new marshaller.
     * 
     * @param desc Descriptor
     */
    public V1CamelQuartzModelMarshaller(Descriptor desc) {
        super(desc, QUARTZ_NAMESPACE_V1);

        registerBinding(QUARTZ, new ModelCreator<V1CamelQuartzBindingModel>() {
            @Override
            public V1CamelQuartzBindingModel create(Configuration config, Descriptor descriptor) {
                return new V1CamelQuartzBindingModel(config, descriptor);
            }
        });
    }

}
