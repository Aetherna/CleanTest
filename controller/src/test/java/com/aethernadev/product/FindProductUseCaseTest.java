package com.aethernadev.product;

import com.aethernadev.TextUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by Aetherna on 2015-12-17.
 */
public class FindProductUseCaseTest {

    @Mock
    ProductDao productDao;
    @Mock
    TextUtils textUtils;
    FindProductUseCase testObject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testObject = new FindProductUseCase(productDao, textUtils);
    }

    @Test
    public void shouldThrowIllegalStateOnNullBarcode() {

        when(textUtils.isNonSpaceEmpty(null)).thenReturn(true);

        //when
        try {
            testObject.findProduct(null);
            Assert.fail();
            //then
        } catch (IllegalStateException ex) {
            verifyZeroInteractions(productDao);
        }
    }

    @Test
    public void shouldThrowIllegalStateOnEmptyBarcode() {

        when(textUtils.isNonSpaceEmpty("")).thenReturn(true);

        //when
        try {
            testObject.findProduct("");
            Assert.fail();
            //then
        } catch (IllegalStateException ex) {
            verifyZeroInteractions(productDao);
        }
    }

    @Test
    public void shouldThrowIllegalStateOnSpacedEmptyBarcode() {

        when(textUtils.isNonSpaceEmpty("   ")).thenReturn(true);

        //when
        try {
            testObject.findProduct("   ");
            Assert.fail();
            //then
        } catch (IllegalStateException ex) {
            verifyZeroInteractions(productDao);
        }
    }

}
