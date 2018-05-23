package com.ls.nssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*
* 项目名称：pisr
* 类名称：BaseAction
* 类描述：公共类Action
* 创建人：SZ-1520 LiMing
* 创建时间�?016/7/1 上午 8:45:30
*
*/
public class BaseAction extends ActionSupport {
	
	/**
	 * 序列�?
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获得sesstion
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}


	/**
	 * 获得request
	 */
	public HttpServletRequest getRequest() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
		return request;
	}
	

	/**
	 * 获取request对象
	 */
	public HttpServletRequest getHttpRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	}

	
	public String getUserIp() {
		String ipFromNginx = getHeader(getRequest(), "X-Real-IP");
		return StringUtils.isEmpty(ipFromNginx) ? getRequest().getRemoteAddr(): ipFromNginx;
	}
	
	private static String getHeader(HttpServletRequest request, String headName) {
		String value = request.getHeader(headName);
		return !StringUtils.isBlank(value)
				&& !"unknown".equalsIgnoreCase(value) ? value : "";
	}
	
	

	public List<String> validList;



	/**
	 * 获取response对象
	 */
	public HttpServletResponse getHttpResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(
				org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
	}
	
	 
}
