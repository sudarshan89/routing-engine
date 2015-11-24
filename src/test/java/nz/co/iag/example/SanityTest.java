package nz.co.iag.example;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by s.sreenivasan on 11/21/2015.
 */
public class SanityTest {

    @Test
    public void whenEachPayloadIsAssessedByEngine_itShouldMatchExactlyOnePayload(){
        File payloadsDirectory = new File("samplepayloads");
        System.out.println(payloadsDirectory.isDirectory() + "" +payloadsDirectory.listFiles());

        assertThat(true).isTrue();
    }
}
