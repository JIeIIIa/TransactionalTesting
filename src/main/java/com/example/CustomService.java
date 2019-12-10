package com.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomService {
    private final JpaRepo jpaRepo;

    public CustomService(JpaRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public List<Dto> findAll() {
        return jpaRepo.findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Dto insert(Dto dto) {
        final CustomEntity entity = new CustomEntity();
        entity.setValue(dto.value);
        final CustomEntity newEntity = jpaRepo.save(entity);
        jpaRepo.save(entity);

        return convert(newEntity);
    }


    public Dto update(Dto dto) {
        final CustomEntity entity = jpaRepo.findById(dto.id).orElseThrow(IllegalAccessError::new);
        entity.setValue(dto.value);
        jpaRepo.save(entity);

        return convert(entity);
    }

    private Dto convert(CustomEntity entity) {
        return new Dto(entity.getId(), entity.getValue());
    }
}
