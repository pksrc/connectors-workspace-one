/*
* Copyright © 2020 VMware, Inc. All Rights Reserved.
* SPDX-License-Identifier: BSD-2-Clause
*/

package com.vmware.connectors.msTeams.utils

import java.util.*
/**
 * Utility class for Base64 decoding
 */
object Base64Utils {
    private val decoder = Base64.getDecoder()

    /**
     * return the decoded ByteArray
     *
     * @param s is the encoded String
     * @return decode ByteArray
     */
    fun decode(s: String): ByteArray = decoder.decode(s)
}