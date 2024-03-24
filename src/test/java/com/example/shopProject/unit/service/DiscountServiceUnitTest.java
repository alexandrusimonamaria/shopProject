package com.example.shopProject.unit.service;

import org.example.dto.DiscountDto;
import org.example.mapper.DiscountMapper;
import org.example.model.Discount;
import org.example.repository.DiscountRepository;
import org.example.service.DiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class DiscountServiceUnitTest {
    @Mock
    private DiscountRepository discountRepository;
    @Mock
    private DiscountMapper discountMapper;
    @InjectMocks
    private DiscountService discountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    private Discount getDummyDiscount() {
        Discount discount = new Discount();
        discount.setId(1);
        discount.setNameProd("Cat");
        discount.setPriceProd(33);
        discount.setPercentageProd(21);

        return discount;
    }

    private DiscountDto getDummyDiscountOne() {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setId(1);
        discountDto.setNameProd("Cat");
        discountDto.setPriceProd(33);
        discountDto.setPercentageProd(21);

        return discountDto;
    }

}
