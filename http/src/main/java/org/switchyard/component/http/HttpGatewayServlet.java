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
 
package org.switchyard.component.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.switchyard.component.http.composer.HttpRequestBindingData;
import org.switchyard.component.http.composer.HttpRequestInfo;
import org.switchyard.component.http.composer.HttpResponseBindingData;
import org.switchyard.security.credential.extractor.ServletRequestCredentialExtractor;

/**
 * Hanldes HTTP requests to invoke a SwitchYard service.
 *
 * @author Magesh Kumar B <mageshbk@jboss.com> (C) 2012 Red Hat Inc.
 */
public class HttpGatewayServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(HttpGatewayServlet.class);
    private static final Map<String,String> LOCALNAMEMAP = new ConcurrentHashMap<String,String>();

    private transient InboundHandler _handler;

    // request.getLocalName() has proven expensive, so cache it
    private static final String getLocalName(HttpServletRequest request) {
        String localAddr = request.getLocalAddr();
        String localName = LOCALNAMEMAP.get(localAddr);
        if (localName == null) {
            localName = request.getLocalName();
            LOCALNAMEMAP.put(localAddr, localName);
        }
        return localName;
    }

    /**
     * Set the SwitchYard component handler for this instance.
     * @param handler the SwicthYard component handler
     */
    public void setHandler(InboundHandler handler) {
        _handler = handler;
    }

    /**
     * {@inheritDoc}
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handle(request, response);
    }

    /**
     * Handles a HTTP Servlet request and responds.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if any Servlet exception
     * @throws IOException if the streams could not be written or read
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            HttpRequestBindingData httpRequest = new HttpRequestBindingData();
            try {
                httpRequest.setContentType(new ContentType(request.getContentType()));
                httpRequest.setBodyFromStream(request.getInputStream());
                for (Enumeration<String> headerNames = request.getHeaderNames(); headerNames.hasMoreElements();) {
                    String name = headerNames.nextElement();
                    for (Enumeration<String> values = request.getHeaders(name); values.hasMoreElements();) {
                        String value = values.nextElement();
                        httpRequest.addHeader(name, value);
                    }
                }
                httpRequest.setRequestInfo(getRequestInfo(request));
            } catch (IOException e) {
                LOGGER.error("Unexpected Exception while reading request", e);
            }
            HttpResponseBindingData httpResponse = _handler.invoke(httpRequest);
            try {
                if (httpResponse != null) {
                    Iterator<Map.Entry<String, List<String>>> entries = httpResponse.getHeaders().entrySet().iterator();
                    while (entries.hasNext()) {
                        Map.Entry<String, List<String>> entry = entries.next();
                        String name = entry.getKey();
                        List<String> values = entry.getValue();
                        for (String value : values) {
                            response.setHeader(name, value);
                        }
                    }
                    if (httpResponse.getBodyBytes() != null) {
                        response.setStatus(httpResponse.getStatus());
                        httpResponse.writeBodyToStream(response.getOutputStream());
                    } else {
                        response.setStatus(httpResponse.getStatus());
                    }
                } else {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (IOException e) {
                LOGGER.error("Unexpected Exception while writing response", e);
            }
    }

   /**
     * Method for get request information from a servlet request.
     *
     * @param request ServletRequest
     * @return Request information parsed by servlet container from a servlet request
     */
    @SuppressWarnings("unchecked")
    public HttpRequestInfo getRequestInfo(HttpServletRequest request) {
        HttpRequestInfo requestInfo = new HttpRequestInfo();

        requestInfo.setAuthType(request.getAuthType());
        requestInfo.setCharacterEncoding(request.getCharacterEncoding());
        requestInfo.setContentType(request.getContentType());
        requestInfo.setContextPath(request.getContextPath());
        requestInfo.setLocalAddr(request.getLocalAddr());
        requestInfo.setLocalName(getLocalName(request));
        requestInfo.setMethod(request.getMethod());
        requestInfo.setProtocol(request.getProtocol());
        requestInfo.setQueryString(request.getQueryString());
        requestInfo.setRemoteAddr(request.getRemoteAddr());
        requestInfo.setRemoteHost(request.getRemoteHost());
        requestInfo.setRemoteUser(request.getRemoteUser());
        requestInfo.setContentLength(request.getContentLength());
        requestInfo.setRequestSessionId(request.getRequestedSessionId());
        requestInfo.setRequestURI(request.getRequestURI());
        requestInfo.setScheme(request.getScheme());
        requestInfo.setServerName(request.getServerName());
        requestInfo.setRequestPath(request.getServletPath());

        String pathInfo = request.getPathInfo();
        requestInfo.setPathInfo(pathInfo);

        if (pathInfo != null) {
            List<String> pathInfoTokens = requestInfo.getPathInfoTokens();

            pathInfoTokens.addAll(Arrays.asList(request.getPathInfo().split("/")));

            // remove empty tokens...
            Iterator<String> tokensIterator = pathInfoTokens.iterator();
            while (tokensIterator.hasNext()) {
                if (tokensIterator.next().trim().length() == 0) {
                    tokensIterator.remove();
                }
            }
        }

        // Http Query params...
        Map paramMap = request.getParameterMap();
        if (paramMap != null) {
            requestInfo.getQueryParams().putAll(paramMap);
        }

        // Credentials...
        requestInfo.getCredentials().addAll(new ServletRequestCredentialExtractor().extract(request));

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(requestInfo);
        }
        return requestInfo;
    }
}
