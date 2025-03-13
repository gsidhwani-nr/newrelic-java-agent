/*
 *
 *  * Copyright 2025 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package io.micronaut.http.filter;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import org.reactivestreams.Publisher;

@Weave(originalName = "io.micronaut.http.filter.ClientFilterChain", type = MatchType.Interface)
public abstract class ClientFilterChain_Instrumentation {

    @Trace
    public Publisher<? extends HttpResponse<?>> proceed(MutableHttpRequest<?> request) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Micronaut", "ClientFilterChain", getClass().getSimpleName(), "proceed");

        return Weaver.callOriginal();
    }
}
