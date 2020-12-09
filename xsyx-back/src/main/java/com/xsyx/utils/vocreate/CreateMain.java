package com.xsyx.utils.vocreate;


import com.xsyx.vo.*;

public class CreateMain {

    public static void main(String[] args) {
        //createVo();
        //createMapper();
    }

    public static void createVo(){
        CreateEntityUtil.init("root","123456",
                "jdbc:mysql://localhost:3306/xsyx?characterEncoding=utf-8",
                "com.mysql.jdbc.Driver","com.xsyx.vo");
        CreateEntityUtil.useFkEntity = true;
        CreateEntityUtil.usePkEntityList = true;
        CreateEntityUtil.write(true,true,true);
    }

    public static void createMapper(){
        CreateMapUtil.init("root","123456",
                "jdbc:mysql://localhost:3306/xsyx?characterEncoding=utf-8",
                "com.mysql.jdbc.Driver","com.xsyx.dao");
        CreateMapUtil.usePkEntityList = false;
        CreateMapUtil.addClass(Collect.class,false,true);
        CreateMapUtil.addClass(ComDiscount.class,false,true);
        CreateMapUtil.addClass(ComImage.class,false,true);
        CreateMapUtil.addClass(ComLabel.class,false,true);
        CreateMapUtil.addClass(Comments.class,false,true);
        CreateMapUtil.addClass(Commodity.class,false,true);
        CreateMapUtil.addClass(ComOrder.class,false,true);
        CreateMapUtil.addClass(ComType.class,false,true);
        CreateMapUtil.addClass(Employee.class,false,true);
        CreateMapUtil.addClass(Emprole.class,false,true);
        CreateMapUtil.addClass(Information.class,false,true);
        CreateMapUtil.addClass(Menu.class,false,true);
        CreateMapUtil.addClass(Merchants.class,false,true);
        CreateMapUtil.addClass(MerchantsApply.class,false,true);
        CreateMapUtil.addClass(Permission.class,false,true);
        CreateMapUtil.addClass(Pickup.class,false,true);
        CreateMapUtil.addClass(Purchase.class,false,true);
        CreateMapUtil.addClass(Purchaseorder.class,false,true);
        CreateMapUtil.addClass(Role.class,false,true);
        CreateMapUtil.addClass(Shopcar.class,false,true);
        CreateMapUtil.addClass(Star.class,false,true);
        CreateMapUtil.addClass(User.class,false,true);
        CreateMapUtil.addClass(Warehouse.class,false,true);
        CreateMapUtil.write("Dao");
    }
}
