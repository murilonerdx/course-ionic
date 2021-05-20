package com.murilo.cursomc.model.produto.dto;

import com.murilo.cursomc.model.categoria.dto.CategoriaDTO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoUpdateDTO {
    private String name;
    private Double price;
    private List<CategoriaDTO> insertCategoryName = new ArrayList<>();
    private List<CategoriaDTO> removeCategoryName = new ArrayList<>();

    public ProdutoUpdateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CategoriaDTO> getInsertCategoryName() {
        return insertCategoryName;
    }

    public void setInsertCategoryName(List<CategoriaDTO> insertCategoryName) {
        this.insertCategoryName = insertCategoryName;
    }

    public List<CategoriaDTO> getRemoveCategoryName() {
        return removeCategoryName;
    }

    public void setRemoveCategoryName(List<CategoriaDTO> removeCategoryName) {
        this.removeCategoryName = removeCategoryName;
    }
}
