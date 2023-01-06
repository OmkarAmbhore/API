package com.example.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.modal.Item;

public class StorieResponse implements QuestionProResponse {
	private String status;
	private String errro;
	private List<Item> items;

	public StorieResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public StorieResponse(String status, String errro, List<Item> items) {
		super();
		this.status = status;
		this.errro = errro;
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrro() {
		return errro;
	}

	public void setErrro(String errro) {
		this.errro = errro;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errro == null) ? 0 : errro.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StorieResponse)) {
			return false;
		}
		StorieResponse other = (StorieResponse) obj;
		if (errro == null) {
			if (other.errro != null) {
				return false;
			}
		} else if (!errro.equals(other.errro)) {
			return false;
		}
		if (items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!items.equals(other.items)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}

}
