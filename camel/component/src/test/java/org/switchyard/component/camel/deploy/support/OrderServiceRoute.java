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
package org.switchyard.component.camel.deploy.support;

import org.apache.camel.builder.RouteBuilder;
import org.switchyard.component.camel.Route;

/**
 *  Java DSL route equivalent to:
 *  <route xmlns="http://camel.apache.org/schema/spring" id="Camel Test Route">
 *   <log message="ItemId [${body}]"/>
 *  <to uri="switchyard://WarehouseService?operationName=hasItem"/>
 *  <log message="Title Name [${body}]"/>
 *  </route>
 */
@Route(OrderService.class)
public class OrderServiceRoute extends RouteBuilder {

    public void configure() {
        from("switchyard://OrderService")
            .log("ItemId [${body}]")
            .to("switchyard://WarehouseService?operationName=hasItem")
            .log("Title Name [${body}]");
    }

}
