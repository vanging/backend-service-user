package com.vanging.www.user.persistence.mapper;

import com.vanging.www.user.persistence.entity.Profile;

public interface ProfileMapper
{
    public void addNewProfileFromEmail(com.vanging.www.user.persistence.entity.Profile profile);
    public String getUidFromEmail(String email);//可以用来检查email是否存在，null
    public String getUidFromUsername(String Username);//可以用来检查username是否存在，null
    public Profile getProfileFromUid(String uid);
}