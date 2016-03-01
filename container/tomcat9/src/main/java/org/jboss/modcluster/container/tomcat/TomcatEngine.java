/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.modcluster.container.tomcat;

import org.apache.catalina.Engine;
import org.apache.catalina.util.SessionConfig;
import org.jboss.modcluster.container.Server;
import org.jboss.modcluster.container.catalina.CatalinaEngine;
import org.jboss.modcluster.container.catalina.CatalinaFactoryRegistry;

/**
 * Custom engine implementation for Tomcat 9.
 *
 * @author Paul Ferraro
 * @author Radoslav Husar
 * @version Mar 2016
 */
public class TomcatEngine extends CatalinaEngine {

    public TomcatEngine(CatalinaFactoryRegistry registry, Engine engine, Server server) {
        super(registry, engine, server);
    }

    // TODO MODCLUSTER-477 Broken design: cookie-name should be specified on the Context level instead of only on the Engine level
    @Override
    public String getSessionCookieName() {
        return SessionConfig.getSessionCookieName(null);
    }

    // TODO MODCLUSTER-477 Broken design: cookie-name should be specified on the Context level instead of only on the Engine level
    @Override
    public String getSessionParameterName() {
        return SessionConfig.getSessionUriParamName(null);
    }
}
