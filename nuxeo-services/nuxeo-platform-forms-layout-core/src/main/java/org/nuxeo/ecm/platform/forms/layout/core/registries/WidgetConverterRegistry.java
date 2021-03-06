/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and others.
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
 * Contributors:
 *     Anahide Tchertchian
 */
package org.nuxeo.ecm.platform.forms.layout.core.registries;

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ecm.platform.forms.layout.descriptors.WidgetConverterDescriptor;
import org.nuxeo.runtime.model.SimpleContributionRegistry;

/**
 * @since 5.5
 */
public class WidgetConverterRegistry extends SimpleContributionRegistry<WidgetConverterDescriptor> {

    protected final String category;

    public WidgetConverterRegistry(String category) {
        super();
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getLayoutNames() {
        List<String> res = new ArrayList<String>();
        res.addAll(currentContribs.keySet());
        return res;
    }

    @Override
    public String getContributionId(WidgetConverterDescriptor contrib) {
        return contrib.getName();
    }

    public List<WidgetConverterDescriptor> getConverters() {
        List<WidgetConverterDescriptor> res = new ArrayList<WidgetConverterDescriptor>();
        for (WidgetConverterDescriptor item : currentContribs.values()) {
            if (item != null) {
                res.add(item);
            }
        }
        return res;
    }

    public WidgetConverterDescriptor getConverter(String id) {
        return getCurrentContribution(id);
    }

}
