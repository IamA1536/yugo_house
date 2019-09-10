package org.csu.sfteam.house_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.csu.sfteam.house.common.model.account.User;
import org.csu.sfteam.house.common.model.account.User_important;
import org.csu.sfteam.house.common.model.account.User_standard;
import org.csu.sfteam.house.common.model.items.Property;
import org.csu.sfteam.house.biz.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.csu.sfteam.house.common.model.items.*;
import org.csu.sfteam.house.biz.service.*;

@Controller
public class UserInformationController {

    @Autowired
    private SalePropertyService salePropertyService;
    @Autowired
    private DecorationService decorationService;
    @Autowired
    private SaleOldHouseService saleOldHouseService;
    @Autowired
    private RentService rentService;
    /**
     * 共有 上传 修改 查看 删除
     * 楼盘的函数
     */
    //跳转至上传楼盘界面
    @GetMapping("/account/addProperty")
    public String ViewAddProperty(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "account/login";
        else
            return "commodity/propertyApplication";

    }

    @PostMapping("/commodity/addProperty")
    //上传楼盘信息
    public String AddProperty(MultipartFile file, HttpSession session, Building building, Model model) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "account/login";
        }
        //生成楼盘id
        long ID = (1 * 1000000) + Math.round((Math.random() * 9 + 1) * 100000);
        //设置一些值
        building.setItemFrom(user.getID());
        building.setType(1);
        building.setID(ID);
        System.out.println("kksk"+building.getLocationX());
        System.out.println("kksk"+building.getLocationY());
        //文件传输
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            //设置文件位置到url
            building.setImg(filePath + fileName);
            System.out.println(building.getImg());
            //调用生成函数
        }
        salePropertyService.CreateProperty(building);
        //model.addAttribute("building",building);
        return "account/publishedInfoManage";

    }

    //显示所有楼盘
    //跳往楼盘信息界面
    @GetMapping("/account/viewProperty")
    public String ViewProperty(@RequestParam("itemName") String itemName, Model model) {
        Building building = salePropertyService.GetPropertyByItemname(itemName);

        model.addAttribute("type", 1);
        model.addAttribute("building", building);

        return "commodity/editProperty";
    }

    //更新楼盘信息 成功
    @PostMapping("/commodity/updateProperty")
    public String UpdateProperty(@RequestParam("ID") long ID, MultipartFile file, HttpSession httpSession, Building building, Model model) {
        building.setID(ID);
        System.out.println(building.getID());
        System.out.println(building.getItemName());
        //判断是否上传文件
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            //获得原有图片url，并删除原有图片
            String orgimghurl = salePropertyService.GetPropertyByID((int) ID).getImg();
            System.out.println(" orgimghurl" + orgimghurl);
            //删除原有文件
            File temfile = new File(orgimghurl);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();

            //把新图片的uml放入新的对象中
            building.setImg(filePath + fileName);
            System.out.println("url " + filePath + fileName);
            //赋给更新的楼盘信息
        }
        //返回更新结果
        int result = salePropertyService.UpdateProperty(building);
        System.out.println("result is" + result);

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }

    //删除楼盘信息
    @GetMapping("/account/deleteProperty")
    public String DeleteProperty(@RequestParam("itemName") String itemName, HttpSession httpSession, Model model) {

        Building building = salePropertyService.GetPropertyByItemname(itemName);
        if (building.getImg() != null) {
            String url = building.getImg();
            File temfile = new File(url);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();
        }
        salePropertyService.Delete(building);
        //直接删除不成功的话，使用ID
        //saleOldHouseService.DeleteByID((int)building.getID());
        //返回地址自己定

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }

    /**
     * 装修界面
     * 共有 上传 修改 查看 删除
     */
    //跳转到至上传装修界面
    @GetMapping("/account/addDecoration")
    public String ViewAddDecoration(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println("null");
        }
        return "/commodity/decorationApplication";
    }

    //上传装修信息
    @PostMapping("/commodity/addDecoration")
    public String AddDecoration(MultipartFile file, HttpSession session, Decoration decoration, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "account/login";

        int ID = (4 * 1000000) + (int) (Math.random() * 9 + 1) * 100000;
        decoration.setItemFrom((int) user.getID());
        decoration.setID(ID);
        System.out.println(decoration.getLocationX());
        System.out.println(decoration.getLocationY());
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            decoration.setImg(filePath + fileName);
            System.out.println(decoration.getImg());
        }
        decorationService.CreateDecoration(decoration);
        return "account/publishedInfoManage";
    }

    //跳转至用户的管理界面，上传所有装修信息
    @GetMapping("/account/viewDecoration")
    public String ViewDecoration(@RequestParam("company") String company, Model model) {
        Decoration decoration = decorationService.GetDecoration(company);

        model.addAttribute("type", 4);
        model.addAttribute("decoration", decoration);

        return "commodity/editDecoration";
    }

    //更新装修信息
    @PostMapping("/commodity/updateDecoration")
    public String UpdateDecoration(@RequestParam("ID") int ID, MultipartFile file, HttpSession httpSession, Decoration decoration, Model model) {
        decoration.setID(ID);
        System.out.println(decoration.getID());
        System.out.println(decoration.getCompany());
        //判断是否上传文件
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            //获得原有图片url，并删除原有图片
            String orgimghurl = decorationService.GetDecorationByID(ID).getImg();
            System.out.println(" orgimghurl" + orgimghurl);
            //删除原有文件
            File temfile = new File(orgimghurl);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();

            //把新图片的uml放入新的对象中
            decoration.setImg(filePath + fileName);
            System.out.println("url " + filePath + fileName);
            //赋给更新的楼盘信息
        }
        //返回更新结果
        int result = decorationService.UpdateDecoration(decoration);
        System.out.println("result is" + result);

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }

    //删除装修信息
    @GetMapping("/account/deleteDecoration")
    public String DeleteDecoration(@RequestParam("company") String company, HttpSession httpSession, Model model) {
        Decoration decoration = decorationService.GetDecoration(company);
        if (decoration.getImg() != null) {
            String url = decoration.getImg();
            File temfile = new File(url);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();
        }
        decorationService.delete(decoration);

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }

    /**
     * 二手房
     * 上传 修改 删除 查看/管理
     */
    //跳转至上传二手房界面
    @GetMapping("/account/addOldHouse")
    public String ViewAddOldHouse(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {

            return "account/login";
        } else {
            model.addAttribute("type", 2);
            //System.out.println("userID is"+user.getID());
            return "commodity/houseApplication";
        }

    }

    @PostMapping("/commodity/addOldHouse")
    //上传二手房信息
    public String AddOldHouse(MultipartFile file, HttpSession session, Building building, Model model) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "account/login";
        }
        //生成楼盘id
        long ID = (2 * 1000000) + Math.round((Math.random() * 9 + 1) * 100000);
        //设置一些值
        building.setItemFrom(user.getID());
        building.setType(2);
        building.setID(ID);
        //文件传输
        if (file != null) {
            if (file.isEmpty())
                System.out.println("文件为空");

            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }

            //设置文件位置到url
            building.setImg(filePath + fileName);
            System.out.println(building.getImg());
            //调用生成函数 result=0 为成功， 1为失败
        }
        int result = saleOldHouseService.CreateOldHouse(building);
        //model.addAttribute("building",building);
        return "account/publishedInfoManage";

    }

    //显示所有二手房
    //跳往二手房信息界面
    @GetMapping("/account/viewOldHouse")
    public String ViewOldHouse(@RequestParam("itemName") String itemName, Model model) {
        Building building = saleOldHouseService.GetOldHouseByItemname(itemName);

        model.addAttribute("type", 2);
        model.addAttribute("building", building);

        return "commodity/editHouse";
    }

    //更新二手房信息
    @PostMapping("/commodity/updateOldHouse")
    public String UpdateOldHouse(@RequestParam("ID") long ID, MultipartFile file, HttpSession httpSession, Building building, Model model) {

        building.setID(ID);
        System.out.println(building.getID());
        System.out.println(building.getItemName());
        //判断是否上传文件
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            //获得原有图片url，并删除原有图片
            String orgimghurl = saleOldHouseService.GetOldHouseByID((int) ID).getImg();
            System.out.println(" orgimghurl" + orgimghurl);
            //删除原有文件
            File temfile = new File(orgimghurl);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();

            //把新图片的uml放入新的对象中
            building.setImg(filePath + fileName);
            System.out.println("url " + filePath + fileName);
            //赋给更新的楼盘信息
        }
        //返回更新结果
        int result = saleOldHouseService.UpdateOldHouse(building);
        System.out.println("result is" + result);

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }

    //删除二手房信息
    @GetMapping("/account/deleteOldHouse")
    public String DeleteOldHouse(@RequestParam("itemName") String itemName, HttpSession httpSession, Model model) {
        //删除文件
        Building building = saleOldHouseService.GetOldHouseByItemname(itemName);
        if (building.getImg() != null) {
            String url = building.getImg();
            File temfile = new File(url);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();
        }
        saleOldHouseService.Delete(building);
        //直接删除不成功的话，使用ID
        //saleOldHouseService.DeleteByID((int)building.getID());
        //返回地址自己定

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";

    }

    /**
     * 租房
     * 上传 修改 删除 查看
     */
    //跳转至上传租房界面
    @GetMapping("/account/addRent")
    public String ViewAddRent(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {

            return "account/login";
        } else {
            //System.out.println("userID is"+user.getID());
            model.addAttribute("type", 3);
            return "commodity/houseApplication";
        }

    }

    @PostMapping("/commodity/addRent")
    //上传租房信息
    public String AddRent(MultipartFile file, HttpSession session, Building building, Rent rent, Model model) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "account/login";
        }
        //生成楼盘id
        long ID = (3 * 1000000) + Math.round((Math.random() * 9 + 1) * 100000);
        //设置一些值
        building.setItemFrom(user.getID());
        building.setArea(rent.getArea());
        building.setType(3);
        building.setID(ID);
        //文件传输
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }

            //设置文件位置到url
            building.setImg(filePath + fileName);
            System.out.println(building.getImg());
            //调用生成函数 result=0 为成功， 1为失败
        }
        int result = rentService.CreateRent(building);
        //model.addAttribute("building",building);
        return "account/publishedInfoManage";

    }

    //显示所有二手房
    //跳往租房信息界面
    @GetMapping("/account/viewRent")
    public String ViewRent(@RequestParam("itemName") String itemName, Model model) {
        Building building = rentService.GetRentByItemname(itemName);

        model.addAttribute("type", 3);
        model.addAttribute("building", building);

        return "commodity/editHouse";
    }

    //更新租房信息
    @PostMapping("/commodity/updateRent")
    public String UpdateRent(@RequestParam("ID") long ID, MultipartFile file, HttpSession httpSession, Building building, Model model) {
        building.setID(ID);
        System.out.println(building.getID());
        System.out.println(building.getItemName());
        //判断是否上传文件
        if (file != null) {
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }
            String fileName = file.getOriginalFilename();
            String filePath = "F:/imgs/";
            System.out.println(filePath);
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            //获得原有图片url，并删除原有图片
            String orgimghurl = rentService.GetRentByID((int) ID).getImg();
            System.out.println(" orgimghurl" + orgimghurl);
            //删除原有文件
            File temfile = new File(orgimghurl);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();

            //把新图片的uml放入新的对象中
            building.setImg(filePath + fileName);
            System.out.println("url " + filePath + fileName);
            //赋给更新的楼盘信息
        }
        //返回更新结果
        int result = rentService.UpdateRent(building);
        System.out.println("result is" + result);

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }

    //删除二手房信息
    @GetMapping("/account/deleteRent")
    public String DeleteRent(@RequestParam("itemName") String itemName, HttpSession httpSession, Model model) {

        Building building = rentService.GetRentByItemname(itemName);
        if (building.getImg() != null) {
            String url = building.getImg();
            File temfile = new File(url);
            if (temfile.exists() && temfile.isFile())
                temfile.delete();
        }
        rentService.Delete(building);
        //直接删除不成功的话，使用ID
        //saleOldHouseService.DeleteByID((int)building.getID());
        //返回地址自己定

        User user = (User) httpSession.getAttribute("user");

        List<Building> buildingProperty = salePropertyService.ShowPropertyByItemFrom((int) user.getID());
        List<Building> buildingOldHouse = saleOldHouseService.ShowOldHouseByItemFrom((int) user.getID());
        List<Building> buildingRent = rentService.ShowRentByItemFrom((int) user.getID());
        List<Decoration> decorationList = decorationService.showDecorationsByItemFrom((int) user.getID());

        model.addAttribute("buildingProperty", buildingProperty);
        model.addAttribute("buildingOldHouse", buildingOldHouse);
        model.addAttribute("buildingRent", buildingRent);
        model.addAttribute("decorationList", decorationList);

        return "account/publishedInfoManage";
    }


}
