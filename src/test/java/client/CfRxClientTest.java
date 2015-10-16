package client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.common.io.CharStreams;
import feign.Response;
import models.Page;
import models.application.Application;
import models.organization.Organization;
import models.service.ServiceInstance;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import rx.observers.TestSubscriber;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static queries.Operator.EQ;
import static queries.Query.query;

public class CfRxClientTest {

    @ClassRule
    public static WireMockRule wireMockRule = new WireMockRule();

    public CfRxClient client;

    public ObjectMapper mapper;

    @Before
    public void initialize() {
        client = new CfRxClient("http://localhost:" + wireMockRule.port());
        mapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());
    }

    @Test
    public void retrieveParticularOrganizationTest() throws IOException {
        // given
        final String organizationJson = loadJson("organization.json");
        final Organization organization = mapper.readValue(organizationJson, Organization.class);

        stubFor(get(urlPathEqualTo("/v2/organizations/e4e8c3fc-1c5b-4571-9517-36a3c6e0b837"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(organizationJson)));

        // when
        final TestSubscriber<Organization> testSubscriber = new TestSubscriber<>();
        client.getOrganizations(UUID.fromString("e4e8c3fc-1c5b-4571-9517-36a3c6e0b837"))
                .subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
        testSubscriber.assertValues(organization);
    }

    @Test
    public void retrieveAllOrganizationsTest() throws IOException {
        // given
        final String page1Json = loadJson("organizations_page_1.json");
        final Page<Organization> page1 = mapper.readValue(page1Json, new TypeReference<Page<Organization>>() {
        });

        final String page2Json = loadJson("organizations_page_2.json");
        final Page<Organization> page2 = mapper.readValue(page2Json, new TypeReference<Page<Organization>>() {
        });

        stubFor(get(urlPathEqualTo("/v2/organizations"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(page1Json)));

        stubFor(get(urlPathEqualTo("/v2/organizations?page=2"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(page2Json)));

        // when
        final TestSubscriber<Organization> testSubscriber = new TestSubscriber<>();
        client.getOrganizations()
                .subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
        testSubscriber.assertValues(page1.getResources().get(0), page2.getResources().get(0));
    }

    @Test
    public void retrieveMatchingOrganizationsTest() throws IOException {
        // given
        final String pageJson = loadJson("organizations_page_2.json");
        final Page<Organization> page = mapper.readValue(pageJson, new TypeReference<Page<Organization>>() {
        });

        stubFor(get(urlPathEqualTo("/v2/organizations"))
                .withQueryParam("q", equalTo("name%3Apage-2-org"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(pageJson)));

        // when
        final TestSubscriber<Organization> testSubscriber = new TestSubscriber<>();
        client.getOrganizations(query("name", EQ, "page-2-org"))
                .subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(page.getResources());
    }

    @Test
    public void deleteOrganizationTest() {
        // given
        stubFor(delete(urlPathEqualTo("/v2/organizations/e4e8c3fc-1c5b-4571-9517-36a3c6e0b837"))
                .willReturn(aResponse()
                        .withStatus(204)));

        // when
        final TestSubscriber<Response> testSubscriber = new TestSubscriber<>();
        client.deleteOrganization(UUID.fromString("e4e8c3fc-1c5b-4571-9517-36a3c6e0b837"), true, true)
                .subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
    }

    @Test
    public void retrieveAllServiceInstancesTest() throws IOException {
        // given
        final String pageJson = loadJson("service_instances_page_1.json");
        final Page<ServiceInstance> page = mapper.readValue(pageJson, new TypeReference<Page<ServiceInstance>>() {
        });

        stubFor(get(urlPathEqualTo("/v2/service_instances"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(pageJson)));

        // when
        final TestSubscriber<ServiceInstance> testSubscriber = new TestSubscriber<>();
        client.getServiceInstances().subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(page.getResources());
    }

    @Test
    public void retrieveApplicationsTest() throws IOException {
        final String pageJson = loadJson("applications.json");
        final Page<Application> page = mapper.readValue(pageJson, new TypeReference<Page<Application>>() {
        });

        stubFor(get(urlPathEqualTo("/v2/apps"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(pageJson)));

        // when
        final TestSubscriber<Application> testSubscriber = new TestSubscriber<>();
        client.getApplications().subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(page.getResources());
    }

    private String loadJson(String name) {
        try {
            return CharStreams.toString(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(name)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file name: " + name);
        }
    }
}
