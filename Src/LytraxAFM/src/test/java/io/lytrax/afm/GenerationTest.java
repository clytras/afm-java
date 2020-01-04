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

import io.lytrax.afm.ValidateAFM;
import io.lytrax.afm.GenerateAFM;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christos Lytras <christos.lytras@gmail.com>
 */
public class GenerationTest {
    
    public GenerationTest() {
    }

    @Test
    public void Default() {
        for (int i = 0; i < Helpers.Iterations; i++)
        {
            GenerateAFM generator = new GenerateAFM();
            String value = generator.generate();

            boolean valid = ValidateAFM.Validate(value);
            assertTrue(String.format(Messages.MessageNotValidated, value), valid);

            String valueValid = generator.generateValid();
            boolean validValid = ValidateAFM.Validate(valueValid);
            assertTrue(String.format(Messages.MessageNotValidated, valueValid), validValid);

            String valueInvalid = generator.generateInvalid();
            boolean invalidInvalid = ValidateAFM.Validate(valueInvalid);
            assertFalse(String.format(Messages.MessageNotInvalidated, valueInvalid), invalidInvalid);
        }
    }
    
    @Test
    public void ForceFirstDigit() {
        for (int i = 0; i < Helpers.Iterations; i++)
        {
            for(int forceFirstDigit = 0; forceFirstDigit <= 9; forceFirstDigit++)
            {
                GenerateAFM generator = new GenerateAFM();

                String value = generator
                    .forceFirstDigit(forceFirstDigit)
                    .generate();
                boolean valid = ValidateAFM.Validate(value);
                int firstDigit = Integer.parseInt(String.valueOf(value.charAt(0)));
                assertTrue(String.format(Messages.MessageNotValidated, value), valid);
                assertEquals(String.format(Messages.MessageFirstDigitNotMatch, forceFirstDigit, firstDigit, value),
                    forceFirstDigit, firstDigit);

                String valueValid = generator
                    .forceFirstDigit(forceFirstDigit)
                    .generateValid();
                boolean validValid = ValidateAFM.Validate(value);
                int firstDigitValid = Integer.parseInt(String.valueOf(valueValid.charAt(0)));
                assertTrue(String.format(Messages.MessageNotValidated, valueValid), validValid);
                assertEquals(String.format(Messages.MessageFirstDigitNotMatch, forceFirstDigit, firstDigitValid, valueValid),
                    forceFirstDigit, firstDigitValid);

                String valueInvalid = generator
                    .forceFirstDigit(forceFirstDigit)
                    .generateInvalid();
                boolean invalidInvalid = ValidateAFM.Validate(valueInvalid);
                int firstDigitInvalid = Integer.parseInt(String.valueOf(valueInvalid.charAt(0)));
                assertFalse(String.format(Messages.MessageNotInvalidated, valueInvalid), invalidInvalid);
                assertEquals(String.format(Messages.MessageFirstDigitNotMatch, forceFirstDigit, firstDigitInvalid, valueInvalid),
                    forceFirstDigit, firstDigitInvalid);
            }
        }
    }
    
    @Test
    public void Pre99() {
        int expectedFirstDigit = 0;
        
        for (int i = 0; i < Helpers.Iterations; i++)
        {
            GenerateAFM generator = new GenerateAFM();

            String value = generator
                .pre99(true)
                .generate();
            boolean valid = ValidateAFM.Validate(value);
            int firstDigit = Integer.parseInt(String.valueOf(value.charAt(0)));
            assertTrue(String.format(Messages.MessageNotValidated, value), valid);
            assertEquals(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigit, value),
                expectedFirstDigit, firstDigit);

            String valueValid = generator
                .pre99(true)
                .generateValid();
            boolean validValid = ValidateAFM.Validate(value);
            int firstDigitValid = Integer.parseInt(String.valueOf(valueValid.charAt(0)));
            assertTrue(String.format(Messages.MessageNotValidated, valueValid), validValid);
            assertEquals(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigitValid, valueValid),
                expectedFirstDigit, firstDigitValid);

