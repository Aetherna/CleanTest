package com.aethernadev.controller;

import com.aethernadev.InputValidator;

import javax.inject.Inject;

public class ProductsController {

    @Inject
    InputValidator inputValidator;

    @Inject
    public ProductsController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public boolean validate(String label) {
       return inputValidator.validate(label);
    }
}
