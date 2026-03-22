package com.clara.ex02.services;

import com.clara.ex02.models.ProdutoModel;
import com.clara.ex02.repositorie.ProdutoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
@Autowired
private ProdutoRepositorie produtoRepositorie;

public List<ProdutoModel> findAll(){
    return produtoRepositorie.findAll();
}

public ProdutoModel criarProduto (ProdutoModel produtoModel){
    return produtoRepositorie.save(produtoModel);
}

public Optional<ProdutoModel> findById(Long id){
    return produtoRepositorie.findById(id);
}

public ProdutoModel atualizar (Long id, ProdutoModel produtoModel){
ProdutoModel model = produtoRepositorie.findById(id).get();
model.setNome(produtoModel.getNome());
return produtoRepositorie.save(model);
}

public void remover (Long id){
    produtoRepositorie.deleteById(id);
}

}
