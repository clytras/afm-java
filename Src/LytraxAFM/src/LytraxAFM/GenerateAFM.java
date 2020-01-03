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

/**
 * Class with static methods to generate valid or invalid AFM numbers
 * @author Christos Lytras <christos.lytras@gmail.com>
 */
public class GenerateAFM {
    private Integer _forceFirstDigit = null;
    private boolean _pre99 = false;
    private boolean _individual = false;
    private boolean _legalEntity = false;
    private Integer _repeatTolerance = null;
    private boolean _valid = true;
    
    public GenerateAFM() {}
    
    /**
     * Generates an AFM number based on class object properties
     * @return String
     */
    public String generate() {
        Utils.GetRandomInt random = new Utils.GetRandomInt();
        int min = _legalEntity ? 7 : 1;
        int max = _individual ? 4 : 9;
        Integer repeatOf = _repeatTolerance;
        int digit = _forceFirstDigit != null ? _forceFirstDigit :
            (_pre99 ?
                0 :
                random.next(min, max)
            );
        int lastGenDigit = digit;
        int repeats = 0;
        String body = String.valueOf(digit);
        int sum = digit * 0x100;
        
        for(int i = 7; i >= 1; i--) {
            digit = random.next(0, 9,
                repeatOf != null && repeats >= repeatOf ?
                    lastGenDigit :
                    null
            );
            body += String.valueOf(digit);
            sum += digit << i;
            if(digit == lastGenDigit)
                repeats++;
            else
                repeats = 0;
            lastGenDigit = digit;
        }
        
        int validator = sum % 11;
        int d9Valid = validator >= 10 ? 0 : validator;
        int d9 = _valid ? d9Valid : random.next(0, 9, d9Valid);
        
        return body + String.valueOf(d9);
    }
    
    /**
     * Generates a valid AFM number based on class object properties
     * @return String
     */
    public String generateValid() {
        _valid = true;
        return generate();
    }
    
    /**
     * Generates an invalid AFM number based on class object properties
     * @return String
     */
    public String generateInvalid() {
        _valid = false;
        return generate();
    }
    
    /**
     * Get the value of forceFirstDigit
     * @return Integer
     */
    public Integer forceFirstDigit() { return this._forceFirstDigit; }
    
    /**
     * The first digit of the generated number
     * If not null, overrides all pre99, legalEntity and individual
     * @param value
     * @return GenerateAFM
     */
    public GenerateAFM forceFirstDigit(Integer value) {
        this._forceFirstDigit = value;
        return this;
    }
    
     /**
     * Get the value of pre99
     * @return boolean
     */
    public boolean pre99() { return this._pre99; }
    
    /**
     * Για ΑΦΜ πριν από 1/1/1999 (ξεκινάει με 0)
     * If true, overrides both legalEntity and individual
     * @param value
     * @return GenerateAFM
     */
    public GenerateAFM pre99(boolean value) {
        this._pre99 = value;
        return this;
    }
    
    /**
     * Get the value of individual
     * @return boolean
     */
    public boolean individual() { return this._individual; }
    
    /**
     * Φυσικά πρόσωπα, (ξεκινάει με 1-4)
     * @param value
     * @return GenerateAFM
     */
    public GenerateAFM individual(boolean value) {
        this._individual = value;
        return this;
    }
    
    /**
     * Get the value of legalEntity
     * @return boolean
     */
    public boolean legalEntity() { return this._legalEntity; }
    
    /**
     * Νομικές οντότητες (ξεκινάει με 7-9)
     * @param value
     * @return GenerateAFM
     */
    public GenerateAFM legalEntity(boolean value) {
        this._legalEntity = value;
        return this;
    }
    
    /**
     * Get the value of repeatTolerance
     * @return Integer
     */
    public Integer repeatTolerance() { return this._repeatTolerance; }
    
    /**
     * Number for max repeat tolerance (0 for no repeats, null for no check)
     * @param value
     * @return GenerateAFM
     */
    public GenerateAFM repeatTolerance(Integer value) {
        this._repeatTolerance = value;
        return this;
    }
    
    /**
     * Get the value of valid
     * @return boolean
     */
    public boolean valid() { return this._valid; }
    
    /**
     * Generate valid or invalid AFM
     * @param value
     * @return GenerateAFM
     */
    public GenerateAFM valid(boolean value) {
        this._valid = value;
        return this;
    }
}
