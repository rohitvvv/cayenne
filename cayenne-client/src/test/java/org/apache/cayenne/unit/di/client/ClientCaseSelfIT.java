/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.unit.di.client;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.di.Inject;
import org.apache.cayenne.di.Provider;
import org.apache.cayenne.unit.di.server.UseServerRuntime;
import org.junit.Test;

@UseServerRuntime(ClientCase.MULTI_TIER_PROJECT)
public class ClientCaseSelfIT extends ClientCase {

    @Inject
    protected ServerRuntime runtime;

    @Inject
    protected Provider<ServerRuntime> runtimeProvider;

    @Test
    public void testServerSetup_TearDown_Runtime() throws Exception {

        ServerRuntime local = this.runtime;
        assertNotNull(local);
        assertSame(local, runtimeProvider.get());

        tearDown();

        setUp();
        assertNotSame(local, this.runtime);
    }
}
