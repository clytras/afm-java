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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christos Lytras <christos.lytras@gmail.com>
 */
public class ValidationTest {
    
    public ValidationTest() {
    }

    @Test
    public void ValidateValidAfmNumbers() {
        for(String afm: Helpers.StaticValidNumbers) {
            boolean result = ValidateAFM.Validate(afm);
            assertTrue(String.format(Messages.MessageNotValidated, afm), result);
            
            ValidateAFM validator = new ValidateAFM(afm);
            assertTrue(String.format(Messages.MessageNotValidated, afm),
                validator.Valid());
            assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, validator.Number(), afm),
                validator.Number(), afm);
            assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, "", validator.Error()),
                validator.Error(), "");
        }
    }
    
    @Test
    public void InvalidateInvalidAfmNumbers() {
        for(String afm: Helpers.StaticInvalidNumbers) {
            boolean result = ValidateAFM.Validate(afm);
            assertFalse(String.format(Messages.MessageNotInvalidated, afm), result);
            
            ValidateAFM validator = new ValidateAFM(afm);
            assertFalse(String.format(Messages.MessageNotInvalidated, afm),
                validator.Valid());
            assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, "invalid", validator.Error()),
                validator.Error(), "invalid");
        }
    }
    
    @Test
    public void InvalidateLengthError() {
        final String testFor = "length";
        String afm = Helpers.InvalidErrors.get(testFor);
        boolean result = ValidateAFM.Validate(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), result);

        ValidateAFM validator = new ValidateAFM(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), validator.Valid());
        assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, testFor, validator.Error()),
            validator.Error(), testFor);
    }
    
    @Test
    public void InvalidateNanError() {
        final String testFor = "nan";
        String afm = Helpers.InvalidErrors.get(testFor);
        boolean result = ValidateAFM.Validate(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), result);

        ValidateAFM validator = new ValidateAFM(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), validator.Valid());
        assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, testFor, validator.Error()),
            validator.Error(), testFor);
    }
    
    @Test
    public void InvalidateZeroError() {
        final String testFor = "zero";
        String afm = Helpers.InvalidErrors.get(testFor);
        boolean result = ValidateAFM.Validate(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), result);

        ValidateAFM validator = new ValidateAFM(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), validator.Valid());
        assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, testFor, validator.Error()),
            validator.Error(), testFor);
    }
    
    @Test
    public void InvalidateInvalidError() {
        final String testFor = "invalid";
        String afm = Helpers.InvalidErrors.get(testFor);
        boolean result = ValidateAFM.Validate(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), result);

        ValidateAFM validator = new ValidateAFM(afm);
        assertFalse(String.format(Messages.MessageNotInvalidated, afm), validator.Valid());
        assertEquals(String.format(Messages.MessageClassInstanceErrorShouldBe, testFor, validator.Error()),
            validator.Error(), testFor);
    }
}
