package com.example.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.modal.Item;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	private static final int BATCH_SIZE = 100;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ItemRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	String INSERT_INTO_ITEMS = "INSERT INTO item (id, by_user, descendants, parent, poll, kids, parts, score, input_text, sync_time, title, item_type, url) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	String GET_TOP_TEN_STORIES_RANK_BY_SCORE = "SELECT title,url, score, sync_time, by_user FROM item  WHERE item_type='story' ORDER BY score DESC LIMIT 10";

	String GET_SERVED_PREVIOUSLY_STORIES = "SELECT title,url, score, sync_time, by_user FROM item  WHERE ID NOT IN (SELECT ID FROM (\r\n"
			+ "( SELECT ID FROM item  WHERE item_type='story' ORDER BY score DESC LIMIT 10) ) AS TEMP) \r\n"
			+ " AND item_type='story' ORDER BY score DESC";

	String GET_TOP_COMMENTS_STORIES = "SELECT title,url, score, sync_time, by_user FROM item  WHERE item_type='story' ORDER BY LENGTH(input_text) DESC LIMIT 10";

	@Override
	public void syncHackerRankApi(List<Item> items) throws Exception {
		int count = 0;
		try (Connection connection = this.jdbcTemplate.getDataSource().getConnection()) {
			try (PreparedStatement ps = connection.prepareStatement(INSERT_INTO_ITEMS)) {
				Gson g = new Gson();
				for (Item item : items) {

//					Date date;
//					SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
//					date = new java.sql.Date(format.parse(item.getTime()).getTime());
//					

//					Date now = new Date();
//					String pattern = "YYYY-MM-DD HH:MM:SS";
//					SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//					 String mysqlDateString = formatter.format(item.getTime().getTime());

//					Date date = new Date(item.getTime().getTime());
					if (item.getId() != null) {
						ps.setBigDecimal(1, item.getId());
					} else {
						ps.setNull(1, Types.NULL);
					}
					if (!StringUtils.isNullOrEmpty(item.getBy())) {
						ps.setString(2, item.getBy());
					} else {
						ps.setNull(2, Types.NULL);
					}
					if (item.getDescendants() != null) {
						ps.setBigDecimal(3, item.getDescendants());
					} else {
						ps.setNull(3, Types.NULL);
					}
					if (item.getParent() != null) {
						ps.setBigDecimal(4, item.getParent());
					} else {
						ps.setNull(4, Types.NULL);
					}
					if (item.getPoll() != null) {

						ps.setBigDecimal(5, item.getPoll());
					} else {
						ps.setNull(5, Types.NULL);
					}

					List<Long> inputKids = item.getKids();
					String kids = g.toJson(inputKids);

					List<Long> inputParts = item.getParts();

					String parts = g.toJson(inputParts);

					if (!StringUtils.isNullOrEmpty(kids)) {
						ps.setString(6, kids);
					} else {
						ps.setNull(6, Types.NULL);
					}
					if (!StringUtils.isNullOrEmpty(parts)) {
						ps.setString(7, parts);

					} else {
						ps.setNull(7, Types.NULL);
					}
					if (item.getScore() != null) {
						ps.setBigDecimal(8, item.getScore());
					} else {
						ps.setNull(8, Types.NULL);
					}
					if (!StringUtils.isNullOrEmpty(item.getText())) {
						ps.setString(9, item.getText());

					} else {
						ps.setNull(9, Types.NULL);
					}
					if (item.getTime() != null) {
						ps.setTimestamp(10, new java.sql.Timestamp(new Date(item.getTime()).getTime()));
					} else {
						ps.setNull(10, Types.NULL);
					}
					if (!StringUtils.isNullOrEmpty(item.getTitle())) {
						ps.setString(11, item.getTitle());
					} else {
						ps.setNull(11, Types.NULL);
					}
					if (!StringUtils.isNullOrEmpty(item.getType())) {
						ps.setString(12, item.getType());
					} else {
						ps.setNull(12, Types.NULL);
					}
					if (!StringUtils.isNullOrEmpty(item.getUrl())) {
						ps.setString(13, item.getUrl());

					} else {
						ps.setNull(13, Types.NULL);
					}
					ps.addBatch();
					// If batch count reaches batch size then execute the batch.
					if (++count % BATCH_SIZE == 0) {
						ps.executeBatch();
					}

				}
				ps.executeBatch();

			} catch (Exception e) {
				throw new Exception(e);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<Item> getTopTenStoriesRankByScore() throws Exception {
		List<Item> items = new ArrayList<Item>();
		try (Connection connection = this.jdbcTemplate.getDataSource().getConnection()) {
			try (PreparedStatement ps = connection.prepareStatement(GET_TOP_TEN_STORIES_RANK_BY_SCORE)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						items.add(new Item(null, rs.getString("by_user"), null, null, null, null, null,
								rs.getBigDecimal("score"), null, rs.getTimestamp("sync_time").getTime(),
								rs.getString("title"), null, rs.getString("url")));
					}
				} catch (Throwable t) {
					throw new Exception(t);
				}
			} catch (Throwable t) {
				throw new Exception(t);
			}
		} catch (Throwable t) {
			throw new Exception(t);
		}
		return items;
	}

	@Override
	public List<Item> getServedPreviouslyStories() throws Exception {
		List<Item> items = new ArrayList<Item>();
		try (Connection connection = this.jdbcTemplate.getDataSource().getConnection()) {
			try (PreparedStatement ps = connection.prepareStatement(GET_SERVED_PREVIOUSLY_STORIES)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						items.add(new Item(null, rs.getString("by_user"), null, null, null, null, null,
								rs.getBigDecimal("score"), null, rs.getTimestamp("sync_time").getTime(),
								rs.getString("title"), null, rs.getString("url")));
					}
				} catch (Throwable t) {
					throw new Exception(t);
				}
			} catch (Throwable t) {
				throw new Exception(t);
			}

		} catch (Exception t) {
			throw new Exception(t);
		}
		return items;

	}

	@Override
	public List<Item> getTopComments() throws Exception {
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<Item>();
		try (Connection connection = this.jdbcTemplate.getDataSource().getConnection()) {
			try (PreparedStatement ps = connection.prepareStatement(GET_TOP_COMMENTS_STORIES)) {
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						items.add(new Item(null, rs.getString("by_user"), null, null, null, null, null,
								rs.getBigDecimal("score"), null, rs.getTimestamp("sync_time").getTime(),
								rs.getString("title"), null, rs.getString("url")));
					}
				} catch (Throwable t) {
					throw new Exception(t);
				}
			} catch (Throwable t) {
				throw new Exception(t);
			}

		} catch (Exception t) {
			throw new Exception(t);
		}
		return items;

	}

}
