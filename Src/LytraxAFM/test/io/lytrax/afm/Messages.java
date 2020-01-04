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

/**
 *
 * @author Christos Lytras <christos.lytras@gmail.com>
 */
public class Messages {
    public static String MessageNotBetween = "GetRandomInt return an int not between 0 and 9 (returned = %1$s)";
    public static String MessageFailNotEqual = "GetRandomInt return an int equal to notEqual (returned = %1$s, notEqual = %2$s)";
    public static String MessageNotValidated = "Validate does not validate valid number (number = \"%1$s\")";
    public static String MessageNotInvalidated = "Validate does not invalidate invalid number (number = %1$s)";
    public static String MessageClassInstanceNotEqualNumber = "ValidateAFM class instance Number not equal number (.Number = \"%1$s\", number = \"%2$s\")";
    public static String MessageClassInstanceErrorShouldBe = "ValidateAFM class instance Error should be \"%1$s\" (.Error = \"%2$s\")";
    public static String MessageFirstDigitNotMatch = "Generate first digit should be \"%1$s\" (firstDigit = \"%2$s\", number = \"%3$s\")";
    public static String MessageRepeatToleranceNotExpected = "Generate expected repeat tolerance to be %1$s but found %2$s repeat(s) (repeatTolerance = %1$s, repeats = %2$s, body = \"%3$s\")";
    public static String MessageRepeatToleranceRepeatExceeded = "Generate repeat tolerance exceeded maximum %1$s repeats (repeatTolerance = %1$s, repeats = %2$s, subject = \"%3$s\", body = \"%3$s\")";
}
