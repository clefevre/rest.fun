package com.clefevre.rest.fun;

import java.security.SecureRandom;

/**
 * Randomizer class for holding the toolkit of methods for randomized input test data.
 */
public class Randomizer {

    /**
     * Secure random instance to generate fake randomized data.
     */
    private final SecureRandom theNumberGenerator = new SecureRandom();

    /**
     * Char Array of all Legal hex characters.
     */
    private final char[] hexCharacters = {'A', 'B', 'C', 'D', 'E', 'F', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * Convnenience method for generating a random integer from 0 up to maxValue, but not inclusive, of the
     * specified max value.
     * @param maxValue top of the number range ( Not inclusive ).
     * @return random number within the given range.
     */
    private int randomNumberExclusive( final int maxValue ) {
        return theNumberGenerator.nextInt( maxValue );
    }

    /**
     * Convenience method for generating a random number between 0 and N, exclusive, which is suitable for array
     * indexing.
     * @param arrayLength the size of the array.
     * @return random index.
     */
    private int randomArrayIndex( final int arrayLength ) {
        return randomNumberExclusive( arrayLength );
    }

    /**
     * Convenience method for generating a input length amount of randomized hex characters in a String form.
     * @param length The number of characters to create in a String.
     * @return A String of length 'length'.
     */
    public String randomHexString( final int length ) {
        final StringBuilder builder = new StringBuilder( length );
        for ( int i = 0; i < length; i++ ) {
            builder.append( hexCharacters[randomArrayIndex( hexCharacters.length)] );
        }
        return builder.toString();
    }
}
