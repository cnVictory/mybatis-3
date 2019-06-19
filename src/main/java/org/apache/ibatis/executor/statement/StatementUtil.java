/**
 * Copyright 2009-2016 the original author or authors.
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
package org.apache.ibatis.executor.statement;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Utility for {@link java.sql.Statement}.
 *
 * @author Kazuki Shimizu
 * @since 3.4.0
 */
public class StatementUtil {

    private StatementUtil() {
        // NOP
    }

    /**
     * Apply a transaction timeout.
     * <p>
     * Update a query timeout to apply a transaction timeout.
     * </p>
     *
     * @param statement          a target statement
     * @param queryTimeout       a query timeout
     * @param transactionTimeout a transaction timeout
     * @throws SQLException if a database access error occurs, this method is called on a closed
     * <code>Statement</code>
     */
    public static void applyTransactionTimeout(Statement statement, Integer queryTimeout,
                                               Integer transactionTimeout) throws SQLException {
        if (transactionTimeout == null) {
            return;
        }
        Integer timeToLiveOfQuery = null;
        if (queryTimeout == null || queryTimeout == 0) {
            timeToLiveOfQuery = transactionTimeout;
        } else if (transactionTimeout < queryTimeout) {
            timeToLiveOfQuery = transactionTimeout;
        }
        if (timeToLiveOfQuery != null) {
            statement.setQueryTimeout(timeToLiveOfQuery);
        }
    }

}
