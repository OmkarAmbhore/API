package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.modal.Item;
import com.example.repository.ItemRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository ir;

	@Override
	public void syncHackerRankApi() throws Exception {
		// TODO Auto-generated method stub

		List<Item> items = this.getHackerNewsApiData();

		ir.syncHackerRankApi(items);
	}

	private List<Item> getHackerNewsApiData() throws JsonMappingException, JsonProcessingException {
		Set<String> sets = new HashSet<String>();
		List<Item> items = new ArrayList<Item>();
		sets.add("https://hacker-news.firebaseio.com/v0/item/8863.json?print=pretty");
		sets.add("https://hacker-news.firebaseio.com/v0/item/2921983.json?print=pretty");
		sets.add("https://hacker-news.firebaseio.com/v0/item/121003.json?print=pretty");
		sets.add("https://hacker-news.firebaseio.com/v0/item/192327.json?print=pretty");
		sets.add("https://hacker-news.firebaseio.com/v0/item/126809.json?print=pretty");
		sets.add("https://hacker-news.firebaseio.com/v0/item/160705.json?print=pretty");
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		for (String uri : sets) {
			String jsonStr = rest.getForObject(uri, String.class);
			Item item = mapper.readValue(jsonStr, Item.class);
			items.add(item);
		}
		return items;
	}

	@Override
	public List<Item> getTopTenStoriesRankByScore() throws Exception {
		// TODO Auto-generated method stub
		return this.ir.getTopTenStoriesRankByScore();
	}

	@Override
	public List<Item> getServedPreviouslyStories() throws Exception {
		// TODO Auto-generated method stub
		return this.ir.getServedPreviouslyStories();
	}

	@Override
	public List<Item> getTopComments() throws Exception {
		// TODO Auto-generated method stub
		return this.ir.getTopComments();
	}

}
