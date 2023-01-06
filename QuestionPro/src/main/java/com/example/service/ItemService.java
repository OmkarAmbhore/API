package com.example.service;

import java.util.List;

import com.example.modal.Item;

public interface ItemService {

	public void syncHackerRankApi() throws Exception;

	public List<Item> getTopTenStoriesRankByScore() throws Exception;

	public List<Item> getServedPreviouslyStories() throws Exception;

	public List<Item> getTopComments() throws Exception;

}
