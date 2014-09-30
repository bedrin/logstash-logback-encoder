/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.logstash.logback.layout;

import java.io.IOException;

import net.logstash.logback.LogstashFormatter;
import net.logstash.logback.fieldnames.LogstashFieldNames;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class LogstashLayout extends LayoutBase<ILoggingEvent> {
    
    private final LogstashFormatter formatter = new LogstashFormatter();
    
    public String doLayout(ILoggingEvent event) {
        try {
            return formatter.writeValueAsString(event, getContext());
        } catch (IOException e) {
            addWarn("Error formatting logging event", e);
            return null;
        }
    }
    
    public void setCustomFields(String customFields) {
        formatter.setCustomFieldsFromString(customFields, this);
    }
    
    public String getCustomFields() {
        return formatter.getCustomFields().toString();
    }
    
    public boolean isIncludeCallerInfo() {
        return formatter.isIncludeCallerInfo();
    }
    
    public void setIncludeCallerInfo(boolean includeCallerInfo) {
        formatter.setIncludeCallerInfo(includeCallerInfo);
    }
    
    public LogstashFieldNames getFieldNames() {
        return formatter.getFieldNames();
    }
    
    public void setFieldNames(LogstashFieldNames fieldNames) {
        formatter.setFieldNames(fieldNames);
    }
    
    public boolean isIncludeMdc() {
        return formatter.isIncludeMdc();
    }
    
    public void setIncludeMdc(boolean includeMdc) {
        formatter.setIncludeMdc(includeMdc);
    }
    
    public boolean isIncludeContext() {
        return formatter.isIncludeContext();
    }
    
    public void setIncludeContext(boolean includeContext) {
        formatter.setIncludeContext(includeContext);
    }

    public void setShortenedLoggerNameLength(int length) { formatter.setShortenedLoggerNameLength(length);}
    
}
