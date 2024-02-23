package ru.igorelesin.springbootapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igorelesin.springbootapp.DAO.UserDAO;
import ru.igorelesin.springbootapp.model.User;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO repository;

    @Override
    @Transactional
    public void addUser(User user) {
        repository.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser) {
        User userToBeUpdated = repository.findUser(updatedUser.getId());
        userToBeUpdated.setId(updatedUser.getId()); //todo возможно удалить тестовый варинт пробуем
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(Long id) {
        return repository.findUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }
}
