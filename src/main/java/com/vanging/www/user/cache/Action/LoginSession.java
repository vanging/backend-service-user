package com.vanging.www.user.cache.Action;

import com.vanging.www.user.cache.Cache;
import redis.clients.jedis.Jedis;

import java.util.UUID;

public class LoginSession
{
    /**
     * session: "uid:"
     */
    private static int sessionTTL = 60 * 60 * 24 * 30;

    // (session) -> sessionInfo
    private static String buildKeyOfSessionToInfo(String session)
    {
        String appPrefix = "com.vanging.www.user.login";
        return appPrefix + ":session2uid:" + session;
    }

    // (uid) -> session
    private static String buildKeyOfUidToSession(String uid)
    {
        String appPrefix = "com.vanging.www.user.login";
        return appPrefix + ":uid2session:" + uid;
    }

    private static String createSessionFromUid(String uid)
    {
        Jedis jedis = Cache.getConnection();
        String uuid = UUID.randomUUID().toString();

        // session -> sessionInfo
        jedis.set(buildKeyOfSessionToInfo(uuid), uid);
        jedis.expire(buildKeyOfSessionToInfo(uuid),sessionTTL);

        // uid -> session
        jedis.set(buildKeyOfUidToSession(uid), uuid);
        jedis.expire(buildKeyOfUidToSession(uid),sessionTTL);

        jedis.close();
        return uuid;
    }

    // session -> (sessionInfo)
    public static String getUidFromSession(String session)
    {
        Jedis jedis = Cache.getConnection();
        String uid = jedis.get(buildKeyOfSessionToInfo(session));
        jedis.close();
        return uid;
    }

    public static String getSessionFromUid(String uid)
    {
        Jedis jedis = Cache.getConnection();
        String session = jedis.get(buildKeyOfUidToSession(uid));
        if(session == null)
        {
            System.out.println("login session not exist, creating new one...done");
            session = createSessionFromUid(uid);
        }
        return session;
    }
}
