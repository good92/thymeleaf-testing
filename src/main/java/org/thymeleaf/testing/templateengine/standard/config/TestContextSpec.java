/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2012, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.testing.templateengine.standard.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;



public class TestContextSpec implements ITestContextSpec {

    private final IContext context;

    
    public TestContextSpec(final IContext context) {
        super();
        this.context = context;
    }
    
    public TestContextSpec(final Locale locale, final Map<String,Object> variables) {
        super();
        this.context = new Context(locale, variables);
    }

    
    public TestContextSpec(final Locale locale, 
            final String variable1Name, final Object variable1Value) {
        super();
        final Map<String,Object> variables = new HashMap<String,Object>();
        variables.put(variable1Name, variable1Value);
        this.context = new Context(locale, variables);
    }

    public TestContextSpec(final Locale locale, 
            final String variable1Name, final Object variable1Value,
            final String variable2Name, final Object variable2Value,
            final String variable3Name, final Object variable3Value,
            final String variable4Name, final Object variable4Value,
            final String variable5Name, final Object variable5Value) {
        super();
        final Map<String,Object> variables = new HashMap<String,Object>();
        variables.put(variable1Name, variable1Value);
        this.context = new Context(locale, variables);
    }
    

    
    public TestContextSpec( 
            final HttpServletRequest request, final HttpServletResponse response, final ServletContext servletContext,
            final Locale locale, final Map<String,Object> variables) {
        super();
        this.context = new WebContext(request, response, servletContext, locale, variables);
    }
    
    

    public IContext getContext(final String testSetName, final String testName, final int iteration) {
        return this.context;
    }
   
    
}