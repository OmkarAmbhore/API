package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enums.APIResponseStatus;
import com.example.modal.Item;
import com.example.response.QuestionProResponse;
import com.example.response.StorieResponse;
import com.example.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService is;

	@PostMapping(value = "/v1/hacker/rank/api/sync")
	public String syncHackerRankApi() throws Exception {
		String status = null;
		String error = null;
		try {
			is.syncHackerRankApi();
			status = APIResponseStatus.Hacker_sync_successfully.toString();
		} catch (Throwable t) {
			status = APIResponseStatus.exception.toString();
			error = t.getMessage();
		}
		return status;
	}

//	 top-stories - Should return the top 10 stories ranked by the score in the last 15
//	minutes (Read Instructions), Each story should have a title, URL, score,
//	time of submission, and the user who submitted it.

	@GetMapping(value = "/top-stories")
	public QuestionProResponse getTopTenStoreisRankByScore() throws Exception {
		List<Item> items = new ArrayList<Item>();
		String status = null;
		String error = null;
		try {
			items = is.getTopTenStoriesRankByScore();
			status = APIResponseStatus.completed.toString();
		} catch (Throwable t) {
			status = APIResponseStatus.exception.toString();
			error = t.getMessage();
		}
		return new StorieResponse(status, error, items);
	}

	// past-stories - Should return all the stories that were served previously from
	// the 1st endpoint (/top-stories).
	@GetMapping(value = "/past-stories")
	public QuestionProResponse getServedPreviouslyStories() throws Exception {
		List<Item> items = new ArrayList<Item>();
		String status = null;
		String error = null;
		try {
			items = is.getServedPreviouslyStories();
			status = APIResponseStatus.completed.toString();
		} catch (Throwable t) {
			status = APIResponseStatus.exception.toString();
			error = t.getMessage();
		}
		return new StorieResponse(status, error, items);
	}

	// comments - Should return 10 comments (max) on a given story sorted by a total
	// number of child comments.
	@GetMapping(value = "/comments")
	public QuestionProResponse getComments() {
		List<Item> items = new ArrayList<Item>();
		String status = null;
		String error = null;
		try {
			items = is.getTopComments();
			status = APIResponseStatus.completed.toString();
		} catch (Throwable t) {
			status = APIResponseStatus.exception.toString();
			error = t.getMessage();
		}
		return new StorieResponse(status, error, items);
	}

}
