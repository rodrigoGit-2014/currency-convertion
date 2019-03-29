package com.microservices.currencyconvertion.controller;

import com.microservices.currencyconvertion.domain.ConversionValue;
import com.microservices.currencyconvertion.proxie.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConvertionController {


    @Autowired
    private CurrencyExchangeServiceProxy proxy;


    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionValue retrieveFeignConversionValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        ConversionValue conversionValue = proxy.retrieveExchangeValue(from, to);
        conversionValue.setTotalCalculatedAmount(quantity.multiply(conversionValue.getConvertion()));
        return conversionValue;
    }
}
