package org.example.controller;

import org.example.dto.StockDto;
import org.example.mapper.StockMapper;
import org.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;
    private final StockMapper stockMapper;

    @Autowired
    public StockController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    @PostMapping
    public StockDto saveStock(@RequestBody StockDto stockDto) {
        return stockService.saveStock(stockDto);
    }

    @GetMapping
    public List<StockDto> getAll() {
        return stockService.getAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        stockService.deleteStock(id);
    }
}
