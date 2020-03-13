package com.org.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

	@Value("${movieBoxBaseUrl.apiKey}")
	private String apiKey;

	@Value("${movieBoxBaseUrl.searchUrl}")
	private String searchUrl;

	@Autowired
	private RestTemplate restTemplate;

	public HttpEntity<Object> searchMovieDetails(String query) {

		String url = searchUrl + "?api_key=" + apiKey + "&query=" + query;

		HttpHeaders httpHeader = new HttpHeaders();

		HttpEntity<Object> httpRequestEntity = new HttpEntity<Object>(httpHeader);

		HttpEntity<Object> httpResponseEntity = restTemplate.exchange(url, HttpMethod.GET, httpRequestEntity,
				Object.class);

		return httpResponseEntity;

	}

}
