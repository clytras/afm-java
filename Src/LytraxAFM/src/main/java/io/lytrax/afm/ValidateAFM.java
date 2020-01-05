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
 * Class with static and instance methods to validate AFM numbers
 * @author Christos Lytras {@literal <christos.lytras@gmail.com>}
 */
public class ValidateAFM {
    private String number;
    private boolean valid;
    private String error;
    
    /**
     * The object constructor initializes and immediately validates an AFM number
     * @param afm A string to be check if it's a valid AFM
     */
    public ValidateAFM(String afm) {
        ValidateAFMExtendedResult result = ValidateExtended(afm);
        
        this.number = afm;
        this.valid = result.Valid();
        this.error = result.Error();
    }
    
    /**
     * Checks if the passed AFM is a valid AFM number
     * @param afm A string to be check if it's a valid AFM
     * @return A boolean result indicating the validation of the number
     */
    public static boolean Validate(String afm) {
        ValidateAFMExtendedResult result = ValidateExtended(afm);
        return result.Valid();
    }
    
    /**
     * Checks if the passed AFM is a valid AFM number
     * @param afm A string to be check if it's a valid AFM
     * @return A ValidateAFMExtendedResult result indicating the validation of the number
     */
    public static ValidateAFMExtendedResult ValidateExtended(String afm) {
        if(afm == null) {
            throw new IllegalArgumentException("AFM number is not initialized");
        }
        
        if(afm.length() != 9) {
            return new ValidateAFMExtendedResult(false, "length");
        }

        if(!afm.matches("^\\d+$")) {
            return new ValidateAFMExtendedResult(false, "nan");
        }
        
        if(afm.equals("000000000")) {
            return new ValidateAFMExtendedResult(false, "zero");
        }
        
        String body = afm.substring(0, 8);
        int sum = 0;
        
        for(int i = 0; i < body.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(body.charAt(i)));
            sum += digit << (8 - i);
        }
        
        int calc = sum % 11;
        int d9 = Integer.parseInt(String.valueOf(afm.charAt(8)));
        boolean valid = calc % 10 == d9;
        
        return new ValidateAFMExtendedResult(valid, valid ? "" : "invalid");
    }
    
    /**
     * The current AFM number the class object contains
     * @return String
     */
    public String Number() { return this.number; }
    
    /**
     * A boolean result indicating the validation of the current number the class object contains
     * @return boolean
     */
    public boolean Valid() { return this.valid; }
    
    /**
     * A string result indicating the error if the current number the class object is invalid.
     * It can be empty or "length" or "nan" or "zero" or "invalid"
     * @return String
     */
    public String Error() { return this.error; }
    
    /**
     * Class for returning an extended validation result
     */
    public static class ValidateAFMExtendedResult {   
        private boolean valid;
        private String error;
        
        /**
         * The object constructor initializes a ValidateAFMExtendedResult
         * @param valid Boolean indicates whether a number is valid or not
         * @param error A string indicating the error if the number is invalid.
         *              It can be "length" or "nan" or "zero" or "invalid"
         */
        public ValidateAFMExtendedResult(boolean valid, String error) {
            this.valid = valid;
            this.error = error;
        }
        
        public ValidateAFMExtendedResult(boolean valid) {
            this(valid, "");
        }
        
        /**
         * Boolean indicates whether a number is valid or not
         * @return boolean
         */
        public boolean Valid() { return this.valid; }
        
        /**
         * A string indicating the error if the number is invalid.
         * It can be "length" or "nan" or "zero" or "invalid"
         * @return String
         */
        public String Error() { return this.error; }
        
        /**
         * Converts ValidateAFMExtendedResult to a friendly string result
         * @return String
         */
        @Override
        public String toString() {
            return String.format("ValidateAFMExtendedResult { Error()=\"%s\", Valid()=%b }", error, valid);
        }
    }
}

