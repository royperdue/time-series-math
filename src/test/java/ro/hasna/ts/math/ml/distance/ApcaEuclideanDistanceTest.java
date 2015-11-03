/**
 * Copyright (C) 2015 Octavian Hasna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.hasna.ts.math.ml.distance;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.hasna.ts.math.ml.distance.util.DistanceTester;
import ro.hasna.ts.math.representation.AdaptivePiecewiseConstantApproximation;
import ro.hasna.ts.math.type.MeanLastPair;
import ro.hasna.ts.math.util.TimeSeriesPrecision;

/**
 * @since 1.0
 */
public class ApcaEuclideanDistanceTest {
    private ApcaEuclideanDistance distance;

    @Before
    public void setUp() throws Exception {
        distance = new ApcaEuclideanDistance(new AdaptivePiecewiseConstantApproximation(8));
    }

    @After
    public void tearDown() throws Exception {
        distance = null;
    }

    @Test
    public void testTriangleInequality() throws Exception {
        new DistanceTester().withDistanceMeasure(distance).testTriangleInequality();
    }

    @Test
    public void testEquality() throws Exception {
        new DistanceTester().withDistanceMeasure(distance).testEquality();
    }

    @Test
    public void testOverflow() throws Exception {
        MeanLastPair[] a = new MeanLastPair[4];
        a[0] = new MeanLastPair(0, 16);
        a[1] = new MeanLastPair(4, 32);
        a[2] = new MeanLastPair(5, 64);
        a[3] = new MeanLastPair(6, 128);

        MeanLastPair[] b = new MeanLastPair[4];
        b[0] = new MeanLastPair(7, 8);
        b[1] = new MeanLastPair(2, 34);
        b[2] = new MeanLastPair(5, 60);
        b[3] = new MeanLastPair(1, 128);

        double result = distance.compute(a, b, 128, 10);

        Assert.assertEquals(Double.POSITIVE_INFINITY, result, TimeSeriesPrecision.EPSILON);
    }
}