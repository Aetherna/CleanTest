package com.aethernadev.addproduct;

import com.aethernadev.product.AddProductUseCase;
import com.aethernadev.product.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by Aetherna on 2015-12-18.
 */
public class AddProductPresenterTest {

    @Mock
    AddProductPresenter.MainUI ui;
    @Mock
    AddProductUseCase addProductUseCase;
    @Mock
    Product product;

    AddProductPresenter testObject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        testObject = new AddProductPresenter(addProductUseCase);
        testObject.attachUI(ui);
    }

    @Test
    public void shouldNotifyUIOfProductAdded() {
        //having

        //when
        testObject.addProduct(product);
        //then
        verify(ui, times(1)).showProductCreated();
    }

    @Test
    public void shouldNotifyUIOfErrorWhileAddingNullProduct() {
        //having
        Mockito.doThrow(new IllegalStateException()).when(addProductUseCase).addProduct(null);
        //when
        testObject.addProduct(null);
        //then
        verify(ui, times(1)).showErrorMessage("Lol exception :O");
    }

    @Test
    public void shouldNotifyUIOfErrorWhileAddingEmptyProduct() {
        //having
        Product emptyProduct = new Product();
        Mockito.doThrow(new IllegalStateException()).when(addProductUseCase).addProduct(emptyProduct);
        //when
        testObject.addProduct(emptyProduct);
        //then
        verify(ui, times(1)).showErrorMessage("Lol exception :O");
    }
}
