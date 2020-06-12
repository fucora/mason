/*
 * Copyright 2020 pc.
 *
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
package com.metamug.mason.entity.request;

import com.metamug.mason.Router;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

/**
 * Represents the requested jsp file
 *
 * @author pc
 */
public class JspResource {

    private HttpServletRequest request;
    private String jspPath;
    private float version;
    private String resourceUri;
    private static final int VERSION_LENGTH = 3; // 1.3
    private static final String JSP_EXTN = ".jsp";

    public String getResourceUri() {
        return resourceUri;
    }

    public JspResource(HttpServletRequest request) {
        this.request = request;
        String resourcePath = this.request.getServletPath();
        this.version = Float.parseFloat(resourcePath.substring(2, 2 + VERSION_LENGTH));
        // https://stackoverflow.com/questions/12972914/wildcard-path-for-servlet
        resourceUri = resourcePath.substring(5); // after /v1.0
    }

    protected boolean resourceExists(String resourcePath) {
        String jspPath = Router.RESOURCES_FOLDER + "v" + version + resourcePath + JSP_EXTN;
        boolean exists = new File(request.getServletContext().getRealPath(jspPath)).exists();
        if (exists) {
            this.jspPath = jspPath; //set as instance variable
        }
        return exists;
    }

    /**
     * Get JSP Path of a valid resource
     *
     * @return
     */
    public String getJspPath() {
        return jspPath;
    }

    public float getVersion() {
        return this.version;
    }
}
