package com.chaminda.destination.resources;

import com.chaminda.destination.core.Destination;
import com.chaminda.destination.core.DestinationBuilder;
import com.chaminda.destination.db.DestinationDao;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DestinationResourceIT extends BaseIntegrationTest{

    public static final String DESTINATIONS_PATH = "http://localhost:8080/destinations";

    private static DestinationDao destinationDao ;

    @Rule
    public ResourceTestRule resource = ResourceTestRule.builder().addResource(new DestinationResource(destinationDao)).build();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

        DBI dbi = new DBIFactory().build(BaseIntegrationTest.RULE.getEnvironment(), BaseIntegrationTest.RULE.getConfiguration().getDataSourceFactory(), "h2");
        destinationDao = dbi.onDemand(DestinationDao.class);
    }


    @Test
    public void given_DestinationId_when_FindById_then_ShouldReturnDestination(){
        //given
        String pathId = "/1";

        //when
        Destination response = resource.getJerseyTest()
                .client()
                .target(DESTINATIONS_PATH + pathId)
                .request(MediaType.APPLICATION_JSON)
                .get(Destination.class);

        //then
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1);
    }

    @Test
    public void given_Destination_when_Persisted_then_ShouldPersisDestination(){
        //given
        Destination destinationToBeSaved = new DestinationBuilder()
                .withId(120)
                .withName("Srilanka")
                .withDescription("Perl of the Indian ocean").build();

        //when
        Response response = resource.getJerseyTest()
                .client()
                .target(DESTINATIONS_PATH)
                .request()
                .post(Entity.json(destinationToBeSaved));

        //then
        assertThat(response).isNotNull();
    }

    @Test
    public void when_RequestAllDestinations_then_ReturnAllDestination(){
        //given

        //when
        List<Destination> response = resource.getJerseyTest()
                .client()
                .target(DESTINATIONS_PATH)
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isEmpty()).isFalse();

    }

    @Test
    public void give_destinationId_when_deleteTheDestination_then_recordShouldBeDeleted(){
        //given
        int id = 121;
        Destination destinationToBeDeleted = new DestinationBuilder()
                .withId(id)
                .withName("Delete")
                .withDescription("To be deleted").build();

        resource.getJerseyTest()
                .client()
                .target(DESTINATIONS_PATH)
                .request()
                .post(Entity.json(destinationToBeDeleted));

        //when
        Response response = resource.getJerseyTest()
                .client().target(DESTINATIONS_PATH + "/" + id).request().delete();


        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT_204);

    }




}