            String valueInvalid = generator
                .pre99(true)
                .generateInvalid();
            boolean invalidInvalid = ValidateAFM.Validate(valueInvalid);
            int firstDigitInvalid = Integer.parseInt(String.valueOf(valueInvalid.charAt(0)));
            assertFalse(String.format(Messages.MessageNotInvalidated, valueInvalid), invalidInvalid);
            assertEquals(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigitInvalid, valueInvalid),
                expectedFirstDigit, firstDigitInvalid);
        }
    }
    
    @Test
    public void Individual() {
        String expectedFirstDigit = "1-4";
        Pattern re = Pattern.compile("^[1-4]{1}$");
        
        for (int i = 0; i < Helpers.Iterations; i++)
        {
            GenerateAFM generator = new GenerateAFM();

            String value = generator
                .individual(true)
                .generate();
            boolean valid = ValidateAFM.Validate(value);
            String firstDigit = String.valueOf(value.charAt(0));
            assertTrue(String.format(Messages.MessageNotValidated, value), valid);
            assertTrue(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigit, value),
                re.matcher(firstDigit).matches());

            String valueValid = generator
                .individual(true)
                .generateValid();
            boolean validValid = ValidateAFM.Validate(valueValid);
            String firstDigitValid = String.valueOf(valueValid.charAt(0));
            assertTrue(String.format(Messages.MessageNotValidated, valueValid), validValid);
            assertTrue(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigitValid, valueValid),
                re.matcher(firstDigitValid).matches());

            String valueInvalid = generator
                .individual(true)
                .generateInvalid();
            boolean invalidInvalid = ValidateAFM.Validate(valueInvalid);
            String firstDigitInvalid = String.valueOf(valueInvalid.charAt(0));
            assertFalse(String.format(Messages.MessageNotInvalidated, valueInvalid), invalidInvalid);
            assertTrue(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigitInvalid, valueInvalid),
                re.matcher(firstDigitInvalid).matches());
        }
    }
    
    @Test
    public void LegalEntity() {
        String expectedFirstDigit = "7-9";
        Pattern re = Pattern.compile("^[7-9]{1}$");
        
        for (int i = 0; i < Helpers.Iterations; i++)
        {
            GenerateAFM generator = new GenerateAFM();

            String value = generator
                .legalEntity(true)
                .generate();
            boolean valid = ValidateAFM.Validate(value);
            String firstDigit = String.valueOf(value.charAt(0));
            assertTrue(String.format(Messages.MessageNotValidated, value), valid);
            assertTrue(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigit, value),
                re.matcher(firstDigit).matches());

            String valueValid = generator
                .legalEntity(true)
                .generateValid();
            boolean validValid = ValidateAFM.Validate(valueValid);
            String firstDigitValid = String.valueOf(valueValid.charAt(0));
            assertTrue(String.format(Messages.MessageNotValidated, valueValid), validValid);
            assertTrue(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigitValid, valueValid),
                re.matcher(firstDigitValid).matches());

            String valueInvalid = generator
                .legalEntity(true)
                .generateInvalid();
            boolean invalidInvalid = ValidateAFM.Validate(valueInvalid);
            String firstDigitInvalid = String.valueOf(valueInvalid.charAt(0));
            assertFalse(String.format(Messages.MessageNotInvalidated, valueInvalid), invalidInvalid);
            assertTrue(String.format(Messages.MessageFirstDigitNotMatch, expectedFirstDigit, firstDigitInvalid, valueInvalid),
                re.matcher(firstDigitInvalid).matches());
        }
    }
    
    @Test
    public void RepeatTolerance()
    {
        Pattern re = Pattern.compile("(.)\\1+");

        for (int i = 0; i < Helpers.Iterations; i++)
        {
            for (int repeatTolerance = 0; repeatTolerance <= 3; repeatTolerance++) {
                GenerateAFM generator = new GenerateAFM();
                
                String value = generator
                    .repeatTolerance(repeatTolerance)
                    .generate();
                boolean valid = ValidateAFM.Validate(value);
                String body = value.substring(0, 8);
                assertTrue(String.format(Messages.MessageNotValidated, value), valid);

                List<String> reMatches = new ArrayList<>();
                Matcher result = re.matcher(body);
                while(result.find())
                    reMatches.add(result.group());

                if(repeatTolerance == 0) {
                    assertEquals(String.format(Messages.MessageRepeatToleranceNotExpected, repeatTolerance, reMatches.size(), body),
                        0, reMatches.size());
                } else {
                    for(String repeat: reMatches) {
                        assertTrue(String.format(Messages.MessageRepeatToleranceRepeatExceeded, repeatTolerance, repeat.length(), repeat, body),
                            repeat.length() <= (repeatTolerance + 1));
                    }
                }

                String valueValid = generator
                    .repeatTolerance(repeatTolerance)
                    .generateValid();
                boolean validValid = ValidateAFM.Validate(valueValid);
                String bodyValid = valueValid.substring(0, 8);
                assertTrue(String.format(Messages.MessageNotValidated, valueValid), validValid);

                List<String> reMatchesValid = new ArrayList<>();
                Matcher resultValid = re.matcher(bodyValid);
                while(resultValid.find())
                    reMatchesValid.add(resultValid.group());

                if(repeatTolerance == 0) {
                    assertEquals(String.format(Messages.MessageRepeatToleranceNotExpected, repeatTolerance, reMatchesValid.size(), bodyValid),
                        0, reMatchesValid.size());
                } else {
                    for(String repeat: reMatchesValid) {
                        assertTrue(String.format(Messages.MessageRepeatToleranceRepeatExceeded, repeatTolerance, repeat.length(), repeat, bodyValid),
                            repeat.length() <= (repeatTolerance + 1));
                    }
                }
                

                String valueInvalid = generator
                    .repeatTolerance(repeatTolerance)
                    .generateInvalid();
                boolean invalidInvalid = ValidateAFM.Validate(valueInvalid);
                String bodyInvalid = valueInvalid.substring(0, 8);
                assertFalse(String.format(Messages.MessageNotInvalidated, valueInvalid), invalidInvalid);

                List<String> reMatchesInvalid = new ArrayList<>();
                Matcher resultInvalid = re.matcher(bodyInvalid);
                while(resultInvalid.find())
                    reMatchesInvalid.add(resultInvalid.group());

                if(repeatTolerance == 0) {
                    assertEquals(String.format(Messages.MessageRepeatToleranceNotExpected, repeatTolerance, reMatchesInvalid.size(), bodyInvalid),
                        0, reMatchesInvalid.size());
                } else {
                    for(String repeat: reMatchesInvalid) {
                        assertTrue(String.format(Messages.MessageRepeatToleranceRepeatExceeded, repeatTolerance, repeat.length(), repeat, bodyInvalid),
                            repeat.length() <= (repeatTolerance + 1));
                    }
                }
            }
        }
    }
}
