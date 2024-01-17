package org.example.controller;

import org.example.dto.DiscountDto;
import org.example.mapper.DiscountMapper;
import org.example.service.DiscountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    final private DiscountService discountService;
    final private DiscountMapper discountMapper;

    public DiscountController(DiscountService discountService, DiscountMapper discountMapper) {
        this.discountService = discountService;
        this.discountMapper = discountMapper;
    }

    @PostMapping
    public DiscountDto addDiscount(@RequestBody DiscountDto discountDto) {
        return discountService.addDiscount(discountDto);
    }

    @GetMapping
    public List<DiscountDto> getAll() {
        return discountService.getAll();
    }


}
