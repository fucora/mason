/*
 * Copyright 2020 anishhirlekar.
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
package com.metamug.mason.entity.response;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.UUID;

/**
 * @author anishhirlekar
 */
public class InternalServerErrorResponse extends ErrorResponse {

    protected String errorId;

    public InternalServerErrorResponse() {
        super(512, "Internal Server Error", "API Error. Please contact your API administrator.");
        String timestamp = String.valueOf(System.currentTimeMillis());
        long hash = UUID.nameUUIDFromBytes(timestamp.getBytes()).getMostSignificantBits();
        errorId = String.valueOf(Math.abs(hash));
    }

    public InternalServerErrorResponse(DbLoggable dbLoggable, DataSource ds, HttpServletRequest request,
                                       String exceptionMessage, StringBuilder errorTraceBuilder) {
        this();
        dbLoggable.log(errorId, request, ds, exceptionMessage, errorTraceBuilder);
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }
}
