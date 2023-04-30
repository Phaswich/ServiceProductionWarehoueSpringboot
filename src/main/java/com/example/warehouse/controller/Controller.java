package com.example.warehouse.controller;

import com.example.warehouse.domain.productionorders;
import com.example.warehouse.domain.materialwithdrawalslip;
import com.example.warehouse.domain.materialitem;
import com.example.warehouse.domain.inventory;
import com.example.warehouse.repository.materialwithdrawalsliprepository;
import com.example.warehouse.repository.production_orders_repository ;
import com.example.warehouse.repository.materialitemrepository ;
import com.example.warehouse.repository.inventoryrepository ;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import com.example.warehouse.repository.*;
//import com.example.warehouse.domain.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/testwarehouse")
public class Controller {
    @Autowired
    private production_orders_repository production_orders_repository;

    @Autowired
    private materialwithdrawalsliprepository Materialwithdrawalsliprepository;
    @Autowired
    private materialitemrepository Materialitemrepository;
    @Autowired
    private inventoryrepository Inventoryrepository;
    @PostMapping(path = "/addProductionorder")

    public @ResponseBody String addnewProductionorder(@RequestParam String material_number,@RequestParam String material_description,@RequestParam int quantity,@RequestParam String com_date,@RequestParam int com_quantity_complete,@RequestParam int com_scrap_quantity
            ,@RequestParam String com_completed_by,@RequestParam String rec_date,@RequestParam int rec_quantity,@RequestParam String rec_completed_by,@RequestParam String rec_received_by,@RequestParam int planned_order_number,@RequestParam String authorized_by,@RequestParam String date_authorized)

    {
        productionorders production_orders = new productionorders(material_number,material_description,quantity,com_date,com_quantity_complete,com_scrap_quantity,com_completed_by,rec_date,rec_quantity,rec_completed_by,
                rec_received_by,planned_order_number,authorized_by,date_authorized);
        production_orders_repository.save(production_orders);
        return "Productionorder Saved";
    }

    @GetMapping("/allProductionorder")
    public @ResponseBody List<productionorders> getallproductionorder(){
        return production_orders_repository.findAll();
    }
    @GetMapping("/allInventory")
    public @ResponseBody List<inventory> getallInventory(){
        return Inventoryrepository.findAll();
    }
    @GetMapping("/findProductionorderid")
    public @ResponseBody List<productionorders> findProductionorderid(@RequestParam int productionorderid){
        return production_orders_repository.findByproductionorderid(productionorderid);
    }

    @Transactional
    public void updateMaterialWithdrawalStatus(int productionOrderId , String Status) {
        List<materialwithdrawalslip> slips = Materialwithdrawalsliprepository.findByproductionorderid(productionOrderId);
        slips.forEach(slip -> {
            slip.setStatus_material(Status);
            Materialwithdrawalsliprepository.save(slip);
        });
    }
    public int Quantityissued(int cal , int quantityinDB){
        if(cal <= quantityinDB){
            return cal ;
        }else {
            return quantityinDB ;
        }
    }
    @Transactional
    public void updateMaterialitemMattIssued(int productionOrderId) {
        //String[] MaterialNum = {"NUT 150","BOLT 100","STBX700","LBL600","GTP600","RPAD320","STOCK2200","STTA2100"};
        List<materialitem> slips = Materialitemrepository.findByproductionorderid(productionOrderId);
                //Materialwithdrawalsliprepository.findByproductionorderid(productionOrderId);

//        for (int i = 0; i < slips.size(); i++) {
//            Quantityissued(slips.get(i).getTotal_quantity_needed(),500);
//            slips.add(i);
//            Inventoryrepository.save(slip);
//        }

        slips.forEach(slip -> {
           // for (int i = 0; i < MaterialNum.length; i++) {
                int Quantityinventory = Inventoryrepository.findByMaterialnumber(slip.getMaterialnumber()).get(0).getQuantity();
            int quantityissued = Quantityissued(slip.getTotal_quantity_needed(),Quantityinventory);

          //  }
            slip.setQuantity_issued(quantityissued);
            Materialitemrepository.save(slip);
        });

    }
    @PutMapping("/Send_Material_withdrawslip")
    public @ResponseBody String SendMaterialwithdrawslip(@RequestParam int productionorderid){
        Gson gson = new GsonBuilder().create();
        String checkST = "Complete";
        String statusMatt = null;

        updateMaterialitemMattIssued(productionorderid);
        for (int i = 0; i < Materialitemrepository.findByproductionorderid(productionorderid).size(); i++) {
            if(Materialitemrepository.findByproductionorderid(productionorderid).get(i).getTotal_quantity_needed() != Materialitemrepository.findByproductionorderid(productionorderid).get(i).getQuantity_issued()  ){
//                System.out.println(Materialitemrepository.findByproductionorderid(productionorderid).get(i).getTotal_quantity_needed() );
//                System.out.println(Materialitemrepository.findByproductionorderid(productionorderid).get(i).getQuantity_issued() );

                statusMatt = "Procurement Process" ;
                break ;
            }else{
                statusMatt = checkST ;

            }
        }

        updateMaterialWithdrawalStatus(productionorderid,statusMatt);

        //Materialwithdrawalsliprepository.updatePropertyById(productionorderid);





        //Materialwithdrawalsliprepository.updatePropertyById(productionorderid,statusMatt);
       // materialwithdrawalslip existingData = Materialwithdrawalsliprepository.findByproductionorderid(productionorderid).get();
        String Slip = gson.toJson(Materialwithdrawalsliprepository.findByproductionorderid(productionorderid));
        String item = gson.toJson(Materialitemrepository.findByproductionorderid(productionorderid));
        //System.out.println(Slip[0].total_quantity_needed);
        String Allresult = Slip + item ;
        return Allresult ;
    }
    public int Totalquantity(int production_quantity , int Quantityper){
            int cal = production_quantity * Quantityper ;
            return  cal;
    }


