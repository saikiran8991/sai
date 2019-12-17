package com.employees.timesheet.core.util; 

public class MyHttpResponse {
	 private String Status;    
	 private Object Data;
	 private Object Message; 
	  
	public String getStatus() { 
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Object getData() {   
		return Data;    
	}
	public void setData(Object data) {  
		Data = data; 
	}   
	public Object getMessage() { 
		return Message; 
	}
	public void setMessage(Object message) {
		Message = message;
	}
	  
}  
     