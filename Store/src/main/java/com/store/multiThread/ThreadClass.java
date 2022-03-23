

//TODO: this file is kept here for educational purpose, I implemented the multithreading directly from the cashierOperationImpl class.

//package com.store.multiThread;
//
//import com.store.exception.InsufficientFundException;
//import com.store.exception.OutOfStockException;
//import com.store.exception.StaffNotAuthorizedException;
//import com.store.model.Company;
//import com.store.model.Customer;
//import com.store.model.Product;
//import com.store.model.Staff;
//import com.store.operations.CashierOperation;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ThreadClass {
//    ExecutorService service = Executors.newFixedThreadPool(2);
//
//    public static void run(ExecutorService executorService,Staff staff,Customer customer, CashierOperation cashierOperation, Company company, Product product){
//
//        executorService.execute(()-> {
//            try {
//                cashierOperation.sellToCustomer(company, staff, customer);
//            } catch (StaffNotAuthorizedException | OutOfStockException | InsufficientFundException e) {
//                e.printStackTrace();
//            } finally {
//                System.out.println(
//                        Thread.currentThread().getName() + "worked on " + customer.getCart().get(product) + " of " +
//                                product.getProductName() + ":RunTime - " + new Date().getSeconds()  //
//                );
//            }
//        });
//    }
//}