    @PostMapping("/Check_Material")
    public @ResponseBody String CreateMaterialWithdrawalSlip(@RequestParam int productionorderid
//                                                             ,@RequestParam int production_quantity,
//                                                             @RequestParam String date,
//                                                             @RequestParam String issue_by,
//                                                             @RequestParam String received_by,
//                                                             @RequestParam String location,
//                                                             @RequestParam String status_material
                                                            ){
        List<productionorders> PO = production_orders_repository.findByproductionorderid(productionorderid);
//        System.out.println(PO.get(0).getQuantity());
//        System.out.println(PO.get(0).getCom_date());
//        System.out.println(PO.get(0).getRec_completed_by());
//        System.out.println(PO.get(0).getRec_received_by());

        int production_quantity = PO.get(0).getQuantity() ;
        String date = PO.get(0).getCom_date();
        String issue_by = PO.get(0).getRec_completed_by();
        String received_by = PO.get(0).getRec_received_by() ;
        String location = "Warehouse" ;
        String status_material = "Waiting";
//
        //set value in Materialitem

        List<materialitem> foraddList = new ArrayList<>();


       String[] MaterialNum = {"NUT 150","BOLT 100","STBX700","LBL600","GTP600","RPAD320","STOCK2200","STTA2100"};
//         String[] MaterialNum = {"BOLT 100","STBX700"};
        String[] MaterialDes = {"Lock Nut","Bolt","Packing Box","SSB Label","Grip Tape","Riser Pads","Standard Deck","Standard Truck Assembly"};
        int[] Quantityper = {8,8,1,1,1,2,1,2};
//        for (int i = 0; i < MaterialNum.length ; i++) {
//            int Quantityinventory = Inventoryrepository.findByMaterialnumber(MaterialNum[i]).get(0).getQuantity();
//            System.out.println(MaterialNum[i]);
//            System.out.println(Quantityinventory);
//        }

        //materialitem Materiallist = new materialitem(productionorderid,MaterialDes[0],);
       // String checkST = "Complete";
            for(int i = 0 ; i < MaterialNum.length ; i++){
               // List<inventory> Qua = new ArrayList<>();
                 int Quantityinventory = Inventoryrepository.findByMaterialnumber(MaterialNum[i]).get(0).getQuantity();
                int totalQuantity = Totalquantity(production_quantity, Quantityper[i]);
                int quantityIssued = 0 ;
                //int quantityIssued = Quantityissued(totalQuantity, Quantityinventory);
                //   int quantityIssued = Quantityissued(totalQuantity, 500);

//                if(totalQuantity != quantityIssued && checkST == "Complete"){
//                    status_material = "Procurement process" ;
//                    //System.out.println(status_material);
//                    //System.out.println(Qua.size());
////                    System.out.println(Quantityinventory);
////                    System.out.println(MaterialNum[i]);
//                }else{
//                    status_material = checkST ;
//                }
                materialitem Materiallist = new materialitem(productionorderid,MaterialNum[i],MaterialDes[i],Quantityper[i],
                        totalQuantity,quantityIssued);
                foraddList.add(Materiallist);
                //System.out.println(MaterialNum[i]);

            }
        Materialitemrepository.saveAll(foraddList);

        materialwithdrawalslip withdrawalslip = new materialwithdrawalslip(productionorderid,production_quantity,date, issue_by,  received_by,  location,  status_material);
        //materialitem item = new materialitem();
        Materialwithdrawalsliprepository.save(withdrawalslip);
//        Materialitemrepository.save(foraddList.get(1));
//        Materialitemrepository.save(foraddList.get(2));
//        Materialitemrepository.save(foraddList.get(3));
//        Materialitemrepository.save(foraddList.get(4));
//        Materialitemrepository.save(foraddList.get(5));
//        Materialitemrepository.save(foraddList.get(6));
//        Materialitemrepository.save(foraddList.get(7));

//            for(int i = 0 ; i < foraddList.size() ; i++){
////                Materialitemrepository.save(foraddList.get(i));
//                System.out.println(foraddList.get(i).getProductionorderid());
//                System.out.println(foraddList.get(i).getMaterialnumber());
//                System.out.println(foraddList.get(i).getMaterial_description());
//                System.out.println(foraddList.get(i).getQuantity_per_skateboard());
//                System.out.println(foraddList.get(i).getTotal_quantity_needed());
//                System.out.println(foraddList.get(i).getQuantity_issued());
//                System.out.println("==============================================");
//            }
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
//        System.out.println(Materialitemrepository.findByproductionorderid(productionorderid));
//        System.out.println(Materialwithdrawalsliprepository.findByproductionorderid(productionorderid));

        Gson gson = new GsonBuilder().create();
        String Slip = gson.toJson(Materialwithdrawalsliprepository.findByproductionorderid(productionorderid));
        String item = gson.toJson(Materialitemrepository.findByproductionorderid(productionorderid));
        String Allresult = Slip + item ;
//        System.out.println(Allresult);
        return "Checking Material "+Allresult ;
    }
}
