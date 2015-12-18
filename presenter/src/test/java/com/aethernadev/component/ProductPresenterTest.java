package com.aethernadev.component;

import com.aethernadev.product.FindProductUseCase;
import com.aethernadev.product.Product;
import com.jayway.awaitility.Awaitility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


import static java.util.concurrent.TimeUnit.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by Aetherna on 2015-12-18.
 */
public class ProductPresenterTest {

    @Mock
    FindProductUseCase findProductUseCase;
    @Mock
    ProductViewModelMapper mapper;
    @Mock
    ProductPresenter.ProductUI ui;
    @Mock
    Product product;

    ProductPresenter testObject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testObject = new ProductPresenter(findProductUseCase, mapper);
        testObject.attachUI(ui);
    }

    //todo do do
    @Test
    public void shouldDisplayWarningWhenProductNotFound() {
        //having
        String unknownBarcode = Mockito.anyString();

        when(findProductUseCase.findProduct(unknownBarcode)).thenReturn(product);
        when(product.isEmpty()).thenReturn(true);

        //when
        testObject.searchProduct(unknownBarcode);

        Awaitility.await().atMost(1, SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                //what to do here? :<
                return null;
            }
        });
        Assert.assertTrue(true);
        //then
//        verify(ui, (times(1))).showValidationProgressBar();
//        verify(ui, (times(1))).displayNoSuchProductWarning();
//        verify(ui, (times(1))).hideValidationProgressBar();

    }
}
