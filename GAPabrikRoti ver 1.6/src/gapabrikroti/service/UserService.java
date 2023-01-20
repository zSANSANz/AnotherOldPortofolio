/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.User;

/**
 *
 * @author cvgs
 */
public interface UserService {
    public void onChange(UserServiceImpl userServiceImpl);
    public void onInsert(User user);
    public void onUpdate(User user);
    public void onDelete();
}
