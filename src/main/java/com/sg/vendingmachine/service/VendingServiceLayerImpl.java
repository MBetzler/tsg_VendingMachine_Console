/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingDao;
import com.sg.vendingmachine.dao.VendingPersistenceException;
import com.sg.vendingmachine.dto.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author betzler
 */
public class VendingServiceLayerImpl implements VendingServiceLayer {

    VendingDao dao;

    public VendingServiceLayerImpl(VendingDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Product> getStockedProducts() throws VendingPersistenceException {
        return dao.getStockedProducts();
    }

    @Override
    public Product getProductByIndex(int index) throws VendingPersistenceException {
        return dao.getProductByIndex(index);
    }

    @Override
    public void updateProduct(String name, Product product) throws VendingPersistenceException {
        dao.updateProduct(name, product);
    }

    @Override
    public void checkProductStock(int quantity) throws VendingNoItemInventoryException {
        if (quantity <= 0) {
            throw new VendingNoItemInventoryException("Sorry - that product is out of stock.");
        }
    }

    @Override
    public void checkCustomerFunds(BigDecimal productPrice, BigDecimal totalMoney) throws VendingInsufficientFundsException {
        if (productPrice.compareTo(totalMoney) > 0) {
            throw new VendingInsufficientFundsException("The product you've selected costs $" + productPrice + " but you've only deposited $" + totalMoney + ".");
        }
    }
}
