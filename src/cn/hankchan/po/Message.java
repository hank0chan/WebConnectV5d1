/**
 * 
 */
package cn.hankchan.po;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 29 Apr 201610:14:52
 * 类说明: 用户聊天信息实体类
 */
public class Message {
	
	private Integer id; //唯一标识
	private String content; //消息内容
	private String username; //对应的发送者Id
	private String receiver; //接收信息用户Id
	private String time; //发送时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", username=" + username + ", receiver=" + receiver
				+ ", time=" + time + "]";
	}
	
}
