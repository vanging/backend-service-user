package com.vanging.www.user.restful.servlet.exist;

import com.alibaba.fastjson.JSON;
import com.vanging.www.user.persistence.Action;
import com.vanging.www.user.restful.response.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Email extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Response finalResponse = new Response();
        String email = request.getParameter("email");
        if(email == null)
        {
            finalResponse.setStatus("no_email");
        }
        else
        {
            if(Action.isEmailExist(email))
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