package com.vanging.www.user.restful.servlet;

import com.alibaba.fastjson.JSON;
import com.vanging.www.user.cache.Action.LoginSession;
import com.vanging.www.user.cache.Cache;
import com.vanging.www.user.persistence.Action;
import com.vanging.www.user.persistence.entity.Profile;
import com.vanging.www.user.restful.response.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetProfileFromSession extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Response finalResponse = new Response();

        String session = request.getParameter("session");

        if(session == null)
        {
            finalResponse.setStatus("param_wrong");
        }
        else
        {
            String uid= LoginSession.getUidFromSession(session);
            if(uid == null)
            {
                finalResponse.setStatus("session_not_exist");
            }
            else
            {
                Profile profile = Action.getProfileFromUid(uid);
                if(profile == null)
                {
                    finalResponse.setStatus("uid_not_exist");
                }
                else
                {
                    finalResponse.setMessage(profile);
                    finalResponse.setStatus("ok");
                }
            }
        }

        JSON.writeJSONString(response.getWriter(), finalResponse);
    }
}