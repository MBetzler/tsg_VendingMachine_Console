/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingDao;
import com.sg.vendingmachine.dao.VendingDaoStubImpl;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author betzler
 */
public class VendingServiceLayerTest {

    private VendingServiceLayer service;

    public VendingServiceLayerTest() {
        VendingDao dao = new VendingDaoStubImpl();

        service = new VendingServiceLayerImpl(dao);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkProductStock method, of class VendingServiceLayer.
     */
    @Test
    public void testCheckProductStock() throws Exception {
        try {
            service.checkProductStock(1);
        } catch (VendingNoItemInventoryException e) {
            fail("Expected VendingNoItemInventoryException exception.");
        }
    }

    @Test
    public void testCheckProductStockOutOfStock() throws Exception {
        try {
            service.checkProductStock(0);
            fail("Expected VendingNoItemInventoryException exception.");
        } catch (VendingNoItemInventoryException e) {
            return;
        }
    }

    /**
     * Test of checkCustomerFunds method, of class VendingServiceLayer.
     */
    @Test
    public void testCheckCustomerFunds() throws Exception {
        try {
            service.checkCustomerFunds(new BigDecimal("0.75"), new BigDecimal("0.76"));
        } catch (VendingInsufficientFundsException e) {
            fail("Expected VendingInsufficientFundsException exception.");
        }
    }

    @Test
    public void testCheckCustomerFundsEqual() throws Exception {
        try {
            service.checkCustomerFunds(new BigDecimal("0.75"), new BigDecimal("0.75"));
        } catch (VendingInsufficientFundsException e) {
            fail("Expected VendingInsufficientFundsException exception.");
        }
    }

    @Test
    public void testCheckCustomerFundsTooLittleFunds() throws Exception {
        try {
            service.checkCustomerFunds(new BigDecimal("0.75"), new BigDecimal("0.74"));
            fail("Expected VendingInsufficientFundsException exception.");
        } catch (VendingInsufficientFundsException e) {
            return;
        }
    }
}
