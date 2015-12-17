package com.aethernadev.product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Created by Aetherna on 2015-12-17.
 */
public class FindAllProductsUseCaseTest {

    @Mock
    ProductDao productDao;
    FindAllProductsUseCase testObject;
    @Mock
    List<Product> products;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testObject = new FindAllProductsUseCase(productDao);
    }

    @Test
    public void shouldFindAllProducts() {

        //having
        when(productDao.getAllProducts()).thenReturn(products);

        //when
        testObject.getResults();
        //then
        verify(productDao, times(1)).getAllProducts();
    }
}
