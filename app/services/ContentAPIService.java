package services;

import java.util.concurrent.CompletionStage;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.typesafe.config.Config;

import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

/**
 * @author ahmed
 *
 */

@Singleton
public class ContentAPIService {

	private static final String URL_SUFFIX = "/200/300";
	private static final String MULTIPLE_IMAGES_URL = "images.url";
	private static final String RANDOM_IMAGE_URL = "image.url";

	private final WSClient wsClient;
	private final Config config;

	@Inject
	public ContentAPIService(Config config, WSClient wsClient) {
		this.config = config;
		this.wsClient = wsClient;
	}

	/**
	 * faire un appel à l'api pour retouner une seule image
	 * 
	 * @return
	 */
	public CompletionStage<WSResponse> getOneImage() {

		return this.wsClient.url(this.config.getString(RANDOM_IMAGE_URL) + URL_SUFFIX).get();
	}

	/**
	 * faire un appel à l'api pour retouner une liste des images
	 * 
	 * @return
	 */
	public CompletionStage<WSResponse> getMultipleImages() {

		return wsClient.url(config.getString(MULTIPLE_IMAGES_URL)).get();

	}

}
