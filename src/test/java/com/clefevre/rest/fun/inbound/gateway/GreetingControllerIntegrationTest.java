package com.clefevre.rest.fun.inbound.gateway;

import com.clefevre.rest.fun.BaseIntegrationTest;
import com.clefevre.rest.fun.domain.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingControllerIntegrationTest extends BaseIntegrationTest {

    @Test
    void given_no_content_we_receive_default_greeting() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                                                          .scheme( "http" )
                                                          .host( "localhost" )
                                                          .port( port )
                                                          .path( "/greeting" )
                                                          .build();
        var result = testRestTemplate.getForObject( uriComponents.toUri(), Greeting.class );
        assertEquals( String.format( GreetingController.template, "World" ), result.getContent() );
    }

    @Test
    void given_content_the_greeting_is_updated() {
        var inputContent = "Everyone";
        HttpHeaders headers = new HttpHeaders();
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme( "http" )
                .host( "localhost" )
                .port( port )
                .path( "/greeting" )
                .queryParam( String.format( "name=%s", inputContent) )
                .build();
        var result = testRestTemplate.getForObject( uriComponents.toUri(), Greeting.class );
        assertEquals( String.format( GreetingController.template, inputContent ), result.getContent() );
    }
}
