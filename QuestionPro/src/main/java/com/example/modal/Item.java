package com.example.modal;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Item {

	private BigDecimal id;
	private String by;
	private BigDecimal descendants;
	private BigDecimal parent;
	private BigDecimal poll;
	private List<Long> kids;
	private List<Long> parts;
	private BigDecimal score;
	private String text;
	private Long time;
	private String title;
	private String type;
	private String url;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public Item(BigDecimal id, String by, BigDecimal descendants, BigDecimal parent, BigDecimal poll, List<Long> kids,
			List<Long> parts, BigDecimal score, String text, Long time, String title, String type, String url) {
		super();
		this.id = id;
		this.by = by;
		this.descendants = descendants;
		this.parent = parent;
		this.poll = poll;
		this.kids = kids;
		this.parts = parts;
		this.score = score;
		this.text = text;
		this.time = time;
		this.title = title;
		this.type = type;
		this.url = url;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public BigDecimal getDescendants() {
		return descendants;
	}

	public void setDescendants(BigDecimal descendants) {
		this.descendants = descendants;
	}

	public BigDecimal getParent() {
		return parent;
	}

	public void setParent(BigDecimal parent) {
		this.parent = parent;
	}

	public BigDecimal getPoll() {
		return poll;
	}

	public void setPoll(BigDecimal poll) {
		this.poll = poll;
	}

	public List<Long> getKids() {
		return kids;
	}

	public void setKids(List<Long> kids) {
		this.kids = kids;
	}

	public List<Long> getParts() {
		return parts;
	}

	public void setParts(List<Long> parts) {
		this.parts = parts;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((by == null) ? 0 : by.hashCode());
		result = prime * result + ((descendants == null) ? 0 : descendants.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kids == null) ? 0 : kids.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((parts == null) ? 0 : parts.hashCode());
		result = prime * result + ((poll == null) ? 0 : poll.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		if (by == null) {
			if (other.by != null) {
				return false;
			}
		} else if (!by.equals(other.by)) {
			return false;
		}
		if (descendants == null) {
			if (other.descendants != null) {
				return false;
			}
		} else if (!descendants.equals(other.descendants)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (kids == null) {
			if (other.kids != null) {
				return false;
			}
		} else if (!kids.equals(other.kids)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (parts == null) {
			if (other.parts != null) {
				return false;
			}
		} else if (!parts.equals(other.parts)) {
			return false;
		}
		if (poll == null) {
			if (other.poll != null) {
				return false;
			}
		} else if (!poll.equals(other.poll)) {
			return false;
		}
		if (score == null) {
			if (other.score != null) {
				return false;
			}
		} else if (!score.equals(other.score)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}

}
