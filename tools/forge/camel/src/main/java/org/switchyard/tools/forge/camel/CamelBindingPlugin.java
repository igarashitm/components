/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
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

package org.switchyard.tools.forge.camel;

import java.net.URI;

import org.jboss.seam.forge.shell.ShellColor;
import org.jboss.seam.forge.shell.plugins.Alias;
import org.jboss.seam.forge.shell.plugins.Command;
import org.jboss.seam.forge.shell.plugins.Help;
import org.jboss.seam.forge.shell.plugins.Option;
import org.jboss.seam.forge.shell.plugins.PipeOut;
import org.jboss.seam.forge.shell.plugins.RequiresFacet;
import org.jboss.seam.forge.shell.plugins.RequiresProject;
import org.jboss.seam.forge.shell.plugins.Topic;
import org.switchyard.component.camel.config.model.v1.V1CamelBindingModel;
import org.switchyard.component.camel.config.model.v1.V1OperationSelector;
import org.switchyard.config.model.composite.CompositeServiceModel;
import org.switchyard.tools.forge.AbstractPlugin;
import org.switchyard.tools.forge.plugin.SwitchYardFacet;

/**
 * Forge plugin for Camel binding commands.
 */
@Alias("camel-binding")
@RequiresProject
@RequiresFacet({SwitchYardFacet.class, CamelFacet.class})
@Topic("SOA")
@Help("Provides commands to manage Camel service bindings in SwitchYard.")
public class CamelBindingPlugin extends AbstractPlugin {
    
    /**
     * Bind a promoted service using the Camel binding.
     * @param serviceName name of the service to bind
     * @param configURI camel endpoint URI
     * @param operationName target operation name for the SwitchYard service
     * @param out shell output
     */
    @Command(value = "bind-service", help = "Add a Camel binding to a service.")
    public void bindService(
            @Option(required = true,
                    name = "serviceName",
                    description = "The service name") 
            final String serviceName,
            @Option(required = true,
                    name = "configURI",
                    description = "The configuration URI") 
            final String configURI,
            @Option(required = true,
                    name = "operationName",
                    description = "The operation name") 
            final String operationName,
            final PipeOut out) {

        SwitchYardFacet switchYard = getProject().getFacet(SwitchYardFacet.class);
        CompositeServiceModel service = switchYard.getCompositeService(serviceName);
        // Check to see if the service is public
        if (service == null) {
            out.println(out.renderColor(ShellColor.RED, "No public service named: " + serviceName));
            return;
        }
        
        V1CamelBindingModel binding = new V1CamelBindingModel();
        binding.setConfigURI(URI.create(configURI));
        V1OperationSelector operation = new V1OperationSelector();
        operation.setOperationName(operationName);
        binding.setOperationSelector(operation);
        service.addBinding(binding);

        switchYard.saveConfig();
        out.println("Added binding.camel to service " + serviceName);
    }
    
}