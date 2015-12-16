package com.aethernadev.product;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Aetherna on 2015-12-16.
 */
public class AddProductUseCaseTest {

    @Mock
    ProductDao productDao;
    AddProductUseCase testObject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testObject = new AddProductUseCase(productDao);
    }

    @Test
    public void shouldAddProduct() {

        //having
        Product testProduct = new Product();
        testProduct.setName("Name");
        testProduct.setBarcode("Barcode");
        testProduct.setExpiryDate(DateTime.now());

        //when
        testObject.addProduct(testProduct);

        //then
        verify(productDao, times(1)).createProduct(testProduct);
    }

    @Test
    public void shouldThrowIllegalStateOnNull() {

        try {
            testObject.addProduct(null);
            Assert.fail();
        } catch (IllegalStateException ex) {
            verifyZeroInteractions(productDao);
        }
    }
}
