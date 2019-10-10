package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;
import play.twirl.api.Content;
import utils.AppUtils;

public class HomeControllerTest extends WithApplication {

	private static final String EXAMPLE_ONE_IMAGE = "https://picsum.photos/id/59/200/300";
	private static final String EXAMPLE_ONE_IMAGE2 = "https://picsum.photos/id/60/200/300";

	private static final String EXAMPLE_HEADER = "/id/59/200/300";
	private List<String> listOfUrls = Arrays.asList(EXAMPLE_ONE_IMAGE, EXAMPLE_ONE_IMAGE2);

	@Override
	protected Application provideApplication() {
		return new GuiceApplicationBuilder().build();
	}

	@Test
	public void testIndex() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/");

		Result result = route(app, request);
		assertEquals(OK, result.status());
	}

	@Test
	public void testoneImage() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/test");

		Result result = route(app, request);
		assertNotNull(result);
		assertEquals(OK, result.status());

	}

	@Test
	public void testMultipleImages() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/testMultiple");

		Result result = route(app, request);
		assertNotNull(result);
		assertEquals(OK, result.status());

	}

	@Test
	public void TestgetIdFromMethod() {
		String id = AppUtils.getIdFrom(EXAMPLE_HEADER);

		assertEquals("59", id);

	}

	@Test
	public void renderTemplateOneImage() {
		Content html = views.html.image.render(EXAMPLE_ONE_IMAGE);
		assertEquals("text/html", html.contentType());
		assertTrue(contentAsString(html).contains("TASK 2"));
	}

	@Test
	public void renderTemplateMultipleImages() {
		Content html = views.html.images.render(this.listOfUrls);
		assertEquals("text/html", html.contentType());
		assertTrue(contentAsString(html).contains("TASK 3"));
	}

}
