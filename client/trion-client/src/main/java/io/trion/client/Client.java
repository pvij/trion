/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trion.client;

import io.trino.sql.parser.SqlParser;
import io.trino.sql.tree.Statement;

public class Client
{
    public static void main(String[] args)
    {
        SqlParser sqlParser = new SqlParser();
        // parse the query, predicate analysis <table:some_table, column: uuid, value: 20>
        // Only single value and range value predicates are returned (didn't understand this)
        Statement statement = sqlParser.createStatement("SELECT * FROM abc.def where age < 50 and age >= 23");
        System.out.println("------running------");
        System.out.println(statement);
        // last update
    }
}
