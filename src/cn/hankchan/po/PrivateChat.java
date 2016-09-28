/**
 * 
 */
package cn.hankchan.po;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 8 May 201617:01:21
 * 类说明:
 */
public class PrivateChat {
	private Integer id;
	private String sender;
	private String receiver;
	private String content;
	private String time; //发送时间
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PrivateChat [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content
				+ ", time=" + time + "]";
	}
	
}
