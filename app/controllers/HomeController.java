package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionStage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.typesafe.config.Config;

import models.Image;
import play.cache.SyncCacheApi;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {
	private static final String URL_SUFFIX = "/200/300";
	private static final String IMAGE_CACHE_TTL = "image.cache.ttl";
	private static final String IMAGE_CACHE_KEY = "Image";
	private static final String MULTIPLE_IMAGES_URL = "images.url";
	private static final String RANDOM_IMAGE_URL = "image.url";

	private final Config config;
	private final SyncCacheApi cache;
	private final WSClient wsClient;

	private JsonNode imagesAsJson;
	private ObjectMapper objectMapper = new ObjectMapper();
	private Image[] images = {};
	private List<String> listOfUrls = new ArrayList<String>();

	@Inject
	public HomeController(Config config, SyncCacheApi cache, WSClient wsClient) {
		this.config = config;
		this.cache = cache;
		this.wsClient = wsClient;
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */
	public Result index() {
		return ok(views.html.index.render());
	}

	/**
	 * This is where the test will be coded for the twirl
	 * 
	 * @return Result
	 */
	public Result test() {

		int id = 0;
		String url = "";

		if (cache.get(IMAGE_CACHE_KEY) == null) {
			Random random = new Random();
			id = (int) random.nextInt(1085);

			this.cache.set(IMAGE_CACHE_KEY, id,this.config.getInt(IMAGE_CACHE_TTL));
		} else {
			id = (cache.get(IMAGE_CACHE_KEY));
		}
		url = config.getString(RANDOM_IMAGE_URL) + id + URL_SUFFIX;

		System.out.println(url);

		return ok(views.html.image.render(url));

	}

	/**
	 * This is where the multiple Image test will be coded
	 * 
	 * @return CompletionStage<Result>
	 */
	public CompletionStage<Result> testMultiple() throws JsonProcessingException {

		cache.set(MULTIPLE_IMAGES_URL, config.getString(MULTIPLE_IMAGES_URL), 10);
		return wsClient.url(config.getString(MULTIPLE_IMAGES_URL)).get().thenApply(files -> {
			this.imagesAsJson = files.asJson();

			try {

				this.images = this.objectMapper.treeToValue(imagesAsJson, Image[].class);
				Arrays.stream(this.images).filter(img -> Integer.parseInt(img.getId()) % 2 == 0)
						.map(image -> image.getDownload_url()).forEach(imageUrl -> this.listOfUrls.add(imageUrl));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return ok(views.html.images.render(this.listOfUrls));
		});
	}

}
