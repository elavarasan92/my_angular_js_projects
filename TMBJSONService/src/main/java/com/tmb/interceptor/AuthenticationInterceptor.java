//package com.tmb.interceptor;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
// 
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.servlet.ModelAndView;
// 
//public class AuthenticationInterceptor implements HandlerInterceptorAdapter  {
//   
//	public boolean preHandle(HttpServletRequest request,
//            HttpServletResponse response, Object handler) throws Exception {
//         
//        System.out.println("Pre-handle");
//         
//        return true;
//    }
//    //override postHandle() and afterCompletion() 
//
//	@Override
//	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
//			throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
//			throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//}