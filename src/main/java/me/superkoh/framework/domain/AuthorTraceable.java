package me.superkoh.framework.domain;

public interface AuthorTraceable {
    void setCreateUser(Long createUser);
    Long getCreateUser();
    void setUpdateUser(Long updateUser);
    Long getUpdateUser();
}
