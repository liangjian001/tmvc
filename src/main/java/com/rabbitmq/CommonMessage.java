package com.rabbitmq;  
  
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;  
  
/** 
 * 消息模型 
 * 
 */  
public class CommonMessage {  
    /** 
     * 约定的几个消息源名称 
     */  
    private String source;  
    /** 
     * 实体表名 
     */  
    private String table;  
    /** 
     * 主键 
     */  
    private String primaryKey;  
    /** 
     * 消息实体bean 
     */  
    private Object message;
    
    /**
     * 消息说明
     */
    private String comments;
  
    public String getSource() {  
        return source;  
    }  
  
    public void setSource(String source) {  
        this.source = source;  
    }  
  
    public String getTable() {  
        return table;  
    }  
  
    public void setTable(String table) {  
        this.table = table;  
    }  
  
  
    public String getPrimaryKey() {  
        return primaryKey;  
    }  
  
    public void setPrimaryKey(String primaryKey) {  
        this.primaryKey = primaryKey;  
    }  
  
    public Object getMessage() {  
        return message;  
    }  
  
    public void setMessage(Object message) {  
        this.message = message;  
    }  
  
    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override  
    public String toString() {  
        return ToStringBuilder.reflectionToString(this,  
                ToStringStyle.DEFAULT_STYLE);  
    }  
      
}  