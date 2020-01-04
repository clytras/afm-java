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
package LytraxAFM;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Christos Lytras <christos.lytras@gmail.com>
 */
public class Helpers {
    public static int Iterations = 100;
    
    public static String[] StaticValidNumbers = {
        "090000045", // DEI
        "094019245", // OTE
        "094079101", // EYDAP
    };
    
    public static String[] StaticInvalidNumbers = {
        "123456789",
        "097364585",
        "150663780",
    };
    
    public static Map<String, String> InvalidErrors = new HashMap<String, String>() {{
        put("length", "09000004");
        put("nan", "09000004A");
        put("zero", "000000000");
        put("invalid", "123456789");
    }};
}
