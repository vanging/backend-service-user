package com.vanging.www.user.cache.Action;

import com.vanging.www.user.cache.Cache;
import redis.clients.jedis.Jedis;

import java.util.UUID;

public class Session
{
    /**
     * session: "uid:"
     */
    private static int sessionTTL = 60 * 60 * 24 * 30;
    private static String buildKeyOfSessionToInfo(String session)
    {
        String appPrefix = "com.vanging.www.user";
        return appPrefix + ":session2info:" + session;
    }
    private static String buildKeyOfUidToSession(String uid)
    {
        String appPrefix = "com.vanging.www.user";
        return appPrefix + ":uid2session:" + uid;
    }
    private static String updateUidInSessionInfo(String sessionInfo, String uid)
    {
        return "";
    }
    public static String getSessionInfo(String session)
    {
        Jedis jedis = Cache.getConnection();
        String sessionInfo = jedis.get(buildKeyOfSessionToInfo(session));
        jedis.close();
        return sessionInfo;
    }
    public static boolean setSessionInfo(String session, String sessionInfo)
    {
        Jedis jedis = Cache.getConnection();
        String result = jedis.set(buildKeyOfSessionToInfo(session), sessionInfo);
        jedis.close();
        return result.equals("OK");
    }
    public static String getUidFromSession(String session)
    {
        String sessionInfo = getSessionInfo(session);
        if(sessionInfo == null)
        {
            return null;
        }
        String[] sessionSegments = sessionInfo.split(":");
        return sessionSegments[0];
    }
    private static String createSessionFromUid(String uid)
    {
        Jedis jedis = Cache.getConnection();
        String uuid = UUID.randomUUID().toString();

        // uid -> session
        jedis.set(buildKeyOfUidToSession(uid), uuid);
        jedis.expire(buildKeyOfUidToSession(uid),sessionTTL);

        // session -> sessionInfo
        jedis.set(buildKeyOfSessionToInfo(uuid), uid);
        jedis.expire(buildKeyOfSessionToInfo(uid),sessionTTL);

        jedis.close();
        return uuid;
    }
    public static String getSessionFromUid(String uid)
    {
        Jedis jedis = Cache.getConnection();
        String session = jedis.get(buildKeyOfUidToSession(uid));
        if(session == null)
        {
            session = createSessionFromUid(uid);
        }
        else
        {
            return session;
        }
    }
}
