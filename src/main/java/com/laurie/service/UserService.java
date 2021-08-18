package com.laurie.service;

/**
 * @author Laurie
 */
public interface UserService {
    /**
     * 登录服务
     * @param username 传入的用户名
     * @param password 传入的密码
     * @return 是否账号密码正确
     */
    boolean login(String username, String password);

    /**
     * 注册服务
     * @param username 传入的用户名
     * @param password 传入的密码
     * @param email 传入的邮箱
     * @param cellphone 传入的手机号码
     */
    void register(String username, String password, String email, String cellphone);

    /**
     * 修改密码
     * @param id 需要修改密码的用户的编号
     * @param password1 原密码
     * @param password2 新密码
     * @return 是否修改成功
     */
    boolean modify(int id, String password1, String password2);
}
