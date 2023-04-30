package com.example.warehouse.controller;

//import com.example.warehouse.domain.materialitem;
import com.example.warehouse.domain.inventory;
import com.example.warehouse.domain.materialitem;
import com.example.warehouse.domain.materialwithdrawalslip;
import com.example.warehouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.warehouse.repository.materialwithdrawalsliprepository ;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/materialSlip")
public class materialSlipController {
    @Autowired
    private materialwithdrawalsliprepository Materialwithdrawalsliprepository;
    @Autowired
    private inventoryrepository Inventoryrepository;
    @Autowired
    private materialitemrepository Materialitemrepository;

    public int Totalquantity(int production_quantity , int Quantityper){
        int cal = production_quantity * Quantityper ;
        return  cal;
    }

    public int Quantityissued(int cal , int quantityinDB){
        if(cal <= quantityinDB){
            return cal ;
        }else {
            return quantityinDB ;
        }
    }

    @GetMapping("/Check_Material")
    public @ResponseBody String CreateMaterialWithdrawalSlip(@RequestParam int productionorderid,
                                                             @RequestParam int production_quantity,
                                                             @RequestParam String date,
                                                             @RequestParam String issue_by,
                                                             @RequestParam String received_by,
                                                             @RequestParam String location,
                                                             @RequestParam String status_material
    ){
//        List<productionorders> PO = production_orders_repository.findByproductionorderid(productionorderid);
        materialwithdrawalslip withdrawalslip = new materialwithdrawalslip(productionorderid,production_quantity,date, issue_by,  received_by,  location,  status_material);
        //materialitem item = new materialitem();
        Materialwithdrawalsliprepository.save(withdrawalslip);
//
        //set value in Materialitem

        List<materialitem> foraddList = new ArrayList<>();
        String[] MaterialNum = {"NUT 150","BOLT 100","STBX700","LBL600","GTP600","RPAD320","STOCK2200","STTA2100"};
        String[] MaterialDes = {"Lock Nut","Bolt","Packing Box","SSB Label","Grip Tape","Riser Pads","Standard Deck","Standard Truck Assembly"};
        int Quantityper[] = {8,8,1,1,1,2,1,2};

//        String Totalquantity[] = {"NUT 150","BOLT 100","STBX700","LBL600","GTP600","RPAD320","STOCK2200","STTA2100"};
//        String Quantityissued[] = {"NUT 150","BOLT 100","STBX700","LBL600","GTP600","RPAD320","STOCK2200","STTA2100"};
        //materialitem Materiallist = new materialitem(productionorderid,MaterialDes[0],);
        for(int i = 0 ; i < MaterialNum.length ; i++){
            List<inventory> Qua = Inventoryrepository.findByMaterialnumber(MaterialNum[i]);
            int Totalquantity = production_quantity * Quantityper[i] ;
            materialitem Materiallist = new materialitem(productionorderid,MaterialNum[i],MaterialDes[i],Quantityper[i],
                    Totalquantity,Quantityissued(Totalquantity(production_quantity,Quantityper[i]),Qua.get(0).getQuantity()));
            foraddList.add(Materiallist);
            //System.out.println(MaterialNum[i]);

        }
        for(int i = 0 ; i < foraddList.size() ; i++){
            Materialitemrepository.save(foraddList.get(i));
            System.out.println(foraddList.get(i).getMaterialnumber());
            System.out.println(foraddList.get(i).getMaterial_description());
            System.out.println(foraddList.get(i).getQuantity_issued());
            System.out.println(foraddList.get(i).getQuantity_per_skateboard());
            System.out.println(foraddList.get(i).getTotal_quantity_needed());
            System.out.println(foraddList.get(i).getProductionorderid());
            System.out.println("==============================================");
        }
//            for(int i = 0 ; i < foraddList.size() ; i++){
//                System.out.println(foraddList.get(i).getMaterialnumber());
//            }
        //Materialitemrepository.save(Materiallist);
        //item.setProductionorderid(productionorderid);

        //item.setMaterial_number();

//        String[] materialnumberArr = {"Test1","Test2"};
//        int[] saleidArr = {1,2};
//        int[] quantityArr = {10,20};
//        String[] materialdesArr = {"des1" , "des2"};
//        String[] unittypeArr = {"type1","type2"};
//        double[] unitpriceArr = {100.10 , 200.20};
//        double[] totalArr = {1001.00,4004.00};
//
//        List<materialitem> saleItemList = new ArrayList<>();
//
//        for (int i = 0; i < 2; i++) {
//
//            List<inventory> Qua = Inventoryrepository.findBymaterialnumber(MaterialNum[i]);
//
//            materialitem saleItem = new materialitem(productionorderid,MaterialNum[i],MaterialDes[i],Quantityper[i],
//                                        Totalquantity(production_quantity,Quantityper[i]),Quantityissued(Totalquantity(production_quantity,Quantityper[i]),Qua.get(0).getMaterial_quantity()));
//            saleItemList.add(saleItem);
//        }
//        for (int i = 0; i < 2; i++) {
//            Materialitemrepository.save(saleItemList.get(i));
//        }

        return "Pass" ;
    }
}
