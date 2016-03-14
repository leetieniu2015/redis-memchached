package org.leetieniu.service;

public interface BaseService {
	
	public  class BaseServiceResponse {
		private boolean success = false;
		private String message;

		public void success() {
			success = true;
		}

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
