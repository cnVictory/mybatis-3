/**
 * Copyright 2009-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.binding;

import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WrongNamespacesTest {

    @Test
    void shouldFailForWrongNamespace() {
        Configuration configuration = new Configuration();
        Assertions.assertThrows(RuntimeException.class,
                () -> configuration.addMapper(WrongNamespaceMapper.class));
    }

    @Test
    void shouldFailForMissingNamespace() {
        Configuration configuration = new Configuration();
        Assertions.assertThrows(RuntimeException.class,
                () -> configuration.addMapper(MissingNamespaceMapper.class));
    }

}
