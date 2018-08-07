/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingController;
import com.sg.vendingmachine.dao.VendingDao;
import com.sg.vendingmachine.dao.VendingDaoFileImpl;
import com.sg.vendingmachine.service.VendingServiceLayer;
import com.sg.vendingmachine.service.VendingServiceLayerImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingView;

/**
 *
 * @author betzler
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VendingView myView = new VendingView(myIo);
        VendingDao myDao = new VendingDaoFileImpl();
        VendingServiceLayer myService = new VendingServiceLayerImpl(myDao);
        VendingController controller = new VendingController(myService, myView);
        controller.run();
    }
    
}
