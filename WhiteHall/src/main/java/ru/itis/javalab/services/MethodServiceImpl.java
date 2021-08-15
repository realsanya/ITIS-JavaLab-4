package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.models.Method;
import ru.itis.javalab.repositories.MethodRepository;

@Service
public class MethodServiceImpl implements MethodService {

    private final MethodRepository methodRepository;

    @Autowired
    public MethodServiceImpl(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @Override
    public void incrementMethod(String name) {
        if (methodRepository.findByName(name) != null) {
            methodRepository.inc(name);
        } else {
            Method method = new Method(name);
            methodRepository.save(method);
            methodRepository.inc(name);
        }
    }
}
