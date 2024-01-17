package org.example.mapper;

import org.example.dto.StockDto;
import org.example.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public List<StockDto> mapListToStockDto(List<Stock> stocks) {
        return stocks
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Stock map(StockDto stockDto) {
        if (stockDto == null) {
            return null;
        }

        Stock stock = new Stock();
        stock.setId(stockDto.getId());
        stock.setPriceStock(stockDto.getPriceStock());
        stock.setProductStock(stockDto.getProductStock());
        stock.setQuantityStock(stockDto.getQuantityStock());
        //stock.setProduct(stockDto);

        return stock;
    }

    public StockDto map(Stock stock) {
        if (stock == null) {
            return null;
        }

        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setPriceStock(stock.getPriceStock());
        stockDto.setProductStock(stock.getProductStock());
        stockDto.setQuantityStock(stock.getQuantityStock());
        //stockDto.setProductStock(stock.getProduct());

        return stockDto;
    }
}
