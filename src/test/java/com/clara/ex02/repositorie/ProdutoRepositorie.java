package com.clara.ex02.repositorie;

import com.clara.ex02.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorie extends JpaRepository<ProdutoModel, Long> {
}
