package com.clefevre.rest.fun.inbound.gateway;

import com.clefevre.rest.fun.BaseUnitTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for the GreetingController.
 */
public class GreetingControllerUnitTest extends BaseUnitTest {

    @Test
    void test_randomized_content_given() {
        //Given a subject under test
        var sut = new GreetingController();

        //and a randomized String
        var inputString = randomizer.randomHexString( 5 );

        //when we call the greeting method
        var result = sut.greeting( inputString );

        //then we get the proper template output
        assertEquals( String.format( GreetingController.template, inputString ), result.getContent() );
    }
}
