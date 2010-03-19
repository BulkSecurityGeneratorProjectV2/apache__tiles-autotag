/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.tiles.autotag.freemarker.runtime;

import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.DeepUnwrap;

/**
 * Utilities for FreeMarker usage in Tiles.
 *
 * @version $Rev$ $Date$
 * @since 2.2.0
 */
public final class FreeMarkerUtil {

    /**
     * Private constructor to avoid instantiation.
     */
    private FreeMarkerUtil() {
    }

    /**
     * Unwraps a TemplateModel to extract an object.
     *
     * @param model The TemplateModel to unwrap.
     * @return The unwrapped object.
     * @since 3.0.0
     */
    public static Object getAsObject(TemplateModel model, Object defaultValue) {
        try {
            Object retValue = DeepUnwrap.unwrap(model);
            if (retValue == null) {
                retValue = defaultValue;
            }
            return retValue;
        } catch (TemplateModelException e) {
            throw new FreemarkerAutotagException("Cannot unwrap a model", e);
        }
    }
}
