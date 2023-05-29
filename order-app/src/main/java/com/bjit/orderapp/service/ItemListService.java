package com.bjit.orderapp.service;

import org.springframework.http.ResponseEntity;

public interface ItemListService {

    ResponseEntity<Object> getAllItemList();
}
