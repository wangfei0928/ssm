package com.wf.controller;

import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    /*
    * 查询所有用户
    * */
    @RequestMapping("/findAll")
    public String findAll(Model model){

        //查询所有用户
      /*  ArrayList<Account> list = new ArrayList<>();
        Account account = new Account();
        account.setId(1);
        account.setName("张三");
        account.setMoney(1000d);

        Account account2 = new Account();
        account2.setId(2);
        account2.setName("李四");
        account2.setMoney(2000d);
        list.add(account);
        list.add(account2);
*/
        List<Account> list = accountService.findAll();
        //把封装好的list存到model中
        model.addAttribute("list",list);
        return "list";
    }

    /*
    * 添加用户
    * */
    @RequestMapping("/save")
    public String save(Account account){
        accountService.save(account);
        //跳转到findAll()方法，重新查询进行一次数据遍历展示。
        return "redirect:/account/findAll";
    }

    /*
    * 根据id查询用户信息
    * */
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Account account = accountService.findById(id);

        model.addAttribute("account",account);
        return "update";
    }

    /*
     更新账户
     */
    @RequestMapping("/update")
    public String update(Account account){
        accountService.update(account);
        return "redirect:/account/findAll";
    }

    /*
    * 批量删除
    * */
    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer [] ids){
        accountService.deleteBatch(ids);
        return "redirect:/account/findAll";
    }
}
