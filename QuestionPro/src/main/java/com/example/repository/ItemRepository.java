package com.example.repository;

import java.util.List;

import com.example.modal.Item;

public interface ItemRepository {

	public void syncHackerRankApi(List<Item> items) throws Exception;

	public List<Item> getTopTenStoriesRankByScore() throws Exception;

	public List<Item> getServedPreviouslyStories() throws Exception;

	public List<Item> getTopComments() throws Exception;

}
