package com.microservices.currencyconvertion.proxie;

import com.microservices.currencyconvertion.domain.ConversionValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currency-exchange")
@RibbonClient(name = "currency-exchange")
public interface CurrencyExchangeServiceProxy {


    @GetMapping("/currency-exchange/from/{currencyOrigin}/{currencyDestine}")
    public ConversionValue retrieveExchangeValue(@PathVariable("currencyOrigin") String currencyOrigin, @PathVariable("currencyDestine") String currencyDestine);
}
