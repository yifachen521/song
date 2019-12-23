package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.BeforeUserService;
import com.qf.utils.ImageCut;
import com.qf.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 炜哥哥
 * @date 2019/12/20 8:29
 */
@Controller
@RequestMapping("/user")
public class BeforeUser {
    @Autowired
    private BeforeUserService beforeUserService;

    /**
     * 邮箱验证 用户登录
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginUser")
    public String loginUser(User user, HttpServletRequest request) {
        User user1 = beforeUserService.UserLogin(user);
        System.out.println(user1.toString() + "111");
        if (user1 != null) {
            //将用户名存入session
            request.getSession().setAttribute("userAccount", user.getEmail());
            //把对象存入session
            request.getSession().setAttribute("user", user1);
            return "success";
        }
        return "error";
    }

    /**
     * 个人中心
     *
     * @return
     */
    @RequestMapping("/showMyProfile")
    public String showMyProfile() {

        return "before/my_profile";
    }

    /**
     * 跳转修改用户信息
     *
     * @return
     */
    @RequestMapping("/changeProfile")
    public String changeProfile() {
        return "before/change_profile";
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {

        Integer integer = beforeUserService.updateUserMsg(user);

        if (integer == 1) {
            //再查一次用户信息  带回到用户页面
            User user1 = beforeUserService.findUser(user);
            request.getSession().setAttribute("user", user1);
            return "before/my_profile";
        } else {

            return "404";
        }
    }

    /**
     * 去修改头像的图片
     *
     * @return
     */
    @RequestMapping("/changeAvatar")
    public String changeAvatar() {
        return "before/change_avatar";
    }


    @RequestMapping("/upLoadImage")
    public String upLoadImage(MultipartFile image_file, HttpServletRequest request, double x1, double x2, double y1, double y2) {
        //设置服务器的地址路径
        File file = new File("E:\\Software\\tomcat\\apache-tomcat-9.0.0.M20-file\\webapps\\Videos\\userAvatar");
        //获取图片名称  这个MultipartFile名称要和前端的提交的name  image_file相同
        String originalFilename = image_file.getOriginalFilename();
        //拼接上uuid的随机码  防止重名
        String s = UUID.randomUUID().toString() + originalFilename;
        //把拼好的名字 保存进数据库 从session里边获取当前用户的信息
        User user = (User) request.getSession().getAttribute("user");
        user.setImgUrl(s);

        beforeUserService.updateUserImg(user);
        //上传文件 到服务器上
        try {
            image_file.transferTo(new File(file, s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将头像的坐标取整
        int xOne = (int) Math.floor(x1);
        int xTwo = (int) Math.floor(y1);
        int yOne = (int) Math.floor(x2);
        int yTwo = (int) Math.floor(y2);

        //通过坐标切割头像 传入文件的路径
        String imagePath = file + "\\" + s;
        ImageCut imageCut = new ImageCut();
        imageCut.cutImage(imagePath, xOne, xTwo, yOne, yTwo);
        //更新session的用户信息
        User user1 = beforeUserService.findUser(user);

        request.getSession().setAttribute("user", user1);
        return "before/my_profile";

    }

    /**
     * 跳转修改密码
     *
     * @return
     */
    @RequestMapping("/passwordSafe")
    public String passwordSafe() {
        return "before/password_safe";
    }

    /**
     * 验证旧密码
     *
     * @param request
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/validatePassword")
    public String validatePassword(HttpServletRequest request, String password) {
        //ajax验证旧密码是否正确
        User user = (User) request.getSession().getAttribute("user");
        if (password.equals(user.getPassword())) {
            //表示旧密码输入正确
            return "success";
        }
        return "error";
    }

    /**
     * 修改密码
     *
     * @param newPassword02
     * @param request
     * @return
     */
    @RequestMapping("/updatePassword")
    public String updatePassword(String newPassword02, HttpServletRequest request) {
        //将修改后的密码保存进数据库
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(newPassword02);
        Integer integer = beforeUserService.updateUserPwd(user);
        if (integer == 1) {
            //保存密码成功 更新session
            request.getSession().setAttribute("user", user);
            System.out.println(user + "333");
        }
        return "before/my_profile";
    }

    /**
     * 注册用户
     *
     * @param email
     * @param psw_again
     * @return
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(String email, String psw_again) {
        //封装进user
        User user = new User();
        user.setEmail(email);
        user.setPassword(psw_again);
        Integer integer = beforeUserService.addUser(user);
        if (integer == 1) {

            return "success";
        }
        return "error";
    }

    /**
     * 验证邮箱是否存在
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/validateEmail")
    public String validateEmail(String email) {
        //查询邮箱是否存在
        User user = new User();
        user.setEmail(email);
        User user1 = beforeUserService.findUser(user);
        if (user1 == null) {
            //表示邮箱未被注册
            return "success";
        }
        return "error";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() {

        return "before/forget_password";
    }

    /**
     * 选个邮箱发送验证码
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendEmail(String email, HttpServletRequest request) {
        String validateCode = MailUtils.getValidateCode(6);
        //放入session
        request.getSession().setAttribute("yzm", validateCode);
        boolean b = MailUtils.sendMail(email, validateCode, "验证码");
        if (b) {
            return "success";
        }
        return "hasNoUser";
    }

    /**
     * 跳转新密码
     *
     * @return
     */
    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String code, HttpServletRequest request, String email, Model model) {
        //
        String yzm = (String) request.getSession().getAttribute("yzm");
        if (yzm.equals(code)) {
            //带上email
            model.addAttribute("email",email);
            return "before/reset_password";
        }
        return "before/forget_password";
    }

    /**
     * 验证邮箱修改密码
     * @param password02
     * @return
     */
    @RequestMapping("/resetPassword")
    public ModelAndView resetPassword(String password02,String email) {
        User user = new User();
        user.setPassword(password02);
        user.setEmail(email);
        Integer integer = beforeUserService.updateUserPwd(user);
        if (integer==1){
            //重定向到首页
            return new ModelAndView("redirect:/subject/selectAll");
        }
        return new ModelAndView("redirect:404.jsp");
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    public  ModelAndView loginOut(HttpServletRequest request){
        //清除用户登录信息
        request.getSession().invalidate();
        User user = (User) request.getSession().getAttribute("user");
        //跳转到首页
       return new ModelAndView("redirect:/subject/selectAll");
    }

}
