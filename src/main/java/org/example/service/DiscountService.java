package org.example.service;

import org.example.dto.DiscountDto;
import org.example.mapper.DiscountMapper;
import org.example.model.Discount;
import org.example.repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;

    public DiscountService(DiscountRepository discountRepository, DiscountMapper discountMapper) {
        this.discountRepository = discountRepository;
        this.discountMapper = discountMapper;
    }

    public DiscountDto addDiscount (DiscountDto discountDto){
        Discount dbDiscount = discountRepository.save(discountMapper.map(discountDto));
        return discountMapper.map(dbDiscount);
    }

    public List<DiscountDto> getAll() {
        List<Discount> discounts = discountRepository.findAll();
        return discountMapper.mapListToDiscountDto(discounts);
    }
}
