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

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * HashMap Wrapper to make request parameters accessible with ${mtgReq.params["name"]}
 * @author pc
 */
public class RequestParamMap extends HashMap<String, String> {

    protected final HttpServletRequest request;

    public RequestParamMap(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String get(Object key) {
        return request.getParameter((String) key);
    }

}
