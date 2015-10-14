package com.chaminda.destination.core;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DestinationBuilderTest {

    @Test
    public void given_DestinationInformation_when_BuildDestination_then_ShouldReturnDestination(){
        //given
        String destinationDesc = "Some Destination";
        String name = "Some Name";
        int id =1;

        //when
        Destination created = new DestinationBuilder()
                .withId(id)
                .withDescription(destinationDesc)
                .withName(name).build();
        //then
        assertThat(created).isNotNull();
        assertThat(created.getId()).isEqualTo(1);
        assertThat(created.getDescription()).isEqualTo(destinationDesc);
        assertThat(created.getName()).isEqualTo(name);

    }
}
