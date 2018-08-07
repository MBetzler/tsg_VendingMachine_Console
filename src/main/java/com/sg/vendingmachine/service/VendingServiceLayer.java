/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingPersistenceException;
import com.sg.vendingmachine.dto.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author betzler
 */
public interface VendingServiceLayer {

    List<Product> getStockedProducts() throws VendingPersistenceException;

    Product getProductByIndex(int index) throws VendingPersistenceException;

    void updateProduct(String name, Product product) throws VendingPersistenceException;

    void checkProductStock(int quantity) throws VendingNoItemInventoryException;

    void checkCustomerFunds(BigDecimal productPrice, BigDecimal totalMoney) throws VendingInsufficientFundsException;
}
