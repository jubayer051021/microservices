package com.bjit.orderapp.service.Imp;

import com.bjit.orderapp.Mapper.MappingModel;
import com.bjit.orderapp.entity.ItemListEntity;
import com.bjit.orderapp.repository.ItemListRepository;
import com.bjit.orderapp.service.ItemListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemListServiceImp implements ItemListService {
    private final ItemListRepository itemListRepository;
    @Override
    public ResponseEntity<Object> getAllItemList() {
        List<ItemListEntity> itemList=itemListRepository.findAll();
        return new ResponseEntity<>(itemList.stream().map(MappingModel::ItemListEntityToDto).toList(),HttpStatus.OK);
    }
}
