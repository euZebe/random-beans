/**
 * The MIT License
 *
 *   Copyright (c) 2017, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package io.github.benas.randombeans.randomizers.time;

import io.github.benas.randombeans.randomizers.AbstractRandomizerTest;
import org.junit.Test;

import java.time.ZonedDateTime;

import static io.github.benas.randombeans.randomizers.time.ZonedDateTimeRandomizer.aNewZonedDateTimeRandomizer;
import static org.assertj.core.api.BDDAssertions.then;

public class ZonedDateTimeRandomizerTest extends AbstractRandomizerTest<ZonedDateTime> {

    @Test
    public void generatedValueShouldNotBeNull() {
        // given
        ZonedDateTimeRandomizer zonedDateTimeRandomizer = aNewZonedDateTimeRandomizer();

        // when
        ZonedDateTime zonedDateTime = zonedDateTimeRandomizer.getRandomValue();

        then(zonedDateTime).isNotNull();
    }

    @Test
    public void shouldGenerateTheSameValueForTheSameSeed() {
        // given
        ZonedDateTimeRandomizer firstSeededZonedDateTimeRandomizer = aNewZonedDateTimeRandomizer(SEED);
        ZonedDateTimeRandomizer secondSeededZonedDateTimeRandomizer = aNewZonedDateTimeRandomizer(SEED);

        // when
        // we can not use a canned value, because the available TimeZones differ between locales/jdks
        ZonedDateTime firstZonedTimeDate = firstSeededZonedDateTimeRandomizer.getRandomValue();
        ZonedDateTime secondZonedTimeDate = secondSeededZonedDateTimeRandomizer.getRandomValue();

        then(firstZonedTimeDate).isNotNull();
        then(secondZonedTimeDate).isNotNull();
        then(firstZonedTimeDate).isEqualTo(secondZonedTimeDate);
    }
}
