/*
 * The MIT License
 *
 * Copyright 2020 Christos Lytras <christos.lytras@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.lytrax.afm;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Christos Lytras {@literal <christos.lytras@gmail.com>}
 */
final class Utils {
    public static class GetRandomInt {
        private final Random random;
        
        public GetRandomInt() {
            random = new Random(UUID.randomUUID().getMostSignificantBits());
        }
        
        public int next(int min, int max) {
            return next(min, max, null);
        }
        
        public int next(int min, int max, Integer notEqual) {
            random.setSeed(UUID.randomUUID().getMostSignificantBits());
            int result;
            
            do {
                result = random.nextInt((max - min) + 1) + min;
            } while(notEqual != null && result == notEqual);

            return result;
        }
    }
}
