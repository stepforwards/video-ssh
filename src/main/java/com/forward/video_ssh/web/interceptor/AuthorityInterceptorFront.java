package com.forward.video_ssh.web.interceptor;

import com.forward.video_ssh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**  
* @ClassName: AuthorityInterceptor  
* @Description: 通过判断session中user是否为空，来判断用户是否登录，进而判断是否拦截
* @author Administrator  
* @date 2017年9月11日  
*    
*/  
@SuppressWarnings("serial")
public class AuthorityInterceptorFront extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null){
			return "toLogin";
		}
		return invocation.invoke();
	}

}
