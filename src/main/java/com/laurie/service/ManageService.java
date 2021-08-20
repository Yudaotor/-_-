package com.laurie.service;

/**
 * @author Laurie
 */
public interface ManageService {
    /**
     * 根据用户输入的信息来进行注册账号
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @param cellphone 手机号码
     */
    void register(String username ,String password ,String email ,String cellphone);

    /**
     * 管理员对用户信息进行修改
     * @param userId 用户编号
     * @param userName 用户名
     * @param password 密码
     * @param email 邮箱
     * @param cellphone 手机号码
     */
    void modifyUser(int userId, String userName, String password, String email, String cellphone);

    /**
     * 根据编号删除用户
     * @param userId 用户编号
     */
    void deleteUserById(int userId);

    /**
     * 删除小组
     * @param groupName 小组名称
     */
    void deleteGroup(String groupName);
}
