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

import javax.servlet.http.HttpServlet;

import org.killbill.billing.osgi.libs.killbill.KillbillActivatorBase;
import org.killbill.billing.osgi.libs.killbill.OSGIConfigPropertiesService;
import org.killbill.billing.plugin.simpletax.config.http.CustomFieldService;
import org.killbill.billing.plugin.simpletax.config.http.InvoiceService;
import org.killbill.billing.plugin.simpletax.config.http.SimpleTaxServlet;
import org.killbill.billing.plugin.simpletax.config.http.TaxCodeController;
import org.killbill.billing.plugin.simpletax.config.http.TaxCountryController;
import org.killbill.billing.plugin.simpletax.config.http.VatinController;
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

    private SimpleTaxConfigurationHandler configHandler;

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

    private HttpServlet createServlet(CustomFieldService customFieldService, InvoiceService invoiceService) {
        TaxCountryController taxCountryController = new TaxCountryController(customFieldService);
        VatinController vatinController = new VatinController(customFieldService);
        TaxCodeController taxCodeController = new TaxCodeController(customFieldService, invoiceService);
        return new SimpleTaxServlet(vatinController, taxCountryController, taxCodeController);
    }

    /**
     * Convenience method used in order to improve the code readability.
     *
     * @return the configuration service
     */
    private OSGIConfigPropertiesService getConfigService() {
        return configProperties;
    }
}
