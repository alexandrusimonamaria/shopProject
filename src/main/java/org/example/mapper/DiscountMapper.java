package org.example.mapper;

import org.example.dto.DiscountDto;
import org.example.model.Discount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountMapper {

    public List<DiscountDto> mapListToDiscountDto(List<Discount> discounts) {
        return discounts.stream()
                .map(discount -> map(discount))
                .collect(Collectors.toList());
    }

    public DiscountDto map(Discount discount) {

        DiscountDto discountDto = new DiscountDto();
        discountDto.setId(discount.getId());
        discountDto.setNameProd(discount.getNameProd());
        discountDto.setPercentageProd(discount.getPercentageProd());

        return discountDto;
    }

    public Discount map(DiscountDto discountDto) {

        Discount discount = new Discount();
        discount.setId(discountDto.getId());
        discount.setNameProd(discountDto.getNameProd());
        discount.setPercentageProd(discountDto.getPercentageProd());

        return discount;
    }
}
