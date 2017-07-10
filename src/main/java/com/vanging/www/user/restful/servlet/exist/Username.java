package com.vanging.www.user.restful.servlet.exist;

import com.alibaba.fastjson.JSON;
import com.vanging.www.user.persistence.Action;
import com.vanging.www.user.restful.response.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Username extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Response finalResponse = new Response();
        String username = request.getParameter("username");
        if(username == null)
        {
            finalResponse.setStatus("no_username");
        }
        else
        {
            if(Action.isUsernameExist(username))
            {
                finalResponse.setMessage(true);
            }
            else
            {
                finalResponse.setMessage(false);
            }
            finalResponse.setStatus("ok");
        }
        JSON.writeJSONString(response.getWriter(), finalResponse);
    }
}