/*
 * Copyright 2015 Benjamin Gandon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.killbill.billing.plugin.simpletax.plumbing;

import org.killbill.billing.osgi.libs.killbill.KillbillActivatorBase;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Activator class for the Simple Tax Plugin.
 *
 * @author Benjamin Gandon
 */
public class SimpleTaxActivator extends KillbillActivatorBase {

    /** The name for this plugin. */
    public static final String PLUGIN_NAME = "killbill-simple-tax";

    private static final Logger logger = LoggerFactory.getLogger(SimpleTaxActivator.class);

    /**
     * This method is the first to be called.
     * <p>
     * It creates a configuration manager, creates the plugin, and then registers it
     * into the system.
     * <p>
     * {@inheritDoc}
     *
     * @see org.killbill.billing.osgi.libs.killbill#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        // Note: super.start() creates the configHandler that we later use in
        // createDefaultConfig() below
        super.start(context);
        logger.info("SimpleTaxActivator starting");
    }
}
