/**
 * 
 */
package cn.hankchan.po;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:10:29
 * 类说明: 管理员信息实体类
 */
public class Root {

	private Integer id;
	private String username;
	private String password;
	private Integer level; //权限等级：1为最高级，2次之，以此类推。
	private String tips; //备注
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
	public Integer getLevel() {
		return getLevel();
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "Root [id=" + id + ", username=" + username + ", password=" + password + ", level=" + level + ", tips="
				+ tips + "]";
	}
}
