/*
 * Project Workday Connector
 * (c) 2020-2020 VMware, Inc. All rights reserved.
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.vmware.ws1connectors.workday.exceptions;

import com.vmware.ws1connectors.workday.annotations.MessageKey;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@MessageKey("time.off.action.request.creation.failed")
public class TimeOffTaskActionRequestCreationFailedException extends LocalizedException {

    private static final long serialVersionUID = 6754921937549777739L;

    public TimeOffTaskActionRequestCreationFailedException(Throwable cause) {
        super(cause);
    }
}
