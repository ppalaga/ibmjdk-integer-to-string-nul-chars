/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package ibmjdk;

/**
 *
 * See the README file in the top directory of the project.
 *
 * @author <a href="https://github.com/ppalaga">Peter Palaga</a>
 *
 */
public class IntegerToString {

    public static void main(String[] args) {

        printSysProp("java.vendor");
        printSysProp("java.version");
        printSysProp("os.arch");
        printSysProp("os.name");
        printSysProp("os.version");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            int timeLow = (int) System.currentTimeMillis() & 0xFFFFFFFF;
            String hex = Integer.toHexString(timeLow);
            int nullPos = hex.indexOf('\u0000');
            System.out.println("timeLow = " + timeLow + ", hex.length = " + hex.length() + ", hex nul pos = " + nullPos
                    + ", hex = '" + hex + "'");

            if (nullPos >= 0) {
                break;
            }

        }
    }

    /**
     *
     */
    private static void printSysProp(String prop) {
        System.out.println(prop + " = " + System.getProperty(prop));
    }

}
