/**
 * 
 */
package cn.hankchan.po;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201615:56:01
 * 类说明: 用户个人信息实体类
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer state; //在线状态: 1 说明在线; 0 说明不在线
	private Integer speak; //是否有发言权限：1为正常；0为被禁言
	private String nickname; //昵称
	private Integer gender;//男性为1，女性为0
	private Integer age;
	private String college;
	private String tel;
	private String email;
	private String weixin;
	private String qq;
	private String motto;//个人签名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getSpeak() {
		return speak;
	}
	public void setSpeak(Integer speak) {
		this.speak = speak;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", state=" + state + ", speak="
				+ speak + ", nickname=" + nickname + ", gender=" + gender + ", age=" + age + ", college=" + college
				+ ", tel=" + tel + ", email=" + email + ", weixin=" + weixin + ", qq=" + qq + ", motto=" + motto + "]";
	}
	public User() {
	}
}
