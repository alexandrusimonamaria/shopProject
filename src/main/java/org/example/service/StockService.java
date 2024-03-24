package org.example.service;

import org.example.dto.StockDto;
import org.example.mapper.StockMapper;
import org.example.model.Stock;
import org.example.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public StockService(StockRepository stockRepository, StockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    public StockDto saveStock(StockDto stockDto) {
        Stock dbStock = stockRepository.save(stockMapper.map(stockDto));
        return stockMapper.map(dbStock);
    }

    public List<StockDto> getAll() {
        List<Stock> allStock = stockRepository.findAll();
        return stockMapper.mapListToStockDto(allStock);
    }

    public void deleteStock(Integer id) {
        stockRepository.deleteById(id);
    }


}
