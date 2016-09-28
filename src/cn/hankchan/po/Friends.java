/**
 * 
 */
package cn.hankchan.po;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201614:28:56
 * 类说明: 用户的好友关系类
 */
public class Friends {
	
	
	private Integer id;
	private String usera; //用户名A
	private String userb; //用户名B
	private Integer isfriend; //A与B是否为好友，1：是好友；0：不是好友
	private String content; //两者的聊天信息
	private Integer isshow; //是否为显示过的消息，1：还未显示；0：已经显示过
	
	public Integer getIsshow() {
		return isshow;
	}
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsera() {
		return usera;
	}
	public void setUsera(String usera) {
		this.usera = usera;
	}
	public String getUserb() {
		return userb;
	}
	public void setUserb(String userb) {
		this.userb = userb;
	}
	public Integer getIsfriend() {
		return isfriend;
	}
	public void setIsfriend(Integer isfriend) {
		this.isfriend = isfriend;
	}
	@Override
	public String toString() {
		return "Friends [id=" + id + ", usera=" + usera + ", userb=" + userb + ", isfriend=" + isfriend + ", content="
				+ content + ", isshow=" + isshow + "]";
	}
	
}
