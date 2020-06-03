/*
 * Project Workday Connector
 * (c) 2019-2020 VMware, Inc. All rights reserved.
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.vmware.ws1connectors.workday.web;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static com.vmware.ws1connectors.workday.exceptions.ExceptionHandlers.INVALID_CONNECTOR_TOKEN;
import static com.vmware.ws1connectors.workday.utils.ApiUrlConstants.USER_INFO;
import static com.vmware.ws1connectors.workday.utils.ApiUrlConstants.WORKDAY_CONNECTOR_CONTEXT_PATH;
import static com.vmware.ws1connectors.workday.utils.CardConstants.DAY0_CARDS_URI;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static org.hamcrest.Matchers.any;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withUnauthorizedRequest;

public class Day0CardsControllerTest extends ControllerTestUtils {

    private static final String UNAUTHORIZED_WORKDAY_AUTH_TOKEN = BEARER + "unauthorized-auth-token";
    private static final String NO_WORKDAY_AUTH_TOKEN = null;
    private static final String ERROR_JSON_PATH = "/error";
    private static final String USER_NOT_FOUND_ERROR_MSG = "User can not be found";
    private static final String NO_INBOX_TASKS_JSON = "no_results.json";
    private static final String USER_INFO_JSON = "fred_user_info.json";
    private static final String NO_CARDS_JSON = "cards/no_cards.json";
    private static final String INBOX_TASKS_JSON = "no_time_off_inbox_tasks.json";
    private static final String MOCK_WORKDAY_URL = "http://workday.com";
    private static final String EXPECTED_DAY0_CARDS_JSON = "cards/day0_cards.json";

    @Test public void testCardRequestsApiIsProtected() throws Exception {
        testProtectedResource(POST, WORKDAY_CONNECTOR_CONTEXT_PATH + DAY0_CARDS_URI);
    }

    @Test public void whenWorkdayAuthTokenIsUnauthorizedThenCardRequestFails() {
        mockBackend.expect(requestTo(any(String.class)))
                .andRespond(withUnauthorizedRequest());

        requestCards(UNAUTHORIZED_WORKDAY_AUTH_TOKEN, DAY0_CARDS_URI)
                .expectStatus().isBadRequest()
                .expectBody().jsonPath(ERROR_JSON_PATH, INVALID_CONNECTOR_TOKEN);
    }

    @Test public void whenWorkdayAuthTokenIsMissingThenCardRequestFails() {
        requestCards(NO_WORKDAY_AUTH_TOKEN, DAY0_CARDS_URI)
                .expectStatus().isBadRequest();
    }

    @Test public void whenUserNotFoundThenCardRequestFails() throws Exception {
        mockWorkdayApiResponse(USER_INFO, NO_INBOX_TASKS_JSON);
        requestCards(WORKDAY_AUTH_TOKEN, DAY0_CARDS_URI)
                .expectStatus().isBadRequest()
                .expectHeader().contentTypeCompatibleWith(APPLICATION_JSON)
                .expectBody().jsonPath(ERROR_JSON_PATH, USER_NOT_FOUND_ERROR_MSG);
    }

    @Test public void whenNoTimeOffTasksFoundThenReturnsEmptyCards() throws Exception {
        mockWorkdayApiResponse(USER_INFO, USER_INFO_JSON);
        mockWorkdayApiResponse(getInboxTasksUri(), NO_INBOX_TASKS_JSON);
        requestCards(WORKDAY_AUTH_TOKEN, DAY0_CARDS_URI)
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(APPLICATION_JSON)
                .expectBody().json(fromFile(NO_CARDS_JSON));
    }

    @Test public void createDay0CardsReturnsExpectedCards() throws Exception {
        mockWorkdayApiResponse(USER_INFO, USER_INFO_JSON);
        mockWorkdayApiResponse(getInboxTasksUri(), INBOX_TASKS_JSON);
        final String actualResponseBody = requestCards(WORKDAY_AUTH_TOKEN, DAY0_CARDS_URI)
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(APPLICATION_JSON)
                .returnResult(String.class)
                .getResponseBody()
                .collect(Collectors.joining())
                .map(json -> json.replaceAll(mockBackend.url("/"), MOCK_WORKDAY_URL))
                .block();
        assertThatJson(actualResponseBody).when(IGNORING_EXTRA_FIELDS, IGNORING_ARRAY_ORDER)
                .isEqualTo(fromFile(EXPECTED_DAY0_CARDS_JSON));
    }
}
