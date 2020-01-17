package com.deloitte.currency.conversion.client.util;

import java.util.Date;

public class ErrorResponse {

		Date timeStamp;
		String message;
		String description;

		 public ErrorResponse() {
		}
	public ErrorResponse(Date timeStamp, String message, String description) {
	         super();

			this.timeStamp = timeStamp;
			this.message = message;
	        this.description = description;	
	        }

		public Date getTimeStamp() {
	      return timeStamp;
	}

		public void setTimeStamp(Date timeStamp) {
	         this.timeStamp = timeStamp;
	}
		public String getMessage() {
	         return message;

		}
	public void setMessage(String message) {
	        this.message = message;

		}
		public String getDescription() {
	        return description;

		}
		public void setDescription(String description) {
			this.description = description;

		}
	}


