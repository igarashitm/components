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
package org.switchyard.component.resteasy.composer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.switchyard.Context;
import org.switchyard.Property;
import org.switchyard.Scope;
import org.switchyard.component.common.composer.BaseRegexContextMapper;
import org.switchyard.component.common.label.ComponentLabel;
import org.switchyard.component.common.label.EndpointLabel;

/**
 * RESTEasyContextMapper.
 *
 * @author Magesh Kumar B <mageshbk@jboss.com> &copy; 2012 Red Hat Inc.
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; &copy; 2012 Red Hat Inc.
 */
public class RESTEasyContextMapper extends BaseRegexContextMapper<RESTEasyBindingData> {

    private static final String[] RESTEASY_LABELS = new String[]{ComponentLabel.RESTEASY.label(), EndpointLabel.REST.label(), EndpointLabel.HTTP.label()};

    /**
     * {@inheritDoc}
     */
    @Override
    public void mapFrom(RESTEasyBindingData source, Context context) throws Exception {
        Iterator<Map.Entry<String, List<String>>> entries = source.getHeaders().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, List<String>> entry = entries.next();
            String name = entry.getKey();
            if (matches(name)) {
                List<String> values = entry.getValue();
                if ((values != null) && (values.size() == 1)) {
                    context.setProperty(name, values.get(0), Scope.IN).addLabels(RESTEASY_LABELS);
                } else if ((values != null) && (values.size() > 1)) {
                    context.setProperty(name, values, Scope.IN).addLabels(RESTEASY_LABELS);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public void mapTo(Context context, RESTEasyBindingData target) throws Exception {
        Map<String, List<String>> httpHeaders = target.getHeaders();
        for (Property property : context.getProperties(Scope.OUT)) {
            if (property.hasLabel(EndpointLabel.HTTP.label())) {
                String name = property.getName();
                if (matches(name)) {
                    Object value = property.getValue();
                    if (value != null) {
                        if (value instanceof List) {
                            httpHeaders.put(name, (List<String>)value);
                        } else if (value instanceof String) {
                            List<String> list = new ArrayList<String>();
                            list.add(String.valueOf(value));
                            httpHeaders.put(name, list);
                        }
                    }
                }
            }
        }
    }

}
