package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.jboss.logging.Logger;

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
import services.ContentAPIService;
import utils.AppUtils;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {
	private static final String ID_STRING = "/id/";
	private static final String URL_SUFFIX = "/200/300";
	private static final String IMAGE_CACHE_TTL = "image.cache.ttl";
	private static final String IMAGE_CACHE_KEY = "ImageId";
	private static final String IMAGE_CACHE_KEY2 = "ImageIdOneView";
	private static final String MULTIPLE_IMAGES_URL = "images.url";
	private static final String RANDOM_IMAGE_URL = "image.url";

	private final Config config;
	private final SyncCacheApi cache;
	private final ContentAPIService service ;

	private JsonNode imagesAsJson;
	private ObjectMapper objectMapper = new ObjectMapper();
	private Image[] images = {};
	private List<String> listOfUrls = new ArrayList<String>();

	private Logger logger = Logger.getLogger("play");

	@Inject
	public HomeController(Config config, SyncCacheApi cache , ContentAPIService service) {
		this.config = config;
		this.cache = cache;
		this.service = service ; 
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */
	public Result index() {
		this.logger.info("Entering Home Screen ........");
		return ok(views.html.index.render());
	}

	/**
	 * This is where the test will be coded for the twirl
	 * 
	 * @return CompletionStage<Result>
	 */

	public CompletionStage<Result> test() {
		this.logger.info("Getting One Image ........");

		if (this.cache.get(IMAGE_CACHE_KEY) != null) {
			this.logger.info("Returning Image From Cache ........");

			return CompletableFuture.completedFuture(ok(views.html.image.render(
					config.getString(RANDOM_IMAGE_URL) + ID_STRING + this.cache.get(IMAGE_CACHE_KEY) + URL_SUFFIX)));
		}

		else {
			this.logger.info("Returning Image From Service ........");

			return this.service.getOneImage()

					.thenApply(file -> {
						String Location = file.getAllHeaders().get("Location").get(0);
						System.out.println(AppUtils.getIdFrom(Location));
						this.cache.set(IMAGE_CACHE_KEY, AppUtils.getIdFrom(Location),
								this.config.getInt(IMAGE_CACHE_TTL));
						return ok(views.html.image.render(config.getString(RANDOM_IMAGE_URL) + Location));
					});
		}
	}

	/**
	 * This is where the multiple Image test will be coded
	 * 
	 * @return CompletionStage<Result>
	 */
	public CompletionStage<Result> testMultiple() throws JsonProcessingException {
		this.logger.info("Getting Multiple Images ........");

		return this.service.getMultipleImages().thenApply(files -> {
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

	public CompletionStage<Result> allInOnView(Boolean showOneImage) throws JsonProcessingException {
		this.logger.info("Getting Either One Image Or Multiple Images ........");

		if (showOneImage == true) {

			if (this.cache.get(IMAGE_CACHE_KEY) != null) {
				this.logger.info("Returning Image From Cache ........");

				return CompletableFuture.completedFuture(ok(views.html.all.render(
						config.getString(RANDOM_IMAGE_URL) + ID_STRING + this.cache.get(IMAGE_CACHE_KEY) + URL_SUFFIX,
						new ArrayList<String>(), showOneImage)));
			}

			else {
				this.logger.info("Returning Image From Service ........");

				return this.service.getOneImage()

						.thenApply(file -> {
							String Location = file.getAllHeaders().get("Location").get(0);
							System.out.println(AppUtils.getIdFrom(Location));
							this.cache.set(IMAGE_CACHE_KEY, AppUtils.getIdFrom(Location),
									this.config.getInt(IMAGE_CACHE_TTL));
							return ok(views.html.all.render(config.getString(RANDOM_IMAGE_URL) + Location,
									new ArrayList<String>(), showOneImage));
						});
			}
		} else {

			return this.service.getMultipleImages().thenApply(files -> {
				this.imagesAsJson = files.asJson();

				try {

					this.images = this.objectMapper.treeToValue(imagesAsJson, Image[].class);
					Arrays.stream(this.images).filter(img -> Integer.parseInt(img.getId()) % 2 == 0)
							.map(image -> image.getDownload_url()).forEach(imageUrl -> this.listOfUrls.add(imageUrl));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				return ok(views.html.all.render("", this.listOfUrls, showOneImage));
			});

		}

	}

}
