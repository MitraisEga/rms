package com.mitrais.rms.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public abstract class AbstractController extends HttpServlet
{
    public static final String VIEW_PREFIX = "/WEB-INF/jsp";
    public static final String VIEW_SUFFIX = ".jsp";

    protected String getTemplatePath(String path)
    {
        if (path.equalsIgnoreCase("/"))
        {
            return VIEW_PREFIX + path + "index" + VIEW_SUFFIX;
        }
        else
        {
            return VIEW_PREFIX + path + VIEW_SUFFIX;
        }
    }
    
    protected Boolean authenticationCheck(HttpSession session) {
    	if(session != null && session.getAttribute("User") != null) {
    		return true;
    	}
    	
    	return false;
    }
}
