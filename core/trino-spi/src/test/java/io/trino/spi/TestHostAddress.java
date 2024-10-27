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
package io.trino.spi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHostAddress
{
    @Test
    public void testEquality()
    {
        HostAddress address1 = HostAddress.fromParts("[1111:2222:3333:4444:5555:6666:7777:8888]", 1234);
        HostAddress address1NoBrackets = HostAddress.fromParts("1111:2222:3333:4444:5555:6666:7777:8888", 1234);
        assertThat(address1).isEqualTo(address1NoBrackets);

        HostAddress address1FromString = HostAddress.fromString("[1111:2222:3333:4444:5555:6666:7777:8888]:1234");
        assertThat(address1).isEqualTo(address1FromString);

        HostAddress address2 = HostAddress.fromParts("[1111:2222:3333:4444:5555:6666:7777:9999]", 1234);
        assertThat(address1).isNotEqualTo(address2);

        HostAddress address3 = HostAddress.fromParts("[1111:2222:3333:4444:5555:6666:7777:8888]", 1235);
        assertThat(address1).isNotEqualTo(address3);
    }

    @Test
    public void testRoundTrip()
    {
        HostAddress address = HostAddress.fromParts("[1111:2222:3333:4444:5555:6666:7777:8888]", 1234);
        HostAddress fromParts = HostAddress.fromParts(address.getHostText(), address.getPort());
        assertThat(address).isEqualTo(fromParts);

        HostAddress fromString = HostAddress.fromString(address.toString());
        assertThat(address).isEqualTo(fromString);

        assertThat(fromParts).isEqualTo(fromString);
    }
}
