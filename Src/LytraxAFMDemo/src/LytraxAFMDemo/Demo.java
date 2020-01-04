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
package LytraxAFMDemo;

import LytraxAFM.ValidateAFM;
import LytraxAFM.GenerateAFM;

/**
 *
 * @author Christos Lytras <christos.lytras@gmail.com>
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenerateAFM generator = new GenerateAFM();
        
        System.out.println("Demo: Generate valid numbers");
        
        report("(default)", generator.reset().generateValid());
        report("pre99", generator.reset().pre99(true).generateValid());
        report("legalEntity", generator.reset().legalEntity(true).generateValid());
        report("individual", generator.reset().individual(true).generateValid());
        report("repeatTolerance:0", generator.reset().repeatTolerance(0).generateValid());

        System.out.println("");
        System.out.println("Demo: Generate invalid numbers");
        
        report("(default)", generator.reset().generateInvalid());
        report("pre99", generator.reset().pre99(true).generateInvalid());
        report("legalEntity", generator.reset().legalEntity(true).generateInvalid());
        report("individual", generator.reset().individual(true).generateInvalid());
        report("repeatTolerance:0", generator.reset().repeatTolerance(0).generateInvalid());
    }
    
    public static void report(String label, String number) {
        System.out.printf("%s %s %s\n", label, number, validator(ValidateAFM.Validate(number)));
    }
    
    public static String validator(boolean valid) {
        return valid ? "(valid)" : "(invalid)";
    }
    
}
