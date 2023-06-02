package com.muhammet.services;

import com.muhammet.repository.IPeronelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonelService {
    private final IPeronelRepository repository;


}
