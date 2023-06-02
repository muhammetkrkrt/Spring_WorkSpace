package com.muhammet.services;


import com.muhammet.repository.IPersonelDeparmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonelDepartmanService {

    private final IPersonelDeparmanRepository repository;
}
